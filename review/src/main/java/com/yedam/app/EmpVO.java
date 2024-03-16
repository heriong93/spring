package com.yedam.app;

import java.util.Date;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import lombok.ToString; 
@RequiredArgsConstructor
@ToString
public class EmpVO {
	private Integer employeeId;
	final private String firstName;
	final private String lastName;
	private String email;
	private Date hireDate;
	final private Integer salary;
	private String jobId;
	private String departmentId;
	private String managerId;
	private String phone; 
	private String photo;
	
	
	
	//public EmpVO() {} 기본 생성자 
	
	public EmpVO (String firstName, String lastName, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;	
		this.salary = salary;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}

	 public Integer getSalary() {
		return this.salary;
	}

	@Override
	public boolean equals(Object obj) {
		EmpVO vo = (EmpVO) obj; //부모 자식간의 형변환 가능
		return this.firstName.equals(vo.getFirstName()) && this.lastName.equals(vo.getLastName()) ; 
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.firstName, this.lastName);
	}
	
	
	
	
	
}
