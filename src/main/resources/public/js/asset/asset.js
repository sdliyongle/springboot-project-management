layui.use(['table','layer',"form"],function(){
       var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;
    //资产列表展示
    console.log(ctx);
    var tableIns = table.render({
        elem: '#assetList',
        url : ctx+'/asset/list',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        id : "assetListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: "id", title:'编号',fixed:"true", width:80, sort:true},
            {field: 'assetName', title: '资产名', minWidth:50, align:"center", sort:true},
            {field: 'projectCode', title: '项目ID', minWidth:50, align:"center", sort:true},
            {field: 'assetType', title: '资产类型', minWidth:50, align:"center", sort:true},
            {field: 'assetStatus', title: '资产状态', minWidth:50, align:"center", sort:true},
            {field: 'assetValue', title: '资产价值', minWidth:50, align:"center", sort:true},
            {field: 'assetRentalStatus', title: '是否外借', minWidth:50, align:"center", sort:true},
            {field: 'assetBuyTime', title: '添加时间', minWidth:50, align:"center", sort:true},
            {title: '操作', minWidth:150, templet:'#assetListBar',fixed:"right",align:"center"}
        ]]
    });

    // 多条件搜索
    $(".search_btn").on("click",function(){
        table.reload("assetListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                assetName: $("input[name='assetName']").val(),  //资产名
            }
        })
    });


    //头工具栏事件
    table.on('toolbar(assets)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case "add":
                openAddOrUpdateAssetDialog();
                break;
            case "del":
                delAsset(checkStatus.data);
                break;
            // case "relationRole":
            //     openRelationRoleDialog(checkStatus.data);
            //     break;
        };
    });


    /**
     * 行监听
     */
    table.on("tool(assets)", function(obj){
        var layEvent = obj.event;
        if(layEvent === "edit") {
            openAddOrUpdateAssetDialog(obj.data.id);
        }else if(layEvent === "del") {
            layer.confirm('确定删除当前资产？', {icon: 3, title: "资产管理"}, function (index) {
                $.post(ctx+"/asset/delete",{ids:obj.data.id},function (data) {
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


    // 打开添加资产页面
    function openAddOrUpdateAssetDialog(uid){
        var url  =  ctx+"/asset/addOrUpdateAssetPage";
        var title="资产管理-资产添加";
        if(uid){
            url = url+"?id="+uid;
            title="资产管理-资产更新";
        }
        layui.layer.open({
            title : title,
            type : 2,
            area:["700px","420px"],
            maxmin:true,
            content : url
        });
    }


    /**
     * 批量删除
     * @param datas
     */
    function delAsset(datas) {
        if(datas.length==0){
            layer.msg("请选择删除记录!", {icon: 5});
            return;
        }

        layer.confirm('确定删除选中的资产记录？', {
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
                url:ctx+"/asset/delete",
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
