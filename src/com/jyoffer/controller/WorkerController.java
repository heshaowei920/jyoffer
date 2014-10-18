package com.jyoffer.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jyoffer.dao.Users;

public class WorkerController extends Controller{
    
	public void index(){
		
		setAttr("msg", "这是一个测试的例子");
        Users users=Users.dao.findById(1);
        
       System.out.println(users.getStr("name"));
       System.out.println(users.getStr("password"));
		renderJsp("../jsp/index.jsp");
	}
	
	
	@Before(Tx.class)
	public void save(){
        
		
		String age=getPara("age");
		String sex=getPara("sex");
		String name=getPara("name");
		String phone=getPara("phone");
		String education=getPara("education");
		String condition=getPara("condition");
		String salary=getPara("salary");
		String email=getPara("email");
		
        Record c = new Record().set("age", age);
        c.set("sex", sex);
        c.set("name", name);
        c.set("phone", phone);
        c.set("education", education);
        c.set("condition", condition);
        c.set("salary",salary);
        c.set("email", email);
        Db.save("worker", c);
        
        
        setSessionAttr("name",name);
		renderJsp("../jsp/index.jsp");
	}
	
	

	
}
