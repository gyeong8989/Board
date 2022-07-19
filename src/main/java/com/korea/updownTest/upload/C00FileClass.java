package com.korea.updownTest.upload;

import java.io.*;


public class C00FileClass {

	public static void main(String[] args) {
		
		File tmp = new File("c://upload/tmp");  //test.txt 하면 파일 뜸  최상위
//		File tmp = new File("upload");  //상대경로
		
		// 1 파일&디렉토리 여부 확인
		if(tmp.isFile())
			System.out.println("필욱이 파일입니다. (허락요망)");
		if(tmp.isDirectory())
			System.out.println("피루기 디렉입니다. (허락 O or X)");
		
		// 2 보로(경로)
		System.out.println(" 상대경로_PATH : " + tmp.getPath()); // 상대경로
		System.out.println("절대경로_PATH : " + tmp.getAbsolutePath()); //절대경로
		
		// 3 디렉토리생성   디렉이 없다면 만들어라
		if(!tmp.exists())  
			tmp.mkdirs();
		
		// 4 파일 목록 확인  디렉안에 파일 뭐가 있는지 확인하고 싶다
		
		File[] list = tmp.listFiles();  //파일 목록이 list에 담긴다
		System.out.println("-------------------------");
		for(int i = 0; i < list.length; i++)  //for문으로 빼내기 
		{
			if(list[i].isFile())  //리스트 안에 파일이라면 파일만 뽑아라 
			{
				System.out.println("필_File(전체경로) : " + list[i]);
				System.out.println("필!!_File(이름만): " + list[i].getName());
			}
		}
		System.out.println("------------아래는 원하는 파일 갖고오기---------------");
		// 5 필터처리(원하는 파일만 가져오기)
		File[] list2 = tmp.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				
				return name.contains(".txt");
				//name.endWidth("t"); //끝문자가 t인 파일 필터
				//naem.startWirdh("s"); //첫문자가 s인 파일 필터
			}
			
		});  //이름부여 없이 익명 개체 인터페이스 상속
		
		for(int i = 0; i < list2.length; i++) {
			System.out.println(list2[i]);
		}
		
	}

}
