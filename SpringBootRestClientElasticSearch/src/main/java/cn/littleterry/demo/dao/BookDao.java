package cn.littleterry.demo.dao;


import cn.littleterry.demo.model.Book;

import java.util.List;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-09-02
 * Time: 下午3:54
 * Describe: dao接口
 */
public interface BookDao {
    List<Book> findAll();

    void save(Book book);

    void deleteById(String id);

    Book findById(String id);
}
