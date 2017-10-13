<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee details</title>
    <style> <%@include file="/resources/tableStyle.css" %></style>
</head>
<body>
<table id="t01">
<tr>
    <th>No.</th>
    <th>Id</th>
    <th>Name</th>
    <th>Surname</th>
</tr>
<c:forEach items="${employees}" var="employee" varStatus="status">
<tr>
    <td>${status.index + 1}</td>
    <td>${employee.id}</td>
    <td>${employee.employeeName}</td>
    <td>${employee.employeeSurname}</td>
</tr>

</c:forEach>
</table>
<p><a href="/">Go back to main menu</a></p>
<p><a href="/show-employees.html">Go back to employees list</a></p>

</body>
</html>
