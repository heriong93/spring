package com.dbal.app.shop.mapper;



import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import com.dbal.app.shop.model.ProductVO;

// BookMapper.xml의 파라미터 타입과 매개변수, namespace, id이름 다 맞아야함
@Mapper
public interface ProductMapper {
		public List<ProductVO> getProductList(); // 상품 목록
		public int insertProduct(ProductVO vo); // 단건 등록
		public int getProductNo(); //상품번호 조회
}
