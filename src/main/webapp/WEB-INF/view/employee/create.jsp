<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Smoky
  Date: 26.04.2022
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>

<form:form action="save" modelAttribute="createEmployee">

    <form:hidden path="id"/>

    Name<form:input path="name"/>
    <br>
    Surname<form:input path="surname"/>
    <br>
    Department<form:input path="department"/>
    <br>
    Salary<form:input path="salary"/>
    <input type="submit" value="Ok">
    
</form:form>

</body>
</html>
