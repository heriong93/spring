package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.ReplyVO;
@Mapper
public interface ReplyMapper {
	List <ReplyVO> getReplyList(ReplyVO vo); //전체 댓글 조회 
	 int insertReply (ReplyVO replyVO); // 단건 등록
}
