<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改</title>
    <link rel="stylesheet" href="<%=path%>/layuiadmin/layui/css/layui.css">
    <script src="<%=path%>/layuiadmin/layui/layui.js"></script>
    <script src="<%=path%>/layuiadmin/jquery.min.js"></script>
    <link rel="stylesheet" href="<%=path%>/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="<%=path%>/layuiadmin/layui/css/layui.css" media="all">
</head>
<body>
<form id="editForm" class="layui-form" autocomplete="off">
    <input type="text" name="id" value="${editGwj.id}" hidden="hidden" >
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name" style="width:300px;" value="${editGwj.name}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" name="phonenum" style="width:300px;" value="${editGwj.phonenum}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">公司</label>
        <div class="layui-input-block">
            <input type="text" name="company" style="width:300px;" value="${editGwj.company}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">出行时间</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" style="width:300px;" required lay-verify="required" value="${startDateGwj}" name="startdateStr" id="startdate" placeholder="yyyy年MM月dd日">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">金额(元)</label>
        <div class="layui-input-block">
            <input type="text" name="price" style="width:300px;" value="${editGwj.price}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">套现(元)</label>
        <div class="layui-input-block">
            <input type="text" name="getprice" style="width:300px;" value="${editGwj.getprice}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <input type="text" name="more" style="width:300px;" value="${editGwj.more}" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <c:if test="${editGwj.status == 1}">
                <input type="radio" name="status" value="1" title="已完结" checked>
                <input type="radio" name="status" value="0" title="未完结">
            </c:if>
            <c:if test="${editGwj.status == 0}">
                <input type="radio" name="status" value="1" title="已完结">
                <input type="radio" name="status" value="0" title="未完结" checked>
            </c:if>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" id="submitbtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            <button class="layui-btn" id="closeBt" >关闭</button>
        </div>
    </div>
</form>
<script type="text/javascript">
    layui.use(['laydate','form'], function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
        form.render();

        var laydate = layui.laydate;
        //常规用法
        laydate.render({
            elem: '#startdate',
            trigger: 'click'
        });
    });
    $("#submitbtn").click(function(){
        var form =new FormData($("#editForm")[0]);     //通过id获取表单的数据
        $.ajax({
            type:"POST",                             //请求的类型
            url:"<%=path %>/gwj/editGwj",                      //请求的路径
            data: form,                              //请求的参数
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (flag) {
                if(flag){
                    alert("保存成功！");
                    //var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    //parent.layer.close(index); //再执行关闭
                    parent.location.reload();  //刷新父页面
                }else{
                    alert('保存失败！');
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
    });

    $("#closeBt").click(function(){
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    });

</script>
</body>
</html>
