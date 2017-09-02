package cn.yjxxclub.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Author: 遇见小星
 * Email: tengxing7452@163.com
 * Date: 17-5-11
 * Time: 下午7:49
 * Describe: book
 */
@Document(collection = "t_app")
public class Book implements java.io.Serializable{

    @Id
    private String id;//id
    @Field(value = "bookname")
    private String bookname;//书名
    @Field(value = "author")
    private String author;//作者
    @Field(value = "publish")
    private String publish;//出版社
    @Field(value = "price")
    private double price;//价格
    @Field(value = "time")
    private String time; //出版时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
