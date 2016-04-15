<%--
  Created by IntelliJ IDEA.
  User: dmitry
  Date: 4/12/16
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car</title>
    <link rel="stylesheet" href="../css/workers.css">
</head>
<body>
<form class="form" action="testDrive" method="post" name="form">
    <input type="hidden" name="request" value="add_testDrive"/>
    <ul>
        <li><h2>Add test</h2></li>
        <li>
            <label for="mark">mark:</label>
            <input type="text" name="mark" placeholder="erdfs" required/>
        <li>
            <label for="model">model:</label>
            <input type="text" name="model" placeholder="rtgfd" required/>
        </li>
        <li>
            <label for="date">date:</label>
            <input type="text" name="date" placeholder="rtgfd" required/>
        </li>
        <li>
            <button class="submit" type="submit">add</button>
        </li>
    </ul>
</form>


<form action="testDrive" class="form" method="post" name="form">
    <input type="hidden" name="request" value="delete_testDrive"/>
    <ul>
        <li><h2>Delete test</h2></li>
        <li>
            <input type="text" name="idTestDrive" placeholder="deleteId" required>
            <button class="submit" type="submit">Delete</button>
        </li>
    </ul>
</form>

<form class="form" action="testDrive" method="post" name="form">
    <input type="hidden" name="request" value="update_testDrive"/>
    <ul>
        <li><h2>update test</h2></li>
        <li>
            <label for="id">id:</label>
            <input type="text" name="id" required/>
        </li>
        <li>
            <label for="mark">mark:</label>
            <input type="text" name="mark" placeholder="erdfs" required/>
        <li>
            <label for="model">model:</label>
            <input type="text" name="model" placeholder="rtgfd" required/>
        </li>
        <li>
            <label for="date">date:</label>
            <input type="text" name="date" placeholder="rtgfd" required/>
        </li>
        <li>
            <button class="submit" type="submit">Submit Form</button>
        </li>
    </ul>
</form>

<form class="delete" action="testDrive" method="get">
    <button type="submit">View all</button>
</form>

</body>
</html>
