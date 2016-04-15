<%--
  Created by IntelliJ IDEA.
  User: dmitry
  Date: 4/12/16
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car</title>
    <link rel="stylesheet" href="../css/workers.css">
</head>
<body>
<form class="form" action="spares" method="post" name="form">
    <input type="hidden" name="request" value="add_spare"/>
    <ul>
        <li><h2>Add spare part</h2></li>
        <li>
            <label for="name">name:</label>
            <input type="text" name="name" placeholder="1" required/>
        </li>
        <li>
            <label for="mark">mark:</label>
            <input type="text" name="mark" placeholder="erdfs" required/>
        <li>
            <label for="model">model:</label>
            <input type="text" name="model" placeholder="rtgfd" required/>
        </li>
        <li>
            <label for="articul">articul:</label>
            <input type="text" name="articul" placeholder="rtgfd" required/>
        </li>
        <li>
            <button class="submit" type="submit">Submit Form</button>
        </li>
    </ul>
</form>


<form action="spares" class="form" method="post" name="form">
    <input type="hidden" name="request" value="delete_spare"/>
    <ul>
        <li><h2>Delete spare</h2></li>
        <li>
            <input type="text" name="idSpare" placeholder="deleteId" required>
            <button class="submit" type="submit">Delete</button>
        </li>
    </ul>
</form>

<form class="form" action="spares" method="post" name="form">
    <input type="hidden" name="request" value="update_spare"/>
    <ul>
        <li><h2>update spare</h2></li>
        <li>
            <label for="id">id:</label>
            <input type="text" name="id" required/>
        </li>
        <li>
            <label for="name">name:</label>
            <input type="text" name="name" placeholder="1" required/>
        </li>
        <li>
            <label for="mark">mark:</label>
            <input type="text" name="mark" placeholder="erdfs" required/>
        <li>
            <label for="model">model:</label>
            <input type="text" name="model" placeholder="rtgfd" required/>
        </li>
        <li>
            <label for="articul">articul:</label>
            <input type="text" name="articul" placeholder="rtgfd" required/>
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
