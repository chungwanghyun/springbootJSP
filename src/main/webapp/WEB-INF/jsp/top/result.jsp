<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <a class="navbar-brand" href="#">SpringBoot + Bootstrap4</a>
        </nav>
    </header>

    <div style="margin-left: 100px; margin-right: 100px; margin-top: 100px;">
        <p>Email : ${id}</p>
        <p>Password : ${password}</p>
    </div>
</body>
</html>
