package com.zuo.restaurant.po;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.zuo.restaurant.controller.validation.ValidationGroup1;
import com.zuo.restaurant.controller.validation.ValidationGroup2;


/**
 * 用户
 * 
 * @author zuo
 *	@NotEmpty(message="用户名不能为空")
	@NotEmpty(message="密码不能为空")
	@Size(min=1,max=10,message="密码的长度应该在1和10之间")
 */
public class User {
	private Integer id;
	@NotEmpty(message="{users.name.isNull}",groups={ValidationGroup2.class})
	private String name;
	@Size(min=6,max=20,message="{users.password.length.error}",groups={ValidationGroup2.class})
	@NotEmpty(message="{users.password.isNull}",groups={ValidationGroup2.class})
	private String password;
	private Integer type;
	
	@NotEmpty(message="{users.nickname.isNull}",groups={ValidationGroup1.class,ValidationGroup2.class})
	private String nickname;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNickname() {
		return nickname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", type=" + type + ", nickname="
				+ nickname + "]";
	}
	
	

}
