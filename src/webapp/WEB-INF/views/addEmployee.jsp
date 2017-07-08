<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dodaj pracownika</h1>
<f:form method="post" modelAttribute="employee">
    <p>
        Imię:<f:input path="employeeName"/>
         <p>
            <f:errors path="employeeName"/>
        </p>
    </p>
    <p>
        Nazwisko:<f:input path="employeeSurname"/>
        <p>
            <f:errors path="employeeSurname"/>
        </p>
    </p>
    <button type="submit">Dodaj</button>
</f:form>
</body>
</html>
