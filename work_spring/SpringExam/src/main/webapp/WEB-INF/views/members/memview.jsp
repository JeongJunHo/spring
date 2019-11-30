<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>

<script type="text/javascript">
	function deletemem(){
		var num = rform.num.value;
		location.href="memdelete?num=" + num;
	}
	function updatemem(){
		rform.action = "memupdate";
		rform.submit();
	}
</script>

</head>
<body>
	<h1>회원 정보</h1>
	<form action="#" id="rform">
		<table border="1">
			<tr>
				<td>num</td>
				<td><input type="text" id="num" name="num" value="${member.num}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input type="password" id="pw" name="pw" required="required" value="${member.pw}" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" id="name" name="name" value="${member.name}" /></td>
			</tr>
			<tr>
				<td>tel</td>
				<td><input type="text" id="tel" name="tel" value="${member.tel}" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="delete" value="삭제" onclick="deletemem()" />
					<input type="button" id="update" value="수정" onclick="updatemem()" />
				</td>
			</tr>
		</table>
		<a href="memlist">리스트</a>
	</form>
</body>
</html>