package com.example.springbootprojectmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootprojectmanagement.pojo.ProjectUser;

/**
 * <p>
 * 项目-成员表 服务类
 * </p>
 *
 * @author ZengQi
 * @since 2021-11-26
 */
public interface IProjectUserService extends IService<ProjectUser> {
    String findProjectLeaderById(Integer id);
}
