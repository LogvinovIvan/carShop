<%--
  Created by IntelliJ IDEA.
  User: dmitry
  Date: 4/12/16
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car</title>
    <link rel="stylesheet" href="../css/workers.css">
</head>
<body>
<form class="form" action="services" method="post" name="form">
    <input type="hidden" name="request" value="add_service"/>
    <ul>
        <li><h2>Add entry to service</h2></li>
        <li>
            <label for="date">date</label>
            <input type="text" name="date" placeholder="1" required/>
        </li>
        <li>
            <label for="mark">mark:</label>
            <input type="text" name="mark" placeholder="erdfs" required/>
        <li>
            <label for="model">model:</label>
            <input type="text" name="model" placeholder="rtgfd" required/>
        </li>
        <li>
            <label for="mileage">mileage:</label>
            <input type="text" name="mileage" placeholder="rtgfd" required/>
        </li>
        <li>
            <button class="submit" type="submit">Submit Form</button>
        </li>
    </ul>
</form>


<form action="services" class="form" method="post" name="form">
    <input type="hidden" name="request" value="delete_service"/>
    <ul>
        <li><h2>Delete entry</h2></li>
        <li>
            <input type="text" name="idEntryToService" placeholder="deleteId" required>
            <button class="submit" type="submit">Delete</button>
        </li>
    </ul>
</form>

<form class="form" action="services" method="post" name="form">
    <input type="hidden" name="request" value="update_service"/>
    <ul>
        <li><h2>update entry</h2></li>
        <li>
            <label for="id">id:</label>
            <input type="text" name="id" required/>
        </li>
        <li>
            <label for="date">date</label>
            <input type="text" name="date" placeholder="1" required/>
        </li>
        <li>
            <label for="mark">mark:</label>
            <input type="text" name="mark" placeholder="erdfs" required/>
        <li>
            <label for="model">model:</label>
            <input type="text" name="model" placeholder="rtgfd" required/>
        </li>
        <li>
            <label for="mileage">mileage:</label>
            <input type="text" name="mileage" placeholder="rtgfd" required/>
        </li>
        <li>
            <button class="submit" type="submit">Submit Form</button>
        </li>
    </ul>
</form>

<form class="delete" action="services" method="get">
    <button type="submit">View all</button>
</form>

</body>
</html>
