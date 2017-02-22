package com.xxbase.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 访问量统计
 *
 * @author li.fang
 * @sine 17/02/20
 */
@Component("pageViewsStatFilter")
public class PageViewsStatFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {

    }

}
