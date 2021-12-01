package com.example.springbootprojectmanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootprojectmanagement.mapper.ProjectUserMapper;
import com.example.springbootprojectmanagement.pojo.ProjectUser;
import com.example.springbootprojectmanagement.service.IProjectUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目-成员表 服务实现类
 * </p>
 *
 * @author ZengQi
 * @since 2021-11-26
 */
@Service
public class ProjectUserServiceImpl extends ServiceImpl<ProjectUserMapper, ProjectUser> implements IProjectUserService {

    /**
     * 通过项目id查询项目创建者/项目经理
     * @author ZengQi
     * @date 2021/11/26 0026 19:44
     * @param id
     * @return String
     */
    @Override
    public String findProjectLeaderById(Integer id) {
        return this.baseMapper.findProjectLeaderById(id);
    }
}
