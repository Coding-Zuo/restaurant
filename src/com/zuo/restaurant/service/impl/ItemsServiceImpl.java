package com.zuo.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuo.restaurant.mapper.ItemsMapper;
import com.zuo.restaurant.mapper.OrdersItemsMapper;
import com.zuo.restaurant.po.Items;
import com.zuo.restaurant.po.ItemsCustom;
import com.zuo.restaurant.po.Pager;
import com.zuo.restaurant.po.SystemContext;
import com.zuo.restaurant.service.ItemsService;
import com.zuo.restaurant.vo.ItemsQueryVo;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService{
	@Autowired
	private ItemsMapper itemsMapper;
	@Autowired
	private OrdersItemsMapper ordersItemsMapper;

	@Override
	public void add(Items items) throws Exception {
		itemsMapper.insertItem(items);
	}

	@Override
	public void delete(int id) throws Exception {
		ordersItemsMapper.deleteOrdersItemsByOrderId(id);
		itemsMapper.deleteItem(id);
	}

	@Override
	public void update(Items items) throws Exception {
		itemsMapper.updateItem(items);
	}

	@Override
	public List<Items> selectAllItemsList(ItemsCustom itemsCustom) throws Exception {
		ItemsQueryVo itemsQueryVo=new ItemsQueryVo();
		itemsQueryVo.setItemsCustom(itemsCustom);
		return itemsMapper.findAllItems(itemsQueryVo);
	}

	@Override
	public Pager<Items> selectAllItemsPage(String itemName,Double price) throws Exception {
		
		int pageSize=SystemContext.getPageSize();
		int pageOffset=SystemContext.getPageOffset();
		int currentPage;
		if(pageSize<=0){
			pageSize=10;
		}
		if(pageOffset<=0){
			pageOffset=0;
		}
		currentPage=pageOffset/10*pageSize;
		
		ItemsCustom itemsCustom=new ItemsCustom();
		itemsCustom.setName(itemName);
		itemsCustom.setPrice(price);
		itemsCustom.setPageSize(pageSize);
		itemsCustom.setCurrentPage(currentPage);
		ItemsQueryVo itemsQueryVo=new ItemsQueryVo();
		itemsQueryVo.setItemsCustom(itemsCustom);
		
		List<Items> datas=itemsMapper.findAllItems(itemsQueryVo);
		long count=itemsMapper.findItemsCount(itemsQueryVo);
		
		Pager<Items> pager=new Pager<>();
		pager.setDatas(datas);
		pager.setPageOffset(pageOffset);
		pager.setPageSize(pageSize);
		pager.setTotalRecord(count);
		
		return pager;
	}

	@Override
	public ItemsCustom selectItemById(int itemId) throws Exception {
		return itemsMapper.selectItemById(itemId);
	}

	@Override
	public void deleteItems(List<Integer> ids) throws Exception {
		ItemsQueryVo itemsQueryVo=new ItemsQueryVo();
		itemsQueryVo.setItemsIds(ids);
		itemsMapper.deleteItems(itemsQueryVo);
	}
	
	
	
	
	
	
	

}
