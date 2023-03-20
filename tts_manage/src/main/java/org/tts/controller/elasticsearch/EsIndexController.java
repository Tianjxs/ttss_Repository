package org.tts.controller.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tts.domain.mysql.DPlTmOrderHMapper;
import org.tts.domain.mysql.DPlTmOrderOrdersDMapper;
import org.tts.domain.mysql.entity.DPlTmOrderH;
import org.tts.domain.mysql.entity.DPlTmOrderOrdersD;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2023/03/13 14:58
 */
@RestController
@Slf4j
public class EsIndexController {

    @Resource
    private RestHighLevelClient restHighLevelClient;
    @Resource
    private DPlTmOrderHMapper dPlTmOrderHMapper;
    @Resource
    private DPlTmOrderOrdersDMapper dPlTmOrderOrdersDMapper;

    /**
     * 创建订单索引并添加文档数据
     * @param indexName
     * @param deleteFlag
     * @return
     * @throws Exception
     */
    @GetMapping("/index/tm/order")
    public String dealTmOrderIndex(String indexName,boolean deleteFlag) throws Exception {
        Map<String,Object> resultMap =new HashMap<>();
        //是否删除索引
        if(deleteFlag){
            boolean deleteIndex = deleteIndex(indexName);
            log.info("索引{},是否成功删除索引{}",indexName,deleteIndex);
        }
        //判断是否创建索引,无则创建
        createIndex(indexName);
        //创建索引数据
        BulkRequest bulkRequest = new BulkRequest();
        BulkResponse bulkResponse=null ;

        DPlTmOrderH dPlTmOrderHQuery =new DPlTmOrderH();
        dPlTmOrderHQuery.setMergeStatus(1);
        List<DPlTmOrderH> dPlTmOrderHList = dPlTmOrderHMapper.queryAll(dPlTmOrderHQuery);
        if(dPlTmOrderHList.size()>0){
            for (DPlTmOrderH dPlTmOrderH : dPlTmOrderHList) {
                Long tid = dPlTmOrderH.getTid();
                String status = dPlTmOrderH.getStatus();
                String buyerNick = dPlTmOrderH.getBuyerNick();
                String sellerNick = dPlTmOrderH.getSellerNick();
                Integer sellerFlag = dPlTmOrderH.getSellerFlag();
                String payment = dPlTmOrderH.getPayment();
                Date modified = dPlTmOrderH.getModified();
                String olshopid = dPlTmOrderH.getOlshopid();
                // 创建索引文档
                Map<String, Object> orderMap = new HashMap<>();
                orderMap.put("tid",tid);
                orderMap.put("status",status);
                orderMap.put("buyerNick",buyerNick);
                orderMap.put("sellerNick",sellerNick);
                orderMap.put("sellerFlag",sellerFlag);
                orderMap.put("olshopid",olshopid);
                orderMap.put("payment",Double.parseDouble(payment));
                orderMap.put("modified",modified);
                Map<String,Object> infoMap =new HashMap<>();
                infoMap.put("name","tid");
                orderMap.put("info",infoMap);

                IndexRequest indexRequest =new IndexRequest(indexName,"_doc",tid+"").source(orderMap);
                bulkRequest.add(indexRequest);
            }
            if (bulkRequest.numberOfActions() > 0) {
                 bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

                log.info("[EsIndexer][indexGoodsDirectory] 批量创建商品索引文档，数量：" + bulkRequest.numberOfActions() + "，结果：" + bulkResponse.status() + "，是否有失败：" + bulkResponse.hasFailures());
            }
        }
        /**
         * 获取订单详情
         */
        BulkRequest bulkRequestOrders = new BulkRequest();
        BulkResponse bulkResponseOrders=null ;
        DPlTmOrderOrdersD dPlTmOrderOrdersD =new DPlTmOrderOrdersD();
        List<DPlTmOrderOrdersD> dPlTmOrderOrdersDList = dPlTmOrderOrdersDMapper.queryAll(dPlTmOrderOrdersD);
        if(dPlTmOrderOrdersDList.size()>0){
            for (DPlTmOrderOrdersD tmOrderOrdersD : dPlTmOrderOrdersDList) {
                Long tid = tmOrderOrdersD.getTid();
                String oid = tmOrderOrdersD.getOid();
                String olshopid = tmOrderOrdersD.getOlshopid();
                String status = tmOrderOrdersD.getStatus();
                String refundStatus = tmOrderOrdersD.getRefundStatus();
                String outerIid = tmOrderOrdersD.getOuterIid();
                String title = tmOrderOrdersD.getTitle();
                String price = tmOrderOrdersD.getPrice();
                String payment = tmOrderOrdersD.getPayment();
                Map<String, Object> orderMap = new HashMap<>();
                orderMap.put("tid",tid);
                orderMap.put("status",status);
                orderMap.put("oid",oid);
                orderMap.put("refundStatus",refundStatus);
                orderMap.put("outerIid",outerIid);
                orderMap.put("title",title);
                orderMap.put("payment",Double.parseDouble(payment));
                orderMap.put("price",price);

                Map<String,Object> infoMap =new HashMap<>();
                infoMap.put("name","tidOrders");
                infoMap.put("parent",tid);
                orderMap.put("info",infoMap);

                IndexRequest indexRequest =new IndexRequest(indexName,"_doc",tid+"_"+oid).source(orderMap).routing(String.valueOf(tid));
                bulkRequestOrders.add(indexRequest);
            }
            if(bulkRequestOrders.numberOfActions()>0){
                bulkResponseOrders =restHighLevelClient.bulk(bulkRequestOrders,RequestOptions.DEFAULT);
            }
        }
        resultMap.put("order",JSON.toJSONString(bulkResponse));
        resultMap.put("product",JSON.toJSONString(bulkResponseOrders));

        return JSON.toJSONString(resultMap) ;
    }

