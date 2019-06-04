package cn.littleterry.sbjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * https://github.com/tengxing/WebFrameCollection
 * @author terry
 * @since 04/06/2019
 */
@EnableTransactionManagement
@SpringBootApplication
public class ThinkKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThinkKafkaApplication.class, args);
    }

}
