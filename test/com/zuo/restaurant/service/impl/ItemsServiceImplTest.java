package com.zuo.restaurant.service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zuo.restaurant.po.Items;
import com.zuo.restaurant.po.ItemsCustom;
import com.zuo.restaurant.po.Pager;
import com.zuo.restaurant.po.SystemContext;
import com.zuo.restaurant.service.ItemsService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext*.xml")
public class ItemsServiceImplTest {

	@Autowired
	private ItemsService itemsService;

	@Test
	public void testAdd() throws Exception {
		Items items=new Items();
		items.setName("爆炒羊肉");
		items.setPrice(20.0);
		items.setDetail("很好吃");
		items.setCreateTime(new Date());
		itemsService.add(items);
	}

	@Test
	public void testDelete() throws Exception {
		itemsService.delete(11);
	}

	@Test
	public void testUpdate() throws Exception {
		ItemsCustom itemsCustom=itemsService.selectItemById(1);
		itemsCustom.setPrice(21d);
		System.out.println(itemsCustom.getId());
		itemsService.update(itemsCustom);
	}

	@Test
	public void testSelectAllItemsList() throws Exception {
		ItemsCustom itemsCustom=new ItemsCustom();
//		itemsCustom.setPrice(30d);
		List<Items> items=itemsService.selectAllItemsList(itemsCustom);
		System.out.println(items);
	}

	@Test
	public void testSelectAllItemsPage() throws Exception {
		SystemContext.setPageSize(5);
		SystemContext.setPageOffset(0);
		Pager<Items> pager=itemsService.selectAllItemsPage(null, null);
		System.out.println(pager);
	}

	@Test
	public void testSelectItemById() throws Exception {
		
		ItemsCustom user=itemsService.selectItemById(11);
		System.out.println(user.getName());
		
	}

}
