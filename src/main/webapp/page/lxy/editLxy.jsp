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
        <input type="text" name="id" value="${editLxy.id}" hidden="hidden" >
        <div class="layui-form-item">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-block" style="width: 300px;">
                <select name="grouptype" lay-verify="required">
                    <c:if test="${editLxy.grouptype eq '医院'}">
                        <option value="">请选择</option>
                        <option value="医院" selected>医院</option>
                        <option value="学校">学校</option>
                        <option value="企业">企业</option>
                        <option value="街道">街道</option>
                        <option value="行政事业单位">事业单位</option>
                    </c:if>
                    <c:if test="${editLxy.grouptype eq '学校'}">
                        <option value="">请选择</option>
                        <option value="医院">医院</option>
                        <option value="学校" selected>学校</option>
                        <option value="企业">企业</option>
                        <option value="街道">街道</option>
                        <option value="行政事业单位">事业单位</option>
                    </c:if>
                    <c:if test="${editLxy.grouptype eq '企业'}">
                        <option value="">请选择</option>
                        <option value="医院">医院</option>
                        <option value="学校">学校</option>
                        <option value="企业" selected>企业</option>
                        <option value="街道">街道</option>
                        <option value="行政事业单位">事业单位</option>
                    </c:if>
                    <c:if test="${editLxy.grouptype eq '街道'}">
                        <option value="">请选择</option>
                        <option value="医院">医院</option>
                        <option value="学校">学校</option>
                        <option value="企业">企业</option>
                        <option value="街道" selected>街道</option>
                        <option value="行政事业单位">事业单位</option>
                    </c:if>
                    <c:if test="${editLxy.grouptype eq '行政事业单位'}">
                        <option value="">请选择</option>
                        <option value="医院">医院</option>
                        <option value="学校">学校</option>
                        <option value="企业">企业</option>
                        <option value="街道">街道</option>
                        <option value="行政事业单位" selected>事业单位</option>
                    </c:if>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">行程</label>
            <div class="layui-input-block">
                <input type="text" name="name" style="width:300px;" required value="${editLxy.name}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">单位名</label>
            <div class="layui-input-block">
                <input type="text" name="gname" style="width:300px;" required value="${editLxy.gname}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">开始日期</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" style="width:300px;" value="${startDate}" name="startdateStr" id="startdate" placeholder="yyyy年MM月dd日">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">人数</label>
            <div class="layui-input-block">
                <input type="text" name="numcount" style="width:300px;" required value="${editLxy.numcount}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">负责人</label>
            <div class="layui-input-block">
                <input type="text" name="principal" style="width:300px;" required value="${editLxy.principal}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-block">
                <input type="text" name="phonenum" style="width:300px;" required value="${editLxy.phonenum}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">应收款(元)</label>
            <div class="layui-input-block">
                <input type="text" name="receivable" style="width:300px;" required value="${editLxy.receivable}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">实收款(元)</label>
            <div class="layui-input-block">
                <input type="text" name="received" style="width:300px;" required value="${editLxy.received}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">b2b报名(元)</label>
            <div class="layui-input-block">
                <input type="text" name="b2b" style="width:300px;" required value="${editLxy.b2b}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">操作/业务</label>
            <div class="layui-input-block">
                <input type="text" name="operator" style="width:300px;" required value="${editLxy.operator}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">门市</label>
            <div class="layui-input-block">
                <input type="text" name="salesroom" style="width:300px;" required value="${editLxy.salesroom}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">合同</label>
            <div class="layui-input-block">
                <input type="text" name="contract" style="width:300px;" required value="${editLxy.contract}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">发票抬头</label>
            <div class="layui-input-block">
                <input type="text" name="invoice" style="width:300px;" required value="${editLxy.invoice}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <input type="text" name="more" style="width:300px;" required value="${editLxy.more}" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <c:if test="${editLxy.status == 1}">
                    <input type="radio" name="status" value="1" title="已完结" checked>
                    <input type="radio" name="status" value="0" title="未完结">
                </c:if>
                <c:if test="${editLxy.status == 0}">
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
                url:"<%=path%>/lxy/editLxy",                      //请求的路径
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
