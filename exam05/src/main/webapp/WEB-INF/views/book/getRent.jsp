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
<th>대여총계</th>
<th>대여횟수</th>
</tr>
<c:forEach items="${rentlist}" var="rent">
<tr>
<td>${rent.bookNo}</td>
<td>${rent.bookName}</td>
<td>${rent.total}</td>
<td>${rent.cnt}</td>
</tr>
</c:forEach>
</table>
</html>