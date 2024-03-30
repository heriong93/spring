package com.dbal.app.book.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbal.app.book.mapper.BookMapper;
import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.service.BookService;

@Service("BookService") // 빈 담아주는 것. 그리고 implements로 상속받아야함
public class BookServiceImpl implements BookService{
	
	@Autowired //mapper부르기 위해 연결
	BookMapper bookMapper;

	@Override
	public List<BookVO> getBookList() {
		return bookMapper.getBookList();
	}

	@Override
	public boolean insertBook(BookVO vo) {
		return bookMapper.insertBook(vo) == 1 ? true : false ;
	}

	@Override
	public int getBookNo() {
		return bookMapper.getBookNo();
	}

	@Override
	public List<Map> getRent() {
		return bookMapper.getRent();
	}

	
	
}

