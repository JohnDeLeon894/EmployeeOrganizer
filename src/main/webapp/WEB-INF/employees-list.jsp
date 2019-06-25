<%--
  Created by IntelliJ IDEA.
  User: johndeleon
  Date: 2019-06-14
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees</title>
    <%@ include file="/WEB-INF/partials/head.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/partials/navbar.jsp" %>
<script type="text/javascript">

</script>
<div class="container">
    <h1>Employees List</h1>

    <%--    <form action="/employees-list" method="post">--%>
    <%--        <div class="float-left clear-fix col-12">--%>
    <%--            <div class="col-3 float-left m-3 ">--%>
    <%--                <label for="perpage">Show how many per page?</label>--%>
    <%--                <select id="perpage" class="form-control form-control-sm " name="perpage"--%>
    <%--                        onchange="options[selectedIndex].value&&self.location.reload(true)">--%>

    <%--                    <option value="6">6</option>--%>
    <%--                    <option value="12" >12</option>--%>
    <%--                    <option value="18">18</option>--%>
    <%--                    <option value="24">24</option>--%>
    <%--                    <option value="30">30</option>--%>
    <%--                </select>--%>
    <%--            </div>--%>

    <%--            &lt;%&ndash; buttons to move page forard or backward.&ndash;%&gt;--%>
    <%--            <div class="col-6 float-right m-3 form-row">--%>

    <%--                <button class=" btn btn-light float-right" type="submit" name="pagenum"--%>
    <%--                        value="${pagenum} -1">Previous--%>
    <%--                    Page</button>--%>
    <%--                <button class=" btn btn-light float-right" name="pagenum" value=${pagenum}>--%>
    <%--                    Page Number <span class="badge badge-light">${pagenum}</span>--%>
    <%--                </button>--%>
    <%--                <button class=" btn btn-light float-right" type="submit" name="pagenum"--%>
    <%--                       value="${pagenum} +1" >Next Page--%>
    <%--                </button>--%>
    <%--            </div>--%>
    <%--        </div>--%>

    <%--    </form>--%>

    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand">Employee Search</a>
        <form class="form-inline" method="post">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="name" value="name" name="stype"
                       checked="checked">
                <label class="form-check-label" for="name">Name</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="id" value="id" name="stype">
                <label class="form-check-label" for="id">ID</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="dept" value="dept" name="stype">
                <label class="form-check-label" for="dept">Department</label>
            </div>
            <input class="form-control mr-sm-5"
                   type="search"
                   placeholder="Search"
                   name="search"
                   id="search"
                   aria-label="Search">

            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>

    <div class="col-12">
        <c:forEach var="emp" items="${emp}">

            <div class="card float-left m-3 nav-style" style="width: 20rem;">
                <img src="https://robohash.org/${emp.first_name}?set=set5" class="card-img-top"
                     alt="...">
                <div class="card-body nav-style">

<%--                <div class="card-body nav-style">--%>

                    <h5 class="card-title"><c:out value="${emp.first_name} ${emp.last_name}"/></h5>
                    <p class="card-text">ID: <c:out value="${emp.id}"/></p>
                    <form action="/employee-info" method="post">

                        <button class="btn btn-primary nav-style" name="id" type="submit"
                                value="${emp.id}">View Employee</button>
                    </form>
                        <c:if test="${isadmin}" >
                            <form action="/employees-list" method="post">
                            <button class="btn btn-danger nav-style" name="stype" type="submit"
                                    value="delete">Delete Employee</button>
                                <input type="number" name="id" value="${emp.id}" hidden>
                            </form>
                        </c:if>
                </div>
            </div>

        </c:forEach>
    </div>

</div>
<div>
    <%@include file="partials/leghand.jsp" %>
</div>
<script src="/"></script>
</body>
</html>
