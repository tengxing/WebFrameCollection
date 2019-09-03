package cn.littleterry.demo.service.impl;

import cn.littleterry.demo.dao.BookMapper;
import cn.littleterry.demo.model.Book;
import cn.littleterry.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author terry
 * @since 27/08/2019
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public Book findById(Integer id) {
        return bookMapper.findById(id);
    }
}
