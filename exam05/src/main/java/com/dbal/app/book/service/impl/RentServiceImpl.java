package com.dbal.app.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbal.app.book.model.RentVO;
import com.dbal.app.book.service.RentService;
import com.dbal.app.emp.mapper.RentMapper;

@Service("rentService")
public class RentServiceImpl implements RentService{
	@Autowired
	RentMapper rentMapper;
	@Override
	public RentVO getRent(int bookNo) {
		return rentMapper.getRent(bookNo);
	}
	
	
}
