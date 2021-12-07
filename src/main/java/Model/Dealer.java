package Model;

import Database.Database;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private PreparedStatement stmt;

    public List<DealerModel> getDealerDetails(String query) throws SQLException, ClassNotFoundException {
        Connection con = Database.initializeDatabase();
        stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<DealerModel> dealers = new ArrayList<>();
        while(rs.next()){
            dealers.add(new DealerModel(rs.getString("DealerName"), rs.getString("DealerNumber")));
        }
        stmt.close();
        con.close();
        return dealers;
    }

    public void addDealer(String DealerName, String DealerPhoneNumber, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        Connection con = Database.initializeDatabase();
        stmt = con.prepareStatement("insert into DealerDB(DealerName, DealerNumber) values(?, ?)");
        stmt.setString(1, DealerName);
        stmt.setString(2, DealerPhoneNumber);

        stmt.executeUpdate();

        stmt.close();
        con.close();
    }
}
