package cn.yjxxclub.demo.dao;

import cn.yjxxclub.demo.model.Book;
import cn.yjxxclub.demo.util.PropertiesUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
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
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Es CURD工具类
 * @author terry
 * @since 06/09/2019
 */
public class EsClientUtils {
    private static String host = PropertiesUtil.prop("elasticsearch.rest.host");
    private static Integer port = Integer.parseInt(PropertiesUtil.prop("elasticsearch.rest.port"));
    private static String index = PropertiesUtil.prop("elasticsearch.rest.index");

    public static void main(String[] args) {
        findAll();
    }

    /**
     * findAll
     * @return
     */
    public static List<Book> findAll() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        SearchRequest searchRequest = new SearchRequest().indices("terry");
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = null;

        try(
                RestHighLevelClient client = getInstance()
        ) {
            searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestStatus status = searchResponse.status();
        System.out.println(status.getStatus());

        SearchHits hits = searchResponse.getHits();

        List<Book> list = new ArrayList<>();
        for (SearchHit searchHit : hits.getHits()) {
            Book book = JSON.parseObject(JSON.toJSONString(searchHit.getSourceAsMap()),Book.class);
            book.setId(searchHit.getId());
            list.add(book);
        }
        System.out.println(JSON.toJSONString(list));
        return list;
    }

    /**
     * saveOrUpdate
     * @param book
     */
    public static void saveOrUpdate(Book book) {
        IndexRequest request = new IndexRequest(index).id(book.getId());

        String jsonStr = JSON.toJSONString(book);
        request.source(jsonStr, XContentType.JSON);

        IndexResponse indexResponse = null;
        try(
                RestHighLevelClient client = getInstance()
        ) {
            indexResponse = client.index(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (indexResponse!=null){
            String index = indexResponse.getIndex();
            String id = indexResponse.getId();
            if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
                System.out.println("_index:"+index+" document:"+id +" created successfully!");
            }else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED){
                System.out.println("_index:"+index+" document:"+id +" updated successfully!");
            }else {
                System.out.println("不明操作类型:" + indexResponse.getResult());
            }
        }
    }

    public static Book findById(String id) {
        GetRequest getRequest = new GetRequest(index).id(id);

        GetResponse getResponse = null;
        try(
                RestHighLevelClient client = getInstance()
        ) {
            getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Book book = JSON.parseObject(JSON.toJSONString(getResponse.getSourceAsMap()),Book.class);
        return book;
    }

    public static void deleteById(String id) {
        DeleteRequest deleteRequest = new DeleteRequest(index).id(id);

        DeleteResponse deleteResponse = null;
        try(
                RestHighLevelClient client = getInstance()
        ) {
            deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RestStatus status = deleteResponse.status();
        if (status.getStatus() == 200){
            System.out.println("删除ID:"+id +" 成功！");
        }
    }

    public void test() {
        Book book = new Book();
        book.setId("1");
        book.setBookname("ES7.3.1官方指南1");
        book.setAuthor("terry");
        book.setPrice(0.00);
        book.setTime(new Date(System.currentTimeMillis()));

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(host, port, "http")
                )
        );

        IndexRequest request = new IndexRequest(index).id(book.getId());
        String jsonStr = JSON.toJSONString(book);
        request.source(jsonStr, XContentType.JSON);

        IndexResponse indexResponse = null;
        try {
            indexResponse = client.index(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static RestHighLevelClient getInstance() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(host, port, "http")
                )
        );
        return client;
    }


}
