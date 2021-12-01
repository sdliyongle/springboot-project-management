layui.use(['form','jquery','jquery_cookie'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        $ = layui.jquery_cookie($);


    // $("#refreshCaptcha").click(function (){
    //     $(this).attr("src", "/image?"+Math.floor(Math.random() * 100));
    // })



    // 进行登录操作
    form.on('submit(register)', function (data) {
        data = data.field;
        if ( data.userName =="undefined" || data.userName =="" || data.userName.trim()=="") {
            layer.msg('用户名不能为空');
            return false;
        }
        if ( data.trueName =="undefined" || data.trueName =="" || data.trueName.trim()=="") {
            layer.msg('真实姓名不能为空');
            return false;
        }
        if ( data.email =="undefined" || data.email =="" || data.email.trim()=="") {
            layer.msg('邮箱不能为空');
            return false;
        }
        if ( data.password =="undefined" || data.password =="" || data.password.trim()=="")  {
            layer.msg('密码不能为空');
            return false;
        }
        if ( data.roleId =="undefined" || data.roleId =="" || data.roleId.trim()=="")  {
            layer.msg('角色不能为空');
            return false;
        }
        layer.msg('请等待邮箱发送')
        // if ( data.captcha =="undefined" || data.captcha =="" || data.captcha.trim()=="")  {
        //     layer.msg('验证码不能为空');
        //     return false;
        // }
        $.ajax({
            type:"post",
            url:ctx+"/user/register",
            data:{
                userName:data.userName,
                trueName: data.trueName,
                email: data.email,
                password:data.password,
                roleId: data.roleId,
            },
            dataType:"json",
            success:function (data) {
                if(data.code==200){
                    layer.msg('注册成功，请先不要关闭该页面。', function () {
                        window.location.href=ctx+"/index";
                    });
                }else{
                    layer.msg(data.message);
                }
            }
        });
        return false;
    });

});