package cn.littleterry.demo.dao;

import cn.littleterry.demo.model.Book;
import org.elasticsearch.common.UUIDs;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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