    private boolean deleteIndex(String indexName) throws IOException {
        DeleteIndexRequest deleteIndexRequest =new DeleteIndexRequest(indexName);
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        boolean acknowledged = delete.isAcknowledged();
        return acknowledged;
    }


    public boolean createIndex(String indexName) throws Exception {

        Boolean exists = isIndexExists(indexName);
        if(exists){
            log.info("索引{},index is exist:{},return",indexName,exists);
            return Boolean.FALSE;
        }else{
            XContentBuilder builder = XContentFactory.jsonBuilder();
            JSONObject orderJson = new JSONObject();

            JSONObject orderFiledJson = new JSONObject();
            JSONObject tid = new JSONObject();
            tid.put("type", "keyword");
            orderFiledJson.put("tid", tid);

            JSONObject status = new JSONObject();
            status.put("type", "keyword");
            orderFiledJson.put("status", status);

            JSONObject olshopid = new JSONObject();
            olshopid.put("type", "keyword");
            orderFiledJson.put("olshopid", olshopid);

            JSONObject buyerNick = new JSONObject();
            buyerNick.put("type", "text");
            buyerNick.put("analyzer", "ik_smart");
            orderFiledJson.put("buyerNick", buyerNick);

            JSONObject sellerNick = new JSONObject();
            sellerNick.put("type", "text");
            sellerNick.put("analyzer", "ik_smart");
            orderFiledJson.put("sellerNick", sellerNick);

            JSONObject title = new JSONObject();
            title.put("type", "text");
            title.put("analyzer", "ik_smart");
            orderFiledJson.put("title", title);

            JSONObject modified = new JSONObject();
            modified.put("type", "date");
            orderFiledJson.put("modified", modified);

            JSONObject sellerFlag = new JSONObject();
            sellerFlag.put("type", "integer");
            orderFiledJson.put("sellerFlag", modified);

            JSONObject payment = new JSONObject();
            payment.put("type", "double");
            orderFiledJson.put("payment", modified);

            JSONObject oid = new JSONObject();
            oid.put("type", "keyword");
            orderFiledJson.put("oid", oid);

            JSONObject outerIid = new JSONObject();
            outerIid.put("type", "keyword");
            orderFiledJson.put("outerIid", outerIid);

            JSONObject refundStatus = new JSONObject();
            refundStatus.put("type", "keyword");
            orderFiledJson.put("refundStatus", refundStatus);

            JSONObject price = new JSONObject();
            price.put("type", "keyword");
            orderFiledJson.put("price", price);

            //定义父子文档关系
            JSONObject info =new JSONObject();
            JSONObject relations =new JSONObject();
            relations.put("tid","tidOrders");
            info.put("relations",relations);
            info.put("type", "join");
            orderFiledJson.put("info",info) ;

            orderJson.put("properties", orderFiledJson);
            Map orderMap = JSONObject.parseObject(orderJson.toJSONString(),Map.class);
            builder.map(orderMap);
            // 创建索引
            CreateIndexRequest createRequest = new CreateIndexRequest(indexName);
            createRequest.settings(Settings.builder()
                    .put("index.number_of_shards", 2)
                    .put("index.number_of_replicas", 1));
            createRequest.mapping(builder);
            CreateIndexResponse response = restHighLevelClient.indices().create(createRequest, RequestOptions.DEFAULT);
            boolean acknowledged = response.isAcknowledged();
            return acknowledged;
        }
    }

    public Boolean isIndexExists(@PathVariable("indexName") String indexName) throws IOException {
        GetIndexRequest getIndexRequest =new GetIndexRequest(indexName.toLowerCase());
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        return exists;
    }
}
