package com.jyoffer.controller;



import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jyoffer.dao.Users;

public class MasterController extends Controller{
    
	public void index(){
		
		setAttr("msg", "����һ�����Ե�����");
		
		renderJsp("../index.jsp");
	}
	
	@Before(Tx.class)
	public void test(){
        setAttr("msg", "����һ������test������");
		
        
       // Users.dao.set("userID", "yonghu").set("password", "0000")
       // .set("realName", "dd").set("roleID", "1").set("roleName", "ϵͳs����Ա")
       // .set("theDate", "2014-08-01").save();
        
        Users users=Users.dao.findById(1);
        
        System.out.println(users.getStr("realName"));
        System.out.println(users.getStr("password"));
        
		renderJsp("../imageCut.jsp");
	}
	
}
