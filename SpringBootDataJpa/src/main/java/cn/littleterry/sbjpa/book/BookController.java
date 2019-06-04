package cn.littleterry.sbjpa.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author terry
 * @since 04/06/2019
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookDao bookDao;

    @GetMapping("/info/{id}")
    public Object get(@PathVariable("id")Integer id){
        return bookDao.findById(id);
    }

    @PostMapping("/add")
    public Object add(@RequestBody Book book){
        bookDao.save(book);
        return "ok";
    }

    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable("id")Integer id){
        bookDao.deleteById(id);
        return "ok";
    }

    @PostMapping("/update")
    public Object update(@RequestBody Book book){
        bookDao.save(book);
        return "ok";
    }
}
