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
    var datalist = [10000, 20000, 30000, 20000, 20000, 40000,20000, 10000, 20000,50000, 10000, 10000];
    var datalist4 = [3000, 2000, 1000, 2000, 2000, 4000, 5000, 3000, 1000, 2000, 2000, 3000];
    var datalist2 = ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"];
    var datalist3 = [5, 2, 6, 10, 8, 10, 5, 7, 3, 4, 2, 7];
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '报表测试功能'
        },
        tooltip: {},
        legend: {
            data:['业绩','利润']
        },
        xAxis: {
            data: datalist2
        },
        yAxis: {},
        series: [{
            name: '业绩',
            type: 'bar',
            data: datalist
        },
            {
                name: '利润',
                type: 'bar',
                data: datalist4
            }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>
