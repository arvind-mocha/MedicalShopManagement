package Model;

import Database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private PreparedStatement stmt;
    private PreparedStatement stmt1;

    // Get Single Or Multiple Customers Detail
    public List<CustomerModel> getCustomerDetails(String query) throws SQLException, ClassNotFoundException {
        Connection con = Database.initializeDatabase();
        stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<CustomerModel> customers = new ArrayList<>();
        while(rs.next()){
            customers.add(new CustomerModel(rs.getInt("CustomerId"),
                    rs.getString("CustomerName"),
                    rs.getString("CustomerNumber"),
                    rs.getString("DateOfPurchase"),
                    rs.getString("PlatformName"),
                    rs.getString("ItemName"),
                    rs.getInt("Quantity")
            ));
        }
        stmt.close();
        con.close();
        return customers;
    }

    // Create a new customer
    public String addCustomer(String CustomerName, String CustomerPhoneNumber ) throws SQLException, ClassNotFoundException {
        Connection con = Database.initializeDatabase();
        stmt = con.prepareStatement("insert into CustomerDB(CustomerName, CustomerNumber) values(?, ?)");
        stmt.setString(1, CustomerName);
        stmt.setString(2, CustomerPhoneNumber);

        stmt.executeUpdate();
        stmt.close();
        con.close();

        return "Customer " + CustomerName + " Has Been added Successfully";
    }

    public int getCustomerId(String Name) throws SQLException, ClassNotFoundException {

        Connection con = Database.initializeDatabase();
        stmt = con.prepareStatement(String.format("select CustomerID from CustomerDB where CustomerName='%s' order by CustomerID desc limit 1", Name));
        ResultSet rs = stmt.executeQuery();
        int id = 0;
        while(rs.next()) {
            id = Integer.parseInt(rs.getString("CustomerId"));
        }
        return id;
    }
}
