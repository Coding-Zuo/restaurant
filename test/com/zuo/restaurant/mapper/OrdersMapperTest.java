package com.zuo.restaurant.mapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zuo.restaurant.po.Orders;
import com.zuo.restaurant.po.OrdersCustom;
import com.zuo.restaurant.po.OrdersItems;
import com.zuo.restaurant.po.User;
import com.zuo.restaurant.po.UserCustom;
import com.zuo.restaurant.service.OrdersService;
import com.zuo.restaurant.service.UserService;
import com.zuo.restaurant.vo.OrdersQueryVo;

public class OrdersMapperTest {


	private ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext*.xml");
	}


	@Test
	public void testFindOrderByUserId() throws Exception {
		OrdersMapper ordersMapper=(OrdersMapper) applicationContext.getBean("ordersMapper");
		OrdersQueryVo ordersQueryVo=new OrdersQueryVo();
		UserCustom userCustom=new UserCustom();
		userCustom.setId(6);
		ordersQueryVo.setUserCustom(userCustom);
		List<OrdersCustom> orders=ordersMapper.findOrderByUserId(ordersQueryVo);
		System.out.println(orders.get(0).getUser().getName());
		System.out.println(orders.get(0).getUserId());
		System.out.println(orders.get(0).getUser().getId());
		
	}
	@Test
	public void testInsertOrder() throws Exception {
		OrdersMapper ordersMapper=(OrdersMapper) applicationContext.getBean("ordersMapper");
		Orders orders=new Orders();
		orders.setAddress("南京市");
		orders.setCreateTime(new Date());
		orders.setNote("不放香菜");
		orders.setUserId(6);
		ordersMapper.insertOrder(orders);
		ordersMapper.updateNumber(orders.getId());
		System.out.println(orders.getId());
		
	}
	@Test
	public void testDeleteOrder() throws Exception {
		OrdersMapper ordersMapper=(OrdersMapper) applicationContext.getBean("ordersMapper");
		ordersMapper.deleteOrder(6);
	}
	@Test
	public void testDeleteOrders() throws Exception {
		OrdersMapper ordersMapper=(OrdersMapper) applicationContext.getBean("ordersMapper");
		OrdersQueryVo ordersQueryVo=new OrdersQueryVo();
		List<Integer> orders=new ArrayList<>();
		orders.add(8);
		orders.add(9);
		orders.add(10);
		ordersQueryVo.setOrderIds(orders);
		ordersMapper.deleteOrders(ordersQueryVo);
	}
	@Test
	public void testfindAllOrder() throws Exception {
		OrdersMapper ordersMapper=(OrdersMapper) applicationContext.getBean("ordersMapper");
		OrdersQueryVo ordersQueryVo=new OrdersQueryVo();
		OrdersCustom ordersCustom=new OrdersCustom();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String createTime ="2016-12-10 00:30:24"; 
		Date create=simpleDateFormat.parse(createTime);
		ordersCustom.setCreateTime(create);
		
//		ordersCustom.setEndTime(create);
		ordersQueryVo.setOrdersCustom(ordersCustom);
		List<Orders> ordersCustoms=ordersMapper.findAllOrder(ordersQueryVo);
		System.out.println(ordersCustoms.get(0).getNumber());
		System.out.println(ordersCustoms.size());
	}
	@Test
	public void testfindAllOrderCount() throws Exception {
		OrdersMapper ordersMapper=(OrdersMapper) applicationContext.getBean("ordersMapper");
		OrdersQueryVo ordersQueryVo=new OrdersQueryVo();
		OrdersCustom ordersCustom=new OrdersCustom();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String createTime ="2016-12-08 00:30:24"; 
		Date create=simpleDateFormat.parse(createTime);
//		ordersCustom.setCreateTime(create);
		ordersCustom.setEndTime(create);
		ordersQueryVo.setOrdersCustom(ordersCustom);
		int count=ordersMapper.findOrdersCount(ordersQueryVo);
		System.out.println(count);
	}
	@Test
	public void testselectAllUserOrdersByNowTime() throws Exception {
		OrdersMapper ordersMapper=(OrdersMapper) applicationContext.getBean("ordersMapper");
		UserCustom userCustom=new UserCustom();
		userCustom.setNowTime("2016-12-08 00:10:09");
		List<Orders> orders=ordersMapper.selectAllUserOrdersByNowTime(userCustom);
		for(Orders order:orders){
			for(OrdersItems ordersItems:order.getOrdersItems()){
				System.out.println(ordersItems.getItems().getId());
			}
		}
	}
	@Test
	public void testSelectOrdersItemsList() throws Exception {
		OrdersMapper ordersMapper=(OrdersMapper) applicationContext.getBean("ordersMapper");
		User user=new User();
		user.setId(2);
		List<Orders> orders=ordersMapper.selectOrdersItemsList(user);
		System.out.println(orders);
	}
	@Test
	public void testUpdateOrderNote() throws Exception {
		OrdersMapper ordersMapper=(OrdersMapper) applicationContext.getBean("ordersMapper");
		UserService userService=(UserService) applicationContext.getBean("userService");
		User user=userService.findUserLogin("user2", "123");
		List<Orders> oList=ordersMapper.selectOrdersItemsList(user);
		Orders orders1=oList.get(0);
		System.out.println(orders1);
		orders1.setNote("再见兄弟1");
		ordersMapper.updateOrderNote(orders1);
		System.out.println(orders1);
		
		
		
	}
	
	

	@Test
	public void testFindOrderByUserIdService() throws Exception {
//		OrdersMapper ordersMapper=(OrdersMapper) applicationContext.getBean("ordersMapper");
		OrdersService ordersService=(OrdersService) applicationContext.getBean("orderService");
		List<OrdersCustom> orders=ordersService.findOrdersByUserId(6);
		System.out.println(orders.get(0).getUserId());
		
	}
	@Test
	public void testUpdateOrderEndTimeById() throws Exception {
		OrdersMapper ordersMapper=(OrdersMapper) applicationContext.getBean("ordersMapper");
		Orders orders=ordersMapper.selectOrderByNum("100007");
		orders.setEndTime(new Date());
		ordersMapper.updateOrderEndTimeById(1);
		
	}
	
	
	
	
	
	
	
	

}
