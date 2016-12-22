<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<head>
		
	</head>
	
	<body>
		<article class="page-container">
			<form class="form form-horizontal" id="from-add">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>用户名称：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value=""  id="userName" name="userName" placeholder="1~16个字符，字母/中文/数字/下划线">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>账号：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value=""  id="account" name="account"  placeholder="账号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>密码：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value=""  id="password" name="password" placeholder="密码">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">电子邮箱：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value=""  id="email" name="email" placeholder="@">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">手机号码：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value=""  id="mobilePhone" name="mobilePhone" placeholder="手机号码">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">身份证：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value=""  id="idNumber" name="idNumber" placeholder="身份证">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>用户类型：</label>
					<div class="formControls col-xs-8 col-sm-9"> 
						<span class="select-box">
							<select name="userType" id="userType" class="select">
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
							<select name="status" id="status" class="select">
								<option value="1">启用</option>
								<option value="2">禁用</option>
							</select>
						</span>
					 </div>
				</div>
			
				<div class="row cl">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
						<button  class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 添加</button>
						<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
					</div>
				</div>
			</form>
		</article>
	</body>
	 <script type="text/javascript">
	 	
	 	$(document).ready(function(){
			$("#from-add").validate({
				rules:{
					userName:{required:true,minlength:1,maxlength:16},
					account:{required:true},
					password:{required:true},
					mobilePhone:{digits:true},	
					email:{email:true},
				},
				onkeyup:false,
				focusCleanup:true,
				submitHandler:function(form){
					toSubmit();
				} 
			});
	 	});
	 	//添加数据
		function toSubmit(){
			$.ajax({
                cache: true,
                type: "POST",
                url:"<%=path%>/sysUserController/add.do",
                data:$('#from-add').serialize(),// 你的formid
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