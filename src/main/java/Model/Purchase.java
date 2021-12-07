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

public class Purchase {
    private PreparedStatement stmt;

    // Get Single Or Multiple Purchase Detail
    public List<PurchaseModel> getPurchaseDetails(String query) throws SQLException, ClassNotFoundException {
        Connection con = Database.initializeDatabase();
        stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<PurchaseModel> purchases = new ArrayList<>();
        while(rs.next()){
            purchases.add(new PurchaseModel(rs.getString("PurchaseId"), rs.getString("DateOfPurchase"), rs.getString("DealerName"), rs.getInt("PurchaseAmount"), rs.getInt("NoOfItems"), rs.getString("Status")));
        }
        stmt.close();
        con.close();
        rs.close();
        return purchases;
    }

    public void addPurchase(String PurchaseId, String DateOfPurchase, String DealerName, int PurchaseAmount, int NoOfItems, String status,  HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        Connection con = Database.initializeDatabase();

        try {
            stmt = con.prepareStatement("insert into PurchaseDB(PurchaseId, DealerName, DateOfPurchase, PurchaseAmount, NoOfItems, status) values(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, PurchaseId);
            stmt.setString(2, DealerName);
            stmt.setString(3, DateOfPurchase);
            stmt.setInt(4, PurchaseAmount);
            stmt.setInt(5, NoOfItems);
            stmt.setString(6, status);
        }catch (Exception e){
            System.out.println("Error");
        }

        stmt.executeUpdate();

        stmt.close();
        con.close();

        PrintWriter out = response.getWriter();
        out.println("New Purchase " + PurchaseId + " Has Been Done Successfully");
    }

    public void updateStatus(String id, String Status, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        Connection con = Database.initializeDatabase();

        stmt = con.prepareStatement(String.format("update PurchaseDB set status='%s' where PurchaseId='%s'",Status,id));
        stmt.executeUpdate();

        con.close();
        stmt.close();
        response.sendRedirect("/Item");
    }
}
