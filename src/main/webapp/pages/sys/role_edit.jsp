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
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>角色名称：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value=""  id="roleName" name="roleName" placeholder="角色名称">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>角色类型：</label>
					<div class="formControls col-xs-8 col-sm-9"> 
						<span class="select-box">
							<select name="roleType" id="roleType" class="select">
								<option value="1">超级管理员</option>
								<option value="2">普通管理员</option>
								<option value="3">一般用户</option>
							</select>
						</span> 
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>状态：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<span class="select-box">
							<select name="roleStatus" id="roleStatus" class="select">
								<option value="1">启用</option>
								<option value="2">禁用</option>
							</select>
						</span>
					 </div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">角色描述：</label>
					<div class="formControls col-xs-8 col-sm-9">	
						<textarea  id="roleDesc" name="roleDesc" cols="" rows="" class="textarea"  placeholder="说点什么..." datatype="*0-200" dragonfly="true" onKeyUp="textarealength(this,200)"></textarea>
						<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
					</div>
				</div>
			
				<div class="row cl">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
						<button  class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 修改</button>
						<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
					</div>
				</div>
			</form>
		</article>
	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			validate();
			var roleId = getQueryString('id');
			if(roleId) {		
				$.ajax({
		            type: "POST",
		            url:"<%=path%>/sysRoleController/findById.do?id="+roleId,
		            success: function(data){
						$("#from-update").JsonToForm(data);
		            }
		          });	
			
			}
		});
		function validate(){
			$("#from-update").validate({
				rules:{
					roleName:{required:true},
				},
				onkeyup:false,
				focusCleanup:true,
				submitHandler:function(form){
					toSubmit();
				} 
			});
		}
		//更新数据
		function toSubmit(){
			$.ajax({
                cache: true,
                type: "POST",
                url:"<%=path%>/sysRoleController/edit.do",
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