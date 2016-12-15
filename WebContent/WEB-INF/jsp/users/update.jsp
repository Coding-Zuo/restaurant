<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息修改</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css" type="text/css"> 
</head>
<body>
<h1>修改用户</h1>
<a href="${pageContext.request.contextPath }/users/usersList">返回</a><br>
<c:if test="${allErrors!=null }">
	<!-- 显示错误信息 -->
	<c:forEach items="${allErrors }" var="error">
		${error.defaultMessage }<br>
	</c:forEach>
</c:if>
<form  action="${pageContext.request.contextPath }/users/${user.id }/update" method="post">
	<table class="ct" width="700" align="center" border="1">
		<tr>
			<td>用户名</td>
			<td>${user.name }<input type="hidden" value="name" name="name"></td>
		</tr>
		<tr>
			<td>用户昵称</td>
			<td><input type="text" value="${user.nickname }" name="nickname"></td>
		</tr>
		<tr>
			<td>用户类型</td>
			<td>
				用户<input type="radio" value="1" name="type" <c:if test="${user.type eq 1 }">checked="checked"</c:if> >
				厨师<input type="radio" value="0" name="type" <c:if test="${user.type eq 0 }">checked="checked"</c:if> >
			</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="2">
				<input type="submit" value="更新">
			</td>
		</tr>
	</table>
</form>
</body>
</html>