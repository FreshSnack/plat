var chart;
var option;
$(function() {
    // 基于准备好的dom，初始化eCharts图表
    chart = echarts.init($('#div1')[0]);
    option = {
        title : {
            text: '未来一周气温变化',
            subtext: '纯属虚构'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['最高气温','最低气温']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['星期一','星期二','星期三','星期四','星期五','星期六','星期日']
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel : {
                    formatter: '{value} °C'
                }
            }
        ],
        series : [
            {
                name:'最高气温',
                type:'line',
                data:[11, 11, 15, 13, 12, 13, 10],
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均值'}
                    ]
                }
            },
            {
                name:'最低气温',
                type:'line',
                data:[1, -2, 2, 5, 3, 2, 0],
                markPoint : {
                    data : [
                        {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name : '平均值'}
                    ]
                }
            }
        ]
    };

    // 为echarts对象加载数据
    chart.setOption(option);
});

// 升高
function up() {
    var dayIndex = getDayIndex();
    var scope = $('input[name="scope"]').val();
    var temp = option.series[1].data[dayIndex]
    temp = temp + parseInt(scope);
    option.series[1].data[dayIndex] = temp;
    chart.setOption(option);
}

// 降低
function down() {
    var dayIndex = getDayIndex();
    var scope = $('input[name="scope"]').val();
    var temp = option.series[1].data[dayIndex]
    temp = temp - parseInt(scope);
    option.series[1].data[dayIndex] = temp;
    chart.setOption(option);
}

function getDayIndex() {
    var day = $('select option:selected').val();
    switch (day) {
        case "Monday":
            return 0;
            break;
        case "Tuesday":
            return 1;
            break;
        case "Wednesday":
            return 2;
            break;
        case "Thursday":
            return 3;
            break;
        case "Friday":
            return 4;
            break;
        case "Friday":
            return 5;
            break;
        case "Sunday":
            return 6;
            break;
    }
    return null;
}