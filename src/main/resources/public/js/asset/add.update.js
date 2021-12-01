layui.use(['form', 'layer','formSelects', 'element'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
        formSelects = layui.formSelects;
        element = layui.element;

    form.on("submit(addOrUpdateAsset)", function (data) {
        index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
        //弹出loading
        var url=ctx + "/asset/add";
        if($("input[name='id']").val()){
            url=ctx + "/asset/update";
        }
        console.log(data.field);
        $.post(url, data.field, function (res) {
            if (res.code == 200) {
                setTimeout(function () {
                    top.layer.close(index);
                    top.layer.msg("操作成功！");
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                }, 500);
            } else {
                layer.msg(
                        res.message, {
                            icon: 5
                        }
                    );
            }
        });
        return false;
    });

    $("#closeDlg").click(function (){
        // iframe 页面关闭 添加parent
        parent.layer.closeAll();
    })

});