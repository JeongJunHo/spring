<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../commons/logincheck.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 리스트</title>
</head>
<body>
	<jsp:include page="../commons/menu.jsp"/>
	<h1>제품 리스트</h1>
	<table border="1">
		<tr>
			<th>num</th>
			<th>name</th>
			<th>tel</th>
		</tr>
		
		<c:forEach items="${products}" var="product">
			<tr>
				<td>
					<a href="productview?num=${product.num}">${product.num }</a>
				</td>
				<td>${product.name }</td>
				<td>${product.price }</td>
			</tr>
		</c:forEach>
		<c:if test="${products.size() == 0}">
			<tr>
				<td colspan="4">제품정보가 없습니다.</td>
			</tr>
		</c:if>
	</table>
	<a href="productregpage">제품등록</a>
</body>
</html>