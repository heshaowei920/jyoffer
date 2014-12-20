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
        
        Users users=Users.dao.findById(1);
        
		renderJsp("../imageCut.jsp");
	}
	
}
