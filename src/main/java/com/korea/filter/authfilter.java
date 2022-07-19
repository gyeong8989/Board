package com.korea.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class authfilter implements Filter {

	//key : URL , Value : Grade 
	Map<String, Integer> pageGradeMap = new HashMap();
	
//	private boolean flag=false;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//권한부여 
		
		pageGradeMap.put("/Board/list.do", 0); //모두 이용가능
		pageGradeMap.put("/Board/post.do", 1); //일반 계정권한 이상
		
		pageGradeMap.put("/Notice/list.do", 0); //모두 이용가능
		pageGradeMap.put("/Notice/post.do", 2); //관리자 등급에서만 사용
		
	}



	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		//Request 전 처리
		System.out.println("======Filter Request전 처리(필욱이 허락 받는중 !!!)");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
			//Sssion으로 부터 grade 추출
			//servlet request -> Http Request 다운캐스팅  상위클래스 객체 라서 내장객체 사용 할수있음
			HttpServletRequest request = (HttpServletRequest)req;
			
			//세션을 통해서 grade 가져오는 작업
			HttpSession session = request.getSession();
//			int usergrade = (Integer)session.getAttribute("grade");
			
			int usergrade = 0 ; // 기본 권한 0으로 잡고
			
			//처음 접속이 아닐경우 
			if(session.getAttribute("grade")!=null)
				usergrade=(Integer)session.getAttribute("grade");
			
			//System.out.println("UserGrade : " + usergrade +"입니다.");
			
		  //URL grade 확인
			String URL = request.getRequestURI();
			System.out.println("Filter's URL : " + URL);
			
			int pagegrade =0;//기본권한
			if(pageGradeMap.get(URL)!=null)//숫자값 get 위에 등록안되어 있는 URL 경우 넘어감 
								
				pagegrade=pageGradeMap.get(URL);
			
			System.out.println("<--PageGrade--> : " + pagegrade +"번 입니다.");
			
			//guest계정이 1이상의 page로 접근 불가
			//user - pag 권한 설정 하는 부분
			//guest 계정의 권한 제한
			if(usergrade==0 && pagegrade>=1)
				throw new ServletException("손필욱 허락이 필요한 페이지 입니다 ");
			//admin이 아닌 계정의 권한 제한 
			if(usergrade<2 && pagegrade==2)
				throw new ServletException("페이지 접근할 권한 없습니다. 에휴~");
			
			
		
		chain.doFilter(req, resp);
		//Response 후 처리  로그아웃 이후 처리되는 녀석  f -> l 안으로 들어옴  O -> 
		
		System.out.println("===Filter Response 후 처리 (필욱이 허락 맡고 처리 완료!!)");
		
		
	}

}
