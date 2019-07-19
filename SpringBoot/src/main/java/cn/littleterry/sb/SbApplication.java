package cn.littleterry.sb;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://github.com/tengxing/WebFrameCollection
 * @author terry
 * @since 04/06/2019
 */
@RestController
@SpringBootApplication
public class SbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbApplication.class, args);
    }

    @GetMapping("/hello")
    public Object get(){
        return new Book(1,"黄金时代","王小波","xxx出版社",100.00,"2019-07-17");
    }
    @Data
    @AllArgsConstructor
    class Book{
        private Integer id;
        private String bookname;
        private String author;
        private String publish;
        private Double price;
        private String time;
    }
}
