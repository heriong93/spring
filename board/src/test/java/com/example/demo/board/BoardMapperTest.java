package com.example.demo.board;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.emp.EmpVO;


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
	
	//게시글 등록
	@Test
	public void 게시글등록() {
		//vo.객체 생성 (아래 내용 builder 로 사용 가능 )
		BoardVO vo = BoardVO.builder()
				.title("게시글 등록 성공하고싶다")
				.content("봍붙이지만 안되는건 뭐죠")
				.writer("홍길동")
				.writerDate(new Date(2024,1,2))
				.ClickCnt(1)
				.image("이미지.jpg")
				.build();
		int result= mapper.insertBoard(vo);
		
		//등록된 사번을 조회
		System.out.println("등록 건수:"+result);
	}
	  //게시글 삭제
	@Test
	public void 게시글삭제() {
		Integer boardNo = 3;
		int result = mapper.deleteBoard(boardNo);
		System.out.println("삭제된 게시글은:"+result);
	}
	  //게시글 수정
	
	
	
	
	
}
