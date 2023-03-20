package org.tts.controller.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.io.stream.InputStreamStreamInput;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.get.GetResult;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2023/03/07 13:19
 */
@RestController
public class EsController {
//    @Resource
//    ElasticsearchRestTemplate elasticsearchRestTemplate;
//
//    public void test(){
//        boolean user = elasticsearchRestTemplate.createIndex("user");
//        System.out.println(user);
//    }
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @GetMapping("/index/create")
    public Boolean createIndex() throws IOException {
        CreateIndexRequest createIndexRequest =new CreateIndexRequest("user_index");
        createIndexRequest.settings(Settings.builder().put("index.number_of_shards",1).put("index.number_of_replicas",1));
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder();
        xContentBuilder.startObject().startObject("properties")
                .startObject("name").field("type","keyword").endObject()
                .startObject("age").field("type","integer").endObject()
                .startObject("content").field("type","text").endObject()
                .startObject("address").field("type","text").endObject()
                .endObject().endObject();
        createIndexRequest.mapping(xContentBuilder);
        CreateIndexResponse response = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        boolean acknowledged = response.isAcknowledged();
        if(acknowledged){
            System.out.println(Boolean.TRUE);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @GetMapping("/index/isExists/{indexName}")
    public Boolean isIndexExists(@PathVariable("indexName") String indexName) throws IOException {
        GetIndexRequest getIndexRequest =new GetIndexRequest(indexName.toLowerCase());
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        return exists;
    }

    @GetMapping("/index/delete")
    public boolean deleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest =new DeleteIndexRequest("user_index");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        boolean acknowledged = delete.isAcknowledged();
        return acknowledged;

    }
    @GetMapping("/index/docment/save")
    public String saveDocment() throws IOException {
        if(!isIndexExists("user_index")){
            createIndex();
        }

        Map<String,Object> paraMap =new HashMap<>();
        paraMap.put("name","tts");
        paraMap.put("age",11);
        paraMap.put("centent","今天是星期五,ok");
        paraMap.put("address","朝阳区望京");
        IndexRequest indexRequest =new IndexRequest("user_index").id("2").source(paraMap);
        IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        return index.toString();
    }

    /**
     * 按文档ID查询
     * @param indexName
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/es/search/{indexName}/doc/{id}")
    public String searchIndexForDocId(@PathVariable("indexName")String indexName,@PathVariable("id") String id) throws Exception {

        GetRequest request =new GetRequest(indexName,id);

        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        return JSON.toJSONString(response);
    }

    @GetMapping("/es/search/{indexName}")
    public String searchIndexForCondition(@PathVariable("indexName")String indexName) throws Exception {

        SearchSourceBuilder searchSourceBuilder =new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("name","tts"));
        SearchRequest searchRequest =new SearchRequest(indexName).source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        return JSON.toJSONString(searchResponse);
    }


}
