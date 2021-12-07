package servlets;

import Model.Customer;
import Model.CustomerModel;
import Model.Item;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServlet extends HttpServlet {
    private Customer service;
    private Item service1;

    public CustomerServlet() throws SQLException, ClassNotFoundException {
        service = new Customer();
        service1 = new Item();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerModel> CustomerList = new ArrayList<>();
        String CustomerId = request.getParameter("CustomerId");
        String CustomerName = request.getParameter("CustomerName");
        String CustomerNumber = request.getParameter("CustomerNumber");
        String query = "select CustomerDB.CustomerId, CustomerDB.CustomerName, CustomerDB.CustomerNumber, OrderDB.DateOfPurchase, OrderDB.PlatformName, ItemDB.ItemName, OrderedItemsDB.Quantity from CustomerDB inner join\n" +
                "OrderDB on CustomerDB.CustomerId = OrderDB.CustomerId inner join OrderedItemsDB on OrderDB.OrderId = OrderedItemsDB.OrderId inner join ItemDB on ItemDB.ItemId = OrderedItemsDB.ItemId ";

        if(CustomerName != null && CustomerName !="") {
            query = query + String.format("where CustomerName='%s'", CustomerName);
        }else if(CustomerId != null && CustomerId != ""){
            query = query + "where CustomerId= " + CustomerId;
        }else if(CustomerNumber != null && CustomerNumber != ""){
            query = query + "where CustomerNumber= " + CustomerNumber;
        }

        try {
            CustomerList = service.getCustomerDetails(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("data", CustomerList);
        request.getRequestDispatcher("/Customer.jsp").forward(request, response);
    }
}
