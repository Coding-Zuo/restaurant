package com.zuo.restaurant.vo;

import java.util.List;

import com.zuo.restaurant.po.ItemsCustom;

public class ItemsQueryVo {
	
	private List<Integer> itemsIds;
	
	private ItemsCustom itemsCustom;
	
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	public List<Integer> getItemsIds() {
		return itemsIds;
	}
	public void setItemsIds(List<Integer> itemsIds) {
		this.itemsIds = itemsIds;
	}
}
