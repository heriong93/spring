package com.example.demo.ex;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.emp.EmpVO;

@Controller //무조건 control은 이 어노테이션 추가하기
public class ExController {
	
	@RequestMapping("/ex6")
	//정보들은 empVO 로 들어가고 사진은 MULTIPART로 들어가게 됨
	public String ex6(EmpVO vo, MultipartFile[] photos) throws IllegalStateException, IOException { //input tag안의 name과 동일하게 적어줘여함
		System.out.println(vo);
		if(photos != null) {
			for(MultipartFile photo : photos) {
				if(photo.getSize() > 0) {
					//파일 생성
					File file=new File("d:/upload",photo.getOriginalFilename());
					//파일 저장
					photo.transferTo(file);
					System.out.println("파일명:"+photo.getOriginalFilename());
					System.out.println("파일크기:"+photo.getSize());
				}
			}
		}
		
		return "index";
	}
	@RequestMapping("/ex5") //커멘드 객체 없이 파라미터 localhost:8081/ex4?username=xxx&userage=2
	public String ex5(String username, @RequestParam(name ="userage", required=false, defaultValue= "10") Integer age) { //int보다는 integer로 지정해주기. 값이 안들어올 경우 default값지정해주면 값이 넘어오지 않아도 에러 뜨지 않음
		System.out.println(username+" is "+ age);
		return "index";
	}
	
	@RequestMapping("/ex4/{username}/{userage}")
	public String ex4(@PathVariable String username, @PathVariable(name="userage") int age) { //파라미터 별 @pathvariable 써줘야함. 변수명이 다르다면 괄호안에 설명해주기
		System.out.println(username+" is "+ age);
		return "index";
	}
	
	@RequestMapping ("/ex2") //req2.html 의 form action과 같이
	public String ex2(EX2VO vo) {
		System.out.println(vo);  //EX2VO(username=우와, password=우와와, hobby=[1]) 넘어옴
		return "index";
	}
	@RequestMapping("/ex3")
	public String ex3(ListCodeVO vo) {
		System.out.println(vo);  //ListCodeVO(list=[CodeVO(code=1, codeName=a), CodeVO(code=2, codeName=b), CodeVO(code=3, codeName=c)])
		return "index";
	}
}
