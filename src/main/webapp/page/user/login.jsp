<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
    <link href="<%=path%>/css/style.css" rel='stylesheet' type='text/css' />
    <script src="<%=path%>/layuiadmin/jquery.min.js"></script>
</head>
<style>
    html,body{
        margin: 0px 0px;
        width:100%;
        height:100%;
    }
</style>
<body>

<!--SIGN UP-->
<h1>国旅后台管理系统</h1>
<div class="login-form">
    <div class="avtar">
        <img src="<%=path%>/images/avtar.png" />
    </div>

    <form id="loginForm">
        <input type="text" name="username" class="text" value="Username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >
        <div class="key">
            <input type="password" name="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
        </div>
    </form>
    <div class="signin">
        <input type="submit" value="Login" id="submitbtn" >
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function(){
        $("#submitbtn").click(function(){
            var form =new FormData($("#loginForm")[0]);     //通过id获取表单的数据
            console.log("ajax");
            $.ajax({
                type:"POST",                             //请求的类型
                url:"<%=path%>/user/loginCheck",                  //请求的路径
                data: form,                              //请求的参数
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (flag) {              //成功返回触发的方法
                    if(flag){
                        window.location.href="<%=path%>/user/toHome";
                    }else{
                        alert('账号密码有误');
                    }
                },
                //请求失败触发的方法
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    console.log("ajax请求失败");
                    console.log("请求对象XMLHttpRequest: "+XMLHttpRequest);
                    console.log("错误类型textStatus: "+textStatus);
                    console.log("异常对象errorThrown: "+errorThrown);
                }
            })
        })
    });
</script>


<div class="copy-rights">
    <p>Copyright ©2019 中国国旅富邦门市</p>
</div>
</body>
</html>