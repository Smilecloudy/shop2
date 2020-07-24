package com.it.controller;

import com.it.entity.User;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @auther: 曹云博
 * @create: 2020-06-2020/6/10 16:07
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //用户注册
    @RequestMapping("/register")
    public String register(User user) throws Exception {
        userService.register(user);
        return "redirect:/register_ok.jsp";
    }

    //用户激活
    @RequestMapping("/active")
    public String active(String code) {
        userService.active(code);
        return "redirect:/default.jsp";
    }

    //用户登录
    @RequestMapping("/login")
    public String login(User user, String remember, HttpServletRequest request, HttpServletResponse response) {
        User loginUser = userService.login(user);
        //--------------------------------Remember username function-------------------------------------------
        if (loginUser != null) {
            //Store user in Httpsession, easy to get user on jsp page.
            request.getSession().setAttribute("user", loginUser);
            if ("true".equals(remember)) {
                //If remember is true, it means that the user chose to remember the username.
                //Store the user name in the cookie named remember.Set life cycle to one day.
                Cookie cookie = new Cookie("remember", loginUser.getUsername());
                cookie.setMaxAge(60 * 60 * 24);
                //Only in the current project directory can you have permission to access the value of the cookie.
                cookie.setPath("/");
                //Put the cookie in the response object and respond to the browser.
                response.addCookie(cookie);
            } else {
                //If the user does not check Remember username, the cookie named remember is destroyed.
                Cookie cookie = new Cookie("remember", null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            //--------------------------------Remember username function-------------------------------------------
            //Successful login, redirect to default.jsp page.
            return "redirect:/default.jsp";
        } else {
            /*
            If the user does not log in successfully, they are also redirected to the default.jsp page because the judgment has been made on the jsp page，
            If there is no cookie named remember in the cookie, the guest login will be displayed.
             */
            return "redirect:/default.jsp";
        }
    }

    //用户退出
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //The user logs out and removes the session named remember,and redirect to the login page.
        session.invalidate();
        return "redirect:/login.jsp";
    }

    //验证用户名是否存在
    @RequestMapping(value = "/checkUserName",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String, Object> checkUserName(@RequestBody String username) {
        System.out.println(username);
        Map<String, Object> map = userService.checkUserName(username);
        return map;
    }


}
