package cn.yjxxclub.demo;

import cn.yjxxclub.demo.dao.EsClientUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

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
