<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Find employee by surname</title>
</head>
<body>
<h3>Find employee by surname</h3>
<h5>Please enter surname: </h5>
<f:form method="post" modelAttribute="employee">
    <p>
    Surname:<f:input path="employeeSurname"/>
    </p>
    <f:hidden path="employeeName"/>
    <f:hidden path="id"/>
    <button type="submit">Find</button>

</f:form>


</body>
</html>
