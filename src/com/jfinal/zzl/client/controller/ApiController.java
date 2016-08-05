package com.jfinal.zzl.client.controller;

import java.util.Date;

import com.jfinal.core.Controller;
import com.jfinal.zzl.ResultBean;
import com.jfinal.zzl.client.model.User;
import com.jfinal.zzl.utils.StringUitls;

public class ApiController extends Controller {
	
	public void registerUser() {
		String name = getPara("name");
		String phone = getPara("phone");
		String password = getPara("password");
		
		ResultBean<User> bean = new ResultBean<User>();
		
		if (StringUitls.isNullOrEmpty(name)) {
			bean.setCode(2);
			bean.setMsg("姓名不能为空");
		} else {
			User user = new User();
			user.set("name", name);
			user.set("phone", phone);
			user.set("password", password);
			user.set("add_time", new Date());
			boolean flag = user.save();
			if (flag) {
				bean.setCode(1);
				bean.setMsg("注册成功");
				bean.setData(user);
			}
		}
		
		renderJson(bean);
	}

}
