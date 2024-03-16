package com.yedam.app;

/*
 * char-Character
 * byte - Byte
 * int - Integer
 * short - Short 
 * long - Long
 * float - Float
 * double - Double
 * boolean -Boolean
 */

public class 형변환 {
	public static void main(String[] args) {
		//other type = > string 
		Integer score = 100;
		String s = Integer.toString(score);
		
		double avg = 90.5;
		String a = Double.toString(avg);
		
		//string ==> other type
		score = Integer.parseInt(s); // integer로 
		avg = Double.parseDouble(s); //double 형식으로
		
		
		
	}
	
}
