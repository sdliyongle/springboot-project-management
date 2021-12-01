package com.example.springbootprojectmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootprojectmanagement.pojo.User;
import com.example.springbootprojectmanagement.query.UserQuery;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ZengQi
 * @since 2021-11-26
 */
public interface IUserService extends IService<User> {
    User login(String userName, String password);

    void register(User user);

    void addUser(User user);

    Map<String, Object> userList(UserQuery userQuery);

    void deleteUser(Integer[] ids);

    void updateUser(User user);

    User getUserByActiveCode(String active_code);
}
