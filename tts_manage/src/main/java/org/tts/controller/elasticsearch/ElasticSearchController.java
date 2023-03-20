package org.tts.controller.elasticsearch;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.*;
import org.elasticsearch.join.query.HasChildQueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregator;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description : 进行搜索
 * @Auther : Tianjx
 * @CreateTime : 2023/03/13 17:54
 */
@RestController
@Slf4j
public class ElasticSearchController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
    /**
     *
     * @param request
     * @return
     */
    @PostMapping("es/accurateSearch")
    public String accurateSearchForOrder(HttpServletRequest request) throws IOException {
        String tid = request.getParameter("tid");
        String sellerNick = request.getParameter("sellerNick");
        String buyerNick = request.getParameter("buyerNick");
        String page = request.getParameter("page");
        String size = request.getParameter("size");
        String indexName = request.getParameter("indexName");
        int pageInt = Integer.parseInt(page);
        int sizeInt = Integer.parseInt(size);

        SearchRequest searchRequest =new SearchRequest();
        searchRequest.indices(indexName);
        SearchSourceBuilder searchSourceBuilder =new SearchSourceBuilder();
//        1、关键词会进行分词查找
       MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("tid", tid);
//        2、精确查找 如果字段是text类型，会按照分词后的结果来进行匹配
//        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("sellerNick", sellerNick);
//        3、查询所有matchAllQuery
//        MatchAllQueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
//        4、指定需要返回或者排除的字段
//        String[] includes={"tid","sellerNick"};
//        String[] excludes = {};
//        searchSourceBuilder.fetchSource(includes,excludes);
//        5、排序
//        searchSourceBuilder.sort("tid", SortOrder.DESC);
//        6、返回查询rangeQuery: gt 大于,gte 大于等于,lt 小于,lte 小于等于
//        RangeQueryBuilder queryBuilder = QueryBuilders.rangeQuery("payment");
//        queryBuilder.gte(4.00);
//        queryBuilder.lt(20.00);
//        7、添加多个doc id
//        IdsQueryBuilder queryBuilder = QueryBuilders.idsQuery();
//        queryBuilder.addIds(tid);
//        8、自定义高亮查找
//        HighlightBuilder highlightBuilder =new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("sellerNick",10);
//        highlightBuilder.requireFieldMatch(false);
//        highlightBuilder.field("buyerNick");
//        searchSourceBuilder.highlighter(highlightBuilder);
//        9、布尔查询Bool
//        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
//        boolQuery.should(QueryBuilders.matchQuery("tid",tid));
//        boolQuery.should(QueryBuilders.matchQuery("sellerNick",sellerNick));
//        boolQuery.must(QueryBuilders.matchQuery("tid",tid));
//        boolQuery.must(QueryBuilders.matchQuery("sellerNick",sellerNick));
//        10、模糊查询 需要字段进行分词才可进行查询
//        FuzzyQueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("buyerNick", buyerNick+"*").fuzziness(Fuzziness.ONE);
//        通配符模糊查询
//        WildcardQueryBuilder queryBuilder = QueryBuilders.wildcardQuery("buyerNick", buyerNick + "*");
//        11、计算最大值、最小值、平均值
//        MaxAggregationBuilder maxAggregationBuilder = AggregationBuilders.max("maxPayment").field("payment").
//                format(sdf.format(new Date())).missing(200);
//        MinAggregationBuilder minAggregationBuilder =AggregationBuilders.min("minPayment").field("payment").
//                format(sdf.format(new Date())).missing(0);
//        AvgAggregationBuilder avgAggregationBuilder =AggregationBuilders.avg("avgPayment").field("payment").
//                format(sdf.format(new Date())).missing(200);
//        searchSourceBuilder.aggregation(maxAggregationBuilder);
//        searchSourceBuilder.aggregation(minAggregationBuilder);
//        searchSourceBuilder.aggregation(avgAggregationBuilder);
//        12、统计
//        StatsAggregationBuilder aggregationBuilder = AggregationBuilders.stats("statPayment").field("payment");
//        searchSourceBuilder.aggregation(aggregationBuilder);
//        13对搜索结果去重统计
//        CardinalityAggregationBuilder aggregationBuilder = AggregationBuilders.cardinality("statusCardinality").field("status");
//        searchSourceBuilder.aggregation(aggregationBuilder);
//        14、开始对整索引进行搜索，从文档中得出第一个词，然后立马执行子聚合，首先刷选出有该词参与的文档集中的词根，并聚合其数量，排名前3的组成一个聚合结果
//        ValueCountAggregationBuilder valueCountAggregationBuilder = AggregationBuilders.count("statusCount").field("status");
//        TermsAggregationBuilder aggregationBuilder = AggregationBuilders.terms("StatusGroup").field("status")
//                .subAggregation(valueCountAggregationBuilder).collectMode(Aggregator.SubAggCollectionMode.BREADTH_FIRST).size(10).shardSize(50);

//        AggregationBuilder aggregationBuild = AggregationBuilders.terms("statusCount")
//                                                                .field("status")
//                                                                .size(10)
//                                                                .shardSize(50)
//                                                                .collectMode(Aggregator.SubAggCollectionMode.BREADTH_FIRST)
//                                                                .subAggregation(AggregationBuilders.terms("statusCount")
//                                                                                .field("olshopid")
//                                                                                .size(10));
//        searchSourceBuilder.aggregation(aggregationBuild);

        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.from((pageInt-1)*sizeInt);
        searchSourceBuilder.size(sizeInt);

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        return JSON.toJSONString(searchResponse);
    }

    /**
     *
     * @param request
     * @return
     */
    @PostMapping("es/wideSearch")
    public String wideSearchForOrder(HttpServletRequest request) throws IOException {
        String tid = request.getParameter("tid");
        String sellerNick = request.getParameter("sellerNick");
        String buyerNick = request.getParameter("buyerNick");
        String page = request.getParameter("page");
        String size = request.getParameter("size");
        String status = request.getParameter("status");
        String olshopid = request.getParameter("olshopid");
        String indexName = request.getParameter("indexName");
        int pageInt = Integer.parseInt(page);
        int sizeInt = Integer.parseInt(size);

        SearchRequest searchRequest =new SearchRequest(indexName);
        SearchSourceBuilder searchSourceBuilder =new SearchSourceBuilder();
        //父文档
        BoolQueryBuilder searchQueryBuilder = QueryBuilders.boolQuery();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.should(QueryBuilders.matchQuery("status",status));
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("buyerNick", buyerNick);
        //搜索词匹配搜索（分词后对各个单词会进行 AND查询）
        matchQuery.operator(Operator.AND);
        boolQuery.should(matchQuery);
        searchQueryBuilder.must(boolQuery);
        //子文档
        BoolQueryBuilder childerQueryBuilder = QueryBuilders.boolQuery();
//        childerQueryBuilder.must(QueryBuilders.termQuery("tid",tid));
        childerQueryBuilder.must(QueryBuilders.termQuery("oid","2554842386501010352"));
        HasChildQueryBuilder hasChildQueryBuilder =new HasChildQueryBuilder("tidOrders",childerQueryBuilder, ScoreMode.None);
        hasChildQueryBuilder.innerHit(new InnerHitBuilder());
        searchQueryBuilder.must(hasChildQueryBuilder);

//        searchBoolQuery.must(QueryBuilders.matchQuery("status",status));
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.should(QueryBuilders.matchQuery("olshopid",olshopid));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("buyerNick",buyerNick));
//        searchBoolQuery.must(boolQueryBuilder);

        searchSourceBuilder.query(searchQueryBuilder);
        searchSourceBuilder.from((pageInt-1)*sizeInt);
        searchSourceBuilder.size(sizeInt);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);


        return JSON.toJSONString(searchResponse) ;
    }
}
