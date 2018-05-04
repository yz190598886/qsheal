package com.yz.vip.web.handler;

import com.yz.vip.entity.User;
import com.yz.vip.function.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by youthz on 2018/5/3.
 */
    @Controller
public class loginHandler {

    @Autowired
    UserService userService;

    @RequestMapping("/login.do")
    public String Login(String name, String password, HttpServletRequest request) {
        try {
            User u = userService.login(name, password);
            HttpSession session=request.getSession();
            session.setAttribute("currentUser", u);

        } catch (Exception e) {
            request.setAttribute("message",e.getMessage());
            return  "forward:login.jsp";
        }
        return "redirect:/index";

    }
    @RequestMapping("/index.do")
    public String index(){
        return "index";
    }
    }
