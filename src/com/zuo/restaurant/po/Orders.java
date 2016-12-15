package com.zuo.restaurant.po;

import java.util.Date;
import java.util.List;

/**
 * 订单
 * @author zuo
 *
 */
public class Orders {
	
	private Integer id;
	private Integer userId;
	private String number;
	private String note;
	private Date createTime;
	private Date endTime;
	private String address;
	
	private Double totalPrice;
	// 用户信息
	private User user;
	// 订单明细
	private List<OrdersItems> ordersItems;
	
	public User getUser() {
		return user;
	}
	public List<OrdersItems> getOrdersItems() {
		return ordersItems;
	}
	public void setOrdersItems(List<OrdersItems> ordersItems) {
		this.ordersItems = ordersItems;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", number=" + number + ", note=" + note + ", createTime="
				+ createTime + ", endTime=" + endTime + ", address=" + address + ", user=" + user + ", ordersItems="
				+ ordersItems + "]";
	}
	
	
	
	
	

}
