<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="logincheck" method="post">
		<table border="1">
			<tr>
				<td>사번</td>
				<td>
					<input name="num">
				</td>
			</tr>
			<tr>
				<td>PW</td>
				<td>
					<input name="pw">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">로그인</button>
					<a href="memregpage">회원가입</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>