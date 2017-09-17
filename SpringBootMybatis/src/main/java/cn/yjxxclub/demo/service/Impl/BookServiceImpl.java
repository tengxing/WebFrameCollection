package cn.yjxxclub.demo.service.Impl;

import cn.yjxxclub.demo.dao.BookMapper;
import cn.yjxxclub.demo.model.Book;
import cn.yjxxclub.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-9-2
 * Time: 下午2:27
 * Describe:
 */
@Service("bookService")
public class BookServiceImpl implements BookService{

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> list() {
        return bookMapper.list();
    }

    @Override
    public Integer add(Book book) {
        return bookMapper.add(book);
    }

    @Override
    public Integer update(Book book) {
        return bookMapper.update(book);
    }

    @Override
    public Integer deleteById(Integer id) {
        return bookMapper.deleteById(id);
    }

    @Override
    public Book findById(Integer id) {
        return bookMapper.findById(id);
    }
}
