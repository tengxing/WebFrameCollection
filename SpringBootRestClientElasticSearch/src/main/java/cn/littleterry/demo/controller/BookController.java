package cn.littleterry.demo.controller;

import cn.littleterry.demo.model.Book;
import cn.littleterry.demo.service.BookService;
import cn.littleterry.demo.util.ResponseUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * BookController
 * @author terry
 * @since 06/09/2019
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 添加页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String add(){
        return "add";
    }

    /**
     * 保存book
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object save(Book book, HttpServletResponse response) throws Exception{
        book.setTime(new Date());
        int r = bookService.add(book);
        JSONObject result = new JSONObject();
        result.put("success",true);
        result.put("status","200");
        if(r!=1){
            result.put("success",false);
            result.put("status","404");
        }
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 获取书籍
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object get(@PathVariable("id")String id, HttpServletResponse response)throws Exception{
        Book book = bookService.findById(id);
        JSONObject result = new JSONObject();
        result.put("book",book);
        result.put("success",true);
        result.put("status","200");
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 更新书籍
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Object put(@PathVariable("id")String id, HttpServletResponse response, Book book)throws Exception{
        book.setTime(new Date());
        int r = bookService.update(book);
        JSONObject result = new JSONObject();
        result.put("success",true);
        result.put("status","200");
        if(r!=1){
            result.put("success",false);
            result.put("status","404");
        }
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 删除书籍
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id")String id, HttpServletResponse response) throws Exception{
        int r = bookService.deleteById(id);
        JSONObject result = new JSONObject();
        result.put("success",true);
        result.put("status","200");
        if(r!=1){
            result.put("success",false);
            result.put("status","404");
        }
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 所有书籍
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Object list(HttpServletResponse response)throws Exception{
        List<Book> list = bookService.list();
        JSONObject result = new JSONObject();
        result.put("books",list);
        result.put("success",true);
        result.put("status","200");
        ResponseUtil.write(response,result);
        return null;
    }

}
