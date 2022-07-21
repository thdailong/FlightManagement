/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Data.GetData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "FinishBooking", urlPatterns = {"/FinishBooking"})
public class FinishBooking extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String[] FirstName = request.getParameterValues("FirstName");
            String[] LastName = request.getParameterValues("LastName");
            String[] DOB = request.getParameterValues("DOB");
            String[] CCCD = request.getParameterValues("CCCD");
            int seat = Integer.parseInt(request.getParameter("seat"));
            String ScheduleID = request.getParameter("ScheduleID");
            String date = request.getParameter("date");
            
            GetData data = new GetData();
            int seatRemaining = data.getSeatRemainingOnSID_date(ScheduleID, date);
            if (seatRemaining == -1) {
                data.insertSeatRemainingOnSID_date(ScheduleID, date, 200-seat);
            }
            else if (seatRemaining - seat >= 0) {
                data.setSeatRemainingOnSID_date(ScheduleID, date, seatRemaining - seat);
            }
            else {
                response.sendRedirect("index.jsp");
            }
            
            String IDFlight = ScheduleID + "_" + date;
            Date today = new Date();
            String stringtoday = "" + (today.getYear()+1900) + "-";
            if (today.getMonth() < 9) stringtoday+='0';
            stringtoday+=(today.getMonth()+1)+"-";
            if (today.getDate() < 10) stringtoday+='0';
            stringtoday+=today.getDate();
            
            data.insertListTicket(3, stringtoday);
            int IDListTicket = data.getListTicketsNewest();
            
            for (int i = 0; i < seat; ++i) {
                data.insertTicket(IDFlight, FirstName[i], LastName[i], CCCD[i], IDListTicket, DOB[i]);
            }
            
            out.print("DONE");
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
