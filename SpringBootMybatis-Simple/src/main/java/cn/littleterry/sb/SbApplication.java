package cn.littleterry.sb;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * https://github.com/tengxing/WebFrameCollection/SpringBootMybatis-Simple
 * @author terry
 * @since 04/06/2019
 */
@SpringBootApplication
public class SbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SbApplication.class, args);
    }

    @Resource
    SqlSessionFactory factory;

    @Override
    @SuppressWarnings("squid:S106")
    public void run(String... args) throws SQLException {
        initDb();
    }

    private void initDb() throws SQLException {
        Connection conn = factory.openSession().getConnection();
        Statement statement = conn.createStatement();
        statement.addBatch("drop table if exists city;");
        statement.addBatch("CREATE TABLE `city` (\n" +
                "  `id` bigint(20) DEFAULT NULL,\n" +
                "  `name` varchar(255) DEFAULT NULL,\n" +
                "  `state` varchar(255) DEFAULT NULL,\n" +
                "  `country` varchar(255) DEFAULT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;" );
        statement.addBatch("insert into city (name, state, country) values ('San Francisco', 'CA', 'US');");

        System.out.println("Creating table in given database...");
        statement.executeBatch();
        System.out.println("Created table in given database...");
        statement.close();
        conn.close();
    }
}