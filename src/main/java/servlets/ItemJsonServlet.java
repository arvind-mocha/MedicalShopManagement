package servlets;

import Model.Item;
import Model.ItemModel;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ItemJsonServlet", value = "/ItemJsonServlet")
public class ItemJsonServlet extends HttpServlet {
    private Item service;

    public ItemJsonServlet(){
        service = new Item();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ItemModel> ItemList = new ArrayList<>();
        String PurchaseId = request.getParameter("PurchaseId");
        String ItemId = request.getParameter("ItemId");
        String ItemName = request.getParameter("ItemName");
        String ExpiryDate = request.getParameter("ExpiryDate");
        String query = "select * from ItemDB inner join PurchaseDB on ItemDB.PurchaseId = PurchaseDB.PurchaseId where PurchaseDB.status = 'Success'";
        if(PurchaseId != null && PurchaseId !="") {
            query = query + String.format(" and PurchaseId='%s'", PurchaseId);
        }else if(ItemName != null && ItemName !="") {
            query = query + String.format(" and ItemName='%s'", ItemName);
        }else if(ItemId != null && ItemId != ""){
            query = query + String.format(" and ItemId= '%s'", ItemId);
        }else if(ExpiryDate != null && ExpiryDate != ""){
            query = query + String.format(" and ExpiryDate= '%s'", ExpiryDate);
        }

        try {
            ItemList = service.getItemDetails(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create A New Servlet And Respond this
        String ItemJson = new Gson().toJson(ItemList);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(ItemJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
