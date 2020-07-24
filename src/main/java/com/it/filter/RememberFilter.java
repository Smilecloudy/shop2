package com.it.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther: 曹云博
 * @create: 2020-06-2020/6/11 14:35
 */
@WebFilter("/login.jsp")
public class RememberFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //Get the cookie and traverse the cookie, get the cookie value named remember and put it in the request object.
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("remember".equals(cookie.getName())) {
                    req.setAttribute("username",cookie.getValue());
                    break;
                }
            }
        }
        chain.doFilter(req, resp);
    }

    public void destroy() {

    }
}
