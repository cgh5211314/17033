/**
 * Create Date:2019年8月12日
 */
package com.chenguanghua.cms;

import java.io.Serializable;

/**
 * <br>
 * Title:TODO 类标题 <br>
 * Description:TODO 实体类功能描述 <br>
 * Author:陈广华(823865618@qq.com) <br>
 * Date:2019年8月12日
 */
public class User implements Serializable {
	private Integer id;
	private String name;
	private String sex;
	private String phone;
	private String youx;
	private String birthday;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getYoux() {
		return youx;
	}

	public void setYoux(String youx) {
		this.youx = youx;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public User(Integer id, String name, String sex, String phone, String youx, String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.youx = youx;
		this.birthday = birthday;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String sex, String phone, String youx, String birthday) {
		super();
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.youx = youx;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", youx=" + youx
				+ ", birthday=" + birthday + "]";
	}

}
