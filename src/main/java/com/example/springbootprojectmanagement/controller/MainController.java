package com.example.springbootprojectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 *
 * @author ZengQi
 * @version 1.0
 */
@Controller
public class MainController {

    /**
     * 系统登录页
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    /**
     * 系统注册页
     * @return
     */
    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

    /**
     * 系统主页面
     * @return
     */
    @RequestMapping("main")
    public String main(){
        return "main";
    }


    /**
     * 系统欢迎页
     * @return
     */
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    /**
     * 用户退出
     * @return
     */
    @RequestMapping("signout")
    public String signout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:index";
    }

}
