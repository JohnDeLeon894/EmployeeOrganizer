<%--
  Created by IntelliJ IDEA.
  User: johndeleon
  Date: 2019-06-20
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="partials/head.jsp" %>
</head>
<body>
<%@include file="partials/navbar.jsp" %>

<div class="container" id="empcontainer">
    <%--    <div class="row">--%>
    <div class="col-4 float-left">
        <div class="card ">
            <img src="https://robohash.org/${emp.first_name}?set=set4" alt="${emp.first_name}">
            <div class="card-body">
                <h1>${emp.first_name} ${emp.last_name}</h1>
                <p>Employee No.: ${emp.id}</p>
            </div>
        </div>
    </div>
</div>
<div class="col-6 float-left">
    <div class="card ">
        <div class="card-body">

            <nav>
                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab"
                       href="#nav-info" role="tab" aria-controls="nav-info"
                       aria-selected="true">Employee Info
                    </a>
                    <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
                       href="#nav-bio" role="tab" aria-controls="nav-bio" aria-selected="false">
                        Personal Info</a>
                    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab"
                       href="#nav-contact" role="tab" aria-controls="nav-contact"
                       aria-selected="false">Team Members
                    </a>
                </div>
            </nav>
            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active" id="nav-info" role="tabpanel"
                     aria-labelledby="nav-home-tab">
                    <div class="card">
                        <div class="card-body">
                            <h3>Hire date:</h3> ${emp.hire_date}
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h3>Title:</h3> ${emp.job_title}
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h3>Department:</h3> <p>${emp.dept_name}</p>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h3>Manager:</h3> ${emp.manager}
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h3>Email:</h3> ${emp.email}
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="nav-bio" role="tabpanel"
                     aria-labelledby="nav-profile-tab">
                    <h3>Career Goal: ${emp.goals}</h3>
                    <h3>Bio: ${emp.bio}</h3>
                </div>
                <div class="tab-pane fade" id="nav-contact" role="tabpanel"
                     aria-labelledby="nav-contact-tab">TODO: list team members
                </div>
            </div>


        </div>
    </div>
</div>
<%--</div>--%>


<%@include file="partials/footer.jsp" %>
</body>
</html>
