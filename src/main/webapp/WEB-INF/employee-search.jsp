<%--
  Created by IntelliJ IDEA.
  User: johndeleon
  Date: 2019-06-16
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Search</title>
    <%@include file="partials/head.jsp"%>
</head>
<body>
<%@include file="partials/navbar.jsp"%>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand">Search Employee by Name</a>
    <form class="form-inline">
        <input class="form-control mr-sm-5" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</nav>
<div>
    <%@ include file="/WEB-INF/partials/footer.jsp" %>
</div>
</body>
</html>
