package com.korea.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.korea.controller.auth.LoginController;
import com.korea.controller.auth.LogoutController;
import com.korea.controller.member.MemberInfoController;
import com.korea.controller.member.MemberJoinController;


public class FrontController extends HttpServlet{
	//URL: SubControlloer 객체주소
	HashMap<String, SubController> list = null;
	
	@Override
	public void init() throws ServletException {
		list = new HashMap();
		
		//회원관련
		list.put("/MemberJoin.do" , new MemberJoinController());
		list.put("/MemberInfo.do", new MemberInfoController());
		System.out.println("프론트 컨트롤러 서비스 손필욱 실행!!");
		
		//인증관련
		list.put("/Login.do",  new LoginController());
		list.put("/Logout.do", new LogoutController());
		
		//게시판관련
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String url = req.getRequestURI();
		System.out.println("URL: " + url);
		SubController sub = list.get(url);
		if(sub!=null)
			sub.execute(req, resp);
	}

	

}
