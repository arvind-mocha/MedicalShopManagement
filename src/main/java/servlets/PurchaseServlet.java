package servlets;

import Model.*;
import com.google.gson.Gson;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.ws.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PurchaseServlet extends HttpServlet {
    private Purchase service;
    private Item service1;
    private Dealer service2;

    public PurchaseServlet() throws SQLException, ClassNotFoundException {
        service = new Purchase();
        service1 = new Item();
        service2 = new Dealer();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DealerModel> DealerList = new ArrayList<>();

        try {
            DealerList = service2.getDealerDetails("select * from DealerDB");
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("DealerList",DealerList);
        request.getRequestDispatcher("/Purchase.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String data = br.readLine();
        JSONObject json = new JSONObject(data);

        String PurchaseId = "PId" + UUID.randomUUID().toString();
        String DateOfPurchase = json.getString("date");
        String DealerName = json.getString("dealer");
        String[] ItemName = json.getString("name").split(",");
        String[] ExpiryDate = json.getString("expiry").split(",");
        String[] PricePerUnit = json.getString("price").split(",");
        String[] AvailableStock = json.getString("quantity").split(",");


        int totalAmount = 0;
        int count;
        for(count=0; count< PricePerUnit.length; count++){
            totalAmount += (Integer.parseInt(PricePerUnit[count])*Integer.parseInt(AvailableStock[count]));
        }

        try {
            service.addPurchase(PurchaseId, DateOfPurchase , DealerName, totalAmount, count, "Pending",  response);
            for(int i=0;i< ItemName.length; i++) {
                String ItemId = "IId" + UUID.randomUUID().toString();
                service1.addItem(ItemName[i], ExpiryDate[i], PurchaseId, ItemId, Integer.parseInt(PricePerUnit[i]), Integer.parseInt(AvailableStock[i]), response);
            }
            System.out.println(DateOfPurchase);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
