package com.jyoffer.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jyoffer.dao.Users;
import com.jyoffer.dao.Worker;
import com.jyoffer.utils.SecurityHelper;
import com.jyoffer.utils.StringUtils;

public class WorkerController extends Controller{
    
	public void index() {
		Users users = Users.dao.findById(1);
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
	
	public void edit() throws Exception{
		String userID=getPara("userID");
		userID=StringUtils.replaceAll(userID);
		userID=SecurityHelper.decrypt("11", userID);
        Worker worker=Worker.dao.findFirst("select * from worker where userID=?", userID);
		setAttr("worker", worker);
		System.out.println(userID);
		renderJsp("../jsp/worker_edit.jsp");
		
	}
	
}
