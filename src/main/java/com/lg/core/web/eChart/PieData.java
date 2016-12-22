package com.lg.core.web.eChart;

/**
 * Echarts饼图用
 */
public class PieData {
	private String name; // 名称
	private String value; // 值

	public PieData(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
