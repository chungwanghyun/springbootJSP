<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<title><spring:message code="user.input.title" /></title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	<!-- メイン -->
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb container">
			<li class="breadcrumb-item">
				<a href="/">
					<spring:message code="top.title" />
				</a>
			</li>
			<li class="breadcrumb-item">
				<a href="/user/list">
					<spring:message code="user.list.title" />
				</a>
			</li>
			<li class="breadcrumb-item active" aria-current="page">
				<spring:message code="user.input.title" />
			</li>
		</ol>
	</nav>
	<main>
		<div class="container">
			<h3><spring:message code="user.input.title" /></h3>
			<p>ユーザーを登録してください。</p>
		</div>
		<div class="py-3">
			<div class="container">
				<h3><spring:message code="user.input.info" /></h3>
				<form:form action="/user/input" method="POST" modelAttribute="userInputModel">
					    <!-- (1) -->
					<div class="form-group row">
						<label for="id" class="col-md-3 col-form-label">
							<spring:message code="user.input.id"/><span class="badge badge-warning">必須</span>
						 </label>
						 <div class="col-md-9">
						 	<form:input path="id" class="form-control  form-control-sm" id="id" placeholder="Id" />
						 	<form:errors path="id"/>
						 </div>
					</div>
					<div class="form-group row">
						<label for="id" class="col-md-3 col-form-label">
							<spring:message code="user.input.password"/><span class="badge badge-warning">必須</span>
						 </label>
						 <div class="col-md-9">
						 	<form:input path="password" class="form-control form-control-sm" placeholder="Password"/>
						 	<form:errors path="password" />
						 </div>
					</div>
					<div class="form-group row justify-content-end">
						 <div class="col-md-9">
						 <form:button  class="btn btn-primary" type="submit"><spring:message code="common.button.input"/> </form:button>
						 <form:button  class="btn btn-primary" type="submit"><spring:message code="common.button.input"/> </form:button>
<%-- 						 	<button class="btn btn-primary" type="submit"><spring:message code="common.button.back"/></button> --%>
<%-- 							<button class="btn btn-primary" type="submit"><spring:message code="common.button.input"/></button> --%>
<%-- 						 	<button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="common.button.back"/></button> --%>
						 </div>
					</div>
				</form:form>
			</div>
		</div>

	</main>

</body>
</html>