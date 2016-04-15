<%--
  Created by IntelliJ IDEA.
  User: dmitry
  Date: 4/12/16
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car</title>
    <link rel="stylesheet" href="../css/workers.css">
</head>
<body>
<form class="form" action="clients" method="post" name="form">
    <input type="hidden" name="request" value="add_client"/>
    <ul>
        <li><h2>Add Clients</h2></li>
        <li>
            <label for="firstName">firstName</label>
            <input type="text" name="firstName" placeholder="1" required/>
        </li>
        <li>
            <label for="lastName">lastName:</label>
            <input type="text" name="lastName" placeholder="erdfs" required/>
        <li>
            <label for="phoneNumber">model:</label>
            <input type="text" name="phoneNumber" placeholder="rtgfd" required/>
        </li>
        <li>
            <button class="submit" type="submit">add Client</button>
        </li>
    </ul>
</form>


<form action="clients" class="form" method="post" name="form">
    <input type="hidden" name="request" value="delete_client"/>
    <ul>
        <li><h2>Delete Clients</h2></li>
        <li>
            <input type="text" name="idWorker" placeholder="deleteId" required>
            <button class="submit" type="submit">Delete Clients</button>
        </li>
    </ul>
</form>

<form class="form" action="clients" method="post" name="form">
    <input type="hidden" name="request" value="update_client"/>
    <ul>
        <li><h2>update Clients</h2></li>
        <li>
            <label for="id">id:</label>
            <input type="text" name="id" required/>
        </li>
        <li>
            <label for="firstName">firstName</label>
            <input type="text" name="firstName" placeholder="1" required/>
        </li>
        <li>
            <label for="lastName">lastName:</label>
            <input type="text" name="lastName" placeholder="erdfs" required/>
        <li>
            <label for="phoneNumber">phoneNumber:</label>
            <input type="text" name="phoneNumber" placeholder="rtgfd" required/>
        </li>
        <li>
            <button class="submit" type="submit">update Client</button>
        </li>
    </ul>
</form>

<form class="delete" action="clients" method="get">
    <button type="submit">View all</button>
</form>

</body>
</html>
