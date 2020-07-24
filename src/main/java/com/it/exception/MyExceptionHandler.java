package com.it.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther: 曹云博
 * @create: 2020-06-2020/6/10 16:19
 */
//自定义全局异常处理器
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("exp", ex);

        modelAndView.setViewName("forward:/WEB-INF/error.jsp");
        return modelAndView;
    }
}
