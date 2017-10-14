<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>List of jobs</title>
    <style> <%@include file="/resources/tableStyle.css" %></style>
</head>
<body>
<table id="t01">
    <tr>
        <th>No.</th>
        <th>Id</th>
        <th>Job</th>
        <th>Employee</th>
        <th>Customer</th>

    </tr>
    <tbody>
    <c:forEach items="${jobs}" var="job" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${job.id}</td>
            <td>${job.jobName}</td>
            <td>
                <c:forEach items="${job.employeeList}" var="employeeList" varStatus="status">
                    ${employeeList.employeeSurname}
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${job.customerList}" var="customerList" varStatus="status">
                     ${customerList.customerSurname}
                </c:forEach>
            </td>

            <td><a href="edit-job.html?id=${job.id}">Edit</a></td>
            <td><a href="remove-job.html?id=${job.id}">Remove</a></td>
        </tr>

    </c:forEach>
    </tbody>
</table>
<p>
    <a href="/">Main menu</a>
</p>
</body>
</html>
