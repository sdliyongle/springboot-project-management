package com.example.springbootprojectmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootprojectmanagement.pojo.ProjectUser;

/**
 * <p>
 * 项目-成员表 Mapper 接口
 * </p>
 *
 * @author ZengQi
 * @since 2021-11-26
 */
public interface ProjectUserMapper extends BaseMapper<ProjectUser> {

    String findProjectLeaderById(Integer id);
}
