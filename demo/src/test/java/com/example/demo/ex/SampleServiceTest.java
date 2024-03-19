package com.example.demo.ex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.ex.service.SampleService;

import lombok.extern.log4j.Log4j2;
@Log4j2
@SpringBootTest
public class SampleServiceTest {
	@Autowired 
	private SampleService service;
	
	@Test
	public void 트랜잭션() {
		String str = "테스트입니다.";
		log.info("문자열 길이:"+str.getBytes().length);
		service.addData(str);
	}
}
