package cn.yjxxclub.demo.service.Impl;

import cn.yjxxclub.demo.dao.BookDao;
import cn.yjxxclub.demo.model.Book;
import cn.yjxxclub.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-9-2
 * Time: 下午2:27
 * Describe:
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> list() {
        List<Book> bookList = bookDao.findAll();
        return bookList;
    }

    @Override
    public Integer add(Book book) {
        bookDao.save(book);
        return 1;
    }

    @Override
    public Integer update(Book book) {
        bookDao.save(book);
        return 1;
    }

    @Override
    public Integer deleteById(String id) {
        bookDao.deleteById(id);
        return 1;
    }

    @Override
    public Book findById(String id) {

        return bookDao.findById(id);
    }
}
