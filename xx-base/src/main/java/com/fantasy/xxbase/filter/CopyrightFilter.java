package com.fantasy.xxbase.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在请求返回值上添加版权说明
 *
 * @author li.fang
 * @since 2017/02/17
 */
@Component("copyrightFilter")
public class CopyrightFilter extends OncePerRequestFilter {

    private static final String pragma = new StringBuffer(10).append("yB").append("-").append("der").append("ewoP").reverse().toString();
    private static final String value = new StringBuffer(15).append("moc").append(".").append("ys").append("ats").append("naf").append("-xx").reverse().toString();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        response.addHeader(pragma, value);

        filterChain.doFilter(request, response);
    }
}
