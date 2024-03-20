package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.board.BoardVO;
import com.example.demo.emp.SearchVO;
@Mapper
public interface BoardMapper {
	List<BoardVO> getBoardList(BoardVO vo); //전체 조회 및 페이징
	BoardVO  getBoardInfo(int boardNo); //게시글 단건 조회
	int insertBoard(BoardVO boardVO); // 단건 등록
	int deleteBoard(int boardNo); //단건 삭제
	int updateBoard(BoardVO VO); //게시물 수정
	
	//@Select("select count(*) from board") 
	 long getCount(BoardVO vo);
		
}
