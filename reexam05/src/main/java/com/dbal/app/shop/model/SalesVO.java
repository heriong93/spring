package com.dbal.app.shop.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SalesVO {
	int saleSeq;  
	@DateTimeFormat(pattern = "yyyy-MM-dd")   
	Date saleDate;
	int productId;
	int saleQty;
	int salePrice;
	String memberId;
}
