package com.example.springbootprojectmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootprojectmanagement.pojo.Project;
import com.example.springbootprojectmanagement.query.ProjectQuery;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZengQi
 * @since 2021-11-26
 */
public interface IProjectService extends IService<Project> {

    Map<String, Object> projectList(ProjectQuery projectQuery, String action);

    void deleteProject(Integer[] ids);

    void addProject(Project project);

    void updateProject(Project project);
}
