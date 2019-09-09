package cn.littleterry.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序入口
 * @author terry
 * @since 06/09/2019
 */
@SpringBootApplication
public class AppAplication {
    public static void main(String[] args){
        System.out.println("--------exe------------");
        SpringApplication.run(AppAplication.class,args);
    }
}
