package com.example.demo.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@AllArgsConstructor

public class ReplyController {
	@Autowired ReplyMapper mapper;
	//댓글 리스트 
	@GetMapping("/replies/list")
	public List<ReplyVO> replyList (ReplyVO vo) {
		return mapper.getReplyList(vo);
	}
	
	//댓글 등록
	@RequestMapping("/replies/new")
	public ReplyVO insert (ReplyVO vo) {
		mapper.insertReply(vo);
		System.out.println(vo);
		return vo;
	}
	

}
