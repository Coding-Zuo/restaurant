package com.zuo.restaurant.mapper;

import com.zuo.restaurant.po.OrdersItemsCustom;

public interface OrdersItemsMapper {
	//删除关联信息 通过ItemId
	public  void deleteOrdersItemsByItemId(int itemId) throws Exception;
	//删除关联信息 通过orderId
	public void deleteOrdersItemsByOrderId(int orderId) throws Exception;
	//添加关联信息
	public void insertOrdersItems(OrdersItemsCustom ordersItemsCustom) throws Exception;
	
}
