<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Sklep ogrodniczy</title>
</head>
<body>
<h1><s:message code="index.title"/></h1>
<ul>
    <li>
        <a href="show-employees.html">
            <s:message code="index.showEmployees"/>
        </a>
    </li>
    <li>
        <a href="employee.html">
            Dodaj pracownika
        </a>
    </li>
</ul>
</body>
</html>