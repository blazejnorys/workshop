<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><s:message code="indexCustomer.title"/></title>
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
    <c:forEach items="${customers}" var="customer" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${customer.id}</td>
            <td>${customer.customerName}</td>
            <td>${customer.customerSurname}</td>
            <td>${customer.car}</td>
            <td>${customer.phonenumber}</td>
            <td><a href="edit-customer.html?id=${customer.id}">Edit</a></td>
            <td><a href="remove-customer.html?id=${customer.id}">Remove</a></td>

        <%--<td>--%>
                <%--<form action="edit-customer.html?id=${customer.id}">--%>
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
