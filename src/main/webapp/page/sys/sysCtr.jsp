<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>控制台</title>
    <link rel="stylesheet" href="<%=path%>/layuiadmin/layui/css/layui.css">
    <link rel="stylesheet" href="<%=path%>/layuiadmin/style/admin.css" media="all">
    <script src="<%=path%>/layuiadmin/jquery.min.js"></script>
    <script src="<%=path %>/echart/echarts.min.js"></script>
</head>
<body>
<div class="layui-row">
    <div class="layui-col-xs6">
        <div class="grid-demo grid-demo-bg1">
            <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
            <div id="main" style="width: 100%;height:400px;"></div>
        </div>
    </div>
    <div class="layui-col-xs6">
        <div class="grid-demo">

        </div>
    </div>
</div>
<div class="layui-row">
    <div class="layui-col-xs3">
        <div class="grid-demo grid-demo-bg1">3/12</div>
    </div>
    <div class="layui-col-xs3">
        <div class="grid-demo">3/12</div>
    </div>
    <div class="layui-col-xs3">
        <div class="grid-demo grid-demo-bg1">3/12</div>
    </div>
    <div class="layui-col-xs3">
        <div class="grid-demo">3/12</div>
    </div>
</div>

<script type="text/javascript">


</script>
<script type="text/javascript">
    $(document).ready(function(){
        $.ajax({
            type:"get",                             //请求的类型
            url:"<%=path%>/sys/getBaseData",                  //请求的路径
            success: function (data) {              //成功返回触发的方法
                var datalist = data.list1;
                var datalist4 = data.list2;
                var datalist2 = ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"];
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '报表测试功能'
                    },
                    tooltip: {},
                    legend: {
                        data:['疗休养','散客']
                    },
                    xAxis: {
                        data: datalist2
                    },
                    yAxis: {},
                    series: [{
                        name: '疗休养',
                        type: 'bar',
                        data: datalist
                    },
                        {
                            name: '散客',
                            type: 'bar',
                            data: datalist4
                        }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            },
            error:function(){

            }
        })
    });
</script>
</body>
</html>
