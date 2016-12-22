var eChartErrorText = "图表请求数据失败!";
var eChartLoadText = "图表数据正在加载中...";
var eChartNoDataText = "查无数据!";
var eChartTheme = "macarons";
// 支持主题：macarons infographic shine roma vintage	 dark


/*******************************************************************************
 * 加载图表
 * 支持类型：柱状图，折线图
 * @param myChart
 *            传入图表
 * @param title
 *            标题
 * @param url
 *            数据源
 */
function loadEChartsData(myChart, title, url) {
	loadEChartsBaseTemplate(myChart);
	$.ajax({
		type : "POST",
		url : timestamp(url),
		success : function(result) {
			if (result) {
				// alert(JSON.stringify(result));
				var options = myChart.getOption();
				options.title[0].text = title;
				options.legend[0].data = result.legend;
				options.xAxis[0].data = result.category;
				options.series = result.series;
				myChart.hideLoading();
				myChart.setOption(options);
			} else {
				layer.msg(eChartNoDataText);
			}
			myChart.hideLoading();
		},
		error : function(errorMsg) {
			layer.msg(eChartErrorText);
			myChart.hideLoading();
		}
	});
}

/*******************************************************************************
 * 加载图表
 * 支持类型：饼图
 * @param myChart
 *            传入图表
 * @param title
 *            标题
 * @param url
 *            数据源
 */
function loadEChartsPieData(myChart, title, url) {
	loadEChartsByBasePie(myChart);
	$.ajax({
		type : "POST",
		url : timestamp(url),
		success : function(result) {
			if (result) {
				//alert(JSON.stringify(result));
				var options = myChart.getOption();
				options.title[0].text = title;
				options.legend[0].data = result.legend;
				options.series = result.series;
				myChart.hideLoading();
				myChart.setOption(options);
			} else {
				layer.msg(eChartNoDataText);
			}
			myChart.hideLoading();
		},
		error : function(errorMsg) {
			layer.msg(eChartErrorText);
			myChart.hideLoading();
		}
	});
}
/*******************************************************************************
 * 初始化图表模版（柱状图，折线图）
 * 
 * @param myChart
 */
function loadEChartsBaseTemplate(myChart) {
	myChart.showLoading({
		text : eChartLoadText
	});
	// 定义图表options
	option = {
		title : {},
		tooltip : {
			trigger : 'axis'
		},
		grid : {
			left : '0%',
			right : '0%',
			bottom : '0%',
			containLabel : true
		},
		legend : {
			data : []
		},
		toolbox : {
			show : true,
			feature : {
				dataView : {
					show : false,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		xAxis : [ {
			type : 'category',
			data : []
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : []
	};

	myChart.setOption(option); // 先把可选项注入myChart中
}

/*******************************************************************************
 * 初始化图表模版(饼图)
 * 
 * @param myChart
 */
function loadEChartsByBasePie(myChart) {
	myChart.showLoading({
		text : eChartLoadText
	});
	// 定义图表options
	option = {
		    title : {
		        text: '',
		        subtext: '',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: []
		    },
		    series : [
		        {
		            name: '',
		            type: 'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:[],
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]
		};
	myChart.setOption(option); // 先把可选项注入myChart中
}
