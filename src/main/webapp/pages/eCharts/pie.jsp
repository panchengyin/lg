<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
   		<script type="text/javascript" src="<%=path%>/lib/echarts/echarts.js"></script>
   		<script type="text/javascript" src="<%=path%>/lib/echarts/echartsScript.js"></script>
   		<script type="text/javascript" src="<%=path%>/lib/echarts/theme/macarons.js"></script>
   		<script type="text/javascript" src="<%=path%>/lib/echarts/theme/infographic.js"></script>
   		<script type="text/javascript" src="<%=path%>/lib/echarts/theme/shine.js"></script>
   		<script type="text/javascript" src="<%=path%>/lib/echarts/theme/roma.js"></script>
   		<script type="text/javascript" src="<%=path%>/lib/echarts/theme/vintage.js"></script>
   		<script type="text/javascript" src="<%=path%>/lib/echarts/theme/dark.js"></script>
	</head>
	
	<body>
		<nav class="breadcrumb">
			<i class="Hui-iconfont">&#xe67f;</i>首页 
			<span class="c-gray en">&gt;</span>图表展示
			<span class="c-gray en">&gt;</span>饼图
		</nav>
		<div class="page-container">
    		<div id="main" style="width:100%;height:80%;"></div>
		</div>
	</body>
	 <script type="text/javascript">
	

      	$(document).ready(function(){
			initChart();
      	});
      	
      	function initChart(){
      		var myChart = echarts.init(document.getElementById('main'),eChartTheme);
	      	
	      	var url="<%=path%>/echarts/pie_data.do";
	      	var title="某站点用户访问来源";
	      	
	      	loadEChartsPieData(myChart,title,url);
	      	
	      	myChart.on('click', function (params) {
			 	layer.msg(params.name);
			});
			window.onresize = function () { 
				myChart.resize();
			};
      	}
    </script>
</html>