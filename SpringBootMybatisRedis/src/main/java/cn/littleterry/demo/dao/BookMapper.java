package cn.littleterry.demo.dao;

import cn.littleterry.demo.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author terry
 * @since 28/08/2019
 */
public interface BookMapper {

    Book findById(@Param("id") Integer id);
}
