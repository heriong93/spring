package com.example.demo.emp;

import lombok.Data;
@Data
public class SearchVO {

long start =1; //페이징용
long end = 10;

long[] employeeIds; //배열 
}
