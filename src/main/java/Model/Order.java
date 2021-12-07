package Model;

import Database.Database;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private PreparedStatement stmt;
    private PreparedStatement stmt1;

    public List<OrderModel> getCustomerDetails(String query) throws SQLException, ClassNotFoundException {
        Connection con = Database.initializeDatabase();
        stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<OrderModel> orders = new ArrayList<>();
        while(rs.next()){
            orders.add(new OrderModel(rs.getInt("CustomerId"), rs.getString("OrderId"), rs.getString("DateOfPurchase"), rs.getString("PlatformName")));
        }
        stmt.close();
        con.close();
        rs.close();
        return orders;
    }

    public void addOrder(int CustomerId, String OrderId, String DateOfPurchase, String PlatformName, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        Connection con = Database.initializeDatabase();
        try {
            stmt1 = con.prepareStatement("insert into OrderDB(CustomerId, OrderId, DateOfPurchase, PlatformName) values(?, ?, ?, ?)");
            stmt1.setInt(1, CustomerId);
            stmt1.setString(2, OrderId);
            stmt1.setString(3, DateOfPurchase);
            stmt1.setString(4, PlatformName);
            stmt1.executeUpdate();
        }catch (Exception e){
            System.out.println("Error");
        }


        stmt1.close();
        con.close();
    }
}
