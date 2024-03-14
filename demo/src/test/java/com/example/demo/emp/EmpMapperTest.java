package com.example.demo.emp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;

@SpringBootTest //test할 수 있는 환경 만들어줌
public class EmpMapperTest {
	@Autowired EmpMapper mapper;
	
	@Test
	public void 사원등록() {
		//vo.객체 생성 (아래 내용 builder 로 사용 가능 )
		EmpVO vo = EmpVO.builder()
				//.employeeId(5000)
				.lastName("Gootry")
				.email("caaado@naver.com")
				.hireDate(new Date(1999,1,2))
				.jobId("IT_PROG")
				.build();
		int result= mapper.insertEmp(vo);
		
		//값을 담고
		//vo.setEmployeeId(5000);
		//vo.setLastName("Caprizo");
		//vo.setEmail("caprizo@gmail.com");
		//vo.setHireDate(new Date(2020,1,2));
		//vo.setJobId("ST_MAN");
		
		//등록된 사번을 조회
		System.out.println("등록된 사번:"+vo.getEmployeeId());
		System.out.println("등록건수:"+result);
	}
	
	//@Test
	public void 사원전체조회() {
		EmpVO vo = new EmpVO();
		SearchVO svo = new SearchVO();
//		vo.setDepartmentId("50"); //<if test="departmentId != null">department_id =#{departmentId} -> emp-mapper.xml에서 지정해준대로 
//		vo.setFirstName("Kevin");
//		vo.setManagerId("103");
//		vo.setStart(1);
//		vo.setEnd(5);
		svo.setEmployeeIds(new int[] {100,101,102});
		List <EmpVO> list = mapper.getEmpList(vo,svo);
		
		//for문 돌려서-> employee_id, firstName 출력해보기 
		for(int i = 0; i < list.size();i++) {
			System.out.println("사번은:"+list.get(i).employeeId);
			System.out.println("이름은:"+list.get(i).firstName);
		}
		for(EmpVO emp : list) {
			System.out.println(emp.getEmployeeId()+":"+emp.getFirstName());
		}
		
		System.out.println(list);
		System.out.println("결과는:"+list.size());
	}
	
	//@Test
	public void 사원단건조회() {
		int employeeId = 100;
		EmpVO vo = mapper.getEmpInfo(employeeId);
		System.out.println(vo);
		//assertEquals(employeeId, vo.employeeId); //두개의 값이 비슷한지 비교하는 것
	}
	
	//@Test
	public void 사원삭제() {
		Integer employeeId = 5000;
		int result = mapper.deleteEmp(employeeId);
		System.out.println("삭제된 사원은:"+result);
	}
	//@Test
	public void 사원통계() { //listMap
		List<Map<String, Object>> list = mapper.getStat();
		//for departmentId cnt 만 출력 
		for(Map<String, Object> map: list) {
			System.out.println(map.get("name")); //map의 키 값 { DEPARTMENT_NAME=Purchasing, DEPARTMENT_ID=30, CNT=6}
		}
		System.out.println(list);
	}
	
}
