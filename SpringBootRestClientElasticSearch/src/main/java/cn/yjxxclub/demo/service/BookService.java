package cn.yjxxclub.demo.service;

import cn.yjxxclub.demo.model.Book;

import java.util.List;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-9-2
 * Time: 下午2:26
 * Describe:
 */
public interface BookService {

    /**
     * 所有书籍
     * @return
     */
    List<Book> list();

    /**
     *  增加书籍
     * @param book
     * @return
     */
    Integer add(Book book);

    /**
     * 修改书籍
     * @param book
     * @return
     */
    Integer update(Book book);

    /**
     * 删除书籍通过id
     * @param id
     * @return
     */
    Integer deleteById(String id);

    /**
     * 通过id 找书籍
     * @param id
     * @return
     */
    Book findById(String id);
}
