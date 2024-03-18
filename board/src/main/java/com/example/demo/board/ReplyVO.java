package com.example.demo.board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {
	Integer rno;
	Integer bno;
	String reply;
	String replyer;
	Date replyDate;
	Date updateDate;
}
