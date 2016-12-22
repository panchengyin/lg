package com.lg.core.web.eChart;

import java.util.ArrayList;
import java.util.List;

public class EchartData {

	public List<String> legend = new ArrayList<String>();// 数据分组
	public List<String> category = new ArrayList<String>();// 横坐标
	public List<Series> series = new ArrayList<Series>();// 纵坐标
	
	public EchartData(List<String> legend, List<String> category,
			List<Series> series) {
		super();
		this.legend = legend;
		this.category = category;
		this.series = series;
	}
	
	public List<String> getLegend() {
		return legend;
	}
	public void setLegend(List<String> legend) {
		this.legend = legend;
	}
	public List<String> getCategory() {
		return category;
	}
	public void setCategory(List<String> category) {
		this.category = category;
	}
	public List<Series> getSeries() {
		return series;
	}
	public void setSeries(List<Series> series) {
		this.series = series;
	}

	
}
