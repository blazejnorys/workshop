<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit produkt</h1>
<f:form method="post" modelAttribute="employee">
    <p>
        Nazwa:<f:input path="employeeName"/>
    <p>
        <f:errors path="employeeName"/>
    </p>
    </p>
    <p>
        Cena:<f:input path="employeeSurname"/>
    <p>
        <f:errors path="employeeSurname"/>
    </p>
    </p>
    <f:hidden path="id"/>
    <button type="submit">Dodaj</button>
</f:form>
</body>
</html>
