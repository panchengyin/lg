<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	
	</head>
	<body>
		
		<aside class="Hui-aside">
			<div class="menu_dropdown bk_2">
				<dl id="menu-tongji">
					<dt><i class="Hui-iconfont">&#xe61a;</i> 图表展示<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
					<dd>
						<ul>
							<li><a data-href="../pages/eCharts/line.jsp" data-title="折线图" href="javascript:void(0)">折线图</a></li>
							<li><a data-href="../pages/eCharts/pie.jsp" data-title="饼状图" href="javascript:void(0)">饼状图</a></li>
							<li><a data-href="../pages/eCharts/column.jsp" data-title="柱状图" href="javascript:void(0)">柱状图</a></li>
						</ul>
					</dd>
				</dl>
				
				<dl id="menu-system">
					<dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
					<dd>
						<ul>
							<li><a data-href="../pages/sys/user_list.jsp" data-title="用户管理" href="javascript:void(0)">用户管理</a></li>
							<li><a data-href="../pages/sys/role_list.jsp" data-title="角色管理" href="javascript:void(0)">角色管理</a></li>
							<li><a data-href="../pages/sys/resource_list.jsp" data-title="资源管理" href="javascript:void(0)">资源管理</a></li>
						</ul>
					</dd>
				</dl>
			</div>
		</aside>
		<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
		<section class="Hui-article-box">
			<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
				<div class="Hui-tabNav-wp">
					<ul id="min_title_list" class="acrossTab cl">
						<li class="active">
							<span title="欢迎页" data-href="#">欢迎页</span><em></em>
						</li>
					</ul>
				</div>
				<div class="Hui-tabNav-more btn-group">
					<a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;">
						<i class="Hui-iconfont">&#xe6d4;</i>
					</a>
					<a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;">
						<i class="Hui-iconfont">&#xe6d7;</i>
					</a>
					</div>
			</div>
			<div id="iframe_box" class="Hui-article">
				<div class="show_iframe">
					<div style="display:none" class="loading"></div>
					<iframe scrolling="yes" frameborder="0" src="../pages/main/welcome.jsp"></iframe>
				</div>
			</div>
		</section>
	
	</body>
</html>