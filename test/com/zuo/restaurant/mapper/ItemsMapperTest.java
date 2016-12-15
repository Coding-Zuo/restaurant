package com.zuo.restaurant.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zuo.restaurant.po.Items;
import com.zuo.restaurant.po.ItemsCustom;
import com.zuo.restaurant.vo.ItemsQueryVo;

public class ItemsMapperTest {


	private ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext*.xml");
	}


	@Test
	public void testDeleteItem() throws Exception {
		ItemsMapper itemsMapper=(ItemsMapper) applicationContext.getBean("itemsMapper");
		itemsMapper.deleteItem(8);
	}

	@Test
	public void testDeleteItems() throws Exception {
		ItemsMapper itemsMapper=(ItemsMapper) applicationContext.getBean("itemsMapper");
		ItemsQueryVo itemsQueryVo=new ItemsQueryVo();
		List<Integer> idList=new ArrayList<>();
		idList.add(9);
		idList.add(10);
		itemsQueryVo.setItemsIds(idList);
		itemsMapper.deleteItems(itemsQueryVo);
	}

	@Test
	public void testUpdateItem() throws Exception {
		ItemsMapper itemsMapper=(ItemsMapper) applicationContext.getBean("itemsMapper");
		Items items=new Items();
		items.setCreateTime(new Date());
		items.setId(8);
		items.setDetail("超级好吃");
		items.setName("青椒炒肉");
		items.setPrice(30.1);
		items.setPic("这里");
		itemsMapper.updateItem(items);
	}

	@Test
	public void testInsertItem() throws Exception {
		ItemsMapper itemsMapper=(ItemsMapper) applicationContext.getBean("itemsMapper");
		Items items=new Items();
		items.setCreateTime(new Date());
		items.setDetail("超级好吃");
		items.setName("青椒炒肉");
		items.setPrice(28.1);
		items.setPic("这里");
		itemsMapper.insertItem(items);
		
	}
	@Test
	public void testfindAllItems() throws Exception {
		ItemsMapper itemsMapper=(ItemsMapper) applicationContext.getBean("itemsMapper");
		ItemsQueryVo itemsQueryVo=new ItemsQueryVo();
		ItemsCustom itemsCustom=new ItemsCustom();
//		itemsCustom.setName("青椒");
		itemsCustom.setPrice(Double.valueOf(20));
		System.out.println(itemsCustom.getPrice());
		itemsQueryVo.setItemsCustom(itemsCustom);
		List<Items>itemsCustoms=itemsMapper.findAllItems(itemsQueryVo);
		System.out.println(itemsCustoms.get(0).getName());
	}
	@Test
	public void testfindItemsCount() throws Exception {
		ItemsMapper itemsMapper=(ItemsMapper) applicationContext.getBean("itemsMapper");
		ItemsQueryVo itemsQueryVo=new ItemsQueryVo();
		ItemsCustom itemsCustom=new ItemsCustom();
//		itemsCustom.setName("青椒");
		itemsCustom.setPrice(Double.valueOf(20));
		itemsQueryVo.setItemsCustom(itemsCustom);
		int count=itemsMapper.findItemsCount(itemsQueryVo);
		System.out.println(count);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
