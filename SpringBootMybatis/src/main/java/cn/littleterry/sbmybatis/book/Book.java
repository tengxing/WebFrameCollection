package cn.littleterry.sbmybatis.book;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author terry
 * @since 04/06/2019
 */
@Data
@AllArgsConstructor
public class Book implements java.io.Serializable{

    private Integer id;
    private String bookname;
    private String author;
    private String publish;
    private Double price;
    private String time;
}
