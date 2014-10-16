package com.jyoffer.controller;



import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jyoffer.model.Users;

public class IndexController extends Controller{
    
	public void index(){
		
		setAttr("msg", "这是一个测试的例子");
        
		renderJsp("../jsp/index.jsp");
	}
	
	@Before(Tx.class)
	public void test(){
        setAttr("msg", "这是一个测试test的例子");
		
        Record c = new Record();
        c.set("userID", "yonghu");
        c.set("password", "0000");
        
       new Users().set("userID", "yonghu").set("password", "0000")
        .set("realName", "dd").set("roleID", "1").set("roleName", "系统s管理员")
       .set("theDate", "2014-08-01").save();
       
        Users users=Users.dao.findById(1);
        
        System.out.println(users.getStr("realName"));
        System.out.println(users.getStr("password"));
        
        
		renderJsp("../imageCut.jsp");
	}
	
}
