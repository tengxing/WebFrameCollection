package cn.yjxxclub.demo.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Response工具类
 * @author terry
 * @since 06/09/2019
 */
public class ResponseUtil {

    public static void write(HttpServletResponse response, Object o)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
