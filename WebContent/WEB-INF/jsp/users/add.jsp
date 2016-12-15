<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css" type="text/css"> 
</head>
<body>
<h1>添加用户</h1>
<a href="${pageContext.request.contextPath }/users/usersList">返回</a>
<c:if test="${allErrors!=null }">
	<!-- 显示错误信息 -->
	<c:forEach items="${allErrors }" var="error">
		${error.defaultMessage }<br>
	</c:forEach>
</c:if>
<form action="${pageContext.request.contextPath }/users/add" method="post">
	<table class="ct" align="center" width="600" border="1">
		<tr>
			<td>用户名：</td>
			<td>
				<input type="text" name="name" value="${user.name }"/>
			</td>
		</tr>
		<tr>
			<td>用户密码：</td>
			<td><input type="password" name="password"/>
			</td>
		</tr>
		<tr>
			<td>用户昵称：</td>
			<td><input type="text" name="nickname"  value="${user.nickname }"/>
			</td>
		</tr>
		<tr>
			<td>用户类型：</td>
			<td>
				用户<input type="radio" value="1" name="type" <c:if test="${user.type eq 1 and user.type eq null}">checked="checked"</c:if> >
				厨师<input type="radio" value="0" name="type" <c:if test="${user.type eq 0 }">checked="checked"</c:if> >
			</td>
		</tr>
		<tr colspan="2">
			<td></td>
			<td><input type="submit" name="添加用户"/></td>
		</tr>
	</table>
	</form>

</body>
</html>