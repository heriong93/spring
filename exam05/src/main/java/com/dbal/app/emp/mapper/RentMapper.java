package com.dbal.app.emp.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.dbal.app.book.model.RentVO;

@Mapper
public interface RentMapper {
	RentVO  getRent(int bookNo); //도서 기준 대여 조회
}
