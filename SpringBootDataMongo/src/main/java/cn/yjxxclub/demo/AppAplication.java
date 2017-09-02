package cn.yjxxclub.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author: Walker.Teng
 * Email: tengxing7452@163.com
 * Date: 17-9-2
 * Time: 上午9:53
 * Describe: 启动类
 */
@SpringBootApplication
@EnableMongoRepositories("cn.yjxxclub.demo.dao")
@EnableTransactionManagement
@EntityScan("cn.yjxxclub.demo.model")
public class AppAplication {
    public static void main(String[] args){
        System.out.println("--------exe------------");
        SpringApplication.run(AppAplication.class,args);
    }
}
