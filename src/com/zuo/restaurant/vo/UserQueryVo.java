package com.zuo.restaurant.vo;

import com.zuo.restaurant.po.OrdersCustom;
import com.zuo.restaurant.po.UserCustom;

public class UserQueryVo {
	
	private UserCustom userCustom;
	
	private OrdersCustom ordersCustom;
	
	
	public UserCustom getUserCustom() {
		return userCustom;
	}
	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	public OrdersCustom getOrdersCustom() {
		return ordersCustom;
	}
	public void setOrdersCustom(OrdersCustom ordersCustom) {
		this.ordersCustom = ordersCustom;
	}
	
}
