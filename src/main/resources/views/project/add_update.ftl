<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">

</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <input name="id" type="hidden" value="${(project.id)!}"/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">项目名</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input projectName"
                   lay-verify="required" name="projectName" id="projectName"  value="${(project.projectName)!}" placeholder="请输入项目名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">项目描述</label>
        <div class="layui-input-block">
            <textarea type="text" class="layui-textarea projectName"
                   name="projectDesc" id="projectDesc" value="${(project.projectDesc)!}" placeholder="请输入项目描述"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">项目经理</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"
                   name="projectLeader" value="${(projectLeader)!}"
                   id="projectLeader"
                   placeholder="请输入项目经理">
        </div>
    </div>

    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">项目进度</label>
        <div class="layui-progress layui-progress-big" lay-filter="schedule" lay-showPercent="true"
             style="margin-left: 110px; margin-top: 10px">
            <div class="layui-progress-bar layui-bg-red" lay-percent="10%"></div>
        </div>
    </div>

    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">日期范围</label>
        <div class="layui-inline" id="date">
            <div class="layui-input-inline">
                <input type="text" autocomplete="off"
                       id="beginTime" name="beginTime"
                       class="layui-input" placeholder="开始日期"
                       value="${(project.beginTime)!}"
                >
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline">
                <input type="text" autocomplete="off"
                       id="endTime" name="endTime"
                       class="layui-input" placeholder="归档日期"
                       value="${(project.endTime)!}"
                >
            </div>
        </div>
    </div>
    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit=""
                    lay-filter="addOrUpdateUser">确认
            </button>
            <a class="layui-btn layui-btn-lg layui-btn-normal"  id="closeDlg" href="javascript:void(0)">取消</a>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx.contextPath}/public/js/user/add.update.js"></script>
</body>
</html>