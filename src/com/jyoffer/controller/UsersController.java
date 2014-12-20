package com.jyoffer.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jyoffer.dao.Users;
import com.jyoffer.dao.Worker;
import com.jyoffer.model.WorkerVO;
import com.jyoffer.utils.SecurityHelper;

public class UsersController extends Controller{
    
	/**
	 * 
	 */
	public void index() {
		setAttr("msg", "����һ�����Ե�����");
		Users users = Users.dao.findById(1);
		System.out.println(users.getStr("name"));
		System.out.println(users.getStr("password"));
		renderJsp("../jsp/index.jsp");
	}
	
	/**
	 * ע��
	 */
	public void register(){
		
		renderJsp("../jsp/users_register.jsp");
	}
	
	/**
	 * �����û�
	 */
	@Before(Tx.class)
	public void save(){
		String userID=getPara("userID");
		String password=getPara("password");
        Record c = new Record().set("userID", userID).set("password", password);
        Db.save("users", c);
		renderJsp("../jsp/worker_edit.jsp");
	}
	
	/**
	 * �༭
	 */
	public void edit(){
		String userID=getPara("userID");
		Worker worker=Worker.dao.findFirst("select * from worker where userID=?", userID);
		setAttr("worker", worker);
		renderJsp("../jsp/worker_edit.jsp");
	}
	
	/**
	 * ��¼
	 */
	public void login(){
		renderJsp("../jsp/users_login.jsp");
	}
	
	/**
	 * ����¼
	 * @throws Exception
	 */
	public void checkLogin() throws Exception{
		String userID=getPara("userID");
		String password=getPara("password");
		Users user = Users.dao.findFirst("select * from users where userID = ? and password = ?",userID,password);
		if(user!=null){
			Worker worker=Worker.dao.findFirst("select * from worker where userID=?", userID);
			WorkerVO workerVo=new WorkerVO();
			workerVo.setName(worker.getStr("name"));
			workerVo.setUserID(SecurityHelper.encrypt("11",worker.getStr("userID")));
			setSessionAttr("worker",workerVo);
			renderJsp("../jsp/index.jsp");
		}else{
			renderJsp("../jsp/users_login.jsp");
		}	
	}
	
}
