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

	onunload = function()
	{
		var perpage = document.getElementById('perpage');
		self.name = 'fooidx' + perpage.selectedIndex;
	};

	onload = function()
	{
		var idx, perpage = document.getElementById('perpage');
		perpage.selectedIndex = (idx = self.name.split('fooidx')) ?	idx[1] : 0;
	};

</script>
<%--< class="container">--%>
    <h1>Employees List</h1>
    <form action="/employees-list" method="post">

        <div class="float-left clear-fix col-12">
            <div class="col-3 float-left m-3 perpage-div">
                <label class="perpage-label" for="perpage">Per page?</label>
                <select id="perpage" class="form-control form-control-sm nav-style btn-style" name="perpage"
                        onchange="options[selectedIndex].value&&self.location.reload(true)">

                    <option value="6">6</option>
                    <option value="12" >12</option>
                    <option value="18">18</option>
                    <option value="24">24</option>
                    <option value="30">30</option>
                </select>
            </div>
        </div>
    </form>

            <%-- buttons to move page forard or backward.--%>
        <form action="/employees-list" method="post">

        <div class="col-6 float-right m-3 form-row page-buttons">

                <button class=" btn btn-light float-right nav-style btn-style" type="submit" name="pagenum"
                        value="${pagenum} -1">Previous
                    Page</button>
                <button class=" btn btn-light float-right nav-style btn-style" name="pagenum" value=${pagenum}>
                    Page <span class="badge">${pagenum}</span>
                </button>
                <button class=" btn btn-light float-right nav-style btn-style" type="submit" name="pagenum"
                       value="${pagenum} +1" >Next Page
                </button>
            </div>
    </form>

    <div class="col-12">
        <c:forEach var="emp" items="${emps}">

            <div class="card float-left m-3 nav-style" style="width: 20rem;">
                <img src="https://robohash.org/${emp.first_name}?set=set5" class="card-img-top"
                     alt="...">
                <div class="card-body nav-style">
                    <h5 class="card-title"><c:out value = "${emp.first_name} ${emp.last_name}"/></h5>
                    <p class="card-text">ID:  <c:out value="${emp.emp_no}" /></p>
                    <a href="#" class="btn btn-primary disabled nav-style">View Employee</a>
                </div>
            </div>

        </c:forEach>
    </div>

</div>
<div>
<%@ include file="/WEB-INF/partials/leghand.jsp" %>
</div>
</body>
</html>
