package cn.yjxxclub.demo.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-9-2
 * Time: 下午6:41
 * Describe: WebMvc 或氯氣
 */
public class MvnFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpServLetResponse = (HttpServletResponse) response;
        httpServLetResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServLetResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        httpServLetResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServLetResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {	}
}
