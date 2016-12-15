<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${item.name }详情</title>
</head>
<body>


<h1>${item.name }</h1>
<a href="${pageContext.request.contextPath }/users/usersList">返回</a><br>
<table class="ct" width="900" cellpadding="0" cellspacing="0" border="1" align="center" >
	<tr>
		<td>标识</td>
		<td>${item.id}</td>
	</tr>
	<tr>
		<td>菜品名称</td>
		<td>${item.name }</td>
	</tr>
	<tr>
		<td>菜品单价</td>
		<td>${item.price }</td>
	</tr>
	<tr>
		<td>菜品图片</td>
		<td><img alt="${item.name }" src="/pic/${item.pic }" width="150" height="150"></td>
	</tr>
	<tr>
		<td>菜品备注</td>
		<td>
			<p>${item.detail }</p>
		</td>
	</tr>
	<tr>
		<td>创建日期</td>
		<td>
			<p><fmt:formatDate value="${item.createTime}" pattern="yyyy年MM月dd日 HH点mm分ss秒"/></p>
		</td>
	</tr>
</table>







</body>
</html>