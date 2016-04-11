<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 09.04.2016
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car</title>
</head>
<body>
<form class="form" action="cars" method="post" name="form">
    <input type="hidden" name="request" value="add_car"/>
    <ul>
        <li><h2>Add Car</h2></li>
        <li>
            <label for="name">vinCode</label>
            <input type="text" name="vinCode" placeholder="1" required/>
        </li>
        <li>
            <label for="firstname">mark:</label>
            <input type="text" name="mark" placeholder="erdfs" required/>
        <li>
            <label for="lastname">model:</label>
            <input type="text" name="model" placeholder="rtgfd" required/>
        </li>
        <li>
            <label for="position">color:</label>
            <input type="text" name="color" required/>
        </li>
        <li>
            <button class="submit" type="submit">Submit Form</button>
        </li>
    </ul>
</form>


<form action="cars" class="form" method="post" name="form">
    <input type="hidden" name="request" value="delete_car"/>
    <ul>
        <li><h2>Delete car</h2></li>
        <li>
            <input type="text" name="vinCode" placeholder="deleteId" required>
            <button class="submit" type="submit">Delete</button>
        </li>
    </ul>
</form>

<form class="form" action="cars" method="post" name="form">
    <input type="hidden" name="request" value="update_car"/>
    <ul>
        <li><h2>update Car</h2></li>
        <li>
            <label for="name">vinCode</label>
            <input type="text" name="vinCode" placeholder="1" required/>
        </li>
        <li>
            <label for="firstname">mark:</label>
            <input type="text" name="mark" placeholder="erdfs" required/>
        <li>
            <label for="lastname">model:</label>
            <input type="text" name="model" placeholder="rtgfd" required/>
        </li>
        <li>
            <label for="position">color:</label>
            <input type="text" name="color" required/>
        </li>
        <li>
            <button class="submit" type="submit">Submit Form</button>
        </li>
    </ul>
</form>

<form class="delete" action="cars" method="get">
    <button type="submit">View all</button>
</form>
</body>
</html>
