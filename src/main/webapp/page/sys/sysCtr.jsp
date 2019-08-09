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
            <div id="main2" style="width: 100%;height:400px;"></div>
        </div>
    </div>
</div>
<div class="layui-row">
    <div class="layui-col-xs3">
        <div class="grid-demo grid-demo-bg1">测试阶段</div>
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
                var monthList = [];
                for (var i = 1; i < 13; i++) {
                    monthList.push(i + "月");
                }
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
                        data: monthList
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
        });

        $.ajax({
            type:"get",                             //请求的类型
            url:"<%=path%>/sys/getBaseData",                  //请求的路径
            success: function (data) {//成功返回触发的方法
                var myChart2 = echarts.init(document.getElementById('main2'));
                var xData = function() {
                    var data = [];
                    for (var i = 1; i < 13; i++) {
                        data.push(i + "月");
                    }
                    return data;
                }();
                option = {
                    backgroundColor: "#f2f2f2",
                    "title": {
                        "text": "年度营业额",
                        x: "4%",
                        textStyle: {
                            color: '#000000',
                            fontSize: '22'
                        },
                    },
                    "tooltip": {
                        "trigger": "axis",
                        "axisPointer": {
                            "type": "shadow",
                            textStyle: {
                                color: "#fff"
                            }

                        },
                    },
                    "grid": {
                        "borderWidth": 0,
                        "top": 110,
                        "bottom": 95,
                        textStyle: {
                            color: "#fff"
                        }
                    },
                    "legend": {
                        x: '4%',
                        top: '11%',
                        textStyle: {
                            color: '#90979c',
                        },
                        "data": ['女', '男', '总数']
                    },


                    "calculable": true,
                    "xAxis": [{
                        "type": "category",
                        "axisLine": {
                            lineStyle: {
                                color: '#000000'
                            }
                        },
                        "splitLine": {
                            "show": false
                        },
                        "axisTick": {
                            "show": false
                        },
                        "splitArea": {
                            "show": false
                        },
                        "axisLabel": {
                            "interval": 0,

                        },
                        "data": xData,
                    }],
                    "yAxis": [{
                        "type": "value",
                        "splitLine": {
                            "show": false
                        },
                        "axisLine": {
                            lineStyle: {
                                color: '#000000'
                            }
                        },
                        "axisTick": {
                            "show": false
                        },
                        "axisLabel": {
                            "interval": 0,

                        },
                        "splitArea": {
                            "show": false
                        },

                    }],
                    "dataZoom": [{
                        "show": true,
                        "height": 30,
                        "xAxisIndex": [
                            0
                        ],
                        bottom: 30,
                        "start": 0,
                        "end": 100,
                        handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
                        handleSize: '110%',
                        handleStyle: {
                            color: "#d3dee5",

                        },
                        textStyle: {
                            color: "#000000"
                        },
                        borderColor: "#90979c"


                    }, {
                        "type": "inside",
                        "show": true,
                        "height": 15,
                        "start": 1,
                        "end": 35
                    }],
                    "series": [{
                        "name": "女",
                        "type": "bar",
                        "stack": "总量",
                        "barMaxWidth": 35,
                        "barGap": "10%",
                        "itemStyle": {
                            "normal": {
                                "color": "rgba(255,144,128,1)",
                                "barBorderRadius": 0,
                                "label": {
                                    "show": true,
                                    "textStyle": {
                                        "color": "#fff"
                                    },
                                    "position": "insideTop",
                                    formatter: function(p) {
                                        return p.value > 0 ? (p.value) : '';
                                    }
                                }
                            }
                        },
                        "data":data.list1,
                    },

                        {
                            "name": "男",
                            "type": "bar",
                            "stack": "总量",
                            "itemStyle": {
                                "normal": {
                                    "color": "rgba(0,191,183,1)",
                                    "barBorderRadius": 0,
                                    "label": {
                                        "show": true,
                                        "position": "insideTop",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            "data": data.list2
                        }, {
                            "name": "总数",
                            "type": "line",
                            "stack": "总量",
                            symbolSize: 10,
                            symbol: 'circle',
                            "itemStyle": {
                                "normal": {
                                    "color": "rgba(252,230,48,1)",
                                    "barBorderRadius": 0,
                                    "label": {
                                        "show": true,
                                        "position": "top",
                                        formatter: function(p) {
                                            return p.value > 0 ? (p.value) : '';
                                        }
                                    }
                                }
                            },
                            "data": [
                                1036,
                                3693,
                                2962,
                                3810,
                                2519,
                                1915,
                                1748,
                                4675,
                                6209,
                                4323,
                                2865,
                                4298
                            ]
                        },
                    ]
                }
                // 使用刚指定的配置项和数据显示图表。
                myChart2.setOption(option);
            },
            error:function(){
            }
        });




    });
</script>
</body>
</html>
