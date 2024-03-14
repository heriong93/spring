package com.example.demo.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
@Mapper
public interface EmpMapper {
	List<EmpVO> getEmpList(@Param("vo")EmpVO vo, SearchVO svo); //결과 값이 여러개일 때 list (emp-mapper.xml과 비교하며 작성)
	EmpVO getEmpInfo(int employeeId);// <select id="getEmpInfo" parameterType="int" resultType="EmpVO">
	int insertEmp(EmpVO empVO); //단건 등록 
	int deleteEmp (Integer employeeId); //단건 삭제
	List<Map<String, Object>> getStat(); // 부서별 사원 조회 #{}매개변수 없으면 안에 (값)없어도 됨 
}
