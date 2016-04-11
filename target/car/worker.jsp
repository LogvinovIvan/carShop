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

<form class="form" action="workers" method="post" name="form">
    <input type="hidden" name="request" value="add_worker"/>
    <ul>
        <li><h2>Add worker</h2></li>
        <li>
            <label for="name">ID:</label>
            <input type="text" name="id" placeholder="1" required/>
        </li>
        <li>
            <label for="firstname">Firstname:</label>
            <input type="text" name="firstName" placeholder="Ivan" required/>
        <li>
            <label for="lastname">Lastname:</label>
            <input type="text" name="lastName" placeholder="Ivanov" required/>
        </li>
        <li>
            <label for="position">position:</label>
            <input type="text" name="position" required/>
        </li>
        <li>
            <label for="phone-namber">phone namber:</label>
            <input type="text" name="phoneNumber" required/>
        </li>
        <li>
            <label for="number-of-passport">number of passport:</label>
            <input type="text" name="numberOfPassport" required>
        </li>
        <li>
            <button class="submit" type="submit">Submit Form</button>
        </li>
    </ul>
</form>


<form action="workers" class="form" method="post" name="form">
    <input type="hidden" name="request" value="delete_worker"/>
    <ul>
        <li><h2>Delete worker</h2></li>
        <li>
            <input type="text" name="id" placeholder="deleteId" required>
            <button class="submit" type="submit">Delete</button>
        </li>
    </ul>
</form>

<form class="form" action="workers" method="post" name="form">
    <input type="hidden" name="request" value="update_worker"/>
    <ul>
        <li><h2>Update worker</h2></li>
        <li>
            <label for="name">ID:</label>
            <input type="text" name="id" placeholder="1" required/>
        </li>
        <li>
            <label for="firstname">Firstname:</label>
            <input type="text" name="firstName" placeholder="Ivan" required/>
        <li>
            <label for="lastname">Lastname:</label>
            <input type="text" name="lastName" placeholder="Ivanov" required/>
        </li>
        <li>
            <label for="position">position:</label>
            <input type="text" name="position" required/>
        </li>
        <li>
            <label for="phone-namber">phone namber:</label>
            <input type="text" name="phoneNumber" required/>
        </li>
        <li>
            <label for="number-of-passport">number of passport:</label>
            <input type="text" name="numberOfPassport" required>
        </li>
        <li>
            <button class="submit" type="submit">Submit Form</button>
        </li>
    </ul>
</form>

<form class="delete" action="workers" method="get">
    <button type="submit">View all</button>
</form>
</body>
</html>
