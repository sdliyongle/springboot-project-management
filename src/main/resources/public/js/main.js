layui.use(['element', 'layer', 'layuimini','jquery','jquery_cookie'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        $ = layui.jquery_cookie($);

    // 菜单获取
    //layuimini.init(ctx+'/api/init.json');
    $('#layuiminiHomeTabIframe').html('<iframe width="100%" height="100%" frameborder="0"  src="welcome"></iframe>')
    layuimini.initTab();

    todo = function () {
        // var X = $(this).offset().top;  //获取当前元素x坐标
        // var Y = $(this).offset().left; //获取当前元素y坐标
        var url = ctx+"/nav/todo"
        layer.open({
            type: 2,
            title: '📝 TODO',
            closeBtn: 1,
            area: ['400px', 'calc(100% - 50px)'],
            // offset: [X + 50, Y - 190],
            shadeClose: true,
            skin: 'yourclass',
            maxmin:true,
            content: url
        });
    }
});