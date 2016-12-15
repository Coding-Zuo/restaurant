package com.zuo.restaurant.mapper;

import java.util.List;

import com.zuo.restaurant.po.Items;
import com.zuo.restaurant.po.ItemsCustom;
import com.zuo.restaurant.vo.ItemsQueryVo;

public interface ItemsMapper {
	
	//删除一个菜品
	public void deleteItem(int id) throws Exception;
	//批量删除菜品
	public void deleteItems(ItemsQueryVo itemsQueryVo) throws Exception;
	//更新一个菜品
	public void updateItem(Items items) throws Exception;
	//添加菜品
	public void insertItem(Items items) throws Exception;
	//查询所有菜品，可以根据price和name 筛选 分页
	public List<Items> findAllItems(ItemsQueryVo itemsQueryVo) throws Exception;
	//查询菜品数量配合分页
	public int findItemsCount(ItemsQueryVo itemsQueryVo) throws Exception;
	//查询单个菜的信息
	public ItemsCustom selectItemById(int itemId) throws Exception;

}
