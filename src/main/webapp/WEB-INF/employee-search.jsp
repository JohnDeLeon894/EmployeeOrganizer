<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<nav class="navbar search-nav-style ">
    <a class="navbar-brand nav-li">Search Employee by Name</a>
    <form class="form-inline search-form">
        <input class="form-control mr-sm-5 search-bar-style" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 search-btn-style" type="submit">Search</button>

    </form>
</nav>
<div class="container">


</div>
<div>
    <%@ include file="/WEB-INF/partials/leghand.jsp" %>
</div>
<%--<script src="/js/main.js"></script>--%>
</body>
</html>
