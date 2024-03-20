package com.example.demo.users;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UsersVO{
	private String userid;
	private String userpw;
	private String grade;
}
