<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/WEB-INF/views/jsp_header.jsp"%>
 --%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="resources/css/img.css">
 -->
 </head>
<body>
	<div class="btns">
		<img class="imgReturn" src="resources/images/return.png" onClick="history.back()" style="width: 10%; height: 10%; float: right;" />
		<a href="http://192.168.0.24:8089/mobile/index.mo">
			<img class="imgHome" src="resources/images/home.png" style="width: 10%; height: 10%; float: right;" />
		</a>
	</div>
	
	<table border="1">
		<caption>전체 계좌 조회</caption>
		<c:forEach var="account" items="${accountList }">
			<tr>
				<th scope="row">계좌번호</th>
				<td>${account.accNum}</td>
			</tr>
			<tr>
				<th scope="row">이름</th>
				<td>${account.name}</td>
			</tr>
			<tr>
				<th scope="row">잔액</th>
				<td>${account.balance}</td>
			</tr>
			<tr>
				<td colspan="2">=====================================</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>

