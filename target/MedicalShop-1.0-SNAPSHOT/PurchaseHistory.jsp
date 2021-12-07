<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Model.Purchase" %>
<%@ page import="Model.PurchaseModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Dealer" %>
<%@ page import="Model.DealerModel" %><%--
  Created by IntelliJ IDEA.
  User: arvind-pt4566
  Date: 26/11/21
  Time: 2:41 PM
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
    <h1 class="title">Purchase History</h1>
    <button class="back" onclick="window.open('/','_self');">Back</button>
    <form method="get"  class="purchase">
        <div class="search">
            <label class="search__label">Status</label>
            <select class="search__input" id="Status" style="font-size: 2rem" name="Status">
                <option></option>
                <option>Success</option>
                <option>Pending</option>
            </select>
        </div>
        <div class="search">
                <label class="search__label">Vendor Name</label>
                <select class="search__input" id="DealerName" style="font-size: 2rem" name="DealerName">
                    <% ArrayList<DealerModel> del = (ArrayList<DealerModel>)request.getAttribute("DealerList");
                    for(DealerModel d:del){ %>
                        <option><%=d.getDealerName()%></option>
                    <% } %>
                </select>
        </div>
        <div class="extra">
            <div class="extra">
                <label class="extra__label">Purchase date</label>
                <input type="text" class="extra__info" name="DateOfPurchase">
            </div>
        </div>
        <button type="submit" class="pbtn btn btn-success btn-lg">Search</button>
    </form>
    <table class="table table-hover purchaseHistoryTable">
        <thead>
            <tr>
                <th scope="col">Purchase Id</th>
                <th scope="col">DOP</th>
                <th scope="col">Vendor Name</th>
                <th scope="col">Amount Spent</th>
                <th scope="col">NumberOfItems</th>
                <th scope="col">Status</th>
            </tr>
        </thead>
        <tbody>
        <% ArrayList<PurchaseModel> pur = (ArrayList<PurchaseModel>)request.getAttribute("PurchaseList");
        for(PurchaseModel s:pur){ %>
                <tr>
                    <th class="prow" scope="row"><%=s.getPurchaseId()%></th>
                    <td class="prow"><%=s.getDateOfPurchase()%></td>
                    <td class="prow"><%=s.getDealerName()%></td>
                    <td class="prow"><%=s.getPurchaseAmount()%></td>
                    <td class="prow"><%=s.getNoOfItems()%></td>
                    <td class="prow"><%=s.getStatus()%></td>
                </tr>
        <% } %>
        </tbody>
    </table>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.0/mdb.min.js"></script>
    <script src="Static/Js/purchasehistory.js"></script>
</body>
</html>
