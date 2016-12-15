package com.zuo.restaurant.service;

import java.util.List;

import com.zuo.restaurant.po.Orders;
import com.zuo.restaurant.po.OrdersCustom;

public interface OrdersService {
	
	
	public void add(OrdersCustom ordersCustom) throws Exception;
	
	public void updateNote(Orders order) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public void deleteOrders(List<Integer> ids) throws Exception;
	
	public List<Orders> findAllOrder(OrdersCustom ordersCustom) throws Exception;
	
	public List<OrdersCustom> findOrdersByUserId(int userId) throws Exception;
	
	public List<Orders> selectOrdersItemsListByUserId(int userId) throws Exception;
	
	public void updateEndTime(int orderId) throws Exception;
	//获取当天所有用户的订单
	public List<Orders> selectAllUserOrdersByNowTime() throws Exception;
}
