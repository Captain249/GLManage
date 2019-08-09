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
<table class="layui-hide" id="scatteredTable" lay-filter="tableTool"></table>

<%--左上角功能块--%>
<script type="text/html" id="barDemo2">
    <a class="layui-btn layui-btn-xs" lay-event="add">增加</a>
</script>

<%--表格右边功能块--%>
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
            elem: '#scatteredTable'
            ,url:'<%=path %>/scattered/gnhk'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,id:'myTable'
            ,method:'post'
            ,cols: [[
                {title: '序号', width:'5%',type:'numbers'}
                //,{field:'id', width:'5%', title: 'ID', sort: true}
                ,{field:'startdate', width:'15%', title: '出发日期',templet : "<div>{{layui.util.toDateString(d.startdate, 'yyyy年MM月dd日')}}</div>"}
                ,{field:'principal', width:'10%', title: '负责人'}
                ,{field:'phonenum', width:'15%', title: '手机号'}
                ,{field:'num', width:'7%', title: '人数'}
                ,{field:'name',width:'20%', title: '行程'/*, width: '30%', minWidth: 100*/} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
               /* ,{field:'receivable',width:'5%', title: '应收款'}
                ,{field:'received',width:'5%', title: '实收款'}
                ,{field:'b2b',width:'5%', title: 'b2b报名'}*/
                /*,{field:'salesroom',width:'5%', title: '门市'}*/
               /* ,{field:'contract',width:'7%', title: '合同'}
                ,{field:'invoice',width:'7%', title: '发票抬头'}*/
                ,{field:'status',width:'7%', title: '状态',templet: '#stateTpl'}
                ,{fixed: 'right', width:'21%', title:'操作', align:'center', toolbar: '#barDemo'}
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
                    url:"<%=path %>/scattered/queryScatteredById",
                    dataType:'json',
                    data: "id="+data.id ,
                    success: function (data) {
                        layer.open({
                            title:'查看详情',
                            area:['300px','300px'],
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
                        url:"<%=path %>/scattered/deleteScatteredById",
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
                    area: ['500px', '500px'],
                    content: "<%=path%>/scattered/editScatteredById?id="+data.id,
                    offset:"t"
                });
                /*//同步更新缓存对应的值
                obj.update({
                    grouptype: '123'
                    ,title: 'xxx'
                });*/
            } else if(layEvent == 'detailmember'){
                $("#member2", parent.document).attr("lay-href","<%=path%>/member/allmembersScattered?scatteredId="+data.id);
                $("#member2", parent.document)[0].click();
                //$("#member", parent.document).attr("lay-href","<%=path%>/member/allmembersScattered?scatteredId=0");
            }/*else if(layEvent == 'add'){
                    alert(11);
                }else if(layEvent == 'import'){
                    alert(112);
                }*/
        });

        //左上角功能块
        table.on('toolbar(tableTool)', function(obj){ //注：tool是工具条事件名，tableTool是table原始容器的属性 lay-filter="对应的值"
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            if(layEvent === 'add'){
                var index = layer.open({
                    title: "新增",
                    type: 2,
                    offset: 't',
                    area: ['500px', '500px'],
                    content: "<%=path%>/scattered/addScattered?type=gnhk",
                    offset:"t"
                });
            } else if(layEvent === 'import'){ //删除
                alert(1112);
            }
        });
    });

</script>

<script type="text/html" id="stateTpl">
    {{# if(d.status==0){ }}
    未完结
    {{#  } else { }}
    已完结
    {{#  } }}
</script>

</body>
</html>
