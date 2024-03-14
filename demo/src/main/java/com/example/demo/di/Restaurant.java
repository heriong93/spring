package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@Data //롬복 getter setter 만들어줌
@RequiredArgsConstructor //생성자를 만들어줌 final로 지정해줘야함
@Scope("prototype") //기본은 singletone, prototype, request, session 
public class Restaurant {
	final private Chef chef;

	
	
}
