<%--
  Created by IntelliJ IDEA.
  User: arvind-pt4566
  Date: 25/11/21
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.0/mdb.min.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/Static/Css/main.css"/>
        <title>Medicals Shop Management Software</title>
    </head>
    <body>
        <h1 class="title">Medical Shop Management</h1>
        <section class="operations">
            <div class="operations__users">
                <div class="operations__users--btns"></div>
                <h1 class="operations__users--title">SHOPKEEPER</h1>
            </div>
        </section>
        <section style="margin-bottom: 10rem"  class="operations">
            <div class="operations__users">
                <div class="operations__users--btns">
                    <button class="sbtns" onclick="window.open('/CustomerPortal')">Buy Items</button>
                </div>
                <h1 class="operations__users--title">USER</h1>
            </div>
        </section>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.0/mdb.min.js"></script>
        <script src="Static/Js/main.js"></script>
    </body>
</html>
