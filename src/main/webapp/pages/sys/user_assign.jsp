<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<head>
		
	</head>
	
	<body>
		<article class="page-container">
			<form class="form form-horizontal" id="from-update">
				<input type="hidden" name="id"/>
			
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>选择角色：</label>
					<div class="formControls col-xs-8 col-sm-9"> 
						<span class="select-box">
							<select name="roleType" id="roleType" class="select">
						
							</select>
						</span> 
					</div>
				</div>
				
				<div class="row cl">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
						<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 确定</button>
						<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
					</div>
				</div>
			</form>
		</article>
	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			getRoleList();
// 			var userId = getQueryString('id');
// 			if(userId) {		
// 				$.ajax({
// 		            type: "POST",
// 		            url:"<%=path%>/sysUserController/findById.do?id="+userId,
// 		            success: function(data) {
// 						$("#from-update").JsonToForm(data);
// 		            }
// 		          });	
// 			}
		});
		//获取角色列表
		function getRoleList(){
			$.ajax({
		            type: "POST",
		            url:"<%=path%>/sysRoleController/roleList.do",
		            success: function(data) {
		             	$.each(data, function(i, item){
		             		$("<option value='"+item.roleName+"'>"+item.roleName+"</option>").appendTo("#roleType");
		             	});
		            }
		   });	
		}
		//更新数据
		function toSubmit(){
			$.ajax({
                cache: true,
                type: "POST",
                url:"<%=path%>/sysUserController/edit.do",
                data:$('#from-update').serialize(),// 你的formid
                async: false,
                error: function(request) {
                   	parent.fnRefreshInfo(window.name,error,5);
                },
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