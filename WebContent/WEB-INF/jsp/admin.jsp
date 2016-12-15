<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/easyui-1/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/easyui-1/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/easyui-1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/easyui-1/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/easyui-1/locale/easyui-lang-zh_CN.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/js/log.js"></script> --%>
<script type="text/javascript">
$(function(){
	var treeData=[{
		text:"系统管理",
		iconCls:"icon-menu",
		children:[{
			text:"用户管理",
			iconCls:"icon-user",
			attributes:{
				url:'${pageContext.request.contextPath}/users/usersList'
			}
		},{
			text:"午餐订单管理",
			iconCls:"icon-user",
			attributes:{
				url:'${pageContext.request.contextPath}/orders/morningList'
			}
		},{
			text:"晚餐订单管理",
			iconCls:"icon-user",
			attributes:{
				url:'${pageContext.request.contextPath}/orders/eveningList'
			}
		},{
			text:"菜单管理",
			iconCls:"icon-user",
			attributes:{
				url:'${pageContext.request.contextPath}/items/itemsList'
			}
		}]
	}];
	
	$("#tree").tree({
		data:treeData,
		lines:true,
		onClick:function(node){
			if(node.attributes){
				openTab(node.text,node.attributes.url,node.iconCls);
			}
		}
	});
	//新增tab
	function openTab(text,url,iconCls){
		if($("#tabs").tabs('exists',text)){
			$("#tabs").tabs('select',text);
		}else{
			var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
			$("#tabs").tabs('add',{
				title:text,
				closable:true,
				content:content,
				iconCls:iconCls
			});
		}
	}
});
	
	
</script>
</head>
<body class="easyui-layout">
	<!-- <div id="dg" class="easyui-dialog" title="登录" style="width:500px;height:400px">
</div> -->


	<div data-options="region:'north',border:false"
		style="height: 100px; background: #B3DFDA; padding: 10px">
		<div style="float: left">
			<h1>后台管理系统</h1>
		</div>
		<div style="float: right">
			<h3>欢迎 ${loginUser.nickname }光临</h3>
			<a href="${pageContext.request.contextPath }/admin/logout">退出</a>
		</div>
	</div> 
	<div data-options="region:'west',split:true,title:'导航菜单'"
		style="width: 200px; padding: 10px;">
		<ul id="tree"></ul>
		
	</div>
	<div
		data-options="region:'east',split:true,collapsed:true,title:'East'"
		style="width: 200px; padding: 10px;">east region</div>
	<!-- <div data-options="region:'south',border:false"
		style="height: 50px; background: #A9FACD; padding: 10px;">
	</div> -->
	<div data-options="region:'center',title:'Main Title'">
		<div class="easyui-tabs" fit="true" border="false" id="tabs"
			style="width:150" >
			<div align="center" title="首页">
				<h1>欢迎${loginUser.nickname }使用该系统 </h1>
				<div>
					您是本店星际厨师，欢迎！
				</div>
			</div>
		</div>
	</div>


	<!-- <div id="dg">
		<form id="loginForm" action="" method="post">
			<table>
				<tr>
					<td>登录:</td>
					<td><input required="true" name="username" type="text"></input></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input class="easyui-validatebox" validType="minLength[5]"
						required="true" id="pwd" name="password" type="password"></input></td>
				</tr>
				<tr>
					<td>确认密码:</td>
					<td><input class="easyui-validatebox"
						validType="equals['#pwd']" required="true" name="repassword"
						type="password"></input></td>
				</tr>
			</table>
		</form>
	</div> -->








</body>
</html>