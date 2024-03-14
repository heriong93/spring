package com.example.demo.di;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Setter;

@SpringBootTest
public class DITest {
@Autowired //restaurant.java의 @component를 꺼내쓰는게 autowired
	 private Restaurant restaurant;

	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant1;
	
	@Test 
	public void 스코프비교() {
		assertThat(restaurant == restaurant1).isTrue(); //둘이 같은지 비교
	}
	 
	 @Test
	 public void test() {
		 assertThat(restaurant).isNotNull(); 
		 assertThat(restaurant.getChef()).isNotNull(); 
		 System.out.println(restaurant);
	}
}
