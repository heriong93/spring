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
<jsp:include page="/WEB-INF/views/shop/header.jsp"></jsp:include>
<h1>쇼핑몰 관리</h1>
<table border="1">
<tr>
<th> 상품ID</th>
<th>이름</th>
<th>단가</th>
<th>담당자</th>
<th>등록일자</th>
<th>공급업체</th>
</tr>
<c:forEach items="${list}" var="product">
<tr>
<td>${product.productId}</td>
<td>${product.productName}</td>
<td><fmt:formatNumber value="${product.productPrice}" type="currency" /> </td>
<td>${product.managerId}</td>
<td><fmt:formatDate value="${product.productDate}" pattern="yyyy-MM-dd"/> </td>
<td>${product.company}</td>
</tr>
</c:forEach>
</table>
</html>