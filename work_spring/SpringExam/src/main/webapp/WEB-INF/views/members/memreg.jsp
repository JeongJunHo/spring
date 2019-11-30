<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
	<c:if test="${not empty loginMem}">
	</c:if>
	<h1>회원 등록</h1>
	<form action="memreg" method="post">
		<table border="1">
			<tr>
				<td>num</td>
				<td><input type="text" id="num" name="num" required="required" /></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input type="password" id="pw" name="pw" required="required" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" id="name" name="name" /></td>
			</tr>
			<tr>
				<td>tel</td>
				<td><input type="text" id="tel" name="tel" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="reset" value="취소" />
					<input type="submit" value="등록" />
				</td>
			</tr>
		</table>
		<a href="memlist">리스트</a>
	</form>
</body>
</html>