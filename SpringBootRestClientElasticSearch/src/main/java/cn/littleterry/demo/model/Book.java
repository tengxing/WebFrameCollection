package cn.littleterry.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * @author terry
 * @since 04/09/2019
 */
@Data
public class Book implements java.io.Serializable{

    private String id;
    /**
     * 书名
     */
    private String bookname;
    /**
     * 作者
     */
    private String author;
    /**
     * 出版社
     */
    private String publish;
    /**
     * 价格
     */
    private double price;
    /**
     * 出版时间
     */
    private Date time;
}
