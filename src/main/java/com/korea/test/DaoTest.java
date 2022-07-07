package com.korea.test;

import org.junit.Test;

import com.korea.dao.MemberDAO;
import com.korea.dto.MemberDTO;

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
	
	@Test
	public void Test2() {
		//MemberDAO's Select(email)
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = dao.Select("example@example.com");
		System.out.println("결과 : " + dto.toString());
	}

}
