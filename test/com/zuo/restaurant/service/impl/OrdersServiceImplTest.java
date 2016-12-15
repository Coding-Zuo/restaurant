package com.zuo.restaurant.service.impl;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zuo.restaurant.po.Orders;
import com.zuo.restaurant.po.OrdersCustom;
import com.zuo.restaurant.service.OrdersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext*.xml")
public class OrdersServiceImplTest {
	@Resource
	private OrdersService orderService;


	@Test
	public void testAdd() throws Exception {
		OrdersCustom ordersCustom=new OrdersCustom();
		ordersCustom.setId(27);
		ordersCustom.setUserId(3);
		ordersCustom.setAddress("吉林");
		ordersCustom.setNote("我吃");
		ordersCustom.setCreateTime(new Date());
		ordersCustom.setItemId(7);
		ordersCustom.setItemNum(1);
		ordersCustom.setItemType(0);
		orderService.add(ordersCustom);
	}

	@Test
	public void testUpdateNote() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() throws Exception {
		orderService.delete(21);
	}

	@Test
	public void testFindOrdersByUserId() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectOrdersItemsList() throws Exception {
		List<Orders> orders=orderService.selectOrdersItemsListByUserId(2);
		
		System.out.println(orders);
		
	}

	@Test
	public void testFindAllOrder() {
		fail("Not yet implemented");
	}
	@Test
	public void testUpdateEndTime() throws Exception {
		orderService.updateEndTime(1);
	}
	@Test
	public void testSelectAllUserOrdersByNowTime() throws Exception {
		List<Orders> orders=orderService.selectAllUserOrdersByNowTime();
		System.out.println(orders);
	}
	@Test
	public void testSelectOrdersItemsListByUserId() throws Exception {
		List<Orders> orders=orderService.selectOrdersItemsListByUserId(2);
		System.out.println(orders);
	}
	
	
	

}
