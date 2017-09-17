package cn.yjxxclub.ssm.service.impl;

import cn.yjxxclub.ssm.entity.Book;
import cn.yjxxclub.ssm.mapper.BookMapper;
import cn.yjxxclub.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: 遇见小星
 * Email: tengxing7452@163.com
 * Date: 17-5-4
 * Time: 下午10:11
 * Describe: BookService实现类
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> list() {
        return bookMapper.list();
    }

    @Override
    public Integer saveOrupdate(Book book) {
        if(null==book.getId()){
            return bookMapper.add(book);
        }
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
