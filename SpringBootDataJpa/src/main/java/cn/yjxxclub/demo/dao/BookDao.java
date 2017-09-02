package cn.yjxxclub.demo.dao;


import cn.yjxxclub.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Author: 遇见小星
 * Email: tengxing7452@163.com
 * Date: 17-5-12
 * Time: 下午3:54
 * Describe: dao接口
 */
@Repository
public interface BookDao extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book>,
        Serializable {
}
