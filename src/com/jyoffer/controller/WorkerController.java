package com.jyoffer.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jyoffer.model.Users;

public class WorkerController extends Controller{
    
	public void index(){
		
		setAttr("msg", "这是一个测试的例子");
        Users users=Users.dao.findById(1);
        
       System.out.println(users.getStr("name"));
       System.out.println(users.getStr("password"));
		renderJsp("../jsp/index.jsp");
	}
	
	public void register(){
		
		renderJsp("../jsp/users_register.jsp");
	}
	
	
	@Before(Tx.class)
	public void save(){
        
		
		String userID=getPara("userID");
		String password=getPara("password");
		System.out.println(userID);
		System.out.println(password);
        Record c = new Record().set("userID", userID).set("password", password);
        Db.save("users", c);
		renderJsp("../jsp/index.jsp");
	}
	
	
	public void login(){
		
		renderJsp("../jsp/users_login.jsp");
	}
	
	
	public void checkLogin(){
		String userID=getPara("userID");
		String password=getPara("password");
		
		Users user = Users.dao.findFirst("select * from users where userID = ? and password = ?",userID,password);
		
		System.out.println(user.getStr("userID"));
		renderJsp("../jsp/index.jsp");
	}
	
}
