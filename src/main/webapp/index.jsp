<%--
  Created by IntelliJ IDEA.
  User: johndeleon
  Date: 2019-06-12
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Employee Lister</title>
    <%@include file="WEB-INF/partials/head.jsp"%>
</head>
<body>
<%@ include file="WEB-INF/partials/navbar.jsp" %>

    <div class="landing-style">
        <h1>
           Welcome to Employee Lister!
        </h1>
        <p>
            Employee Lister is your one-stop shop for employees. Login as an employee or as a
            manager and look up your team members!
        </p>
    </div>
    <div id="landing-img">
        <img src="/img/image%20(1).png" class="card-img-top" alt="employees">
    </div>

<%@ include file="WEB-INF/partials/leghand.jsp" %>

<%--changed something--%>
</body>
</html>