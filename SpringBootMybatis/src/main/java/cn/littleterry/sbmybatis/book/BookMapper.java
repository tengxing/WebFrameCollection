package cn.littleterry.sbmybatis.book;

import org.apache.ibatis.annotations.*;

/**
 * BookMapper，SQL文件BookMapper.xml最好写在classpath*:mappers/book/
 * @author terry
 * @since 04/06/2019
 */
@Mapper
public interface BookMapper {

    @Select("SELECT * FROM t_book WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "bookname",  column = "bookname"),
            @Result(property = "author",  column = "author"),
            @Result(property = "publish",  column = "publish"),
            @Result(property = "price",  column = "price"),
            @Result(property = "time", column = "time")
    })
    Book findById(Integer id);

    @Insert("INSERT INTO t_book(id,bookname,author,publish,price,time) VALUES(null, #{bookname}, #{author}, #{publish}, #{price}, #{time})")
    int save(Book book);

    @Update("UPDATE t_book SET bookname=#{bookname},author=#{author},publish=#{publish},price=#{price},time=#{time} WHERE id =#{id}")
    int update(Book book);

    @Delete("DELETE FROM t_book WHERE id =#{id}")
    int deleteById(Integer id);
}
