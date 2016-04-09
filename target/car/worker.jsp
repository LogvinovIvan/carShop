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
    <link rel="stylesheet" href="../css/workers.css">
</head>
<body>

<table class="table">
    <thead class="head">
    <tr>
        <th>ID</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>position</th>
        <th>phone number</th>
        <th>number of passport</th>
    </tr>
    </thead>
    <tbody class="body">
    <c:forEach  var="worker" items="${workerList}">
        <tr>
            <td>${worker.id}</td>
            <td><c:out value="${worker.firstname}" /></td>
            <td><c:out value="${worker.lastname}" /></td>
            <td><c:out value="${worker.position}" /></td>
            <td><c:out value="${worker.phoneNumber}" /></td>
            <td><c:out value="${worker.numberOfPasport}" /></td>
        </tr>
    </c:forEach>


    </tbody>

</table>


</body>
</html>
