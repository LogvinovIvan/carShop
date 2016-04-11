<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 09.04.2016
  Time: 10:43
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
        <th>vinCode</th>
        <th>mark</th>
        <th>model</th>
        <th>color</th>
    </tr>
    </thead>
    <tbody class="body">
    <c:forEach  var="car" items="${carList}">
        <tr>
            <td><c:out value="${car.vinCode}" /></td>
            <td><c:out value="${car.mark}" /></td>
            <td><c:out value="${car.model}" /></td>
            <td><c:out value="${car.color}" /></td>
        </tr>
    </c:forEach>


    </tbody>

</table>
</body>
</html>
