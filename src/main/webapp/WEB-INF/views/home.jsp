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
	<title>Home</title>
</head>
<body>
<h1>
	Hello world! EX01
</h1>

<h1>
	post request
</h1>
<form action="/sample/basic" method="post">
	<input type="text" name="name"> <br>
	<input type="submit" />
</form>

<P>  The time on the server is ${serverTime}. </P>

<a id="my-link" href="#">
/sample/ex02Bean?list[0].name=aaa&list[1].name=bbb&list[2].name=ccc
</a>
<p id="test"></p>

<script>
	/*
	var url = document.getElementById("my-link").innerHTML;
	var encoded = encodeURI(url.trim());
	document.getElementById("my-link").href = encoded;
	document.getElementById("test").innerHTML = encoded;
	*/
	var url = $("#my-link").text();
	var encoded = encodeURI(url.trim());
	console.log(encoded);
	$("#my-link").attr("href", encoded);
	
</script>

</body>
</html>
