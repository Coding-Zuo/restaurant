<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当日晚餐订单列表</title>
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
<h1>当日晚餐订单列表</h1>
<c:if test="${empty orderList }">暂无订单</c:if>
<c:forEach items="${orderList }" var="order">
	<h5>订单编号:${order.number }</h5>
	<table  class="ct" width="900" cellpadding="0" cellspacing="0" border="1" align="center">
		<thead>
			<tr>
				<th width="20%">菜品名称</th>
				<th>总金额</th>
				<th>订单备注</th>
				<th width="25%">配货地址</th>
				<th width="15%">下单日期</th>
				<th width="15%">签收日期</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<c:forEach items="${order.ordersItems }" var="ordersItems">
						<h5><a href="${pageContext.request.contextPath }/items/${ordersItems.items.id }/show">${ordersItems.items.name }</a></h5>
						数量:[${ordersItems.itemNum }],
						餐型[<c:if test="${ordersItems.itemType eq 0 }">午餐</c:if><c:if test="${ordersItems.itemType eq 1 }">晚餐</c:if>]，
					</c:forEach>
				</td>
				<td>${order.totalPrice }元</td>
				<td>${order.note }</td>
				<td>${order.address }</td>
				<td><fmt:formatDate value="${order.createTime}" pattern="yyyy年MM月dd日 HH点mm分ss秒"/></td>
				<td>
					<c:if test="${order.endTime eq null }">
						<!-- <button class="setEndbtn">结束订单</button> -->
						<form action="${pageContext.request.contextPath }/orders/${order.id }/eveningListSet" method="post">
							<input type="submit" value="结束订单">
							<input type="hidden" value="${order.userId }" name="userId" >
						</form>
					</c:if>
					<c:if test="${order.endTime != null }">
						<fmt:formatDate value="${order.endTime}" pattern="yyyy年MM月dd日 HH点mm分ss秒"/>
					</c:if>
				</td>
			</tr>
		</tbody>
	</table>
	<hr>
</c:forEach>


</body>
</html>