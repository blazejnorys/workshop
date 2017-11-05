<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add job</title>
</head>
<body>
<h1>Add new job</h1>
<f:form method="post" modelAttribute="job">

    <p>Job name:<f:input path="jobName"/></p>

    <f:hidden path="id"/>

    <f:select path="employeeList" multiple="true">
        <f:options items="${employeeInit}" itemLabel="employeeSurname" itemValue="id"></f:options>
    </f:select>

    <f:select path="customerList" multiple="true">
        <f:options items="${customerInit}" itemLabel="customerSurname" itemValue="id"></f:options>
    </f:select>

    <button type="submit">Add</button>
</f:form>

</body>
</html>


<%--<f:form method="post" modelAttribute="employeeInit">--%>
<%--<f:select path="" items="${employeeInit}" multiple="true"  itemLabel="employeeSurname"/>--%>
<%--</f:form>--%>
