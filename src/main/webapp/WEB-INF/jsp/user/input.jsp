<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<script src="../js/user/input.js" type="text/javascript"></script>
<title><spring:message code="user.input.title" /></title>
</head>
<body>
	<!-- ヘッダー -->
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<%-- 	<jsp:include page="/WEB-INF/jsp/common/header.jsp"  flush="false" /> --%>

	<nav aria-label="breadcrumb">
		<ol class="breadcrumb container">
			<li class="breadcrumb-item">
				<a href="/">
					<spring:message code="top.title" /><spring:message code="top.title" />
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
	<!-- メイン -->
	<main>
		<div class="container">
			<h3><spring:message code="user.input.title" /></h3>
			<p>ユーザーを登録してください。</p>
			<p>ユーザーを登録してください。</p>
			<p>ユーザーを登録してください。</p>
			<p>ユーザーを登録してください。</p>
		</div>
		<div class="py-3">
			<div class="container">
				<h3><spring:message code="user.input.info" /></h3>
				<form:form action="/user/input" method="POST" modelAttribute="userInputModel"  enctype="multipart/form-data">
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
							 	<form:input path="id" class="form-control form-control-sm  ${firstCheck ? '' : status.error ? 'is-invalid' : 'is-valid' }" placeholder="Id" />
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
							 	<form:input path="password" class="form-control form-control-sm ${firstCheck ? '' : status.error ? 'is-invalid' : 'is-valid' }" placeholder="Password"/>
							 	<div class="invalid-feedback"><form:errors path="password"/></div>
						 	</spring:bind>
						 </div>
					</div>
					<div class="form-group row">
						<label for="money" class="col-md-3 col-form-label">
							<spring:message code="user.input.money"/><span class="badge badge-warning">必須</span>
						 </label>
						 <div class="col-md-9">
						 	<spring:bind path="money">
							 	<form:input path="money" class="form-control form-control-sm ${firstCheck ? '' : status.error ? 'is-invalid' : 'is-valid' }" placeholder="Money"/>
							 	<div class="invalid-feedback"><form:errors path="money"/></div>
						 	</spring:bind>
						 </div>
					</div>
					<div class="form-group row">
						<label for="favorite" class="col-md-3 col-form-label">
							<spring:message code="user.input.favorite"/><span class="badge badge-warning">必須</span>
						 </label>
						 <div class="col-md-9">
						 <spring:bind path="favorite">
						 	<form:select class="form-control form-control-sm ${firstCheck ? '' : status.error ? 'is-invalid' : 'is-valid' }" path="favorite" items="${favoriteList}"/>

<%-- 						 	<form:select path="book"> --%>
<%-- 							    <form:option value=null label="--Please Select--"/> --%>
<%-- 							    <form:options items="${hobbySelectMap}"/> --%>
<%-- 							</form:select> --%>
							<div class="invalid-feedback"><form:errors path="favorite"/></div>
							</spring:bind>
						 </div>
					</div>
					<div class="form-group row">
						<label for="hobby" class="col-md-3 col-form-label">
							<spring:message code="user.input.hobby"/><span class="badge badge-warning">必須</span>
						</label>
						<div class="col-md-9">
						<c:forEach var="obj" items="${hobbyList}" varStatus="status">
							<div class=" form-check form-check-inline">
								<form:checkbox path="hobby" class="form-check-input" value="${obj.key}"/>
								<label for="hobby${status.index+1}" class="form-check-label" >${obj.value}</label>
							</div>
						</c:forEach>
						<spring:bind path="hobby">
							<div style="display:none;" class="form-control form-control-sm  ${firstCheck ? '' : status.error ? 'is-invalid' : 'is-valid' }"></div>
							<div class="invalid-feedback"><form:errors path="hobby"/></div>
						</spring:bind>
<%-- 							<form:checkboxes items="${hobbyList}" path="hobby" class=""/> --%>
<%-- 							Bird watching: <form:checkbox path="hobby" value="1"/> --%>
<%-- 							Astronomy: <form:checkbox path="hobby" value="2"/> --%>
<%-- 							Snowboarding: <form:checkbox path="hobby" value="3"/> --%>
						</div>
					</div>
					<div class="form-group row">
						<label for="gender" class="col-md-3 col-form-label">
							<spring:message code="user.input.gender"/><span class="badge badge-warning">必須</span>
						</label>
						<div class="col-md-9">
