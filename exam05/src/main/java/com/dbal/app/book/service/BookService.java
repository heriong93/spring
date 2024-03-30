package com.dbal.app.book.service;

import java.util.List;
import java.util.Map;

import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.model.RentVO;

//BookMapper.java 와 80% 이상 비슷. 복사 붙여넣기 해도 무관
public interface BookService {
	public List<BookVO> getBookList(); // 목록 
	public boolean insertBook(BookVO vo); //도서 등록
	public int getBookNo(); 
	public List<Map> getRent();
}
