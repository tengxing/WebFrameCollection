package cn.yjxxclub.demo.dao;


import cn.yjxxclub.demo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-09-02
 * Time: 下午3:54
 * Describe: dao接口
 */
@Repository
public interface BookDao extends MongoRepository<Book, String>, Serializable {
}
