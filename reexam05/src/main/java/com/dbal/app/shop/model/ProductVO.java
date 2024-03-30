package com.dbal.app.shop.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductVO {
	int productId;
	String productName;
	int productPrice;
	String productInfo;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	Date productDate;
	String company;
	String ManagerId;
}
