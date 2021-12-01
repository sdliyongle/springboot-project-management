layui.use(['table','layer',"form"],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;
    //项目列表展示
    var tableIns = table.render({
        elem: '#projectList',
        url : ctx+'/project/list?action='+action,
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        id : "projectListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: "id", title:'编号',fixed:"true", width:80, sort:true},
            {field: 'projectName', title: '项目名', minWidth:50, align:"center", sort:true},
            {field: 'projectDesc', title: '项目描述', minWidth:100, align:"center", sort:true},
            {field: 'projectLeader', title: '项目经理', align:"center", sort:true},
            {field: 'schedule', title: '项目进度', align:"center", sort:true},
            {field: 'beginTime', title: '开始时间', minWidth:100, align:"center", sort:true},
            {field: 'endTime', title: '归档时间', minWidth:100, align:"center", sort:true},
            {title: '操作', minWidth:150, templet:'#projectListBar',fixed:"right",align:"center"}
        ]]
    });

    // 多条件搜索
    $(".search_btn").on("click",function(){
        table.reload("projectListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                userName: $("input[name='projectName']").val(),  //用户名
            }
        })
    });


    //头工具栏事件
    table.on('toolbar(projects)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case "add":
                openAddOrUpdateUserDialog();
                break;
            case "del":
                delUser(checkStatus.data);
                break;
            // case "relationRole":
            //     openRelationRoleDialog(checkStatus.data);
            //     break;
        };
    });


    /**
     * 行监听
     */
    table.on("tool(projects)", function(obj){
        var layEvent = obj.event;
        if(layEvent === "edit") {
            openAddOrUpdateUserDialog(obj.data.id);
        }else if(layEvent === "del") {
            layer.confirm('确定删除当前项目？', {icon: 3, title: "项目管理"}, function (index) {
                $.post(ctx+"/project/delete",{ids:obj.data.id},function (data) {
                    if(data.code==200){
                        layer.msg("操作成功！");
                        tableIns.reload();
                    }else{
                        layer.msg(data.message, {icon: 5});
                    }
                });
            })
        }
    });


    // 打开添加用户页面
    function openAddOrUpdateUserDialog(uid){
        var url  =  ctx+"/project/addOrUpdateUserPage";
        var title="项目管理-项目添加";
        if(uid){
            url = url+"?id="+uid;
            title="项目管理-项目更新";
        }
        layui.layer.open({
            title : title,
            type : 2,
            area:["800px","500px"],
            maxmin:true,
            content : url
        });
    }


    /**
     * 批量删除
     * @param datas
     */
    function delUser(datas) {
        if(datas.length==0){
            layer.msg("请选择删除记录!", {icon: 5});
            return;
        }

        layer.confirm('确定删除选中的项目记录？', {
            btn: ['确定','取消'] //按钮
        }, function(index){
            layer.close(index);
            var ids= "ids=";
            for(var i=0;i<datas.length;i++){
                if(i<datas.length-1){
                    ids=ids+datas[i].id+"&ids=";
                }else {
                    ids=ids+datas[i].id
                }
            }
            $.ajax({
                type:"post",
                url:ctx+"/project/delete",
                data:ids,
                dataType:"json",
                success:function (data) {
                    if(data.code==200){
                        tableIns.reload();
                    }else{
                        layer.msg(data.message, {icon: 5});
                    }
                }
            })
        });


    }


});
