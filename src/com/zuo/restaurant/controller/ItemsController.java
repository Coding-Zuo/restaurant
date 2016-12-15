package com.zuo.restaurant.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;

import com.zuo.restaurant.controller.validation.ValidationGroup2;
import com.zuo.restaurant.po.Items;
import com.zuo.restaurant.po.Pager;
import com.zuo.restaurant.service.ItemsService;

@Controller("itemsController")
@RequestMapping("/items")
public class ItemsController {
	@Resource
	private ItemsService itemsService;
	
	@RequestMapping("/itemsList")
	public String itemsList(Model model,HttpServletRequest request) throws Exception{
		String itemName = null;
		Double price = null;
		if(request.getParameter("itemName")!=null){
			itemName=request.getParameter("itemName");
		}
		if(request.getParameter("price")!=null){
			price=Double.valueOf(request.getParameter("price"));
		}
		Pager<Items> itemList=itemsService.selectAllItemsPage(itemName, price);
		
		model.addAttribute("pages", itemList);
		
		return "items/itemsList";
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(Model model) throws Exception{
		model.addAttribute("item", new Items());
		return "/items/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(Model model,
			@Validated(value={ValidationGroup2.class}) Items items,
			BindingResult br,
			MultipartFile items_pic//接收图片
			) throws Exception{
		
		if(br.hasErrors()){
			List<ObjectError> allErrors=br.getAllErrors();
			for(ObjectError objectError:allErrors){
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("allErrors", allErrors);
			return "/items/add";
		}
		
		//上传图片
		String originalFilename=items_pic.getOriginalFilename();
		if(items_pic!=null&& originalFilename!=null&& originalFilename.length()>0){
			String pic_path="/Users/zuo/Desktop/图片服务器/";
			
			//新的图片名称
			String newFileName=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			//新的图片
			File newFile=new File(pic_path+newFileName);
			//将内存中数据写入磁盘
			items_pic.transferTo(newFile);
			//将新图片名称写到itemsCustom中
			items.setPic(newFileName);
		}
		
		itemsService.add(items);
		return "redirect:/items/itemsList";
	}
	
	@RequestMapping("{id}/delete")
	public String delete(@PathVariable Integer id) throws Exception{
		itemsService.delete(id);
		return "items/itemsList";
	}
	
	@RequestMapping(value="{id}/update",method=RequestMethod.GET)
	public String update(Model model,@PathVariable Integer id) throws Exception{
		model.addAttribute("item", itemsService.selectItemById(id));
		return "items/update";
	}
	@RequestMapping(value="{id}/update",method=RequestMethod.POST)
	public String update(Model model,
			@PathVariable Integer id,
			@Validated(value={ValidationGroup2.class})Items items,
			MultipartFile items_pic,//接收图片
			BindingResult br) throws Exception{
		if(br.hasErrors()){
			List<ObjectError> allErrors=br.getAllErrors();
			for(ObjectError objectError:allErrors){
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("allErrors", allErrors);
			return "/items/add";
		}
		
		Items it=itemsService.selectItemById(id);
		it.setDetail(items.getDetail());
		it.setName(items.getName());
		it.setPic(items.getPic());
		it.setPrice(items.getPrice());
		//上传图片
		String originalFilename=items_pic.getOriginalFilename();
		if(items_pic!=null&& originalFilename!=null&& originalFilename.length()>0){
			String pic_path="/Users/zuo/Desktop/图片服务器/";
					
			//新的图片名称
			String newFileName=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			//新的图片
			File newFile=new File(pic_path+newFileName);
			//将内存中数据写入磁盘
			items_pic.transferTo(newFile);
			//将新图片名称写到itemsCustom中
			it.setPic(newFileName);
		}
		
		
		itemsService.update(it);
		
		return "redirect:/items/itemsList";
	}
	
	@RequestMapping(value="/{id}/show",method=RequestMethod.GET)
	public String show(Model model,@PathVariable Integer id) throws Exception{
		Items item=itemsService.selectItemById(id);
		model.addAttribute("item", item);
		return "items/show";
	}
	
	
	
	
	
	
	
	
	
	

}
