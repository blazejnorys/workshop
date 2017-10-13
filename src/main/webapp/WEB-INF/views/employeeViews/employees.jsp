<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>List of employees</title>
    <style> <%@include file="/resources/tableStyle.css" %></style>
</head>
<body>
<table id="t01">
    <tr>
        <th>No.</th>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Edit</th>
        <th>Remove</th>
    </tr>
    <tbody>
    <c:forEach items="${employees}" var="employee" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${employee.id}</td>
            <td>${employee.employeeName}</td>
            <td>${employee.employeeSurname}</td>
            <td><a href="edit-employee.html?id=${employee.id}">Edit</a></td>
            <td><a href="remove-employee.html?id=${employee.id}">Remove</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
<a href="/">Main menu</a>
</p>
</body>
</html>
