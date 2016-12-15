<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单列表</title>
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
</head>
<body>
	<h1>菜单列表</h1>
	<a href="${pageContext.request.contextPath }/items/add">添加菜品</a>
	<c:if test="${empty pages.datas }">暂无菜品</c:if>
	<c:forEach items="${pages.datas }" var="item">
		<table class="ct" width="900" cellpadding="0" cellspacing="0"
			border="1" align="center">
			<thead>
				<th>标识</th>
				<th width="8%">菜品名</th>
				<th width="8%">单价</th>
				<th width="15%">图片地址</th>
				<th width="25%">备注</th>
				<th width="25%">创建日期</th>
				<th width="15%">操作</th>
			</thead>
			<tbody>
				<tr>
					<td>${item.id }</td>
					<td><a href="${pageContext.request.contextPath }/items/${item.id}/show">${item.name }</a></td>
					<td>${item.price }元</td>
					<td><img alt="${item.name }" src="/pic/${item.pic }" width="100" height="100"></td>
					<td>${item.detail }</td>
					<td><fmt:formatDate value="${item.createTime}" pattern="yyyy年MM月dd日 HH点mm分ss秒"/></td>
					<td>
						<form action="${pageContext.request.contextPath }/items/${item.id}/update">
							<input type="submit" value="修改">
						</form>
						<form action="${pageContext.request.contextPath }/items/${item.id}/delete">
							<input type="submit" value="删除">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
		<hr>
		<br>
	</c:forEach>

	<div align="center">
		<jsp:include page="/resources/inc/pager.jsp">
			<jsp:param value="${pageContext.request.contextPath }/items/itemsList" name="url" />
			<jsp:param value="${pages.totalRecord }" name="items" />
			<jsp:param value="type,name" name="params" />
		</jsp:include>
	</div>



</body>
</html>