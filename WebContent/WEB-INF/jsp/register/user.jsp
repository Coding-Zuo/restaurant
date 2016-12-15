<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>

<h1>用户注册</h1>
<hr>
<a href="${pageContext.request.contextPath }/login">登录</a><br><br>
<c:if test="${allErrors!=null }">
	<!-- 显示错误信息 -->
	<c:forEach items="${allErrors }" var="error">
		${error.defaultMessage }<br>
	</c:forEach>
</c:if>
<form action="${pageContext.request.contextPath }/register/user"  method="post">
	用户名&nbsp;：<input type="text" name="name" value="${user.name }"><br>
	用户昵称：<input type="text" name="nickname" value="${user.nickname }"><br>
	用户密码：<input type="password" name="password" value="${user.password }"><br>
	<input type="submit" value="提交">
</form>



</body>
</html>