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
<!-- <link rel="stylesheet" href="resources/css/img.css">
 --><title>Insert title here</title>
</head>
<body>
	<div class="btns">
		<img class="imgReturn" src="resources/images/return.png" onClick="history.back()" style="width: 10%; height: 10%; float: right;" />
		<a href="http://192.168.0.24:8089/mobile/index.mo">
			<img class="imgHome" src="resources/images/home.png" style="width: 10%; height: 10%; float: right;" />
		</a>
	</div>
	
	<div id="withdraw">
		<form:form modelAttribute="account" action="withdrawAction.mo" method="post">
			<table border="1">
				<caption>출금</caption>
				<tr>
					<th scope="row">계좌번호</th>
					<td><form:input path="accNum" type="text" name="accNum" /></td>
				</tr>
				<tr>
					<th scope="row">출금액</th>
					<td><form:input path="balance" type="text" name="balance" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right;"><input
						type="submit" value="출금" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>