<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Lp.</th>
        <th>Id</th>
        <th>Imię</th>
        <th>Nazwisko</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${employee.id}</td>
            <td>${employee.employeeName}</td>
            <td>${employee.employeeSurname}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/">Menu głowne</a>
</body>
</html>
