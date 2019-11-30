<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
	<h1>회원 리스트</h1>
	<table border="1">
		<tr>
			<th>num</th>
			<th>pw</th>
			<th>name</th>
			<th>tel</th>
		</tr>
		
		<c:forEach items="${list}" var="mem">
			<tr>
				<td>
					<a href="memview?num=${mem.num}">${mem.num }</a>
				</td>
				<td>${mem.pw }</td>
				<td>${mem.name }</td>
				<td>${mem.tel }</td>
			</tr>
		</c:forEach>
		<c:if test="${list.size() == 0}">
			<tr>
				<td colspan="4">회원정보가 없습니다.</td>
			</tr>
		</c:if>
	</table>
	<a href="memreg">회원등록</a>
</body>
</html>