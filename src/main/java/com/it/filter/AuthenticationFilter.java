package com.it.filter;

import com.it.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther: 曹云博
 * @create: 2020-06-2020/6/11 14:23
 */
@WebFilter({"/cart.jsp", "/order_list.jsp", "/product_list.jsp"})
public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //Determine whether the user is logged in through httpsession.
        User user = (User) request.getSession().getAttribute("user");
        if (user.getUsername() != null) {
            //Login status, allow access
            chain.doFilter(req, resp);
        } else {
            //User is not logged in, redirect to login page.
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
