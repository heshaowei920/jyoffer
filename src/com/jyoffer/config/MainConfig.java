package com.jyoffer.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.UrlSkipHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jyoffer.controller.CompanyController;
import com.jyoffer.controller.IndexController;
import com.jyoffer.controller.UsersController;
import com.jyoffer.controller.WorkerController;
import com.jyoffer.dao.Company;
import com.jyoffer.dao.Users;
import com.jyoffer.dao.Worker;
import com.jyoffer.handler.ServletHandler;



public class MainConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		loadPropertyFile("jdbc.properties");	
		me.setDevMode(getPropertyToBoolean("devMode", false));
		
	}

	@Override
	public void configHandler(Handlers me) {
		
		 me.add(new ServletHandler());
	}

	@Override
	public void configInterceptor(Interceptors me) {
		
		
	}

	@Override
	public void configPlugin(Plugins me) {
		String url=getProperty("url");
		String userName=getProperty("userName");
		String password=getProperty("password");
		
		C3p0Plugin cp=new C3p0Plugin(url,userName,password);
	    me.add(cp);
	    ActiveRecordPlugin arp=new ActiveRecordPlugin(cp);
	    me.add(arp);
	    arp.addMapping("users", "theID", Users.class);
	    arp.addMapping("worker", "theID", Worker.class);
	    arp.addMapping("company", "theID", Company.class);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/index",IndexController.class);
		me.add("/users",UsersController.class);
		me.add("/worker",WorkerController.class);
		me.add("/company",CompanyController.class);
	}
   
	
}
