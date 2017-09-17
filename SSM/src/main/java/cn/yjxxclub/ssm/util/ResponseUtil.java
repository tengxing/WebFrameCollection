package cn.yjxxclub.ssm.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Author: 遇见小星
 * Email: tengxing7452@163.com
 * Date: 17-5-4
 * Time: 下午10:30
 * Describe: response 工具类
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
