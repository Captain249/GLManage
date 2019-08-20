<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>全部展示</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=path%>/layuiadmin/layui/css/layui.css">
    <script src="<%=path%>/layuiadmin/layui/layui.js"></script>
    <script src="<%=path%>/layuiadmin/jquery.min.js"></script>
    <link rel="stylesheet" href="<%=path%>/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="<%=path%>/layuiadmin/layui/css/layui.css" media="all">
</head>

<body>
    <%--搜索框--%>
    <div class="layui-inline" style="width:300px">
        <input class="layui-input" name="keyWord" id="keyWord" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>

    <%--表格--%>
    <table class="layui-hide" id="memberTable" lay-filter="tableTool"></table>

    <%--左上角功能块--%>
    <script type="text/html" id="barDemo2">
        <a class="layui-btn layui-btn-xs" href="<%=path%>/member/download">下载模板</a>
        <a class="layui-btn layui-btn-xs" lay-event="add">增加</a>
        <a class="layui-btn layui-btn-xs" lay-event="import" id="import">导入</a>
    </script>

    <%--表格右边功能块--%>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="detail">详情</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script>
        layui.use(['table','upload'], function(){
            var table = layui.table;
            table.render({
                elem: '#memberTable'
                ,url:'<%=path %>/member/queryAllMemberScattered?scatteredId='+${scatteredId}
                // ,type:'post'
                ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                ,id:'myTable'
                ,cols: [[
                    {title: '序号', width:'5%',type:'numbers'}
                    //,{field:'id', width:'5%', title: 'ID', sort: true}
                    ,{field:'name', width:'10%', title: '姓名'}
                    ,{field:'phonenum', width:'13%', title: '手机号'}
                   // ,{field:'address', width:'7%', title: '地址'}
                    ,{field:'idcard',width:'18%', title: '身份证号'/*, width: '30%', minWidth: 100*/} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                   // ,{field:'passport',width:'12%', title: '护照'}
                    ,{fixed: 'right', width:'20%', title:'操作', align:'center', toolbar: '#barDemo'}
                ]]
                ,page:true
                ,toolbar:'#barDemo2'
            });

            var $ = layui.jquery, active = {
                reload: function () {
                    var keyWord = $("#keyWord").val();
                    table.reload('myTable', {
                        method: 'get',
                        where: {keyWord: keyWord}
                    });
                }
            };

            $('.layui-btn').on('click', function () {
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });

            //表格右边监听工具条
            table.on('tool(tableTool)', function(obj){ //注：tool是工具条事件名，tableTool是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象
                if(layEvent === 'detail'){ //查看详情
                    $.ajax({
                        type:"post",
                        url:"<%=path %>/member/queryMemberById",
                        dataType:'json',
                        data: "id="+data.id ,
                        success: function (data) {
                            layer.open({
                                title:'查看详情',
                                area:['420px','180px'],
                                shade: 0.4,
                                content: data.html,
                                offset:"t"
                            })
                        },
                        error:function(){
                            alert("fail");
                        }
                    })
                } else if(layEvent === 'del'){ //删除
                    layer.confirm('真的删除行么', function(index){
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        $.ajax({
                            type:"post",
                            url:"<%=path %>/member/deleteMemberByIdScattered",
                            dataType:'json',
                            data: "id="+data.id ,
                        })
                    });
                } else if(layEvent === 'edit'){ //编辑
                    //do something
                    var index = layer.open({
                        title: "编辑",
                        type: 2,
                        offset: 't',
                        area: ['500px', '450px'],
                        content: "<%=path%>/member/editMemberById?id="+data.id,
                    });
                }
            });

            //左上角功能块
            table.on('toolbar(tableTool)', function(obj){ //注：tool是工具条事件名，tableTool是table原始容器的属性 lay-filter="对应的值"
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                if(layEvent === 'add'){
                    var index = layer.open({
                        title: "新增",
                        type: 2,
                        offset: 't',
                        area: ['500px', '450px'],
                        content: "<%=path%>/member/addMemberScattered",
                    });
                }
            });

            var upload = layui.upload;
            //执行实例
            var uploadInst = upload.render({
                elem: '#import' //绑定元素
                ,url: '<%=path %>/member/excelUp2' //上传接口
                ,accept: 'file'
                ,done: function(res){
                    window.location.reload();
                }
                ,error: function(){
                    alert('上传失败，请联系你儿子！');
                }
            });

        });
    </script>
</body>
</html>
