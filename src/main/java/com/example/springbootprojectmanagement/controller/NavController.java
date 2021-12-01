package com.example.springbootprojectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZengQi
 * @description: TODO
 * @date 2021/12/1 0001 9:51
 */
@Controller
@RequestMapping("nav")
public class NavController {

    /**
     * todo待办事件
     * @author ZengQi
     * @date 2021/12/1 0001 9:48
     */
    @RequestMapping("todo")
    public String todo() {
        return "nav/todo";
    }
}
