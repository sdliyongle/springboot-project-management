package com.example.springbootprojectmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootprojectmanagement.mapper.ProjectMapper;
import com.example.springbootprojectmanagement.pojo.Project;
import com.example.springbootprojectmanagement.query.ProjectQuery;
import com.example.springbootprojectmanagement.service.IProjectService;
import com.example.springbootprojectmanagement.service.IProjectUserService;
import com.example.springbootprojectmanagement.utils.PageResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZengQi
 * @since 2021-11-26
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Resource
    private IProjectUserService projectUserService;

    @Override
    public Map<String, Object> projectList(ProjectQuery projectQuery, String action) {
        //分页的类
        IPage<Project> page = new Page<Project>(projectQuery.getPage(), projectQuery.getLimit());
        //QueryWrapper：sql条件查询
        //eq("is_del", 0) 代表 where is_del=0
        //详细可搜索相关用法
        QueryWrapper<Project> queryWrapper = new QueryWrapper<Project>();
        if(StringUtils.isBlank(action)) {
            queryWrapper.eq("is_private",0).eq("is_del",0);
        } else if("deleted".equals(action)) {
            queryWrapper.eq("is_del",1);
        } else if("private".equals(action)) {
            queryWrapper.eq("is_private",1);
        } else if("public".equals(action)) {
            queryWrapper.eq("is_private",0);
        }
        //这里就是代表 sql语句中的 like
        if(StringUtils.isNotBlank(projectQuery.getProjectName())) {
            queryWrapper.like("project_name",projectQuery.getProjectName());
        }
        //已经写好的接口
        page = this.baseMapper.selectPage(page,queryWrapper);
        List<Project> projectList = page.getRecords();
        for(Project p : projectList) {
            p.setProjectLeader(projectUserService.findProjectLeaderById(p.getId()));
        }
        System.out.println(projectList);
        return PageResultUtil.getResult(page.getTotal(),projectList);
    }

    @Override
    public void deleteProject(Integer[] ids) {

    }

    @Override
    public void addProject(Project project) {

    }

    @Override
    public void updateProject(Project project) {

    }
}
