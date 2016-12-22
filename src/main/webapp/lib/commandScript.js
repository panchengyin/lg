window.codeHashMap;
/**
 * 公用函数
 * 从URL连接中获取key为name的value
 * @param {Object} name
 */
function getQueryString(name) {
	
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = location.search.substr(1).match(reg);
	if(r != null)return decodeURI(r[2]);
	return null;
}
/**
 * 解决浏览器缓存  
 * */
function timestamp(url){  
      var getTimestamp=new Date().getTime();  
      if(url.indexOf("?")>-1){  
        url=url+"&timestamp="+getTimestamp;
      }else{  
        url=url+"?timestamp="+getTimestamp; 
      }  
      return url;  
}  
/**
 * 弹出窗口-全屏
 * @param {Object} title 弹窗标题
 * @param {Object} url 打开的URL地址
 */
function popFull(title, url) {
	var index = layer.open({
		type: 2,
		title: title,
		content: encodeURI(url)
	});
	layer.full(index);
}
/***
 * 弹出窗口-默认固定宽度高度
 * @param title 弹窗标题
 * @param url   打开的URL地址
 * @param w     宽度px
 * @param h     高度px
 */
function pop(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		shadeClose: false,
		shade: false,
		maxmin: true, //开启最大化最小化按钮
		area: [w, h],
		content: url
	});
}
/**
 * 删除
 * @param {Object} table 表格来源
 * @param {Object} url 打开的URL地址
 * @param {Object} id 实体ID
 */
function del(table, url, id) {
	layer.confirm('确认删除该记录？',function(index){	
		layer.close(index);			
		$.ajax({
            type: "POST",
            url:url + '?id=' + id,
            success: function(data) {
               if(data.success){
				  layer.msg(data.msg,{icon:1,time:1500});
				  $(table).parents("tr").remove();
				}else{
				  layer.msg(data.msg,{icon:2,time:1500});
				}	
            }
          });	
	});
}
/**
 * 前台缓存字典数据 --暂时不可行！
 */
function cacheCode() {
	codeHashMap= new HashTable();
	$.ajax({
        type: "POST",
        url: contextPath+"/codeController/list.do",
        success: function(data) {
        	for(var o in data){  
        		var isExist=codeHashMap.containsKey(data[o].groupid);
        		if(isExist){
        			var arr=codeHashMap.getValue(data[o].groupid);
        			arr.push(data[o]);
        		}else{
        			var arr = new Array();
        			arr.push(data[o]);
        			codeHashMap.add(data[o].groupid, arr);
        		}
        	}
        	var arr=codeHashMap.getValue(1);
        //	console.info(arr.length);
        }
      });
}
/***
 * 动态绑定下拉框
 * @param id  对应字典groupId
 * @param ddl 绑定对象
 */
function bingDropDownList(id,ddl){
	var tmp=ddl[0];
	tmp.options.length=0;
	var arr=codeHashMap.getValue(id);
	for(var o in arr){  
		tmp.options.add(new Option(arr[o].typename,arr[o].typeid));
	}
}