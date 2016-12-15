package com.zuo.restaurant.mapper;

import java.util.List;


import com.zuo.restaurant.po.Orders;
import com.zuo.restaurant.po.OrdersCustom;
import com.zuo.restaurant.po.User;
import com.zuo.restaurant.po.UserCustom;
import com.zuo.restaurant.vo.OrdersQueryVo;

public interface OrdersMapper {
	
	/**
	 * 通过id查订单
	 * @param ordersQueryVo 包装类
	 * @return 列表
	 */
	public List<OrdersCustom> findOrderByUserId(OrdersQueryVo ordersQueryVo) throws Exception;
	/**
	 * 添加订单
	 */
	public void insertOrder(Orders orders) throws Exception;
	/**
	*配合insert修改一下订单编号  。。。。 可能设计有问题
	 */
	public void updateNumber(int id) throws Exception;
	/**
	 * 删除订单
	 */
	public void deleteOrder(Integer id) throws Exception;
	/**
	 * 批量删除
	 */
	public void deleteOrders(OrdersQueryVo ordersQueryVo) throws Exception;
	/**
	 * 找所有订单 可以通过创建时间和结束时间筛选 为了分页
	 * @param ordersQueryVo
	 */
	public List<Orders> findAllOrder(OrdersQueryVo ordersQueryVo) throws Exception;
	/**
	 * 配合分页查数量
	 * @return
	 */
	public int findOrdersCount(OrdersQueryVo ordersQueryVo) throws Exception;
	/**
	 * 通过用户id 查询订单及明细和菜品
	 */
	public List<Orders> selectOrdersItemsList(User user) throws Exception;
	/**
	 * 更新订单note
	 */
	public void updateOrderNote(Orders orders) throws Exception;
	/**
	 * 查询订单及商品信息数量
	 */
	public int selectOrdersItemsCount(UserCustom userCustom) throws Exception;
	/**
	 * 查询所有用户当日的订单及详情
	 */
	public List<Orders> selectAllUserOrdersByNowTime(UserCustom userCustom) throws Exception;
	/**
	 * 查询所有用户当日的订单及详情的数量
	 */
	public int selectAllUserOrdersByNowTimeCount(UserCustom userCustom) throws Exception;
	/**
	 * 通过订单number查详细信息
	 */
	public List<Orders> selectOrdersItemsListByNum(String number) throws Exception;
	
	public List<Integer> selectOrderIdByUserId(int userId) throws Exception;
	
	//订单结束日期插入
	public void updateOrderEndTimeById(int orderId) throws Exception;
	//通过订单编号查订单
	public Orders selectOrderByNum(String number) throws Exception;
	

}
