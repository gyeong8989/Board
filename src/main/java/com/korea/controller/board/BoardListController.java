package com.korea.controller.board;

import java.util.List;

<<<<<<< HEAD
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.korea.controller.SubController;
import com.korea.dto.BoardDTO;
import com.korea.service.BoardService;

public class BoardListController implements SubController {

	BoardService service = BoardService.getInstance();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			
			//파라미터 확인 
			String tmpstart = req.getParameter("start");
			String tmpend = req.getParameter("end");
			String nowPage = req.getParameter("nowPage");
			
			int start = 0;  // rownum  1~ 10 까지만 보게 함
			int end = 0;
			
			if(tmpstart==null || tmpend==null)
			{
				start = 1; 
				end = 10;
			}
			else
			{
				start = Integer.parseInt(tmpstart);
				end = Integer.parseInt(tmpend);
			}
			
			//입력값 검증
			// 서비스실행
			List<BoardDTO> list = service.getBoardList(start, end); //DAO 호출
			int tcnt = service.getTotalCnt(); //서비스 사용 해서 tcnt 에 담아줌
			
			
			req.setAttribute("list", list); // key 와 value 로 저장 
			req.setAttribute("tcnt", tcnt);// 담아서 리퀘스트 
			//정리 6일차 (페이징처리) 추가?
			//req.setAttribute("nowPage", nowPage);
			
			//쿠키생성(게시글읽기 새로고침시 중복 Count방지)
			Cookie init = new Cookie("init","true");
			resp.addCookie(init);
			
			req.getRequestDispatcher("/WEB-INF/board/list.jsp?nowPage="+nowPage).forward(req, resp);
		} catch (Exception e) {
			
			  
			e.printStackTrace();
		}
		
=======
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.korea.controller.SubController;
import com.korea.dto.BoardDTO;
import com.korea.service.BoardService;

public class BoardListController implements SubController {

	BoardService service = BoardService.getInstance();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			
			//파라미터 확인 
			String tmpstart = req.getParameter("start");
			String tmpend = req.getParameter("end");
			String nowPage = req.getParameter("nowPage");
			
			int start = 1;  // rownum  1~ 10 까지만 보게 함
			int end = 10;
			
			if(tmpstart==null || tmpend==null)
			{
				start = 1; 
				end = 10;
			}
			else
			{
				start = Integer.parseInt(tmpstart);
				end = Integer.parseInt(tmpend);
			}
			//입력값 검증
			// 서비스실행
			List<BoardDTO> list = service.getBoardList(start, end); //DAO 호출
			int tcnt = service.getTotalCnt(); //서비스 사용 해서 tcnt 에 담아줌
			
			
			req.setAttribute("list", list); // key 와 value 로 저장 
			req.setAttribute("tcnt", tcnt);// 담아서 리퀘스트 
			//정리 6일차 (페이징처리) 추가?
			
			
			req.setAttribute("nowPage", nowPage);
			
			req.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(req, resp);
		} catch (Exception e) {
			
			  
			e.printStackTrace();
		}
>>>>>>> refs/remotes/origin/master
		

	}

}