<%-- 							<form:radiobuttons items="${genderList}" path="gender" class="" /> --%>
							<c:forEach var="obj" items="${genderList}" varStatus="status">
							<div class="form-check form-check-inline">
								<form:radiobutton path="gender" class="form-check-input" value="${obj.key}"/>
								<label for="gender${status.index+1}" class="form-check-label">${obj.value}</label>
							</div>
						</c:forEach>
						<spring:bind path="gender">
							<div style="display:none;" class="form-control form-control-sm  ${firstCheck ? '' : status.error ? 'is-invalid' : 'is-valid' }"></div>
							<div class="invalid-feedback"><form:errors path="gender"/></div>
						</spring:bind>
						</div>
					</div>

					<div class="form-group row">
						<label for="birthday" class="col-md-3 col-form-label">
							<spring:message code="user.input.birthday"/><span class="badge badge-warning">必須</span>
						</label>
				        <div class="col-md-9">
			                <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
				                <spring:bind path="birthday">
				                    <form:input path="birthday" class="form-control form-control-sm datetimepicker-input ${firstCheck ? '' : status.error ? 'is-invalid' : 'is-valid' }" data-toggle="datetimepicker" data-target="#datetimepicker1"/>
				                    <div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
				                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
				                    </div>
				                    <div class="invalid-feedback"><form:errors path="birthday"/></div>
			                     </spring:bind>
			                </div>
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
							<spring:message code="user.input.file"/><span class="badge badge-warning">必須</span>
						</label>
						<div class="col-md-9">
							<div class="input-group">
<!-- 								<div class="custom-file"> -->
								<spring:bind path="userFile1">
									<input type="file" class="custom-file-input  form-control-sm ${firstCheck ? '' : status.error ? 'is-invalid' : 'is-valid' }" name="userFile1" id="userFile1">
									<label class="custom-file-label" for="userFile1" data-browse="<spring:message code="common.button.browse"/>" data-message="<spring:message code='common.file.message'/>">
										<spring:message code="common.file.message"/>
									</label>
									<div class="invalid-feedback"><form:errors path="userFile1"/></div>
							    </spring:bind>
							    <form:hidden name="userFileTemp1" path="userFileTemp1" id="userFileTemp1" />
<!-- 							    </div> -->
<!-- 								<div class="input-group-append"> -->
<%-- 							        <button type="button" class="btn btn-outline-secondary reset"><spring:message code="common.button.cancle"/></button> --%>
<!-- 							    </div> -->
<%-- 							    <div class="invalid-feedback"><form:errors path="userFile1"/></div> --%>
							</div>

						</div>
					</div>
					<div class="form-group row">
						<label for="file" class="col-md-3 col-form-label">
							<spring:message code="user.input.file"/><span class="badge badge-warning">必須</span>
						</label>
						<div class="col-md-9">
							<div class="input-group">
<!-- 								<div class="custom-file"> -->
								<spring:bind path="userFile2">
							      <input type="file" class="custom-file-input  form-control-sm ${firstCheck ? '' : status.error ? 'is-invalid' : 'is-valid' }"  name="userFile2" id="userFile2">
									<label class="custom-file-label" for="userFile2" data-browse="<spring:message code='common.button.browse'/>" data-message="<spring:message code='common.file.message'/>">
										<spring:message code="common.file.message"/>
							      	</label>
							      	<div class="invalid-feedback"><form:errors path="userFile2"/></div>
								</spring:bind>
								<form:hidden name="userFileTemp2" path="userFileTemp2" id="userFileTemp2" />
<!-- 							    </div> -->
<!-- 								<div class="input-group-append"> -->
<%-- 							        <button type="button" class="btn btn-outline-secondary reset"><spring:message code="common.button.cancle"/></button> --%>
<!-- 							    </div> -->
							</div>
<%-- 							<form:errors class="invalid-feedback" path="userFile2"/> --%>
						</div>
					</div>

					<div class="form-group row justify-content-end">
						 <div class="col-md-9">
						 <button type="button" class="btn btn-primary" onClick="history.back();"><spring:message code="common.button.back"/></button>
						 <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal01"><spring:message code="common.button.input"/></button>
 <%-- 						 <form:button  class="btn btn-primary" type="submit"><spring:message code="common.button.back"/> </form:button> --%>
<%-- 						 <form:button  class="btn btn-primary" data-toggle="modal" data-target="#modal01"><spring:message code="common.button.input"/> </form:button> --%>
						 </div>
					</div>
					 <!-- モーダル01 -->
			        <div class="modal fade" id="modal01" tabindex="-1" role="dialog" aria-labelledby="modal01-label" aria-hidden="true">
			          <div class="modal-dialog " role="document">
			            <div class="modal-content">
			              <div class="modal-header">
			                <h5 class="modal-title" id="modal01-label">登録</h5>
			                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			                  <span aria-hidden="true">&times;</span>
			                </button>
			              </div>
			              <div class="modal-body">
			                <p>よろしいでしょうか？</p>
			              </div>
			              <div class="modal-footer">
			                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			                <button type="button" id="modal01-ok" class="btn btn-primary">送信</button>
			              </div>
			            </div>
			          </div>
			        </div>
				</form:form>
			</div>
		</div>

	</main>
	<!-- フッター -->
	<%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>