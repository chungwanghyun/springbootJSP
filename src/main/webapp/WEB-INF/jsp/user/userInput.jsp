<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<script src="../js/user/userInput.js" type="text/javascript"></script>
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
				<form:form action="/user/userInput" method="POST" modelAttribute="userInputModel" >
<%-- 						 	<spring:hasBindErrors name="userInputModel"> --%>
<%-- 							 	<c:forEach var="error" items="${errors.allErrors}" > --%>
<%-- 							 	<spring:message message="${error}"></spring:message> --%>
<%-- 							 	</c:forEach> --%>
<%-- 						 	</spring:hasBindErrors> --%>
					<div class="form-group row">
						<label for="id" class="col-md-3 col-form-label">
							<spring:message code="user.input.id"/><span class="badge badge-warning">必須</span>
						 </label>
						 <div class="col-md-9">
						 	<spring:bind path="id">
							 	<form:input path="id" class="form-control form-control-sm ${status.error ? 'is-invalid' : ''}" placeholder="Id" />
							 	<div class="invalid-feedback"><form:errors path="id"/></div>
						 	</spring:bind>
						 </div>
					</div>
					<div class="form-group row">
						<label for="password" class="col-md-3 col-form-label">
							<spring:message code="user.input.password"/><span class="badge badge-warning">必須</span>
						 </label>
						 <div class="col-md-9">
						 	<spring:bind path="password">
						 	<form:input path="password" class="form-control form-control-sm ${status.error ? 'is-invalid' : ''}" placeholder="Password"/>
						 	<div class="invalid-feedback"><form:errors path="password"/></div>
						 	</spring:bind>
						 </div>
					</div>
					<div class="form-group row">
						<label for="favorite" class="col-md-3 col-form-label">
							<spring:message code="user.input.favorite"/>
						 </label>
						 <div class="col-md-9">
						 	<form:select class="form-control form-control-sm" path="favorite" items="${favoriteList}"/>

<%-- 						 	<form:select path="book"> --%>
<%-- 							    <form:option value=null label="--Please Select--"/> --%>
<%-- 							    <form:options items="${hobbySelectMap}"/> --%>
<%-- 							</form:select> --%>
						 </div>
					</div>
					<div class="form-group row">
						<label for="hobby" class="col-md-3 col-form-label">
							<spring:message code="user.input.hobby"/>
						</label>
						<div class="col-md-9">
						<c:forEach var="obj" items="${hobbyList}" varStatus="status">
							<div class="form-check form-check-inline">
								<form:checkbox path="hobby" class="form-check-input" value="${obj.key}"/>
								<label for="hobby${status.index+1}" class="form-check-label" >${obj.value}</label>
							</div>
						</c:forEach>
<%-- 							<form:checkboxes items="${hobbyList}" path="hobby" class=""/> --%>
<%-- 							Bird watching: <form:checkbox path="hobby" value="1"/> --%>
<%-- 							Astronomy: <form:checkbox path="hobby" value="2"/> --%>
<%-- 							Snowboarding: <form:checkbox path="hobby" value="3"/> --%>
						</div>
					</div>
					<div class="form-group row">
						<label for="gender" class="col-md-3 col-form-label">
							<spring:message code="user.input.gender"/>
						</label>
						<div class="col-md-9">
<%-- 							<form:radiobuttons items="${genderList}" path="gender" class="" /> --%>
							<c:forEach var="obj" items="${genderList}" varStatus="status">
							<div class="form-check form-check-inline">
								<form:radiobutton path="gender" class="form-check-input" value="${obj.key}"/>
								<label for="gender${status.index+1}" class="form-check-label">${obj.value}</label>
							</div>
						</c:forEach>
						</div>
					</div>

					<div class="form-group row">
						<label for="memo" class="col-md-3 col-form-label">
							<spring:message code="user.input.memo"/>
						</label>
						<div class="col-md-9">
							<form:textarea path="memo" class="form-control" rows="3"/>
						</div>
					</div>

					<div class="form-group row">
						<label for="file" class="col-md-3 col-form-label">
							<spring:message code="user.input.file"/>
						</label>
						<div class="col-md-9">
							<div class="input-group">
								<div class="custom-file">
							      <input type="file" class="custom-file-input" id="customFile">
							      <label class="custom-file-label" for="customFile" data-browse="参照">Choose file</label>
							    </div>
								<div class="input-group-append">
							        <button type="button" class="btn btn-outline-secondary reset">取消</button>
							    </div>
							</div>
						</div>
					</div>
					<div class="form-group row justify-content-end">
						 <div class="col-md-9">
						 <form:button  class="btn btn-primary" type="submit"><spring:message code="common.button.back"/> </form:button>
						 <form:button  class="btn btn-primary" type="submit"><spring:message code="common.button.input"/> </form:button>
						 </div>
					</div>
				</form:form>
			</div>
		</div>

	</main>

</body>
</html>