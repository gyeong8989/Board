package com.korea.test;

import java.util.List;

import org.junit.Test;

import com.korea.dao.BoardDAO;
import com.korea.dto.BoardDTO;

public class DaoTest {

//	@Test
//	public void test() {
//		//
//		MemberDTO dto = new MemberDTO();
//		dto.setEmail("example@example.com");
//		dto.setPwd("1234");
//		dto.setAddr1("대구광역시 북구 구암로 남산에 돈까스");
//		dto.setAddr2("필욱이집 앞에 맛있음  ");
//		
//		MemberDAO dao = MemberDAO.getInstance();
//		boolean result = dao.insert(dto);
//		if(result)
//			System.out.println("INSERT 필승");
//		else
//			System.out.println("INSERT 실패유");
//	}
	
//	@Test
//	public void Test2() {
//		//MemberDAO's Select(email)
//		MemberDAO dao = MemberDAO.getInstance();
//		MemberDTO dto = dao.Select("example@example.com");
//		System.out.println("결과 : " + dto.toString());
//	}
	
//---------------------------------------------------------------------	
	
//	@Test
//	public void Test3() {
//		MemberDTO dto = new MemberDTO();
//		dto.setEmail("2@2");
//		dto.setPwd("123");
//		dto.setAddr1("피리");
//		dto.setAddr2("e대구");
//		
//		MemberDAO dao = MemberDAO.getInstance();
//		dao.update(dto);
//	}
	
//-----------------------------------------------------------------------	
	
//	@Test
//    public void Test4() {
//        MemberDTO dto = new MemberDTO();
//        dto.setEmail("admin@admin.com");
//        dto.setPwd("1234");
//        dto.setAddr1("");
//        dto.setAddr2("");
//        dto.setGrade(2);
//
//        MemberService memberService = MemberService.getInstance();
//        memberService.MemberInsert(dto); // 관리자 계정 등록

//        dto.setEmail("guest@guest.com");
//        dto.setPwd("1234");
//        dto.setAddr1("");
//        dto.setAddr2("");
//        dto.setGrade(0);
//
//        memberService.MemberInsert(dto);
	
//---------------------------------------------------------
    
//	@Test
//	public void Test4()
//	{
//		BoardDAO dao = BoardDAO.getInstance();
//		
//		List<BoardDTO> list = dao.Select(11, 20);
//		
//		//list.forEach(dto -> System.out.println(dto));
//		for(int i=0; i < list.size(); i++)
//		{
//			System.out.println(list.get(i));
//		}
//	}
	
//---------------------------------------------------------------	
	
//	@Test
//	public void Test5()	{
//		BoardDAO dao= BoardDAO.getInstance();
//		int result = dao.getTotalCount();
//		System.out.println("게시물 건수 :" + result);
//	}
	
//------------------------------------------------------------------
	
//	@Test
//	public void Test6()
//	{
//		BoardDAO dao= BoardDAO.getInstance();
//		BoardDTO dto = new BoardDTO();
//		dto.setTitle("t손씨");
//		dto.setContent("호호호");
//		dto.setWriter("필방");
//		dto.setPwd("112233");
//		dto.setIp("192.168.10.1");
//		
//		dao.Insert(dto);
//	}
	
//	------------------------------------------------------------------
	
	@Test
	public void Test7()
	{
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.Select(100);
		
		System.out.println(dto);
	}

}
