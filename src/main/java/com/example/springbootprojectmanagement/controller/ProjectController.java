package com.example.springbootprojectmanagement.controller;


import com.example.springbootprojectmanagement.model.RespBean;
import com.example.springbootprojectmanagement.pojo.Project;
import com.example.springbootprojectmanagement.query.ProjectQuery;
import com.example.springbootprojectmanagement.service.IProjectService;
import com.example.springbootprojectmanagement.service.IProjectUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZengQi
 * @since 2021-11-26
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private IProjectService projectService;

    @Resource
    private IProjectUserService projectUserService;
    /**
     * 项目管理主界面
     * @return
     */
    @RequestMapping("index")
    public String index(String action, Model model) {
        System.out.println(action);
        if("deleted".equals(action)) {
            model.addAttribute("action",action);
            return "project/project_deleted";
        } else if("private".equals(action)) {
            model.addAttribute("action",action);
            return "project/project_private";
        } else if("public".equals(action)) {
            model.addAttribute("action",action);
            return "project/project_public";
        } else {
            return "project/project";
        }
    }


    /**
     * 添加更新项目页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("addOrUpdateUserPage")
    public String addOrUpdatePage(Integer id, Model model) {
        if (null!=id) {
            model.addAttribute("project",projectService.getById(id));
            model.addAttribute("projectLeader",projectUserService.findProjectLeaderById(id));
        }
        return "project/add_update";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> projectList(ProjectQuery projectQuery, String action) {
        return projectService.projectList(projectQuery, action);
    }

    @RequestMapping("delete")
    @ResponseBody
    public RespBean deleteProject(Integer[] ids) {
        projectService.deleteProject(ids);
        return RespBean.success("项目记录删除成功");
    }

    @RequestMapping("add")
    @ResponseBody
    public RespBean addProject(Project project) {
        projectService.addProject(project);
        return RespBean.success("项目记录添加成功");
    }


    @RequestMapping("update")
    @ResponseBody
    public RespBean updateProject(Project project) {
        projectService.updateProject(project);
        return RespBean.success("项目记录更新成功");
    }
}
