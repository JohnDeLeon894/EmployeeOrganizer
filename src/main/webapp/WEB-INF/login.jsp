<%--
  Created by IntelliJ IDEA.
  User: mykalclinard
  Date: 2019-06-20
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="login-style">

    <h2>Please Log In</h2>

    <form action="/login" method="POST">
        <div class="form-group">
            <label for="username" class="login-label login-input">Username</label>
            <input id="username" name="username" class="form-control login-input" type="text">
        </div>
        <div class="form-group">
            <label for="password" class="login-label">Password</label>
            <input id="password" name="password" class="form-control login-input" type="password">
        </div>
        <input type="submit" class="btn login-btn-style" value="Log In">
        <div class="form-group">
        <a href="/registeruser">Not Registered Yet?</a>
        </div>
    </form>
</div>

<%@include file="partials/leghand.jsp" %>

</body>
</html>
