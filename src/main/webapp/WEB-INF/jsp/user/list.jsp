<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<script src="../js/user/list.js" type="text/javascript"></script>
<title><spring:message code="user.list.title" /></title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb container">
			<li class="breadcrumb-item">
				<a href="/">
					<spring:message code="top.title" />
				</a>
			</li>
			<li class="breadcrumb-item active" aria-current="page">
				<spring:message code="user.list.title" />
			</li>
		</ol>
	</nav>
	<!-- メイン -->
	<main>

		<!-- 検索条件 -->
		<div class="py-4">
			<section id="searchS">
				<div class="container">
					<form:form action="/user/list" method="POST" modelAttribute="userListModel">
						<div class="form-group row">
							<label for="id" class="col-md-3 col-form-label">
								<spring:message code="user.input.id"/><span class="badge badge-warning">必須</span>
							 </label>
							 <div class="col-md-9">
							 	<form:input path="id" class="form-control form-control-sm" placeholder="Id" />
							 </div>
						</div>
						<button type="button" class="btn btn-primary" id="search"><spring:message code="common.button.search"/></button>
					<div class="row">
					<div class="col-12">
						<a class="btn btn-primary" href="/user/input" role="button"><spring:message code="common.button.input"/></a>
					</div>
					</div>
					</form:form>
				</div>
			</section>
		</div>

		<div class="py-4">
			<section id="list">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<table class="table table-hover table-sm">
								<thead class="thead-dark">
									<tr>
										 <th scope="col">#</th>
									     <th scope="col">id</th>
									     <th scope="col">favorite</th>
									     <th scope="col">hobby</th>
									     <th scope="col"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="obj" items="${userList.content}" varStatus="status">
										<tr>
											<td>${status.index+1}</td>
											<td>${obj.id}</td>
											<td>${obj.favorite}</td>
											<td>${obj.hobby}</td>
											<td class="d-flex justify-content-end">
											<div class="px-1"><button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modal01"><spring:message code="common.button.detail"/></button></div>
											<div class="px-1"><a class="btn btn-primary btn-sm" href="/user/input" role="button"><spring:message code="common.button.update"/></a></div>
											<div class="px-1"><a class="btn btn-primary btn-sm" href="/user/input" role="button"><spring:message code="common.button.delete"/></a></div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<c:if test="${userList.totalElements > 0}">
								<nav aria-label="ページ送りの実例">
								  <ul class="pagination justify-content-end">
									<li class="page-item ${userList.number + 1 == 1 ? 'disabled': ''} ">
								      <a class="page-link" href="/user/paging?page=1" aria-label="prev">
								       <span aria-hidden="true">&lt;&lt;</span>
								      </a>
									</li>
									<li class="page-item ${userList.number + 1 == 1 ? 'disabled': ''} ">
								      <a class="page-link" href="/user/paging?page=${userList.number}" aria-label="prev">
								       <span aria-hidden="true">&lt;</span>
								      </a>
									</li>
								  	<c:forEach var="pageNumber" items="${pageNumbers}" varStatus="status">
								  		<li class="page-item ${pageNumber == userList.number + 1 ? 'active': ''} "><a class="page-link " href="/user/paging?page=${pageNumber}">${pageNumber}</a></li>
								  	</c:forEach>
								  	<li class="page-item ${userList.number + 1 == userList.totalPages ? 'disabled': ''} ">
								      <a class="page-link" href="/user/paging?page=${userList.number + 2}" aria-label="next">
								       <span aria-hidden="true">&gt;</span>
								      </a>
									</li>
								  	<li class="page-item ${userList.number + 1 == userList.totalPages ? 'disabled': ''} ">
								      <a class="page-link" href="/user/paging?page=${userList.totalPages}" aria-label="next">
								       <span aria-hidden="true">&gt;&gt;</span>
								      </a>
									</li>
								  </ul>
								</nav>
							</c:if>
						</div>
					</div>
				</div>
				<div class="modal fade" id="modal01" tabindex="-1" role="dialog" aria-labelledby="modal01-label" aria-hidden="true">
			          <div class="modal-dialog modal-dialog-centered" role="document">
			            <div class="modal-content">
			              <div class="modal-header">
			                <h5 class="modal-title" id="modal01-label">くつろぎの空間</h5>
			                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			                  <span aria-hidden="true">&times;</span>
			                </button>
			              </div>
			              <div class="modal-body">
			                <p class="text-center">
			                  <img alt="#" src="/images/about02.jpg" class="img-fluid">
			                </p>
			                <p>店主がこだわった家具たちです。座り心地の良いソファと丁度良い高さのテーブル。くつろぎの空間を満喫してください。</p>
			              </div>
			              <div class="modal-footer">
			                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			                <button type="button" id="modal01-ok" class="btn btn-primary">送信</button>
			              </div>
			            </div>
			          </div>
			        </div>
			</section>
		</div>

	</main>
</body>
</html>