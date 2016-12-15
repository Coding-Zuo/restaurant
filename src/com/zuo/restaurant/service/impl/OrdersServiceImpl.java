package com.zuo.restaurant.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuo.restaurant.mapper.OrdersItemsMapper;
import com.zuo.restaurant.mapper.OrdersMapper;
import com.zuo.restaurant.po.Orders;
import com.zuo.restaurant.po.OrdersCustom;
import com.zuo.restaurant.po.OrdersItemsCustom;
import com.zuo.restaurant.po.UserCustom;
import com.zuo.restaurant.service.OrdersService;
import com.zuo.restaurant.vo.OrdersQueryVo;

@Service("orderService")
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private OrdersItemsMapper ordersItemsMapper;

	@Override
	public void add(OrdersCustom ordersCustom) throws Exception {
		// 添加订单同时添加订单明细
		ordersMapper.insertOrder(ordersCustom);
		OrdersItemsCustom ordersItemsCustom = new OrdersItemsCustom();
		ordersMapper.updateNumber(ordersCustom.getId());
		ordersItemsCustom.setOrderId(ordersCustom.getId());
		ordersItemsCustom.setItemId(ordersCustom.getItemId());
		ordersItemsCustom.setItemNum(ordersCustom.getItemNum());
		ordersItemsCustom.setItemType(ordersCustom.getItemType());
		ordersItemsMapper.insertOrdersItems(ordersItemsCustom);

	}

	@Override
	public void updateNote(Orders order) throws Exception {
		ordersMapper.updateOrderNote(order);
	}

	@Override
	public void delete(int id) throws Exception {
		ordersItemsMapper.deleteOrdersItemsByOrderId(id);
		ordersMapper.deleteOrder(id);
	}

	@Override
	public List<OrdersCustom> findOrdersByUserId(int userId) throws Exception {
		OrdersQueryVo ordersQueryVo = new OrdersQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setId(userId);
		ordersQueryVo.setUserCustom(userCustom);
		return ordersMapper.findOrderByUserId(ordersQueryVo);
	}

	@Override
	public void deleteOrders(List<Integer> ids) throws Exception {
		OrdersQueryVo ordersQueryVo = new OrdersQueryVo();
		ordersQueryVo.setOrderIds(ids);
		ordersMapper.deleteOrders(ordersQueryVo);
	}

	@Override
	public List<Orders> selectOrdersItemsListByUserId(int userId) throws Exception {
		UserCustom userCustom = new UserCustom();
		userCustom.setId(userId);
		return ordersMapper.selectOrdersItemsList(userCustom);
	}

	@Override
	public List<Orders> findAllOrder(OrdersCustom ordersCustom) throws Exception {
		OrdersQueryVo ordersQueryVo = new OrdersQueryVo();
		ordersQueryVo.setOrdersCustom(ordersCustom);
		return ordersMapper.findAllOrder(ordersQueryVo);
	}

	@Override
	public void updateEndTime(int orderId) throws Exception {
		ordersMapper.updateOrderEndTimeById(orderId);
	}

	@Override
	public List<Orders> selectAllUserOrdersByNowTime() throws Exception {
		UserCustom userCustom = new UserCustom();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date nowTime=calendar.getTime();
		userCustom.setNowTime(sf.format(nowTime));
		List<Orders> orderList = ordersMapper.selectAllUserOrdersByNowTime(userCustom);
		return orderList;
	}

}
