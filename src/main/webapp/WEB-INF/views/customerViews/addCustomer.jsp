<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add customer</title>
</head>
<body>
<h1>Add new customer</h1>
<f:form method="post" modelAttribute="customer">
    <p>
        Name:<f:input path="customerName"/>
         <p style="color:#ff0000;font-weight:bold">
            <f:errors path="customerName"/>
        </p>
    </p>
    <p>
        Surname:<f:input path="customerSurname"/>
        <p style="color:#ff0000;font-weight:bold">
            <f:errors path="customerSurname"/>
        </p>
    </p>
    <p>
        Car:<f:input path="car"/>
    <p style="color:#ff0000;font-weight:bold">
        <f:errors path="car"/>
    </p>
    </p>
    <p>
        Phonenumber:<f:input path="phonenumber"/>
    <p style="color:#ff0000;font-weight:bold">
        <f:errors path="phonenumber"/>
    </p>
    </p>
    <f:hidden path="id"/>
    <button type="submit">Add</button>
</f:form>
</body>
</html>
