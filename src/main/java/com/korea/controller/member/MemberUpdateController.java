package com.korea.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.korea.controller.SubController;
import com.korea.dto.MemberDTO;
import com.korea.service.MemberService;

public class MemberUpdateController implements SubController{
	
	MemberService service = MemberService.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//파라미터받기
		//입력값 확인
		//서비스 실행
		//View
		
		String flag = req.getParameter("flag");
		try {
			
			if(flag==null) //myinfo.jsp 에서 요청바음
			{
				req.getRequestDispatcher("/WEB-INF/member/password.jsp").forward(req, resp);
			}
			else  //password.jsp 에서 요청받음
			{
				//패스워드 검증후 일치한다면 정보수정 처리 해야함
				String pwd=req.getParameter("pwd");
				
				HttpSession session = req.getSession();
				String email = (String)session.getAttribute("email");
				MemberDTO dto = service.MemberSearch(email);
				
				if(service.passwordEncoder.checkpw(pwd, dto.getPwd()))
				{
					//패스워드가 일치한 경우
					//-> 수정된 값 파라미터 받기
					String addr1 = req.getParameter("addr1");
					String addr2 = req.getParameter("addr2");
					
					dto.setAddr1(addr1);
					dto.setAddr2(addr2);
					
					String newpwd = req.getParameter("newpwd");
					
					newpwd = service.passwordEncoder.hashpw(newpwd, service.passwordEncoder.gensalt());
					
					dto.setPwd(newpwd);
					
					
					// ->dto e단위로 담아서 service 함수로 전달
					service.MemberUpdate(dto);
					
					//View 이동
					req.setAttribute("dto", dto);
					req.getRequestDispatcher("/WEB-INF/member/myinfo.jsp").forward(req, resp);
					return;
				}
				else
				{
					//불일치한 경우
					req.setAttribute("MSG", "패스워드 불일치 똑바로 입력 하세요 ");
					req.getRequestDispatcher("/WEB-INF/member/password.jsp").forward(req, resp);
					return;
				}
				
			}
			
		} catch (ServletException | IOException e){
			
			e.printStackTrace();
		}
		
	}
	

}
