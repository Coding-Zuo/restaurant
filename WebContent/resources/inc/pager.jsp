<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<pg:pager items="${param.items }" maxPageItems="10" export="curPage=pageNumber" url="${param.url }">
	<c:forEach items="${param.params }" var="p">
		<!-- 用来设置将要加入到URL的参数。使用Name属性指定即可，用于参数传递。 -->
		<pg:param name="${p }" />
	</c:forEach>
	<pg:last>
			一共有:${param.items }条记录，共${pageNumber }页,当前是第${curPage }页
				<%-- 每页显示<%=pages.getPageSize() %>条记录 --%>
	</pg:last>
	<pg:first>
		<a href="${pageUrl }">首页</a>
	</pg:first>
	<pg:prev>
		<a href="${pageUrl }">上一页</a>
	</pg:prev>
	<pg:pages>
		<c:if test="${curPage eq pageNumber }">
			[${pageNumber }]
		</c:if>
		<c:if test="${curPage ne pageNumber }">
			<a href="${pageUrl }">${pageNumber }</a>
		</c:if>
	</pg:pages>
	<pg:next>
		<a href="${pageUrl }">下一页</a>
	</pg:next>
	<pg:last>
		<a href="${pageUrl }">尾页</a>
	</pg:last>


</pg:pager>