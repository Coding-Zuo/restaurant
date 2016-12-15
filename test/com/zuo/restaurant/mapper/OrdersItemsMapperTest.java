package com.zuo.restaurant.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zuo.restaurant.po.OrdersItemsCustom;

public class OrdersItemsMapperTest {


	private ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext*.xml");
	}


	@Test
	public void testDeleteOrdersItemsByOrderId() {
//		OrdersItemsMapper ordersItemsMapper=(OrdersItemsMapper) applicationContext.getBean("ordersItemsMapper");
	}

	@Test
	public void testInsertOrdersItems() throws Exception {
		OrdersItemsMapper ordersItemsMapper=(OrdersItemsMapper) applicationContext.getBean("ordersItemsMapper");
		OrdersItemsCustom ordersItemsCustom=new OrdersItemsCustom();
		ordersItemsCustom.setOrderId(1);
		ordersItemsCustom.setItemId(1);
		ordersItemsCustom.setItemNum(2);
		ordersItemsCustom.setItemType(1);
		ordersItemsMapper.insertOrdersItems(ordersItemsCustom);
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
