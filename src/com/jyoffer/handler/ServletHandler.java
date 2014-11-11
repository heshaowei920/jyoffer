package com.jyoffer.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class ServletHandler extends Handler {
	@Override
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, boolean[] isHandled) {
		int index=target.indexOf(".png");
		
		System.out.println(index+"/////////////////////");
		if(index!=-1){
			return;
		}else{
			nextHandler.handle(target, request, response, isHandled);
		}
	}

}
