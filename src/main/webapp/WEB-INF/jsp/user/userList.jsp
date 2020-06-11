<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<title><spring:message code="user.list.title" /></title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
	<!-- メイン -->
	<main>
		<div class="py-4">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<a class="btn btn-primary" href="/user/userInput" role="button"><spring:message code="common.button.input"/></a>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>