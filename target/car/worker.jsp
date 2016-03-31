<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 26.03.2016
  Time: 7:42
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="java.util.List"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>Login</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach  var="worker" items="${workerList}">
        <tr>
            <td>${worker.firstname}</td>
            <td><c:out value="${worker.lastname}" /></td>
        </tr>
    </c:forEach>


    </tbody>

</table>


</body>
</html>
