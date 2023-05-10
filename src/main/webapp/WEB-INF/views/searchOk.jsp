<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색 결과</title>
</head>
<body>
	<h2>회원 이름 검색 결과</h2>
	<hr>
	<c:forEach items = "${memberDtos }" var="memberDto">
		학번 : ${memberDto.hakbun }<br>
		이름 : ${memberDto.name }<br>
		나이 : ${memberDto.age }<br>
		학년 : ${memberDto.grade }<br>
		기타 : ${memberDto.etc }<br>
		<hr>
	</c:forEach>
</body>
</html>