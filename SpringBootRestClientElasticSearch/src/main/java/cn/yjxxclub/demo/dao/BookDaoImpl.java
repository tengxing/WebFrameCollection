package cn.yjxxclub.demo.dao;

import cn.yjxxclub.demo.model.Book;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.UUIDs;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author terry
 * @since 05/09/2019
 */
@Service
public class BookDaoImpl implements BookDao {

    @Override
    public List<Book> findAll() {
        return EsClientUtils.findAll();
    }

    @Override
    public void save(Book book) {
        if (StringUtils.isEmpty(book.getId())){
            book.setId(UUIDs.randomBase64UUID());
        }
        EsClientUtils.saveOrUpdate(book);
    }

    @Override
    public void deleteById(String id) {
        EsClientUtils.deleteById(id);
    }

    @Override
    public Book findById(String id) {
        return EsClientUtils.findById(id);
    }

}
