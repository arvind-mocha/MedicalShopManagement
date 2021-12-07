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

public class Item {
    private PreparedStatement stmt;

    public List<ItemModel> getItemDetails(String query) throws SQLException, ClassNotFoundException {
        Connection con = Database.initializeDatabase();
        stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<ItemModel> items = new ArrayList<>();
        while(rs.next()){
            items.add(new ItemModel(rs.getString("ItemName"), rs.getString("ExpiryDate"), rs.getString("PurchaseId"),
                                    rs.getString("ItemId"), rs.getInt("PricePerUnit"), rs.getInt("AvailableStock")));
        }
        stmt.close();
        con.close();
        return items;
    }

    public void addItem(String ItemName, String ExpiryDate, String PurchaseId, String ItemId, int PricePerUnit, int AvailableStock, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        Connection con = Database.initializeDatabase();
        stmt = con.prepareStatement("insert into ItemDB(ItemName, ExpiryDate, PurchaseId, ItemId, PricePerUnit, AvailableStock) values(?, ?, ?, ?, ?, ?)");
        stmt.setString(1, ItemName);
        stmt.setString(2, ExpiryDate);
        stmt.setString(3, PurchaseId);
        stmt.setString(4, ItemId);
        stmt.setInt(5,PricePerUnit);
        stmt.setInt(6,AvailableStock);

        stmt.executeUpdate();

        stmt.close();
        con.close();

        PrintWriter out = response.getWriter();
        out.println("New Item " + ItemName + " has been Successfully Added");
    }

    public void updateItem(int Quantity, String ItemId) throws SQLException, ClassNotFoundException {
        Connection con = Database.initializeDatabase();
        stmt = con.prepareStatement(String.format("select AvailableStock from ItemDB where ItemId='%s'",ItemId));
        ResultSet rs = stmt.executeQuery();
        int quantity = 0;
        if(rs.next()){
            quantity = rs.getInt("AvailableStock") - Quantity;
        }
        stmt = con.prepareStatement(String.format("update ItemDB set AvailableStock ='%d' where ItemId = '%s' ",quantity,ItemId));
        stmt.executeUpdate();
        stmt.close();
        con.close();
        rs.close();
    }

    public ArrayList<String> getItemId(String ItemId) throws SQLException, ClassNotFoundException {
        Connection con = Database.initializeDatabase();
        stmt = con.prepareStatement(String.format("select ItemId from ItemDB where ItemName= '%s' ",ItemId));
        ResultSet rs = stmt.executeQuery();
        ArrayList<String> Items = new ArrayList<>();
        while(rs.next()){
            Items.add(rs.getString("ItemId"));
        }
        stmt.close();
        con.close();

        return Items;
    }
}
