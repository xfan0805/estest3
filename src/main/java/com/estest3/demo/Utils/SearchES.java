package com.estest3.demo.Utils;


import com.estest3.demo.Domain.ESbean;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//封装一个用于ES搜索的类
public class SearchES {

    public static List<ESbean> search(String labelname) throws IOException {

        //ESutils 用于连接ES 返回client
        EsUtils esUtils = new EsUtils();
        RestHighLevelClient client = esUtils.getConnection();



        //创建search请求
        SearchRequest searchRequest = new SearchRequest("carnorm");
        searchRequest.types("norm");

        // 2、用SearchSourceBuilder来构造查询请求体 ,请仔细查看它的方法，构造各种查询的方法都在这。
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();


        //matchQuery("filedname","value")匹配单个字段，匹配字段名为filedname,值为value的文档
        //sourceBuilder.query(QueryBuilders.boolQuery()
        //.should(QueryBuilders.matchQuery("title",labelname))
        //.must(QueryBuilders.existsQuery("title")));  //返回了所有搜索值
        sourceBuilder.query(QueryBuilders.termQuery("title",labelname));

        //第几页
        sourceBuilder.from(0);
        //每页有多少条数据
        sourceBuilder.size(200);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //将请求体加入到请求中
        searchRequest.source(sourceBuilder);

        //发送请求
        SearchResponse searchResponse = client.search(searchRequest);

        //处理搜索命中文档
        SearchHit[] searchHits = searchResponse.getHits().getHits();

        List<ESbean> eSbeans = new ArrayList<>();
        for (SearchHit hit : searchHits){
            //取_source字段值
            //String sourceAsString = hit.getSourceAsString();//取成JSON串
            Map<String,Object> sourceAsMap = hit.getSourceAsMap();


            String uuid = String.valueOf(sourceAsMap.get("uuid"));
            String subuuid = String.valueOf(sourceAsMap.get("subuuid"));
            String title = String.valueOf(sourceAsMap.get("title"));
            String en_title = String.valueOf(sourceAsMap.get("en_title"));
            String standard_number = String.valueOf(sourceAsMap.get("standard_number"));
            String replace_standard = String.valueOf(sourceAsMap.get("replace_standard"));
            String pubdate = String.valueOf(sourceAsMap.get("pubdate"));
            String implement_date = String.valueOf(sourceAsMap.get("implement_date"));
            String pdf = String.valueOf(sourceAsMap.get("pdf"));
            String drafting_unit = String.valueOf(sourceAsMap.get("drafting_unit"));
            String drafter = String.valueOf(sourceAsMap.get("drafter"));
            String scope = String.valueOf(sourceAsMap.get("scope"));
            String reference_file = String.valueOf(sourceAsMap.get("reference_file"));
            String reference_file_pdf = String.valueOf(sourceAsMap.get("reference_file_pdf"));
            String reference_file_number = String.valueOf(sourceAsMap.get("reference_file_number"));
            String term_definition = String.valueOf(sourceAsMap.get("term_definition"));
            String request = String.valueOf(sourceAsMap.get("request"));

            ESbean esbean = new ESbean();

            esbean.setUuid(uuid);
            esbean.setSubuuid(subuuid);
            esbean.setTitle(title);
            esbean.setEn_title(en_title);
            esbean.setStandard_number(standard_number);
            esbean.setReplace_standard(replace_standard);
            esbean.setPubdate(pubdate);
            esbean.setImplement_date(implement_date);
            esbean.setPdf(pdf);
            esbean.setDrafting_unit(drafting_unit);
            esbean.setDrafter(drafter);
            esbean.setScope(scope);
            esbean.setReference_file(reference_file);
            esbean.setReference_file_pdf(reference_file_pdf);
            esbean.setReference_file_number(reference_file_number);
            esbean.setTerm_definition(term_definition);
            esbean.setRequest(request);

            //System.out.println(esbean);
            eSbeans.add(esbean);
        }

        return eSbeans;

    }



}
