package com.example.demo.emp;

import java.util.Date; //sql 로 하면 20-20-12 util.date로하면 23/23/12 넣는 포맷 다름

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpVO {
	Integer employeeId;
	String firstName;
	String lastName;
	String email;
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm") 
	Date hireDate;
	Integer salary;
	String jobId;
	String departmentId;
	String managerId;
	String phone; //emp-mapper에 alias로 이름 정해 적어줄 수도 있다
	String photo;
	
}
