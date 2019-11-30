<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../commons/logincheck.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 정보</title>

<script type="text/javascript">
	function deleteproduct(){
		var num = rform.num.value;
		location.href="productdelete?num=" + num;
	}
	function updateproduct(){
		rform.action = "productupdate";
		rform.submit();
	}
</script>

</head>
<body>
	<jsp:include page="../commons/menu.jsp"/>
	<h1>제품 정보</h1>
	<form action="#" id="rform">
		<table border="1">
			<tr>
				<td>num</td>
				<td><input type="text" id="num" name="num" value="${product.num}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" id="name" name="name" value="${product.name}" /></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="number" id="price" name="price" value="${product.price}" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="delete" value="삭제" onclick="deleteproduct()" />
					<input type="button" id="update" value="수정" onclick="updateproduct()" />
				</td>
			</tr>
		</table>
		<a href="productlist">리스트</a>
	</form>
</body>
</html>