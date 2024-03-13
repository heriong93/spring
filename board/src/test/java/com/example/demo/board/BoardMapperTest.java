package com.example.demo.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;


@SpringBootTest
public class BoardMapperTest {
	@Autowired BoardMapper mapper;
	
	//게시글 검색, 페이징
	@Test
	public void 게시글전체조회() {
		BoardVO vo = new BoardVO();
		List <BoardVO> list = mapper.getBoardList(vo);

		for(BoardVO board : list) {
			System.out.println(board.getBoardNo()+":"+board.getContent());
		}
		
		System.out.println(list);
		System.out.println("결과는:"+list.size());
	}
	
	//게시글 단건조회
	//@Test
	public void 게시글단건조회() {
		int boardNo = 3;
		BoardVO vo = mapper.getBoardInfo(boardNo);
		System.out.println(vo);
		
	}
	
	
	
}
