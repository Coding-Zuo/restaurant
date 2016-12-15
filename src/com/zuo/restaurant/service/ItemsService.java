package com.zuo.restaurant.service;

import java.util.List;

import com.zuo.restaurant.po.Items;
import com.zuo.restaurant.po.ItemsCustom;
import com.zuo.restaurant.po.Pager;

public interface ItemsService {
	
	public void add(Items items) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public void deleteItems(List<Integer> ids) throws Exception;
	
	public void update(Items items) throws Exception;
	
	public List<Items> selectAllItemsList(ItemsCustom itemsCustom) throws Exception;
	
	public Pager<Items> selectAllItemsPage(String itemName,Double price) throws Exception;
	
	public ItemsCustom selectItemById(int itemId) throws Exception;

}
