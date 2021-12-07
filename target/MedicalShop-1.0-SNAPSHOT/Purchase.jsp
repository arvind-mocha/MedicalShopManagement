<%@ page import="Model.DealerModel" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: arvind-pt4566
  Date: 26/11/21
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.0/mdb.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/Static/Css/main.css"/>
    <title>Title</title>
</head>
<body>
    <h1 class="title">NEW PURCHASE</h1>
    <button class="back" onclick="window.open('/','_self');">Back</button>
    <form method="post" name="myform" class="purchase" id="purchase">
        <div class="search">
            <label class="search__label">Vendor Name</label>
            <select class="search__input" id="DealerName" style="font-size: 2rem" name="DealerName">
                <% ArrayList<DealerModel> del = (ArrayList<DealerModel>)request.getAttribute("DealerList");
                    for(DealerModel d:del){ %>
                    <option><%=d.getDealerName()%></option>
                <% } %>
            </select>
        </div>
        <div class="icontainer">
            <div class="add">
                <div class="items">
                    <label class="items__label">Item Name</label>
                    <input type="text" class="items__info" name="ItemName" required>
                </div>
                <div class="items">
                    <label class="items__label">Item Expiry</label>
                    <input type="text" class="items__info" name="ExpiryDate" placeholder="yyyy-mm-dd">
                </div>
                <div class="items">
                    <label class="items__label">Price Per Unit</label>
                    <input type="number" class="items__info" name="PricePerUnit">
                </div>
                <div class="items">
                    <label class="items__label">Item Quantity</label>
                    <input type="number" class="items__info" name="AvailableStock">
                </div>
            </div>
        </div>
        <button type="button" class="btn btn-primary add__btn" >add item</button>
        <div class="extra">
            <div class="extra">
                <label class="extra__label">Purchase date</label>
                <input type="text" class="extra__info" name="DateOfPurchase" placeholder="yyyy-mm-dd" required>
            </div>
        </div>
        <button type="submit" class="pbtn btn btn-success btn-lg">Purchase</button>
    </form>

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.0/mdb.min.js"></script>
    <script src="Static/Js/purchase.js"></script>
</body>
</html>
