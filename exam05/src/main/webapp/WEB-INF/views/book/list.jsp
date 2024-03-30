<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<style>
.bookimg {width:50px;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>도서대여관리</h1>
<table border="1">
<tr>
<th> 도서번호</th>
<th>도서명</th>
<th>표지</th>
<th>출판일자</th>
<th>금액</th>
<th>출판사</th>
<th>도서소개</th>
</tr>
<c:forEach items="${list}" var="book">
<tr>
<td>${book.bookNo}</td>
<td>${book.bookName}</td>
<td><img class="bookimg" src="${pageContext.request.contextPath}/resources/images/${book.bookCoverimg}"></td> 
<!-- http://localhost:8081/mb/ 이게 생략된 것.상대경로 ../ ${pageContext.request.contextPath}이거 지정해주면 자동으로 찾아옴 -->
<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy-MM-dd"/> </td>
<td><fmt:formatNumber value="${book.bookPrice}" type="currency" /> </td>
<td>${book.bookPublisher}</td>
<td>${book.bookInfo}</td>
</tr>
</c:forEach>
</table>
</html>