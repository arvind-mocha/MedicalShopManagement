package servlets;

import Database.Database;
import Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderServlet extends HttpServlet {
    private Customer service;
    private Item service1;
    private OrderedItem service2;
    private Order service3;
    private PreparedStatement stmt;


    public OrderServlet() throws SQLException, ClassNotFoundException {
        service = new Customer();
        service1 = new Item();
        service2 = new OrderedItem();
        service3 = new Order();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ItemModel> ItemList = new ArrayList<>();
        List<String> PlatformList = new ArrayList<>();

        try {
            ItemList = service1.getItemDetails("select * from ItemDB");
            Connection con = Database.initializeDatabase();
            stmt = con.prepareStatement("select * from PlatformDB");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                PlatformList.add(rs.getString("PlatformName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("ItemList",ItemList);
        request.setAttribute("PlatformList",PlatformList);
        request.getRequestDispatcher("/CustomerPortal.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/dd/MM");
        LocalDateTime now = LocalDateTime.now();
        String CustomerName = request.getParameter("CustomerName");
        String OrderId = "OId" + UUID.randomUUID().toString();
        String DateOfPurchase = dtf.format(now);
        String PlatformName = request.getParameter("PlatformName");
        String CustomerPhoneNumber = request.getParameter("CustomerPhoneNumber");
        String[] Quantity = request.getParameter("Quantity").split(",");
        String[] ItemName = request.getParameter("ItemName").split(",");

        try {
            service.addCustomer(CustomerName, CustomerPhoneNumber);
            service3.addOrder(service.getCustomerId(CustomerName),OrderId, DateOfPurchase, PlatformName, response);

            for(int i=0;i< ItemName.length; i++) {
                String iid = service1.getItemId(ItemName[i]).get(0);
                service2.addOrderItem(OrderId,iid,Integer.parseInt(Quantity[i]));
                service1.updateItem(Integer.parseInt(Quantity[i]), iid);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
