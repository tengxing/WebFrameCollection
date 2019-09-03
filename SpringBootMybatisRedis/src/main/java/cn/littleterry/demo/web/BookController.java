package cn.littleterry.demo.web;

import cn.littleterry.demo.model.Book;
import cn.littleterry.demo.service.BookService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author terry
 * @since 28/08/2019
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/info/{id}")
    public Object get(@PathVariable("id")Integer id){
        String bookStr = redisTemplate.opsForValue().get(String.valueOf(id));
        Book book = JSON.parseObject(bookStr,Book.class);
        if (book!=null){
            return book;
        }
        book = bookService.findById(id);
        redisTemplate.opsForValue().set(String.valueOf(id), JSON.toJSONString(book));
        return book;
    }
}
