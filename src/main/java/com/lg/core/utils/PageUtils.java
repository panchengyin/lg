package com.lg.core.utils;

import javax.servlet.http.HttpServletRequest;

public class PageUtils {

	public static Integer getPage() {
		HttpServletRequest request = ContextHolderUtils.getRequest();
		Integer currentPage = request.getParameter("offset") == null ? 0
				: Integer.parseInt(request.getParameter("offset"));
		Integer rows = getRows();
		if (currentPage != 0) {// 获取页数
			currentPage = currentPage / rows;
		}
		currentPage += 1;
		return currentPage;
	}

	public static Integer getRows() {
		HttpServletRequest request = ContextHolderUtils.getRequest();
		Integer rows = request.getParameter("limit") == null ? 5 : Integer
				.parseInt(request.getParameter("limit"));
		return rows;
	}
	/***
	 * 该方法通过数量，算出所在页
	 * @param iDisplayStart  开始数量
	 * @param iDisplayLength 结束数量
	 * @return
	 */
	public static int CountToPageNum(int iDisplayStart,int iDisplayLength){
		int pageNum=0;
		if(iDisplayStart==0)pageNum=1;
		else{
			pageNum= (new Double(iDisplayStart/iDisplayLength)).intValue();
			pageNum++;
		}
		return pageNum;
	}
}
