<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><s:message code="index.jobTitle"/></title>
</head>
<body>
<h1><s:message code="index.jobTitle"/></h1>
<ul>
    <li>
        <a href="show-jobs.html">
            <s:message code="index.showJob"/>
        </a>
    </li>
    <li>
        <a href="add-job.html">
            <s:message code="index.addJob"/>
        </a>
    </li>
</ul>
</body>
</html>