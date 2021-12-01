package com.example.springbootprojectmanagement.controller;


import com.example.springbootprojectmanagement.model.RespBean;
import com.example.springbootprojectmanagement.pojo.User;
import com.example.springbootprojectmanagement.query.UserQuery;
import com.example.springbootprojectmanagement.service.IUserService;
import com.example.springbootprojectmanagement.utils.IDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ZengQi
 * @since 2021-11-26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 用户管理主界面
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "user/user";
    }

    /**
     * 添加更新用户页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("addOrUpdateUserPage")
    public String addOrUpdatePage(Integer id, Model model) {
        if (null!=id) {
            model.addAttribute("user",userService.getById(id));
        }
        return "user/add_update";
    }

    @RequestMapping("login")
    @ResponseBody
    public RespBean login(String userName, String password, HttpSession session){
        System.out.println(userName);
        System.out.println(password);
        User user = userService.login(userName,password);
        session.setAttribute("user",user);
        return RespBean.success("用户登录成功!");
    }

    @RequestMapping("register")
    @ResponseBody
    public RespBean register(User user) {
        user.setActiveStatus(0);
        String activeCode = IDUtils.getUUID();
        user.setActiveCode(activeCode);
        userService.register(user);
        return RespBean.success("用户注册成功!请前往邮箱激活");
    }

    /**
     * 校验激活码
     * @param active_code
     * @return
     */
    @RequestMapping("checkCode")
    @ResponseBody
    public String checkCode(String active_code) {
        User user = userService.getUserByActiveCode(active_code);
        //如果用户不等于null，把用户状态修改status=1
        if (user !=null) {
            user.setActiveStatus(1);
            //把code验证码清空，已经不需要了
            user.setActiveCode("");
            userService.updateUser(user);
            return "账号已激活";
        }
        return "激活失败";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> userList(UserQuery userQuery) {
        return userService.userList(userQuery);
    }

    @RequestMapping("delete")
    @ResponseBody
    public RespBean deleteUser(Integer[] ids) {
        userService.deleteUser(ids);
        return RespBean.success("用户记录删除成功");
    }

    @RequestMapping("add")
    @ResponseBody
    public RespBean addUser(User user) {
        userService.addUser(user);
        return RespBean.success("用户记录添加成功");
    }


    @RequestMapping("update")
    @ResponseBody
    public RespBean updateUser(User user) {
        userService.updateUser(user);
        return RespBean.success("用户记录更新成功");
    }

}
