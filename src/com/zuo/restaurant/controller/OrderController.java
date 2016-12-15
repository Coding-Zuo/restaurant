package com.zuo.restaurant.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zuo.restaurant.po.Orders;
import com.zuo.restaurant.po.OrdersItems;
import com.zuo.restaurant.service.OrdersService;

@Controller("orderController")
@RequestMapping("/orders")
public class OrderController {
	
	@Resource
	private OrdersService ordersService;
	
	@RequestMapping("/morningList")
	public String morningList(Model model) throws Exception{
		List<Orders> orderList=ordersService.selectAllUserOrdersByNowTime();
		List<Orders> orders=new ArrayList<>();
		for(Orders order:orderList){
			double totalPrice=0d;
			for(int i=0;i<order.getOrdersItems().size();i++){
				OrdersItems ordersItems=order.getOrdersItems().get(i);
				totalPrice+=ordersItems.getItemNum()*ordersItems.getItems().getPrice();
				if(ordersItems.getItemType()==0){
					orders.add(order);
				}
			}
			order.setTotalPrice(totalPrice);
		}
		
		model.addAttribute("orderList", orders);
		return "orders/morningList";
	}
	
	@RequestMapping(value="/{id}/morningListSet",method=RequestMethod.POST)
	public String morningListSetEndTime(@PathVariable Integer id) throws Exception{
		ordersService.updateEndTime(id);
		return "redirect:/orders/morningList";
	}
	
	@RequestMapping(value="/eveningList",method=RequestMethod.GET)
	public String eveningList(Model model) throws Exception{
		List<Orders> orderList=ordersService.selectAllUserOrdersByNowTime();
		List<Orders> orders=new ArrayList<>();
		
		for(Orders order:orderList){
			double totalPrice=0d;
			for(int i=0;i<order.getOrdersItems().size();i++){
				OrdersItems ordersItems=order.getOrdersItems().get(i);
				totalPrice+=ordersItems.getItemNum()*ordersItems.getItems().getPrice();
				if(ordersItems.getItemType()==1){
					orders.add(order);
				}
			}
			order.setTotalPrice(totalPrice);
		}
		
		model.addAttribute("orderList", orders);
		return "orders/eveningList";
	}
	@RequestMapping(value="/{id}/eveningListSet",method=RequestMethod.POST)
	public String eveningListSetEndTime(@PathVariable Integer id) throws Exception{
		ordersService.updateEndTime(id);
		return "redirect:/orders/eveningList";
	}
	
	
	@RequestMapping(value="/{id}/setEndTime",method=RequestMethod.POST)
	public String setEndTime(@PathVariable Integer id,HttpServletRequest request) throws Exception{
		Integer userId=Integer.parseInt(request.getParameter("userId"));
		ordersService.updateEndTime(id);
		return "redirect:/users/"+userId+"/show";
	}
	
	
	@RequestMapping("/{id}/responseEndTime")
	public @ResponseBody Orders responseJson(@PathVariable Integer orderId) throws Exception{
		ordersService.updateEndTime(orderId);
		Orders orders=new Orders();
		orders.setEndTime(new Date());
		return orders;
	}
	
	
	
	
	
	
	

}
