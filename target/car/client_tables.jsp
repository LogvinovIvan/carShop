<%--
  Created by IntelliJ IDEA.
  User: dmitry
  Date: 4/12/16
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="java.util.List"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/workers.css">
</head>

<body>
<table class="table">
    <thead class="head">
    <tr>
        <th>firstName</th>
        <th>lastName</th>
        <th>phoneNumber</th>
    </tr>
    </thead>
    <tbody class="body">
    <c:forEach  var="client" items="${clientList}">
        <tr>
            <td><c:out value="${client.id}" /></td>
            <td><c:out value="${client.firstName}" /></td>
            <td><c:out value="${client.lastName}" /></td>
            <td><c:out value="${client.phoneNumber}" /></td>
        </tr>
    </c:forEach>


    </tbody>

</table>
</body>
</html>
