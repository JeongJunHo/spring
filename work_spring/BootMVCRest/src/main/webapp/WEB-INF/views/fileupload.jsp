<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/fileupload" id="fileupload" name="fileupload" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
		이름 : <input type="text" name="name" id="name"><br>
		파일 : <input type="file" name="file"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>