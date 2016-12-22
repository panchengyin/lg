package com.lg.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.core.web.eChart.EchartData;
import com.lg.core.web.eChart.PieData;
import com.lg.core.web.eChart.Series;

@Controller
@RequestMapping("/echarts")
public class EChartController {

	private static Logger log = Logger.getLogger(EChartController.class);

	@RequestMapping("/line_data")
	@ResponseBody
	public EchartData lineData() {
		
		 	List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"上海","北京","厦门"}));//数据分组  
	        List<String> category = new ArrayList<String>(Arrays.asList(new String []{"周一","周二","周三","周四","周五","周六","周日"}));//横坐标
	        List<Series> series = new ArrayList<Series>();//纵坐标  
	        series.add(new Series("上海", "line",new ArrayList<Object>(Arrays.asList(11,23,28,26,21,33,44))));  
	        series.add(new Series("北京", "line",new ArrayList<Object>(Arrays.asList(33,21,22,43,11,14,41))));  
	        series.add(new Series("厦门", "line",new ArrayList<Object>(Arrays.asList(22,22,33,43,15,29,31))));  
	        EchartData data=new EchartData(legend, category, series);  
	        return data;  
	
	}
	@RequestMapping("/pie_data")
	@ResponseBody
	public EchartData pieData() {
		
		 	List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"直接访问","邮件营销","联盟广告","视频广告","搜索引擎"}));//数据分组  
	        List<Series> series = new ArrayList<Series>();//纵坐标  
	        List<Object> data=new ArrayList<Object>();
	        data.add(new PieData("直接访问", "335"));
	        data.add(new PieData("邮件营销", "310"));
	        data.add(new PieData("联盟广告", "224"));
	        data.add(new PieData("视频广告", "115"));
	        data.add(new PieData("搜索引擎", "80"));
	        series.add(new Series("访问来源", "pie", data));  
	      
	        EchartData eData=new EchartData(legend, null, series);  
	        return eData;  
	}
}