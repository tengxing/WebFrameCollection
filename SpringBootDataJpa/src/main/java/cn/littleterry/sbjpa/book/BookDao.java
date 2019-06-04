package cn.littleterry.sbjpa.book;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author terry
 * @since 04/06/2019
 */
@Repository
public interface BookDao extends CrudRepository<Book, Integer>, JpaSpecificationExecutor<Book>,
        Serializable {
}
