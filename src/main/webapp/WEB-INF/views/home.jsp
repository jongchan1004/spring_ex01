<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
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
</body>
</html>
