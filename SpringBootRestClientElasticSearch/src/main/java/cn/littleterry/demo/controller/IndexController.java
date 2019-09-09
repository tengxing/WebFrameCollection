package cn.littleterry.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * IndexController
 * @author terry
 * @since 06/09/2019
 */
@Controller
@RequestMapping("/books")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public Object init(HttpServletResponse response)throws Exception{
        log("--------exe---------");
        return "init";
    }

    void log(Object str){
        System.out.println(str);
    }

}