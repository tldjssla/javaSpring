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
	<div id="deposit">
		<form:form modelAttribute="account" action="depositAction.bk" method="post">
			<table border="1">
				<caption>입금</caption>
				<tr>
					<th scope="row">계좌번호</th>
					<td><form:input path="accNum" type="text" name="accNum" /></td>
				</tr>
				<tr>
					<th scope="row">입금액</th>
					<td><form:input path="balance" type="text" name="balance" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right;"><input
						type="submit" value="입금" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>