package com.yedam.app;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON변환 {
	public static void main(String[] args) throws MalformedURLException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		//object => json 
		EmpVO vo = new EmpVO("길동", "홍"); //생성자 방식
		//vo.setFirstName("길동"); //setter방식
		//vo.setLastName("홍");
		
		String str = objectMapper.writeValueAsString(vo);  //json 형식 string변환
		System.out.println(str);
		//json string => object로 바꾼 것 
		String json = "{\"employeeId\":null,\"firstName\":\"길동\",\"lastName\":\"홍\",\"email\":null,\"hireDate\":null,\"salary\":null,\"jobId\":null,\"departmentId\":null,\"managerId\":null,\"phone\":null,\"photo\":null}";
		vo = objectMapper.readValue(json, EmpVO.class );	//json 을 java object로 
		
		//url=> object
		Map map = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos/1"), Map.class);
		System.out.println(map.get("title"));
	}
}
