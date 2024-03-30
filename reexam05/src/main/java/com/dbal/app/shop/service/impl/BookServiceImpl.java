package com.dbal.app.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbal.app.shop.mapper.ProductMapper;
import com.dbal.app.shop.model.ProductVO;
import com.dbal.app.shop.service.ProductService;

@Service("ProductService") // 빈 담아주는 것. 그리고 implements로 상속받아야함
public class BookServiceImpl implements ProductService{
	
	@Autowired //mapper부르기 위해 연결
	ProductMapper productMapper;

	@Override
	public List<ProductVO> getProductList() {
		return productMapper.getProductList();
	}

	@Override
	public boolean insertProduct(ProductVO vo) {
		return productMapper.insertProduct(vo) == 1 ? true : false;
	}

	@Override
	public int getProductNo() {
		return productMapper.getProductNo();
	}

	
	
}

