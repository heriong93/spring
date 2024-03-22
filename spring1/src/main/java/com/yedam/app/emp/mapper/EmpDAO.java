package com.yedam.app.emp.mapper;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class EmpDAO {

	SqlSession mybatis;
	
		//생성자 주입 방식
		public EmpDAO(SqlSession mybatis) {
		super();
		this.mybatis = mybatis;
	}


		public Map<String, Object> getInfo(String employeeId){
			return mybatis.selectOne("Employee.getInfo", employeeId); //EmpMapper.xml 의 namespace, id와 동일
		}
	}

