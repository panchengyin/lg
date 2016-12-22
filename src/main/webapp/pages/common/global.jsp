<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<%
	String path = request.getContextPath();
%>
<!--[if lt IE 9]>
	<script type="text/javascript" src="<%=path%>/lib/html5.js"></script>
	<script type="text/javascript" src="<%=path%>/lib/respond.min.js"></script>
	<script type="text/javascript" src="<%=path%>/lib/PIE_IE678.js"></script>
<![endif]-->
		
<!--[if IE 6]>
	<script type="text/javascript" src="<%=path%>/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
		
<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui/css/H-ui.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui.admin/css/style.css" />
			
<script type="text/javascript"> var contextPath = "${pageContext.request.contextPath}";</script>
<script type="text/javascript" src="<%=path%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path%>/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="<%=path%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path%>/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="<%=path%>/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path%>/static/h-ui.admin/js/H-ui.admin.js"></script>
<!-- 表单验证 -->
<script type="text/javascript" src="<%=path%>/lib/jquery.validation/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=path%>/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=path%>/lib/jquery.validation/1.14.0/messages_zh.min.js"></script>

<script type="text/javascript" src="<%=path%>/lib/formHandle.js"></script>
<script type="text/javascript" src="<%=path%>/lib/HashTable.js"></script>
<script type="text/javascript" src="<%=path%>/lib/commandScript.js"></script>

<script type="text/javascript">
	var error="网络连接异常...";
	//屏蔽readonly下按backspace键返回的功能
	$(document).keydown(
			function(e) {
				var event = arguments.callee.caller.arguments[0]|| window.event;// 修正浏览器兼容 
				var target = e.target;
				var tag = e.target.tagName.toUpperCase();
				if (event.keyCode == 8) {
					if ((tag == 'INPUT' && !$(target).attr("readonly"))
							|| (tag == 'TEXTAREA' && !$(target)
									.attr("readonly"))) {
						if ((target.type.toUpperCase() == "RADIO")
								|| (target.type.toUpperCase() == "CHECKBOX")) {
							return false;
						} else {
							return true;
						}
					} else {
						return false;
					}
				}
	});
</script>
