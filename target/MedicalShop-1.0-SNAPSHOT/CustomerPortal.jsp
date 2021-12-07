<%@ page import="Model.DealerModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.ItemModel" %>
<%@ page import="Model.CustomerModel" %><%--
  Created by IntelliJ IDEA.
  User: arvind-pt4566
  Date: 30/11/21
  Time: 4:32 PM
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
    <h1 class="title">Buy Items</h1>
    <button class="back" onclick="window.open('/','_self');">Back</button>
    <form method="post" class="purchase" id="purchase">
        <div class="extra">
            <div class="extra">
                <label class="extra__label">Name</label>
                <input type="text" class="extra__info" name="CustomerName">
            </div>
            <div class="extra">
                <label class="extra__label">Mobile Number</label>
                <input type="text" class="extra__info" name="CustomerPhoneNumber">
            </div>

        </div>
        <div class="search">
            <label class="search__label">Vendor Name</label>
            <select class="search__input" id="PlatformName" style="font-size: 2rem" name="PlatformName">
                <%ArrayList<String> std = (ArrayList<String>)request.getAttribute("PlatformList");
                    for(String s:std){ %>
                <option><%=s%></option>
                <% } %>
            </select>
        </div>
        <div class="icontainer">
            <div class="add">
                <div class="items">
                    <label class="items__label">Item Name</label>
                    <select class="search__input search__item" id="ItemName" style="font-size: 2rem" name="ItemName">
                        <% ArrayList<ItemModel> del = (ArrayList< ItemModel>)request.getAttribute("ItemList");
                            for(ItemModel d:del){ %>
                        <option><%=d.getItemName()%></option>
                        <% } %>
                    </select>
                </div>
                <div class="items">
                    <label class="items__label">Item Quantity</label>
                    <input type="number" class="items__info" name="Quantity">
                </div>
                <div>
                    <h3>Price Per Unit</h3>
                    <h1 class="uprice"></h1>
                </div>
                <div>
                    <h3>Total</h3>
                    <h1 class="utotal"></h1>
                </div>
            </div>

        </div>
        <button type="button" class="btn btn-primary add__btn" >add item</button>
        <button type="submit" class="btn btn-success add__btn" >Purchase</button>

    </form>

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.0/mdb.min.js"></script>
    <script src="Static/Js/customerportal.js"></script>
</body>
</html>
