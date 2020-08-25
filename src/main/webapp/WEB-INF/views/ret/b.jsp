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
</head>
<body>

	<div>
		/g: <br />
		<ol>
			<c:forEach items="${cities }" var="city">
				<li>${city }</li>
			</c:forEach>
		</ol>
	</div>
	
	<div>
		<p>/h</p>
			<table class="table">
				<tr>
					<th>name</th>
					<th>age</th>
				</tr>
				<c:forEach items="${memberList }" var="member">
					<tr>
						<td>${member.name }</td>
						<td>${member.age }</td>
					</tr>
				</c:forEach>
			</table>
	</div>

</body>
</html>