package servlets;

import Model.*;
import com.google.gson.Gson;
import org.json.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseHistoryServlet extends HttpServlet {
    private Purchase service;
    private Dealer service1;

    public PurchaseHistoryServlet() throws SQLException, ClassNotFoundException {
        service = new Purchase();
        service1 = new Dealer();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PurchaseModel> PurchaseList = new ArrayList<>();
        List<DealerModel> DealerList = new ArrayList<>();
        String DealerName = request.getParameter("DealerName");
        String Status = request.getParameter("Status");
        String DateOfPurchase = request.getParameter("DateOfPurchase");
        String query = "select * from PurchaseDB";
       if(Status != null && Status != ""){
            query = String.format("select * from PurchaseDB where Status= '%s'", Status);
        }else if(DateOfPurchase != null && DateOfPurchase!= ""){
            query = String.format("select * from PurchaseDB where DateOfPurchase= '%s'", DateOfPurchase);
        }else if(DealerName != null && DealerName != "") {
            query = String.format("select * from PurchaseDB where DealerName= '%s'", DealerName);
        }

        try {
            PurchaseList = service.getPurchaseDetails(query);
            DealerList = service1.getDealerDetails("select * from DealerDB");
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("PurchaseList",PurchaseList);
        request.setAttribute("DealerList",DealerList);
        request.getRequestDispatcher("/PurchaseHistory.jsp").forward(request, response);
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String data = br.readLine();
        JSONObject json = new JSONObject(data);
        try {
            service.updateStatus(json.getString("id"), json.getString("msg"), resp);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
