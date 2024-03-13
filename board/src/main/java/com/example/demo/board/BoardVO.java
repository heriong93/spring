package com.example.demo.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	int boardNo;
	String title;
	String content;
	String writer;
	Date writerDate;
	int ClickCnt;
	String image;
	int start =1; //페이징용
	int end = 10;
}
