<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@ include file="../common/global.jsp"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
	</head>
	
	<body>
		<nav class="breadcrumb">
			<i class="Hui-iconfont">&#xe67f;</i>首页 
			<span class="c-gray en">&gt;</span>系统管理
			<span class="c-gray en">&gt;</span>角色管理
		</nav>
		<div class="page-container">
			<!-- 条件栏 -->
			<div class="text-c">
				<input type="text"  id="txt_search" placeholder="请输入角色名称" style="width:40%" class="input-text"  onkeypress="if(event.keyCode==13) {fnRefresh();return false;}">
				<button class="btn btn-success" onclick="fnRefresh()"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
				<a class="btn btn-success"  title="刷新" onclick="fnRefreshAndClear()"><i class="Hui-iconfont">&#xe68f;</i></a>
			</div>
			<!-- 工具栏 -->
			<div class="cl pd-5 bg-1 bk-gray mt-20"> 
				<span class="l">
					<a href="javascript:;" onclick="batchDel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
					<a class="btn btn-primary radius"  onclick="add();" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加</a>
					<a class="btn btn-secondary radius"  onclick="accredit()" href="javascript:;"><i class="Hui-iconfont">&#xe61d;</i> 授权</a>
				</span>  
			</div>
			<!-- 列表 -->
			<div class="mt-20">
				<table id="table_user" class="table table-border table-bordered table-bg table-hover table-sort" width="100%">
					<thead>
						<tr class="text-c">
							<th width="25"><input type="checkbox" name="" value=""></th>
							<th width="150">角色名称</th>
							<th width="120">角色类型</th>
							<th width="70">状态</th>
							<th >角色描述</th>
							<th width="80">操作</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
	</body>
	

	<script type="text/javascript">
		
		var oTable=null;
		$(document).ready(function(){
			queryList();
		});
		function queryList(){
			oTable=$("#table_user").dataTable({
				"aaSorting": [[ 1, "desc" ]],//默认第几个排序
				"bStateSave": false,//状态保存
				"serverSide":true,///是否启用服务器模式
				"bFilter": false, //是否启用客户端过滤器
				"bSort": false,//是否启用排序
				"bLengthChange": false, //是否显示每页大小的下拉框
				"bPaginage":true,  //进度条
				"sAjaxSource": '<%=path%>/sysRoleController/list.do', 
				"aoColumns":[  
					{ 
					"mData": null, "bSortable": false, "render":function(data,type,full){  
		                var content = '<div class="text-c">';  
		                    content += '<input name="ck" class="check" type="checkbox" value="'+data.id+'">';  
		                    content += '</div>';  
		                return content;  
		            	} 
		            },
					{ "mData": "roleName","sClass":"text-c"}, 
		        	{ "mData": "roleType","sClass":"text-c"},
		        	{ "mData": "roleStatus","sClass":"text-c"},
		        	{ "mData": "roleDesc"},
		        	{ 
					"mData": null, "bSortable": false, "render":function(data,type,full){  
		                var content = '<div class="text-c">';
		                	content += '<a style="text-decoration:none" class="ml-5" onClick="edit('+data.id+')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>';  
		                    content += '<a style="text-decoration:none" class="ml-5" onClick="delById(this,'+data.id+')" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>';
		                    content +='</div>'; 
		                return content;  
		            	} 
		            },
		        ],
		        "columnDefs": [
		           {
                      "targets": [2],
                      "data": "roleType", 
                      "render": function(data, type, full) { 
                      	  var userTypeName;
                      	  if(data=="1"){
                      	  	userTypeName="超级管理员";
                      	  }else if(data=="2"){
                      	  	userTypeName="普通管理员";
                      	  }else if(data=="3"){
                      	 	 userTypeName="一般用户";
                      	  }
                          return userTypeName;
                      }
                  },
                   {
                      "targets": [3], 
                      "data": "roleStatus", 
                      "render": function(data, type, full) { 
                      	  var html;
                      	  if(data=="1"){
                      	  	 html="<span class='label label-success radius'>启用</span>";
                      	  }else if(data=="2"){
                      	  	 html="<span class='label label-danger radius'>禁用</span>";
                      	  }
                          return html;
                      }
                     
                  },
				],
		       "fnServerData" : function(sSource, aoData, fnCallback) {
		       		var txt_search = $("#txt_search").val();
 					aoData.push({"name" : "txt_search","value" : txt_search});
 					
					$.ajax({
						"type" : 'post',
						"url" : sSource,
						"dataType" : "json",
						"data" : {
							aoData : JSON.stringify(aoData)
						},
						"success" : function(resp) {
							fnCallback(resp);
						}
					});
			   }
			});
		}
		/*刷新*/
		function fnRefresh(){
			oTable.fnDraw();
		}
		//清空并刷新
		function fnRefreshAndClear(){
 			$("#txt_search").val("");
			oTable.fnDraw();
		}
		/*关闭层-刷新列表*/
		function fnRefreshInfo(index,msg,iconIndex){
		 	var index = layer.getFrameIndex(index); //获取窗口索引
	        layer.close(index);
	        oTable.fnDraw();
	        layer.msg(msg, {icon:iconIndex,time:1500});	
		}
		/*新增*/
		function add(){
			popFull("新增角色","role_add.jsp");
		}
		/*编辑*/
		function edit(id){
			popFull("编辑角色","role_edit.jsp?id="+id);
		}
		/*授权*/	
		function accredit(title, url) {
			var ids=''; 
	  		getChecked().each(function(){ //ps:暂时支持勾选一个，后续扩展
	  			if($(this).val()!="")ids=$(this).val(); 
	  		});
	  		if(ids!=''){
	  			popFull("授权","role_accredit.jsp?roleId="+ids);
	  		}else{
	  			 layer.msg("请勾选列表记录!");
	  		}
		}
		/*删除*/
		function delById(table,id){
			var url="<%=path%>/sysRoleController/deleteById.do";
			del(table,url,id);	
		}
	   //批量删除
	   function batchDel(){  
	   		var ids=''; 
	  		getChecked().each(function(){ 
	  			if($(this).val()!="")ids+=$(this).val()+","; 
	  		});
	  		if(ids!=''){
	  			ids=ids.substring(0,ids.length-1);
	  			layer.confirm('确认批量删除记录？',function(index){	
					layer.close(index);			
					$.ajax({
			            type: "POST",
			            url:"<%=path%>/sysRoleController/deleteById.do?id="+ids,
			            success: function(data) {
			               if(data.success){
							  layer.msg(data.msg,{icon:1,time:1500});
							  fnRefresh();
							}else{
							  layer.msg(data.msg,{icon:2,time:1500});
							}	
			            }
			          });	
				});
	  		}else{
	  			 layer.msg("请勾选列表记录!");
	  		}	
       }
       function getChecked(){
       		var arr=$("table input[type=checkbox]:checked");
       		return arr;
       }  
	</script>
</html>