<%@ page import="Model.CustomerModel" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: arvind-pt4566
  Date: 29/11/21
  Time: 1:16 PM
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
    <h1 class="title">Customer Details</h1>
    <button class="back" onclick="window.open('/','_self');">Back</button>
    <form method="get"  class="purchase">

        <div class="extra">
            <div class="extra">
                <label class="extra__label">Customer Name</label>
                <input type="text" class="extra__info" name="CustomerName">
            </div>
            <div class="extra">
                <label class="extra__label">Customer Id</label>
                <input type="text" class="extra__info" name="CustomerId">
            </div>
            <div class="extra">
                <label class="extra__label">Customer Mobile</label>
                <input type="text" class="extra__info" name="CustomerNumber">
            </div>
        </div>
        <button type="submit" class="pbtn btn btn-success btn-lg">Search</button>
    </form>
    <table class="table table-hover purchaseHistoryTable">

        <thead>
        <tr>
            <th scope="col">Customer Id</th>
            <th scope="col">Customer Name</th>
            <th scope="col">Customer Mobile</th>
            <th scope="col">Date Of Purchase</th>
            <th scope="col">Platform Name</th>
            <th scope="col">Item Name</th>
            <th scope="col">Quantity</th>
        </tr>
        </thead>
        <tbody>
        <%ArrayList<CustomerModel> std = (ArrayList<CustomerModel>)request.getAttribute("data");
            for(CustomerModel s:std){ %>
        <tr>
            <td><%=s.getId()%></td>
            <td><%=s.getName()%></td>
            <td><%=s.getMobileNumber()%></td>
            <td><%=s.getDateOfPurchase()%></td>
            <td><%=s.getPlatformName()%></td>
            <td><%=s.getItemName()%></td>
            <td><%=s.getQuantity()%></td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.0/mdb.min.js"></script>
</body>
</html>
