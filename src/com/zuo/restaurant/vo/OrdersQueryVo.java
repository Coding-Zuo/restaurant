package com.zuo.restaurant.vo;

import java.util.List;

import com.zuo.restaurant.po.OrdersCustom;
import com.zuo.restaurant.po.UserCustom;

public class OrdersQueryVo {
	
	List<Integer> orderIds;
	
	private UserCustom userCustom;
	
	private OrdersCustom ordersCustom;
	
	public List<Integer> getOrderIds() {
		return orderIds;
	}
	public void setOrderIds(List<Integer> orderIds) {
		this.orderIds = orderIds;
	}
	public OrdersCustom getOrdersCustom() {
		return ordersCustom;
	}
	public void setOrdersCustom(OrdersCustom ordersCustom) {
		this.ordersCustom = ordersCustom;
	}
	public UserCustom getUserCustom() {
		return userCustom;
	}
	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

}
