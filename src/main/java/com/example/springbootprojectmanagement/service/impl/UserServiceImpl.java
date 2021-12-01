package com.example.springbootprojectmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootprojectmanagement.mapper.UserMapper;
import com.example.springbootprojectmanagement.pojo.User;
import com.example.springbootprojectmanagement.query.UserQuery;
import com.example.springbootprojectmanagement.service.IMailService;
import com.example.springbootprojectmanagement.service.IUserService;
import com.example.springbootprojectmanagement.utils.AssertUtil;
import com.example.springbootprojectmanagement.utils.PageResultUtil;
import com.example.springbootprojectmanagement.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ZengQi
 * @since 2021-11-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private IMailService mailService;

    @Override
    public User login(String userName, String password) {
        //判断用户名是否为空
        AssertUtil.isTrue(StringUtil.isEmpty(userName),"用户名不能为空!");
        //判断密码是否为空
        AssertUtil.isTrue(StringUtil.isEmpty(password),"密码不能为空!");
        User user = this.findUserByUserName(userName);
        //能不能找到用户
        AssertUtil.isTrue(null == user,"该用户记录不存在或已注销!");
        System.out.println(user);
        //然后就是账号密码正不正确
        AssertUtil.isTrue(!(user.getPassword().equals(password)),"密码错误!");

        AssertUtil.isTrue(user.getActiveStatus() == 0, "该用户未激活");
        /**
         * 后续引入SpringSecurity 使用框架处理密码
         */
        return user;
    }

    @Override
    public void register(User user) {
        /**
         * 用户名
         * 不可重复
         * 用户默认有效
         * 设置默认备注和默认描述
         */
        User oldUser = this.findUserByUserName(user.getUserName());
        AssertUtil.isTrue(null != oldUser, "用户已存在");
        int roleId = user.getRoleId();
        String bz = "";
        String remarks = "";
        if(roleId==2) {
            bz="项目经理";
            remarks="产品经理，管理项目成员，管理项目";
        } else if(roleId==3) {
            bz="项目成员";
            remarks="项目普通成员，项目代码编写";
        } else if(roleId==4){
            bz="主管";
            remarks="项目总监，负责管理多个项目组";
        }
        user.setBz(bz);
        user.setRemarks(remarks);
        user.setIsDel(0);
        user.setRegisterTime(LocalDateTime.now());
        AssertUtil.isTrue(!(this.save(user)),"用户记录添加失败");
        String code = user.getActiveCode();
        System.out.println("激活码:"+code);
        String subject = "来自项目管理系统的激活邮件";
        //上面的激活码发送到用户注册邮箱
        String context = "<a href=\"http://www.ylxteach.net/yk2021-xm04/user/checkCode?active_code="+code+"\">激活请点击:"+code+"</a>";
        //发送激活邮件
        mailService.sendMimeMail (user.getEmail(),subject,context);
    }

    @Override
    public void addUser(User user) {
        /**
         * 用户名
         * 非空 不可重复
         * 用户默认有效
         */
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()),"用户名不能为空");
        AssertUtil.isTrue(null!=this.findUserByUserName(user.getUserName()),"用户名已存在");
        user.setIsDel(0);
        user.setActiveStatus(1);
        user.setRegisterTime(LocalDateTime.now());
        AssertUtil.isTrue(!(this.save(user)),"用户记录添加失败");
    }

    @Override
    public Map<String, Object> userList(UserQuery userQuery) {
        //分页的类
        IPage<User> page = new Page<User>(userQuery.getPage(), userQuery.getLimit());
        //QueryWrapper：sql条件查询
        //eq("is_del", 0) 代表 where is_del=0
        //详细可搜索相关用法
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("is_del",0).eq("active_status",1);

        //这里就是代表 sql语句中的 like
        if(StringUtils.isNotBlank(userQuery.getUserName())) {
            queryWrapper.like("user_name",userQuery.getUserName());
        }
        //已经写好的接口
        page = this.baseMapper.selectPage(page,queryWrapper);
        System.out.println(page.getTotal());
        return PageResultUtil.getResult(page.getTotal(),page.getRecords());
    }

    @Override
    public void deleteUser(Integer[] ids) {
        /**
         * 批量删除用户
         */
        AssertUtil.isTrue(null==ids || ids.length==0,"请选择待删除的id");

        /**
         * 第一种删除，只设置IsDel值为1，不从数据库中删除
         */
//        List<User> users = new ArrayList<>();
//        for (Integer id : ids) {
//            User temp = this.getById(id);
//            temp.setIsDel(1);
//            users.add(temp);
//        }
//        AssertUtil.isTrue(!(this.updateBatchById(users)),"用户记录删除失败");
        /**
         * 第二种删除，直接从数据库删除
         * 先采用这一种
         */
        AssertUtil.isTrue(!(this.removeByIds(Arrays.asList(ids))),"用户记录删除失败");
    }

    @Override
    public void updateUser(User user) {
        /**
         * 用户名
         * 非空 不可重复
         */
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()),"用户名不能为空");
        User temp = this.findUserByUserName(user.getUserName());
        AssertUtil.isTrue(null!=temp&&!(temp.getId().equals(user.getId())),"用户名已存在！");
        AssertUtil.isTrue(!(this.updateById(user)),"用户记录更新失败");
    }

    @Override
    public User getUserByActiveCode(String active_code) {
        return this.baseMapper.selectOne(new QueryWrapper<User>().eq("active_code",active_code));
    }

    private User findUserByUserName(String userName) {
        return this.baseMapper.selectOne(new QueryWrapper<User>().eq("user_name",userName));
    }
}
