<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<title>Insert title here</title>

<script>
$(function() {
	$("#btn-id").click(function(){
		var id = $("#id").val();
		$.get("/as/dup", {id:id}, function(data){  //{id:id} javascript 객체
			if(data == "dup"){
				message = "중복된 아이디";
			}else if(data == "nodup"){
				message = "사용 가능";
			}
			$("#result").text(message);
		});
	});
})
</script>
</head>
<body>

<div class="container">
	<input type="text" id="id" /> <button id="btn-id">중복</button>
	<p id="result"></p>
</div>

</body>
</html>