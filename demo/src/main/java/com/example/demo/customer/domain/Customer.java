package com.example.demo.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity //테이블과 연결
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) //시퀀스 지정
	 //기본키라는 의미
	private Long id;
	@Column(length = 20, nullable = false)
	private String name;
	private String phone;
}
