<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<title>RESTFUL EXAM</title>

<style type="text/css">
	#listBox ul li{
		cursor: pointer;
		text-decoration: underline;
	}
	
	#listBox ul li:hover{
		font-weight: bold;
	}
</style>

<script type="text/javascript">
	$(function(){
		listLoad();
		
		$(".searchListBtn").click(function(){
			listLoad();
		});
		
		$("#listBox").on('click','.searchOne' ,function(){
			var num = $(this).data("num");
			
			searchOne(num);
		});
		
		$(".insertBtn").click(function(){
			var JSONObject = {};
			JSONObject.num = $("#num").val();
			JSONObject.name = $("#name").val();
			JSONObject.price = $("#price").val();
			if(JSONObject.num != ""){
				insertFunc(JSONObject);	
			}else{
				alert("id를 입력해주세요.");
				$("#num").focus();
			}
		});
		
		$(".updateBtn").click(function(){
			var JSONObject = {};
			JSONObject.num = $("#num").val();
			JSONObject.name = $("#name").val();
			JSONObject.price = $("#price").val();
			
			if(JSONObject.num != ""){
				updateFunc(JSONObject);	
			}else{
				alert("id를 입력해주세요.");
				$("#num").focus();
			}
		});
		
		$(".deleteBtn").click(function(){
			var num = $("#num").val();
			
			if(num != ""){
				deleteFunc(num);	
			}else{
				alert("id를 입력해주세요.");
				$("#num").focus();
			}
		});
	});
	
	function listLoad(){
		$.ajax({
			url: '/api/productlist',
			type: 'GET',
			contentType: 'application/json; charset=utf-8',
			success: function(res){
				var inner = "<ul>";
				for(var i in res.resvalue){
					inner += "<li class='searchOne' data-num='"+ res.resvalue[i].num +"'>" + res.resvalue[i].name + "</li>";
				}
				inner += "</ul>";
				$("#listBox").html(inner);
				
				$("#statusBox").text(res.resmsg);
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert(jqXHR.status + '' + jqXHR.responseText);
			}
		});
	}
	
	function refresh(){
		$.ajax({
			type: 'GET',
			url: '/api/productlist',
			contentType: 'application/json; charset=utf-8',
			success: function(res){
				var inner = "<ul>";
				for(var i in res.resvalue){
					inner += "<li class='searchOne' data-num='"+ res.resvalue[i].num +"'>" + res.resvalue[i].name + "</li>";
				}
				inner += "</ul>";
				$("#listBox").html(inner);
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert(jqXHR.status + '' + jqXHR.responseText);
			}
		});
	}
	
	function searchOne(num){
		$.ajax({
			type: 'GET',
			url: '/api/productview/' + num,
			contentType: 'application/json; charset=utf-8',
			success: function(res){
				$("#num").val(res.resvalue.num);
				$("#name").val(res.resvalue.name);
				$("#price").val(res.resvalue.price);
				$("#statusBox").text(res.resmsg);
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert(jqXHR.status + '' + jqXHR.responseText);
			}
		});
	}
	
	function insertFunc(JSONObject){
		$.ajax({
			type: 'POST',
			url: '/api/productreg',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(JSONObject),
	        dataType: 'json',
			success: function(res){
				refresh();
				$("#num, #name, #price").val("");
				$("#statusBox").text(res.resmsg + " : " + res.resvalue);
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert(jqXHR.status + '' + jqXHR.responseText);
			}
		});
	}
	
	function updateFunc(JSONObject){
		$.ajax({
			type: 'PUT',
			url: '/api/productupdate',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(JSONObject),
	        dataType: 'json',
			success: function(res){
				refresh();
				$("#num, #name, #price").val("");
				$("#statusBox").text(res.resmsg + " : " + res.resvalue);
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert(jqXHR.status + '' + jqXHR.responseText);
			}
		});
	}
	
	function deleteFunc(num){
		$.ajax({
			type: 'DELETE',
			url: '/api/productdelete/' + num,
			contentType: 'application/json; charset=utf-8',
			success: function(res){
				refresh();
				$("#num, #name, #price").val("");
				$("#statusBox").text(res.resmsg + " : " + res.resvalue);
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert(jqXHR.status + '' + jqXHR.responseText);
			}
		});
	}
</script>
</head>
<body>
	<h1>Welcome To SSAFY</h1>
	<hr>
	
	<h3>상품 관리</h3>
	<button class="searchListBtn">목록조회</button> <span>(상세 내용을 조회하기 위해서 목록의 아이템을 클릭하세요.)</span>
	<div id="listBox"></div>
	<button class="insertBtn">추가</button> <button class="updateBtn">수정</button> <button class="deleteBtn">삭제</button>
	
	<table>
		<tr>
			<td>id</td>
			<td>
				<input id="num">
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input id="name">
			</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>
				<input id="price">
			</td>
		</tr>
	</table>
	<div id="statusBox">
		
	</div>
</body>
</html>