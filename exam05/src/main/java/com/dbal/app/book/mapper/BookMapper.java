package com.dbal.app.book.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.model.RentVO;

// BookMapper.xml의 파라미터 타입과 매개변수, namespace, id이름 다 맞아야함
@Mapper
public interface BookMapper {
		public List<BookVO> getBookList(); // 목록 출력되는 건이 여러건이라서 List로 지정해줌.단건조회면 bookVO만 줘도 됨
		public int insertBook(BookVO vo); // 단건 등록
		public int getBookNo(); //도서번호 조회
		public List<Map> getRent(); //대여매출 현황
		//parameterType="BookVO" 로 지정되어 있으니 (BookVO vo) 넣어줘야힘
}
