package com.yedam.app.emp.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmpMapper {
	@Select("select sysdate from dual")
	public String getTime();
	
	public Map<String,Object> getInfo(String EmpMapper); 
}
