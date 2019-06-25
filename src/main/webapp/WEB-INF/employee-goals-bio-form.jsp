<%--
  Created by IntelliJ IDEA.
  User: mykalclinard
  Date: 2019-06-19
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/partials/head.jsp" %>

</head>
<body>
<%@ include file="/WEB-INF/partials/navbar.jsp" %>

<div class="container">
    <h1>Please fill in your information.</h1>
    <form action="/employee-info" method="post">
        <div class="form-group">
            <input type="text" hidden name="id" value="${emp.id}">
            <label for="goals">Career Goals</label>
            <%--            <input id="goals" name="goals" class="form-control" type="text" required--%>
            <%--                   value="${emp.goals}">--%>
            <div>
                <textarea name="goals" id="goals" cols="60" rows="5">${emp.goals}</textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="bio">Personal Bio</label>
            <%--            <input id="bio" name="bio" class="form-control" type="text" required value="${emp.bio}">--%>
            <div>
                <textarea name="bio" id="bio" cols="60" rows="5">${emp.bio}</textarea>
            </div>
        </div>
        <input type="text" name="update" value="true" hidden>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>
<script>
	<%@ include file="/WEB-INF/js/jobTitleChoice.js"%>
</script>
<%@include file="partials/leghand.jsp" %>
</body>
</html>

