<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>蓝戈后台管理系统</title>

	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<meta name="keywords" content="后台管理系统">
	<meta name="description" content="后台管理系统">
	
	<!--[if lt IE 9]>
	<script type="text/javascript" src="lib/html5.js"></script>
	<script type="text/javascript" src="lib/respond.min.js"></script>
	<script type="text/javascript" src="lib/PIE_IE678.js"></script>
	<![endif]-->
		
	<!--[if IE 6]>
	<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->	
		
	<link href="<%=path%>/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css" />
	

</head>

<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header"></div>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal" action="loginController/login.do" method="post">
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i>
					</label>
					<div class="formControls col-xs-8">
						<input id="" name="username" type="text" value="cql" placeholder="账户" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i>
					</label>
					<div class="formControls col-xs-8">
						<input id="" name="password" type="password" value="111" placeholder="密码"
							class="input-text size-L">
					</div>
				</div>
				
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<label for="online">${error}</label>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input name="" type="submit" class="btn btn-success radius size-L"
							value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"> <input
							name="" type="reset" class="btn btn-default radius size-L"
							value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">Copyright ©2016 上海蓝戈信息科技发展有限公司</div>
	<script type="text/javascript" src="<%=path%>/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/static/h-ui/js/H-ui.js"></script>
	<script>
	
	</script>
</body>
</html>
