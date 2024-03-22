package com.yedam.app.emp.service;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface EmpService {
	
	public String getTime();
	public Map<String,Object> getInfo(String EmpMapper); 
}
