<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><s:message code="indexEmployee.title"/></title>
    <style>
        table {
            width:60%;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
            text-align: left;
        }
        table#t01 tr:nth-child(even) {
            background-color: #eee;
        }
        table#t01 tr:nth-child(odd) {
            background-color:#fff;
        }
        table#t01 th {
            background-color: black;
            color: white;
        }
    </style>
</head>
<body>
<table id="t01">

    <tr>
        <th>No.</th>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
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

        <%--<td>--%>
                <%--<form action="edit-employee.html?id=${employee.id}">--%>
                    <%--<input type ="submit" value="Edit"/>--%>
                <%--</form>--%>
            <%--</td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
<a href="/">Main menu</a>
</p>
</body>
</html>
