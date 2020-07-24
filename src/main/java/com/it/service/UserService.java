package com.it.service;

import com.it.dao.UserMapper;
import com.it.entity.User;
import com.it.util.MailUtil;
import com.it.util.Md5Util;
import com.it.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: 曹云博
 * @create: 2020-06-2020/6/10 16:10
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //用户注册
    public void register(final User user) throws Exception {
        //获取明文密码
        String password = user.getPassword();
        //加密密码
        String passwordMd5 = Md5Util.encodeByMd5(password);
        //设置状态未激活N
        String statue = "N";
        //设置激活码
        String code = UuidUtil.getUuid();
        //封装到user
        user.setPassword(passwordMd5);
        user.setState(statue);
        user.setCode(code);
        userMapper.register(user);

        new Thread() {
            @Override
            public void run() {
                String fromEmail = "boss@it.com";
                String toEmail = user.getEmail();
                String subject = "激活邮箱";
                String emailMsg = "恭喜" + user.getName() + "注册成功，请点击<a href='http://192.168.0.111:8080/user/active?code=" + user.getCode() + "'>激活</a>账号";
                MailUtil.sendMail(fromEmail, toEmail, subject, emailMsg);
            }
        }.start();
    }

    //激活用户
    public void active(String code) {
        userMapper.active(code);
    }

    //用户登录
    public User login(User user) {
        //Get the password in user and then encrypt it.
        String password = user.getPassword();
        try {
            String passwordMd5 = Md5Util.encodeByMd5(password);
            user.setPassword(passwordMd5);
            User login = userMapper.login(user);
            if (user.getUsername().equals(login.getUsername())) {
                /*The username found by the database is the same as the username entered by the user,
                and the login is successful. Returns the username of the user object*/
                return login;
            } else {
                //Login failed, there is no matching username in the database
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //验证用户名是否存在
    public Map<String, Object> checkUserName(String username) {
        Map<String, Object> map = new HashMap<String, Object>();
        String userName = userMapper.checkUserName(username);
        if (username.equals(userName)) {
            map.put("flag", false);
            map.put("msg", "已经有人抢先一步使用了这个用户名，请重新想一个");
        } else {
            map.put("flag", true);
            map.put("msg", "用户名输入正确");
        }
        return map;
    }
}
