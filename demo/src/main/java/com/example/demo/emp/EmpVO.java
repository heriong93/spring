package com.example.demo.emp;

import java.sql.Date;

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
	Date hireDate;
	Integer salary;
	String jobId;
	String departmentId;
	String managerId;
	String phone; //emp-mapper에 alias로 이름 정해 적어줄 수도 있다
	
}
