<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>项目管理系统</title>
    <link rel="apple-touch-icon" sizes="180x180" href="favicon.ico">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon.ico">
    <#include "common.ftl">
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header header">
        <!-- logo 区域 -->
        <div class="layui-logo layuimini-logo">
            <a href="" >
                <img src="${ctx.contextPath}/public/images/security.png" alt="logo" >
                <h1 style="margin: 0 0 0 3px">
                    项目管理系统
                </h1>
            </a>
        </div>
        <div class="layuimini-header-content">
            <!-- 头部区域 -->
            <a>
                <div class="layuimini-tool"><i title="展开" class="fa fa-outdent" data-side-fold="1"></i></div>
            </a>
            <!-- 头像区域 -->
            <ul class="layui-nav layui-layout-right" lay-filter="nav">
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" data-refresh="刷新"><i class="fa fa-refresh"></i></a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" data-clear="清理" class="layuimini-clear"><i class="fa fa-trash-o"></i></a>
                </li>

                <li class="layui-nav-item feature-items">
                    <a href="javascript:;" lay-event="tag" title="便签"><i class="ri-git-repository-line"></i></a>
                </li>

                <li class="layui-nav-item feature-items">
                    <a href="javascript:;" onclick="todo(); return false" lay-event="todo" title="待处理任务"><i class="ri-calendar-todo-line"></i></a>
                </li>

                <li class="layui-nav-item mobile layui-hide-xs" lay-unselect>
                    <a href="javascript:;" data-check-screen="full" title="全屏">
                        <i class="fa fa-arrows-alt"></i>
                    </a>
                </li>
                <li class="layui-nav-item layuimini-setting">
                    <a href="javascript:;">admin</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-iframe-tab="${ctx.contextPath}/user/setting" data-title="基本资料" data-icon="fa fa-gears">基本资料</a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-iframe-tab="${ctx.contextPath}/user/password" data-title="修改密码" data-icon="fa fa-gears">修改密码</a>
                        </dd>
                        <dd>
                            <hr>
                        </dd>
                        <dd>
                            <a href="${ctx.contextPath}/signout" class="login-out">退出登录</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item layuimini-select-bgcolor mobile layui-hide-xs" lay-unselect>
                    <a href="javascript:;"></a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-side layui-bg-black layuimini-menu-left">
        <div class="layui-side-scroll layui-left-menu">
                <ul class="layui-nav layui-nav-tree layui-left-nav-tree layui-this" id="currency">
                    <li class="layui-nav-item">
                        <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-gears"></i><span class="layui-left-nav"> 项目管理</span> <span class="layui-nav-more"></span></a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-11" data-tab="project/index?action=" target="_self"><i class="fa fa-user"></i><span class="layui-left-nav"> 项目档案</span></a>
                            </dd>

                            <dd class="">
                                <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-12" data-tab="project/index?action=deleted" target="_self"><i class="fa fa-tachometer"></i><span class="layui-left-nav">已删除项目</span></a>
                            </dd>
                            <dd class="">
                                <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-13" data-tab="project/index?action=private" target="_self"><i class="fa fa-tachometer"></i><span class="layui-left-nav"> 私人项目查询</span></a>
                            </dd>
                            <dd class="">
                                <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-14" data-tab="project/index?action=public" target="_self"><i class="fa fa-tachometer"></i><span class="layui-left-nav"> 公共项目查询</span></a>
                            </dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-gears"></i><span class="layui-left-nav"> 资产管理</span> <span class="layui-nav-more"></span></a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-11" data-tab="asset/index" target="_self"><i class="fa fa-tachometer"></i><span class="layui-left-nav"> 资产管理</span></a>
                            </dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                            <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-gears"></i><span class="layui-left-nav"> 系统设置</span> <span class="layui-nav-more"></span></a>
                            <dl class="layui-nav-child">
                                    <dd>
                                        <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-11" data-tab="user/index" target="_self"><i class="fa fa-user"></i><span class="layui-left-nav"> 用户管理</span></a>
                                    </dd>
                                    <dd class="">
                                        <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-12" data-tab="role/index" target="_self"><i class="fa fa-tachometer"></i><span class="layui-left-nav"> 角色管理</span></a>
                                    </dd>
                                    <dd class="">
                                        <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-13" data-tab="menu/index" target="_self"><i class="fa fa-tachometer"></i><span class="layui-left-nav"> 菜单管理</span></a>
                                    </dd>
                            </dl>
                        </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-gears"></i><span class="layui-left-nav"> 待办事项管理</span> <span class="layui-nav-more"></span></a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-11" data-tab="todo/index" target="_self"><i class="fa fa-tachometer"></i><span class="layui-left-nav"> 待办事项管理</span></a>
                            </dd>
                            <dd>
                                <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-12" data-tab="todo/count" target="_self"><i class="fa fa-tachometer"></i><span class="layui-left-nav"> 待办事项统计</span></a>
                            </dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-gears"></i><span class="layui-left-nav"> 统计报表</span> <span class="layui-nav-more"></span></a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-11" data-tab="user/count" target="_self"><i class="fa fa-tachometer"></i><span class="layui-left-nav"> 用户统计</span></a>
                            </dd>
                        </dl>
                    </li>
                    <span class="layui-nav-bar" style="top: 201px; height: 0px; opacity: 0;"></span>
                </ul>
        </div>
    </div>

    <div class="layui-body">
        <div class="layui-tab" lay-filter="layuiminiTab" id="top_tabs_box">
            <ul class="layui-tab-title" id="top_tabs">
                <li class="layui-this" id="layuiminiHomeTabId" lay-id="welcome"><i class="fa fa-home"></i> <span>首页</span></li>
            </ul>


            <ul class="layui-nav closeBox">
                <li class="layui-nav-item">
                    <a href="javascript:;"> <i class="fa fa-dot-circle-o"></i> 页面操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-page-close="other"><i class="fa fa-window-close"></i> 关闭其他</a></dd>
                        <dd><a href="javascript:;" data-page-close="all"><i class="fa fa-window-close-o"></i> 关闭全部</a></dd>
                    </dl>
                </li>
            </ul>

            <div class="layui-tab-content clildFrame">
                <div id="layuiminiHomeTabIframe" class="layui-tab-item layui-show">
                </div>
            </div>
        </div>
    </div>

</div>
<script>
    const roleId = "${Session.user.roleId}";
    alert(roleId);
</script>
<script type="text/javascript" src="${ctx.contextPath}/public/js/main.js"></script>
</body>
</html>
