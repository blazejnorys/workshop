<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><s:message code="indexCustomer.title"/></title>
</head>
<body>
<h1><s:message code="indexCustomer.title"/></h1>
<ul>
    <li>
        <a href="show-customers.html">
            <s:message code="index.showCustomers"/>
        </a>
    </li>
    <li>
        <a href="add-customer.html">
            Add new customer
        </a>
    </li>
</ul>
</body>
</html>