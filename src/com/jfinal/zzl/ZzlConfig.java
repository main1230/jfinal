package com.jfinal.zzl;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.zzl.client.controller.ApiController;

public class ZzlConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用PropKit.get(...)获取值ֵ
		PropKit.use("config.properties");
		me.setDevMode(PropKit.getBoolean("devMode", false));
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/api", ApiController.class);
	}

	public static C3p0Plugin createC3p0Plugin() {
		return new C3p0Plugin(PropKit.get("jdbcUrl"), 
				PropKit.get("user"), 
				PropKit.get("password").trim());
	}

	@Override
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		C3p0Plugin C3p0Plugin = createC3p0Plugin();
		me.add(C3p0Plugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
		me.add(arp);
		
		// 所有配置在 MappingKit 中搞定
		_MappingKit.mapping(arp);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}

}
