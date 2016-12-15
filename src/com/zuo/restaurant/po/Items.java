package com.zuo.restaurant.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.zuo.restaurant.controller.validation.ValidationGroup2;
/**
 * 菜
 * @author zuo
 *
 */
public class Items {
	
	private Integer id;
	@NotBlank(message="{items.name.isNull}",groups={ValidationGroup2.class})
	private String name;
	@NotNull(message="{items.price.isNull}",groups={ValidationGroup2.class})
	private Double price;
	private String detail;
	private String pic;
	private Date createTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
	

}
