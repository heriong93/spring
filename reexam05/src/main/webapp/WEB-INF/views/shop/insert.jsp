<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<style>
label {display:inline-block; width:100px;}
div {}
</style>
</head>
<body>
	<h3>상품 등록</h3>

		<form method="post" name="frm" action="insertProduct"> <!--  name= vo필드명과 동일하게 -->
		<div class="form ">
		<label>상품ID</label>
		<input type="text" name="productId" value="${productId}">
		</div>
		<div>
		<label>이름</label>
		<input type="text" name="productName">
		</div>
		<div>
		<label>단가</label>
		<input type="number" name="productPrice">
		</div>
		<div>
		<label>상품정보</label>
		<input type="text" name="productInfo">
		</div>
		<div>
		<label>등록일자</label>
		<input type="date" name="productDate" value="${productDate}">
		</div>
		<div>
		<label>공급업체</label>
	<input type="text" name="company">
		</div>
		<div>
		<label>담당자</label>
	<input type="text" name="managerId">
		</div>
		<div>
		<button id="saveBtn" type="button" value="등록">등록</button>
		<button id="infos" type="button" value="조회">조회</button>
		</div>
 </form>

 
 <script>
 saveBtn.addEventListener("click", function(){
	 if(frm.productId.value == ''){
		 alert("상품명이 입력되지 않았습니다")
		 return;
	 }
	
	 frm.submit(); //값이 있으면 폼 제출 
	 alert("상품 등록이 완료되었습니다")
 })
 </script>
</body>

</html>