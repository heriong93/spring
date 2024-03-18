package com.example.demo.emp;

import java.util.Date; //sql 로 하면 20-20-12 util.date로하면 23/23/12 넣는 포맷 다름

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm") //입력 string -> Date
	@JsonFormat (pattern="yyyy-MM-dd") //출력 Date -> String
	Date hireDate;
	Integer salary;
	String jobId;
	@JsonProperty(value="deptId") String departmentId;
	@JsonIgnore String managerId;
	@JsonIgnore String phone; //emp-mapper에 alias로 이름 정해 적어줄 수도 있다
	
}
