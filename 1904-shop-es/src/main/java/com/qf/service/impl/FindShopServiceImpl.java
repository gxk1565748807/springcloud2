package com.qf.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qf.service.FindShopService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class FindShopServiceImpl implements FindShopService {
    @Autowired
    RestHighLevelClient client;

    @Override
    public JSONArray find(String name) {
        JSONArray jsonArray = new JSONArray();
        //搜索请求对象
        SearchRequest searchRequest = new SearchRequest("qf_shop");
        //设置类型
        searchRequest.types("doc");
        //搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.query(QueryBuilders.matchQuery("name",name).operator(Operator.OR));
        //设置搜索源
        searchRequest.source(searchSourceBuilder);
        //执行搜索
        try {
            SearchResponse search = client.search(searchRequest);
            //搜索匹配结果
            SearchHits hits = search.getHits();
            SearchHit[] searchHits = hits.getHits();
            for (SearchHit hit: searchHits) {
                //定义jsonobect
                JSONObject obj = new JSONObject();
                //文档id
                String id = hit.getId();
                //源文档内容
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                //获取源文档name
                String username = (String) sourceAsMap.get("name");
                String description = (String) sourceAsMap.get("description");
                String studymodel = (String) sourceAsMap.get("studymodel");
                obj.put("name",username);
                obj.put("description",description);
                obj.put("studymodel",studymodel);
                jsonArray.add(obj);
            }
            return jsonArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
