<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit employee</title>
</head>
<body>
<h1>Edit employee</h1>
<f:form method="post" modelAttribute="employee">
    <p>
        Name:<f:input path="employeeName"/>
    <p>
        <f:errors path="employeeName"/>
    </p>
    </p>
    <p>
        Surname:<f:input path="employeeSurname"/>
    <p>
        <f:errors path="employeeSurname"/>
    </p>
    </p>
    <f:hidden path="id"/>
    <button type="submit">Edit</button>
</f:form>
</body>
</html>
