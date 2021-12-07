package Model;

import Database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderedItem {
    private PreparedStatement stmt;

    public void addOrderItem(String OrderId, String ItemId, int Quantity) throws SQLException, ClassNotFoundException {
        Connection con = Database.initializeDatabase();

        try {
            stmt = con.prepareStatement("insert into OrderedItemsDB(OrderId, ItemId, Quantity) values(?, ?, ?)");
            stmt.setString(1, OrderId);
            stmt.setString(2, ItemId);
            stmt.setInt(3, Quantity);
        } catch (Exception e) {
            System.out.println("Error");
        }

        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

}
