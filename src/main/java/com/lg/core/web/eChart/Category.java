package com.lg.core.web.eChart;

public class Category {
	/**
	 * 坐标轴有三种类型，类目型、数值型和时间型 类目型：需要指定类目列表，坐标轴内有且仅有这些指定类目坐标
	 * 数值型：需要指定数值区间，不指定时则自定计算数值范围，坐标轴内包含数值区间内容全部坐标
	 * 时间型：时间型坐标轴用法同数值型，只是目标处理和格式化显示时会自动转变为时间，并且随着时间跨度的不同自动切换需要显示的时间粒度
	 * 默认为类目型'category'
	 */
	private String type = "category";
	private String[] data = { "" }; // []值 类目列表，同时也是label内容
	
	public Category(String[] data) {
		super();
		this.data = data;
	}

	public Category(String type, String[] data) {
		super();
		this.type = type;
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

}
