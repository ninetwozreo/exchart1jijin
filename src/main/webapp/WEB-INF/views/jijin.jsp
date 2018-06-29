<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="static/echarts.common.min.js"></script>
基金投资盈亏表
</head>
<body>
<span>a</span>
<%--<div id="main"  style="width: 900px;height:600px;"></div>--%>
<span>k-fn</span>
<div id="main-fn"  style="width: 900px;height:600px;"></div>
<%--<div id="main"  style="width: 900px;height:600px;"></div>--%>
<div id="main1"  style="position:absolute;left:900px; top:0px;width: 900px;height:600px;"></div>
<span>mn</span>
<%--<div id="main2"  style="width: 900px;height:600px;"></div>--%>
<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        xAxis: {
            type: 'category',
            data:${n}
        },
        yAxis: {
        },
        series: [{

            data: ${a},
            type: 'line'
        }]
    };


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main1'));

    // 指定图表的配置项和数据
    var option = {
        xAxis: {
            type: 'category',
            data:${n}
        },
        yAxis: {
        },
        series: [{

            data: ${fn},
            type: 'line'
        }]
    };


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main2'));

    // 指定图表的配置项和数据
    var option = {
        xAxis: {
            type: 'category',
            data:${n}
        },
        yAxis: {
        },
        series: [{

            data: ${mn},
            type: 'line'
        }]
    };


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main-fn'));

    // 指定图表的配置项和数据

    var option = {
        xAxis: {
            type: 'category',
            data:${k}
        },
        yAxis: {
        },
        series: [{

            data: ${fn},
            type: 'line'
        }]
    };


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>

</body>
</html>
