package cn.littleterry.sbmybatis.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author terry
 * @since 04/06/2019
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    BookMapper bookMapper;

    @GetMapping("/info/{id}")
    public Object get(@PathVariable("id")Integer id){
        return bookMapper.findById(id);
    }

    @PostMapping("/add")
    public Object add(@RequestBody Book book){
        bookMapper.save(book);
        return "ok";
    }

    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable("id")Integer id){
        bookMapper.deleteById(id);
        return "ok";
    }

    @PostMapping("/update")
    public Object update(@RequestBody Book book){
        bookMapper.update(book);
        return "ok";
    }
}
