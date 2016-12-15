package com.zuo.restaurant.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zuo.restaurant.controller.validation.ValidationGroup1;
import com.zuo.restaurant.controller.validation.ValidationGroup2;
import com.zuo.restaurant.po.Orders;
import com.zuo.restaurant.po.OrdersItems;
import com.zuo.restaurant.po.Pager;
import com.zuo.restaurant.po.User;
import com.zuo.restaurant.po.UserCustom;
import com.zuo.restaurant.service.OrdersService;
import com.zuo.restaurant.service.UserService;


@Controller("userController")
@RequestMapping("/users")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private OrdersService orderService;
	
	@RequestMapping(value="/usersList")
	public String list(Model model,HttpServletRequest request) throws Exception{
		String nickName=null;
		Integer type=null;
		if(request.getParameter("nickname")!=null){
			nickName=request.getParameter("nickname");
		}
		if(request.getParameter("type")!=null){
			type=Integer.parseInt(request.getParameter("type"));
		}
		Pager<UserCustom> users=userService.findAllUser(nickName,type);
		
		model.addAttribute("pages", users);
		model.addAttribute("nickname",nickName);
		return "users/usersList";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable int id, Model model) throws Exception{
		model.addAttribute("user",userService.findUserById(id));
		return "/users/update";
	}
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable int id,
			@Validated(value={ValidationGroup1.class}) User user,
			BindingResult br ,
			Model model) throws Exception{
		
		if(br.hasErrors()){
			List<ObjectError> allErrors=br.getAllErrors();
			for(ObjectError objectError:allErrors){
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("allErrors", allErrors);
			return "/users/update";
		}
		User tu=userService.findUserById(id);
		tu.setNickname(user.getNickname());
		tu.setType(user.getType());
		userService.update(tu);
		return "redirect:/users/usersList";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id) throws Exception{
		userService.delete(id);
		return "redirect:/users/usersList";
	}
	
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("user",new User());
		return "/users/add";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Model model,@Validated(value={ValidationGroup2.class}) User user,BindingResult br ) throws Exception{
		if(br.hasErrors()){
			List<ObjectError> allErrors=br.getAllErrors();
			for(ObjectError objectError:allErrors){
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("allErrors", allErrors);
			return "/users/add";
		}
		userService.add(user);
		return "redirect:/users/usersList";
	}
	
	@RequestMapping(value="/{id}/show",method=RequestMethod.GET)
	public String show(Model model,@PathVariable Integer id) throws Exception{
		User user=userService.findUserById(id);
		List<Orders> orderList=orderService.selectOrdersItemsListByUserId(id);
		
		for(Orders order:orderList){
			double totalPrice=0d;
			for(int i=0;i<order.getOrdersItems().size();i++){
				OrdersItems ordersItems=order.getOrdersItems().get(i);
				totalPrice+=ordersItems.getItemNum()*ordersItems.getItems().getPrice();
			}
			order.setTotalPrice(totalPrice);
		}
		
		model.addAttribute("user", user);
		model.addAttribute("orderList", orderList);
		return "users/show";
	}
	
//	@RequestMapping(value="/{orderId}/setEndTime",method=RequestMethod.GET)
//	public String setEndTime(@PathVariable Integer orderId) throws Exception{
//		orderService.updateEndTime(orderId);
//		return "/";
//	}
	
	
	
	
	
	

}
