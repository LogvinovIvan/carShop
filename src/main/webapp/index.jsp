<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>

<body>

<div class="container">
    <s:form action="autorizate" method="POST" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputLogin" class="sr-only">Login</label>
        <s:textfield key="login" id="inputLogin" class="form-control" placeholder="Login" required="true"/>
        <label for="inputPassword" class="sr-only">Password</label>
        <s:password key="password" id="inputPassword" class="form-control" placeholder="Password" required="true"/>
        <s:submit name="Sign in" class="btn btn-lg btn-primary btn-block" value="Sign In"/>
    </s:form>

</div> <!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
</body>
</html>
