<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%-- <%@ include file="/WEB-INF/views/jsp_header.jsp"%>
 --%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<!-- 
링크로 css 적용하니까 적용이 잘 안됨.
<link rel="stylesheet" type="text/css" href="/WEB-INF/views/moviews/css/css/main.css"> -->
<style type="text/css">
	.title {
		font-size: 18pt;
		margin: auto;
		text-align: center;
	}
</style>
</head>
<body>
<div data-role="page" id="pageone">
  <div data-role="main" class="ui-content">
    <h2 class="title">렉토피아 은행</h2>
    <ul data-role="listview" data-inset="true">    
      <li><a href="makeAccount.mo">계좌 개설</a></li>
      <li data-icon="plus"><a href="deposit.mo">입금</a></li>
      <li data-icon="minus"><a href="withdraw.mo">출금</a></li>
      <li data-icon="search"><a href="searchAccount.mo">계좌 조회</a></li>
      <li data-icon="search"><a href="searchAllAccount.mo">전체 계좌 조회</a></li>
    </ul>
  </div>
</div> 

</body>
</html>