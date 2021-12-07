<%@ page import="Model.ItemModel" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: arvind-pt4566
  Date: 29/11/21
  Time: 5:24 PM
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
    <h1 class="title">Inventory</h1>
    <button class="back" onclick="window.open('/','_self');">Back</button>
    <form method="get"  class="purchase">

        <div class="extra">
            <div class="extra">
                <label class="extra__label">Purchase Id</label>
                <input type="text" class="extra__info" name="PurchaseId" placeholder="Purchase ID">
            </div>
        </div>
        <div class="extra">
            <div class="extra">
                <label class="extra__label">Item Id</label>
                <input type="text" class="extra__info" name="ItemId">
            </div>
            <div class="extra">
                <label class="extra__label">Item Name</label>
                <input type="text" class="extra__info" name="ItemName">
            </div>
            <div class="extra">
                <label class="extra__label">Expiry Date</label>
                <input type="text" class="extra__info" name="ExpiryDate" placeholder="yyyy-mm-dd">
            </div>
        </div>
        <button type="submit" class="pbtn btn btn-success btn-lg">Search</button>
    </form>
    <table class="table table-hover purchaseHistoryTable">

        <thead>
        <tr>
            <th scope="col">Purchase Id</th>
            <th scope="col">Item Id</th>
            <th scope="col">Item Name</th>
            <th scope="col">Expiry Date</th>
            <th scope="col">Price Per Unit</th>
            <th scope="col">Available Stock</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<ItemModel> std = (ArrayList<ItemModel>)request.getAttribute("data");
            for(ItemModel s:std){ %>
        <tr>
            <td><%=s.getPurchaseId()%></td>
            <td><%=s.getItemId()%></td>
            <td><%=s.getItemName()%></td>
            <td><%=s.getExpiryDate()%></td>
            <td><%=s.getPricePerUnit()%></td>
            <td><%=s.getAvailableStock()%></td>

        </tr>
        <% } %>
        </tbody>
    </table>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.0/mdb.min.js"></script>
</body>
</html>
