<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><s:message code="indexEmployee.title"/></title>
</head>
<body>
<h1><s:message code="indexEmployee.title"/></h1>
<ul>
    <li>
        <a href="show-employees.html">
            <s:message code="index.showEmployees"/>
        </a>
    </li>
    <li>
        <a href="add-employee.html">
            Add new employee
        </a>
    </li>
</ul>
</body>
</html>