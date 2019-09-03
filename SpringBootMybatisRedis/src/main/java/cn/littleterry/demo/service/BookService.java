package cn.littleterry.demo.service;

import cn.littleterry.demo.model.Book;

/**
 * @author terry
 * @since 28/08/2019
 */
public interface BookService {
    Book findById(Integer id);
}
