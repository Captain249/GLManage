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
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="<%=path%>/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="<%=path%>/layuiadmin/layui/css/layui.css" media="all">
</head>
<body>
<div class="layui-inline" style="width:300px">
    <input class="layui-input" name="keyWord" id="keyWord" autocomplete="off">
</div><button class="layui-btn" data-type="reload">搜索</button>
    <table class="layui-hide" id="test" lay-filter="test"></table>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="detailmember">人员</a>
        <a class="layui-btn layui-btn-xs" lay-event="detail">详情</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script>
        layui.use('table', function(){
            var table = layui.table;
            table.render({
                elem: '#test'
                ,url:'<%=path %>/lxy/getfinishlxy'
                // ,type:'post'
                ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                ,id:'myTable'
                ,cols: [[
                    {title: '序号', width:'5%',type:'numbers', sort: true}
                    //,{field:'id', width:'5%', title: 'ID', sort: true}
                    ,{field:'grouptype', width:'10%', title: '类别'}
                    ,{field:'name', width:'13%', title: '名称'}
                    ,{field:'countmem', width:'10%', title: '人数'}
                    ,{field:'principal',width:'10%', title: '负责人'/*, width: '30%', minWidth: 100*/} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                    ,{field:'phonenum',width:'12%', title: '联系电话'}
                    ,{field:'date',width:'10%', title: '日期'}
                    ,{field:'status',width:'10%', title: '状态'}
                    ,{fixed: 'right', width:'20%', title:'操作', align:'center', toolbar: '#barDemo'}
                ]]
                ,page:true
                ,toolbar:'default'
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
            //监听工具条
            table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象
                if(layEvent === 'detail'){ //查看详情
                    $.ajax({
                        type:"post",
                        url:"<%=path %>/lxy/queryLxyById",
                        dataType:'json',
                        data: "id="+data.id ,
                        success: function (data) {
                            layer.open({
                                title:'查看详情',
                                area:['200px','350px'],
                                shade: 0.4,
                                content: data.html,
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
                            url:"<%=path %>/lxy/deleteLxyById",
                            dataType:'json',
                            data: "id="+data.id ,
                        })
                    });
                } else if(layEvent === 'edit'){ //编辑
                    //do something
                    var index = layer.open({
                        title: "编辑",
                        type: 2,
                        offset: 'auto',
                        area: ['500px', '500px'],
                        content: "<%=path%>/lxy/editLxyById?id="+data.id,
                    });
                    /*//同步更新缓存对应的值
                    obj.update({
                        grouptype: '123'
                        ,title: 'xxx'
                    });*/
                } else if(layEvent == 'detailmember'){
                    $("#member", parent.document).attr("lay-href","<%=path%>/lxy/finishlxy?member="+data.id);
                    $("#member", parent.document)[0].click();
                    $("#member", parent.document).attr("lay-href","<%=path%>/lxy/finishlxy?member=0");
                }
            });

        });

    </script>
<script>
</script>
</body>
</html>
