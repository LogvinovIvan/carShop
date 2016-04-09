<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 26.03.2016
  Time: 7:42
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
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
        <th>phone namber</th>
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

<form class="form" action="WorkerController" method="post" name="form">
    <ul>
        <li>
            <label for="name">ID:</label>
            <input type="text" name="name" placeholder="1" required/>
        </li>
        <li>
            <label for="firstname">Firstname:</label>
            <input type="text" name="firstname" placeholder="Ivan" required/>
        <li>
            <label for="lastname">Lastname:</label>
            <input type="text" name="lastname" placeholder="Ivanov" required/>
        </li>
        <li>
            <label for="position">position:</label>
            <input type="text" name="position" required/>
        </li>
        <li>
            <label for="phone-namber">phone namber:</label>
            <input type="text" name="phone-namber" required/>
        </li>
        <li>
            <label for="number-of-passport">number of passport:</label>
            <input type="text" name="number-of-passport" required>
        </li>
        <li>
            <button class="submit" type="submit">Submit Form</button>
        </li>
    </ul>
</form>

</body>
</html>
