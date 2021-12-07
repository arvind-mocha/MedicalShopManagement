<%@ page import="Model.DealerModel" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: arvind-pt4566
  Date: 27/11/21
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.0/mdb.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/Static/Css/main.css"/>
    <title>Medical Shop Management</title>
</head>
<body>
    <h1 class="title">Add New Dealer</h1>
    <button class="back" onclick="window.open('/','_self');">Back</button>
    <form method="post" class="purchase">
        <div class="search">
            <label class="search__label">Vendor Name</label>
            <input type="text" class="extra__info" name="DealerName" placeholder="Dealer Name">
        </div>
        <div class="extra">
            <div class="extra">
                <label class="extra__label">Vendor Number</label>
                <input type="text" class="extra__info" name="DealerNumber" placeholder="Dealer Number">
            </div>
        </div>
        <button type="submit" class="pbtn btn btn-success btn-lg">Add Dealer</button>
    </form>
    <table class="table table-hover purchaseHistoryTable">
        <thead>
        <tr>
            <th scope="col">Dealer Name</th>
            <th scope="col">Contact Number</th>
        </tr>
        </thead>
        <tbody>
        <%ArrayList<DealerModel> std = (ArrayList<DealerModel>)request.getAttribute("data");
            for(DealerModel s:std){ %>
        <tr>
            <td><%=s.getDealerName()%></td>
            <td><%=s.getDealerNumber()%></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.0/mdb.min.js"></script>
    <script src="Static/Js/purchasehistory.js"></script>
</body>
</html>
