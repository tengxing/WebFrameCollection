package cn.littleterry.sbmybatis;

import cn.littleterry.sbmybatis.book.Book;
import cn.littleterry.sbmybatis.book.BookMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbApplicationTests {

    @Resource
    private BookMapper bookMapper;

    @Test
    public void testInsert() {
        Integer a = bookMapper.save(new Book(null,"《高级架构宝典》", "terry","人教版",111.0,""));
        Integer b = bookMapper.save(new Book(null,"《kafka核心解密》", "terry","人教版",100.0,""));
        Integer c = bookMapper.save(new Book(null,"《哈希算法解密》", "terry","人教版",70.0,""));

        Assert.assertEquals(3, a+b+c);
    }

}
