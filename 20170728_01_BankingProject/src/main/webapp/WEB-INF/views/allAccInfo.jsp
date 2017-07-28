<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp_header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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

