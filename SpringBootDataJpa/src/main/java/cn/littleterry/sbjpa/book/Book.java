package cn.littleterry.sbjpa.book;

import lombok.Data;

import javax.persistence.*;

/**
 * @author terry
 * @since 04/06/2019
 */
@Data
@Entity
@Table(name = "t_book")
public class Book implements java.io.Serializable{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "bookname")
    private String bookname;
    @Column(name = "author")
    private String author;
    @Column(name = "publish")
    private String publish;
    @Column(name = "price")
    private Double price;
    @Column(name = "time")
    private String time;
}
