package com.korea.controller.auth;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.korea.controller.SubController;
import com.korea.filter.authfilter;

public class LogoutController implements SubController{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		
		try {
			
			//필처로그아웃시 flag를 false 설정 ->
			//재접속시 한번은 session 로부터 grade 꺼내지 않는다
			
			
			req.setAttribute("MSG", "로그아웃 완료");
			req.getRequestDispatcher("/").forward(req, resp);
			//resp.sendRedirect("/");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	
}
