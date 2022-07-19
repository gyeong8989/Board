package com.korea.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.korea.controller.SubController;
import com.korea.dto.BoardDTO;
import com.korea.service.BoardService;

public class BoardReadController implements SubController {

		BoardService service = BoardService.getInstance();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//파라미터
		String no = req.getParameter("no");
		String nowPage = req.getParameter("nowPage");
		

		//서비스실행
		int num = Integer.parseInt(no);

		//Count증가
		Cookie[] cookies=req.getCookies();
		
		
		
		String isstop=null;
		for(int i=0;i<cookies.length;i++) 
		{
			if(cookies[i].getName().equals("count"));
				isstop = cookies[i].getValue();
		}
		
		if(isstop==null)
			service.CountUp(num);
		 
		//게시물 받기
		BoardDTO dto = service.getBoardDTO(num);
		
		//세션에 읽고있는 게시물 저장(수정,삭제로 이동시 현재 읽는 게시물 확인하기 쉽다)
		HttpSession session = req.getSession();
		session.setAttribute("dto", dto);

		
		//조회수 새로고침시 무한증가 방지
		Cookie cookie = new Cookie("count","true");
		cookie.setPath("/WEB-INF/board/read.jsp");
		resp.addCookie(cookie);
		
		//뷰로 이동
		

		
		try {
		
			req.setAttribute("dto", dto);
			req.setAttribute("nowPage", nowPage);			
			req.getRequestDispatcher("/WEB-INF/board/read.jsp").forward(req, resp);
			
		
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}