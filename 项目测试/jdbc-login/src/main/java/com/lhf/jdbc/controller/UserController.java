package com.lhf.jdbc.controller;
import com.lhf.jdbc.pojo.User;
import com.lhf.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;


/**
 * 
 *
 * @author lhf
 * @email i@lhf.com
 * @date 2022-02-22 21:18:14
 */
@Controller
public class UserController {
    @Autowired
    // autowire默认使用类型注入，多个类型的时候需要使用Qualifier来指定名称，spring内置注解
    // resource默认使用名称注入，
//    @Qualifier(value = "userService")
    private UserService userService;
//    @Resource() // Resource默认使用名称注入，jdk的规范
//    private UserService userService;

    @RequestMapping({"/"})
    public String index(Model model, HttpSession session) {
        Object user = session.getAttribute("user");
        if (Objects.isNull(user)) {
            return "login";
        }
        return "index";
    }

    @RequestMapping("/userInfo")
    public String userInfo(Model model) {
        return "userInfo";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        return "index";
    }

    @RequestMapping("/login")
    public String login(User user, Model model) {
        User login = userService.login(user);
        if(login==null){
            model.addAttribute("errorMsg","用户名不存在或密码错误");
            return "login";
        }
        model.addAttribute("user",login);
        return "userInfo";
    }

}
