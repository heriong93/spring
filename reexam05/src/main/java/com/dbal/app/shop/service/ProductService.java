package com.dbal.app.shop.service;

import java.util.List;

import com.dbal.app.shop.model.ProductVO;



public interface ProductService {
	public List<ProductVO> getProductList(); // 목록 
	public boolean insertProduct(ProductVO vo); //상품 등록
	public int getProductNo(); 
}
