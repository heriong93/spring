package com.example.demo.board;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
