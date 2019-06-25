<%--
  Created by IntelliJ IDEA.
  User: mykalclinard
  Date: 2019-06-19
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/partials/head.jsp" %>

</head>
<body>
<%@ include file="/WEB-INF/partials/navbar.jsp" %>

<c:choose >
    <c:when test="${isadmin}">

<div class="container">
    <h2>Please fill in your information.</h2>
    <form action="/registeremployee" method="post">
        <div class="form-group">
            <label for="gender">What is your Gender?</label>
            <select class="custom-select my-1 mr-sm-2" id="gender" name="gender" required>
                <option selected>Choose...</option>
                <option value="M">Male</option>
                <option value="F">Female</option>
            </select>
        </div>
        <div class="form-group">
            <label for="first_name">First Name</label>
            <input id="first_name" name="first_name" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="last_name">Last Name</label>
            <input id="last_name" name="last_name" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="birth_date">Birthday</label>
            <input id="birth_date" name="birth_date" class="form-control" type="date" placeholder="YYYMMDD" required>
        </div>
        <div class="form-group">
            <label for="hire_date">Hire Date</label>
            <input id="hire_date" name="hire_date" class="form-control" type="date" placeholder="YYYMMDD" required>
        </div>
        <div class="form-group">
            <label for="salary">Salary</label>
            <input id="salary" name="salary" class="form-control" type="text" placeholder="Enter current salary" required>
        </div>
        <div class="form-group">
            <label for="bio">Bio</label>
            <textarea class="form-control" id="bio" name="bio" placeholder="Enter you're bio..."></textarea>
        </div>
        <div class="form-group">
            <label for="goals">Goals</label>
            <input id="goals" name="goals" class="form-control" type="text" placeholder="Enter you're goals..." required>
        </div>
        <div class="form-group">
            <label for="dept_id">Department ID</label>
            <select class="form-control my-1 mr-sm-2" id="dept_id" name="dept_id" onClick="getJobTitle()" required>
                <%--                This is dynamically made in the jobTitleChoice.js / DONT change "id"--%>

            </select>
        </div>
        <div class="form-group">
            <label for="job_id">Job Title</label>
            <select class="form-control my-1 mr-sm-2" id="job_id" name="job_id"  required>
                <%--                This is dynamically made in the jobTitleChoice.js / DONT change "id"--%>

            </select>
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>

    </c:when>
    <c:otherwise>
        <% response.sendRedirect("/employees-list"); %>
    </c:otherwise>

</c:choose>




<%@include file="partials/leghand.jsp" %>

<script>
    <%@include file="js/jobTitleChoice.js"%>
</script>
</body>
</html>
