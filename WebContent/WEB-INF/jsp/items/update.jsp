<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加菜品</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/main.css"
	type="text/css">
</head>
<body>
	<h1>更新菜品</h1>
	<a href="${pageContext.request.contextPath }/items/itemsList">返回</a><br>
	<c:if test="${allErrors!=null }">
		<!-- 显示错误信息 -->
		<c:forEach items="${allErrors }" var="error">
		${error.defaultMessage }<br>
		</c:forEach>
	</c:if>
	<form action="${pageContext.request.contextPath }/items/${item.id}/update"
		method="post" enctype="multipart/form-data">
		<table class="ct" align="center" width="600" border="1" >
			<tr>
				<td>菜名：</td>
				<td><input type="text" name="name" value="${item.name }" /></td>
			</tr>
			<tr>
				<td>单价：</td>
				<td><input type="text" name="price" value="${item.price }" />
				</td>
			</tr>
			<tr>
			<td>菜品图片</td>
			<td>
				<c:if test="${item.pic !=null}">
					<img src="/pic/${item.pic}" width=100 height=100 />
					<br />
				</c:if>
				<input type="file" name="items_pic" /></td>
			</tr> 
			<tr>
				<td>菜品备注</td>
				<td>
					<textarea rows="3" cols="30" name="detail">${item.detail }</textarea>
				</td>
			</tr>
			<tr colspan="2">
				<td></td>
				<td><input type="submit" name="更新菜品" /></td>
			</tr>
		</table>
	</form>

</body>
</html>