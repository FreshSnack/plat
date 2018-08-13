$(function() {
    // 基于准备好的dom，初始化eCharts图表
    var chart = document.getElementById('div1');
    var chartData = echarts.init(chart);
    var option = {
        tooltip: {
            show: true
        },
        legend: {
            data:['销量']
        },
        xAxis : [
            {
                type : 'category',
                data : ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                "name":"销量",
                "type":"bar",
                "data":[5, 20, 40, 20, 10, 20]
            }
        ]
    };

    // 为echarts对象加载数据
    chartData.setOption(option);
});
