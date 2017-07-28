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
	<div id="accInfo">
		<form:form modelAttribute="account" action="accInfoAction.bk" method="post">
			<table>
				<caption>계좌조회</caption>
				<tr>
					<th scope="row">계좌번호</th>
					<td><form:input path="accNum" type="text" name="accNum" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right;"><input
						type="submit" value="조회" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>