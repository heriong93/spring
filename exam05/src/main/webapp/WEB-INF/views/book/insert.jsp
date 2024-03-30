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
	<h3>도서 등록</h3>
		<form method="post" name="frm" action="insertBook"> <!--  name= vo필드명과 동일하게 -->
		<div class="form ">
		<label>도서번호</label>
		<input type="text" name="bookNo" value="${bookNo}">
		</div>
		<div>
		<label>도서명</label>
		<input type="text" name="bookName">
		</div>
		<div>
		<label>도서표지</label>
		<input type="text" name="bookCoverimg">
		</div>
		<div>
		<label>출판일자</label>
		<input type="date" name="bookDate">
		</div>
		<div>
		<label>금액</label>
		<input type="number" name="bookPrice">
		</div>
		<div>
		<label>출판사</label>
	<input type="text" name="bookPublisher">
		</div>
		<div>
		<label>도서 소개</label>
	<input type="text" name="bookInfo">
		</div>
		<div>
		<button id="infos" type="button" value="조회">조회</button>
		<button id="saveBtn" type="button" value="등록">등록</button>
		</div>
 </form>
 
 <script>
 saveBtn.addEventListener("click", function(){
	 if(frm.bookName.value == ''){
		 alert("도서명이 입력되지 않았습니다")
		 return;
	 }
	 if(frm.bookPublisher.value == ''){
		 alert("출판사가 입력되지 않았습니다")
		 return;
	 }
	 alert("도서 등록이 완료되었습니다")
	 frm.submit(); //값이 있으면 폼 제출 
 })
 </script>
</body>

</html>