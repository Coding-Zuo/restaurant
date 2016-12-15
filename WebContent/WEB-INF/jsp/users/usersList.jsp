<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css" type="text/css"> 
</head>
<body>
<h1>用户列表</h1>
<a href="${pageContext.request.contextPath }/users/add">添加用户</a>
	<table class="ct" width="900" align="center" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="5">
				<form action="${pageContext.request.contextPath }/users/usersList" method="post">
					<input type="text" name="nickname" value="${nickname }" ><input type="submit" value="查询">
				</form>
			</td>
		</tr>
		<tr>
			<td>用户Id</td>
			<td>用户名</td>
			<td>用户昵称</td>
			<td>用户类型</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pages.datas }" var="user">
			<tr>
				<td>${user.id }</td>
				<td><a href="${pageContext.request.contextPath }/users/${user.id }/show">${user.name }</a></td>
				<td>${user.nickname }</td>
				<td>
					<c:if test="${user.type==1 }">
						普通用户
					</c:if>
					<c:if test="${user.type==0 }">
						厨师
					</c:if>
				</td>
				<td>
					<a href="${pageContext.request.contextPath }/users/${user.id }/update" >修改</a>
					<a href="${pageContext.request.contextPath }/users/${user.id}/delete">删除</a>
				</td>
			
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<jsp:include page="/resources/inc/pager.jsp">
					<jsp:param value="${pageContext.request.contextPath }/users/usersList" name="url" />
					<jsp:param value="${pages.totalRecord }" name="items" />
					<jsp:param value="type,name" name="params"/>
				</jsp:include>
			</td> 
		</tr>
	</table>

</body>
</html>