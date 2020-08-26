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
<script>
$(function(){
	$("#btn-b").click(function() {
		$("#result-b").load("/res/b"); // /res/b로 요청시의 응답을 load. 페이지 전체가 로딩된 것은 아니고 일부만 바뀜
	})
	
	$("#btn-c").click(function() {
		$("#result-c").load("/res/c");
	})
	
	$("#btn-d").click(function() {
		$("#result-d").load("/res/d");
	})
	
	$("#btn-e").click(function() {
		$("#result-e").load("/res/e");
	})
	
	$("#btn-g").click(function() {
		$("#result-g").load("/res/g"); //$(selector).load(URL,data,callback);
										//JSON이 표시됨
	})
	
	$("#btn-g2").click(function() { //$=jQuery함수, 함수자체도 객체
		$.get("/res/g", function(data){ //identifier()는 함수 호출??, identifier그대로 사용하면 객체 자체 11:33
			console.log(data); // javascript 객체가 찍힘??
			//console.log(data.name);
			//console.log(data.age);
			$("#result-g2-name").text(data.name);
			$("#result-g2-age").text(data.age);
		}); 
	})
	
	$("#btn-g-json").click(function(){
		$.get("/res/g", function(data) {
			console.log(data); //json을 javascript로 변환??
		});
	});
	
	$("#btn-d-text").click(function(){
		$.get("/res/d", function(data) {
			console.log(data); //text
			var obj = JSON.parse(data); //javascript객체로 변환??
			console.log(obj);
		});
	});
	
	$("#btn-h").click(function(){
		$.get("/res/h", function(data) {
			//console.log(data);
			data.forEach(function(d){
				//console.log(d);
				$("#result-h").append(d.name+", "+d.age + "<br>");
			});
		});
	});
	
	$("#btn-i").click(function(){
		$.get("/res/i", "name=myname");
	});
	
	$("#btn-j").click(function(){
		$.get("/res/j", "name=myname");
	});
	
	$("#btn-jj").click(function(){
		$.get("/res/jj", "name=myname&age=22"); //여러개 query string
	});
	
	$("#btn-k").click(function(){
		var o = {name:"myname", age:22}; //javascript 객체
		$.get("/res/k", o); //객체 보냄
	});
	
	$("#btn-l").click(function(){
		$.get("/res/l", "id=3", function(data){ //id=3을 보내 db에서 멤버를 찾아 return
			$("#result-l").append(data.name + ", " + data.age);
		});
	});
})
</script>
<title>Insert title here</title>
</head>
<body>

<h1>a.jsp</h1>

<button id="btn-b">load b</button>
<h2 id="result-b"></h2>

<button id="btn-c">load c</button>
<ol id="result-c"></ol>

<!-- button#btn-d+p#result-d -->
<button id="btn-d">load d</button>
<p id="result-d"></p>

<!-- button#btn-e{load e}+p#result-e -->
<button id="btn-e">load e</button>
<p id="result-e"></p>

<button id="btn-g">load g</button>
<p id="result-g"></p>

<button id="btn-g2">get g2</button>
<div id="result-g2-name"></div>
<div id="result-g2-age"></div>

<button id="btn-g-json">get g json </button>
<button id="btn-d-text">get d text </button>

<br />

<button id="btn-h">get h</button>
<div id="result-h"></div>

<button id="btn-i">get i with data</button>
<div id="result-i"></div>

<button id="btn-j">get j with data</button>
<div id="result-j"></div>

<button id="btn-jj">get jj with data</button>
<div id="result-jj"></div>

<button id="btn-k">get k with data</button>
<div id="result-k"></div>

<button id="btn-l">get l with data</button>
<div id="result-l"></div>
</body>
</html>