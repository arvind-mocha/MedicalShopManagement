package servlets;

import Model.Customer;
import Model.CustomerModel;
import Model.Dealer;
import Model.DealerModel;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealerServlet extends HttpServlet {
    private Dealer service;

    public DealerServlet() throws SQLException, ClassNotFoundException {
        service = new Dealer();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DealerModel> DealerList = new ArrayList<>();
        String query = "select * from DealerDB";
        try {
            DealerList = service.getDealerDetails(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("data",DealerList);
        request.getRequestDispatcher("/Dealer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Name = request.getParameter("DealerName");
        String Number = request.getParameter("DealerNumber");

        try {
            service.addDealer(Name, Number, response);
        } catch (Exception e) {
        }

        response.sendRedirect("/Dealer");
    }
}
