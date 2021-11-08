package com.github.diegopacheco.javapocs.es.driver;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

public class ESDriver {

    private RestHighLevelClient client;

    public ESDriver() {
        client = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200, "http"),
                new HttpHost("localhost", 9201, "http")));
    }

    public GetResponse get(String index,String id){
        GetRequest getRequest = new GetRequest(
                index,
                id);
        try {
            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
            return getResponse;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SearchResponse search(String index, MatchQueryBuilder query){
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(query);
        searchRequest.source(searchSourceBuilder);

        try {
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            return searchResponse;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public IndexResponse index(Document document){
        IndexRequest request = new IndexRequest(document.getIndex());
        request.id(document.getId());
        request.source(document.getContent(), XContentType.JSON);

        try {
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            return indexResponse;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void shutDown(){
        try {
            client.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
