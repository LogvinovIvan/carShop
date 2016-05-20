<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 15.04.2016
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="java.util.List"%>
<html lang="ru">
<head>
    <title>Название</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>

<body>
<div class="pl">
    <div class="round"></div>
    <div class="pl-l"></div>
    <div class="pl-r"></div>

</div>

<header class="navbar navbar-inverse navbar-fixed-top">

    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right">


                <button type="submit" class="btn btn-success">Sign out</button>
            </form>
        </div><!--/.navbar-collapse -->
    </div>
</header>

<div class="container">
    <main class="row">

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">lalala</h1>

            <h2 class="sub-header">Section title</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>position</th>
                        <th>phone number</th>
                        <th>number of passport</th>
                    </tr>
                    </thead>
                    <tbody>
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
            </div>
            <button type="submit" class="btn btn-danger">Remove</button>
            <!-- HTML-код модального окна-->
            <div class="modal fade remove">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Заголовок модального окна -->
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Заголовок модального окна</h4>
                        </div>
                        <!-- Основное содержимое модального окна -->

                        <form action="workers" class="form" method="post" name="form">
                            <div class="modal-body">
                                <input type="hidden" name="request" value="delete_worker"/>
                                <ul>
                                    <li><h2>Delete worker</h2></li>
                                    <li>
                                        <input type="text" name="id" placeholder="deleteId" required>
                                    </li>
                                </ul>
                            </div>
                            <!-- Футер модального окна -->
                            <div class="modal-footer">
                                <button type="submit" class="btn submit btn-primary">Send</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!------------------------------------------------>
            <button type="submit" class="btn btn-success">Add</button>
            <div class="modal fade add">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Заголовок модального окна -->
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Заголовок модального окна</h4>
                        </div>
                        <!-- Основное содержимое модального окна -->

                        <form class="form" action="workers" method="post" name="form">
                            <div class="modal-body">
                                <input type="hidden" name="request" value="add_worker"/>
                                <ul>
                                    <li><h2>Add worker</h2></li>
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
                                </ul>
                            </div>
                            <!-- Футер модального окна -->
                            <div class="modal-footer">
                                <button type="submit" class="submit">Send</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
            <!-- HTML-код модального окна-->
            <div class="modal fade update">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Заголовок модального окна -->
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Заголовок модального окна</h4>
                        </div>
                        <!-- Основное содержимое модального окна -->

                        <form class="form" action="workers" method="post" name="form">
                            <div class="modal-body">
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
                                </ul>
                            </div>
                            <!-- Футер модального окна -->
                            <div class="modal-footer">
                                <button type="button" class="btn submit btn-primary">Send</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


    </main>
</div>
<footer class="footer container">
    <p>© 2016  Logvinov Ivan,  Tretsyak Evgen, Sannikov Dmitry 351003</p>
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="js/js.js"></script>
<script>
    $(document).ready(function(){
        $(".btn-danger").click(function() {
            $(".remove").modal('show');
        });
    });
    $(document).ready(function(){
        $(".btn-success").click(function() {
            $(".add").modal('show');
        });
    });
    $(document).ready(function(){
        $(".btn-primary").click(function() {
            $(".update").modal('show');
        });
    });
</script>
</body>
</html>