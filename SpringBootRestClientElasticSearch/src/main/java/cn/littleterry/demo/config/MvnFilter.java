package cn.littleterry.demo.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Web mvc配置
 * @author terry
 * @since 06/09/2019
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
