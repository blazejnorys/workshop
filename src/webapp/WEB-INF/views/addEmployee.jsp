<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Workshop/employee</title>
</head>
<body>
<h1>Add new employee</h1>
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
    <button type="submit">Add</button>
</f:form>
</body>
</html>
