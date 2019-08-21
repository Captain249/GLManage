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
            <div id="main" style="width: 100%;height:60%;"></div>
        </div>
    </div>
    <div class="layui-col-xs6">
        <div class="grid-demo">
            <div id="main2" style="width: 100%;height:60%;"></div>
        </div>
    </div>
</div>
<div class="layui-row">
    <div class="layui-col-xs6">
        <div class="grid-demo grid-demo-bg1">
            <div id="main3" style="width: 100%;height:60%;"></div>
        </div>
    </div>
    <div class="layui-col-xs6">
        <div class="grid-demo">3/12</div>
    </div>
</div>

<script type="text/javascript">


</script>
<script type="text/javascript">
    $(document).ready(function(){
        var monthList = [];
        for (var i = 1; i < 13; i++) {
            monthList.push(i + "月");
        }
        $.ajax({
            url:"<%=path%>/sys/getBaseData",                  //请求的路径
            data : JSON.stringify({"year":"2019"}),
            type: "POST",
            contentType:"application/json;charset=utf-8",
            success: function (data) {              //成功返回触发的方法
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));
                var myChart2 = echarts.init(document.getElementById('main2'));
                var myChart3 = echarts.init(document.getElementById('main3'));
                // 指定图表的配置项和数据

                var option = {
                    title: {
                        "text": "2019年各业绩柱状图",
                        x: "4%",
                        textStyle: {
                            color: '#000000',
                            fontSize: '22'
                        },
                    },
                    tooltip: {},
                    legend: {
                        data: ['普通团队', '疗休养','散客']
                    },
                    xAxis: {
                        data: monthList
                    },
                    yAxis: {},
                    series: [{
                        name: '普通团队',
                        type: 'bar',
                        data: data["nomalSs"]
                    },{
                        name: '疗休养',
                        type: 'bar',
                        data: data["lxySs"]
                    },{
                            name: '散客',
                            type: 'bar',
                            data: data["skSs"]
                        }]
                };

                option2 = {
                    backgroundColor: "#f2f2f2",
                    "title": {
                        "text": "2019年团队与散客比重图",
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
                        "data": ['普通团队', '疗休养','散客', '总数']
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
                        "data": monthList,
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
                        "name": "普通团队",
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
                        "data":data["nomalSs"],
                    },{
                        "name": "疗休养",
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
                        "data": data["lxySs"]
                    },
                        {
                            "name": "散客",
                            "type": "bar",
                            "stack": "总量",
                            "itemStyle": {
                                "normal": {
                                    "color": "rgba(144, 238 ,144, 0.5)",
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
                            "data": data["skSs"]
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
                            "data": data["sumSs"]
                        },
                    ]
                }

                option3 = {
                    title: {
                        "text": "2019年业绩堆叠区域图",
                        x: "2%",
                        textStyle: {
                            color: '#000000',
                            fontSize: '22'
                        },
                    },
                    tooltip : {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['普通团队', '疗休养','散客']
                    },
                    /* toolbox: {
                         feature: {
                             saveAsImage: {}
                         }
                     },*/
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            data : monthList
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'普通团队',
                            type:'line',
                            stack: '总量',
                            areaStyle: {normal: {}},
                            data:data["nomalSs"]
                        },
                        {
                            name:'疗休养',
                            type:'line',
                            stack: '总量',
                            areaStyle: {normal: {}},
                            data:data["lxySs"]
                        },
                        {
                            name:'散客',
                            type:'line',
                            stack: '总量',
                            areaStyle: {normal: {}},
                            data:data["skSs"]
                        }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
                myChart2.setOption(option2);
                myChart3.setOption(option3);
            },
            error:function(){
            }
        });
    });
</script>
</body>
</html>
