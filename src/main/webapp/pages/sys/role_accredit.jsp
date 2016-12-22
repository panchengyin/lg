<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>	
	<head>	
		<link rel="stylesheet" href="<%=path%>/lib/jstree/themes/default/style.css" />  
		<script src="<%=path%>/lib/jstree/jstree.min.js"></script>  
	</head>
	
	<body>
		<div class="page-container">
		 	<div id="orgjsTree" ></div>
		 	 
		 	<div  class="text-c mt-20">
		 		<button  class="btn btn-primary radius" type="button" onclick="saveTree()"><i class="Hui-iconfont">&#xe632;</i>保存</button>
		 	</div>
		</div>
	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			initJsTree();
		});
		function initJsTree(){
			var roleId = getQueryString('roleId');
			$.ajax({
			     type: "POST",
			     url:timestamp("<%=path%>/sysResourceController/getTree.do"),
			     data:"roleId="+roleId,
			     success: function(data) {
			     	$('#orgjsTree').data('jstree', false).empty();  
			    	if(data!="")isTreeNull=true;
			    	$('#orgjsTree').jstree({'plugins':["wholerow","checkbox"], 'core' : {  
						 'data' : data
					}}); 
			     }
			 });	
		};
		function saveTree(){
			var roleId = getQueryString('roleId');
			var ids = $('#orgjsTree').jstree().get_checked(); 
			console.info(ids);
			$.ajax({
			     type: "POST",
			     url:timestamp("<%=path%>/sysResourceController/batchAdd.do"),
			     data:"roleId="+roleId+"&resourceIds="+ids,
			     success: function(data) {
			     	 if(data.success){
                   		parent.fnRefreshInfo(window.name,data.msg,1);
					}else{
						parent.fnRefreshInfo(window.name,data.msg,2);	
					}
			     }
			 });	
		}
		//关闭窗口
		function removeIframe(){
			 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	         parent.layer.close(index);	
		}
	</script>
</html>