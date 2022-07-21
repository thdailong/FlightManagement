/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Data.GetData;
import Entity.Airport;
import Entity.Flight;
import Entity.Schedule;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ChooseFlight", urlPatterns = {"/ChooseFlight"})
public class ChooseFlight extends HttpServlet {

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

            int from = Integer.parseInt(request.getParameter("from"));
            int to = Integer.parseInt(request.getParameter("to"));
            String date = request.getParameter("date");
            int seat = Integer.parseInt(request.getParameter("seat"));

            GetData data = new GetData();
            ArrayList<Airport> ArrAirport = data.getAirport();
            for (int i = 0; i < ArrAirport.size(); ++i) {
                if (ArrAirport.get(i).getID() == from) {
                    request.setAttribute("FROM", ArrAirport.get(i).getName());
                } else if (ArrAirport.get(i).getID() == to) {
                    request.setAttribute("TO", ArrAirport.get(i).getName());
                }
            }

            ArrayList<Schedule> ArrSchedule = data.getSchedule(from, to);
            ArrayList<Flight> ArrFlight = data.getAllFlightOnDate(date);
            ArrayList<Integer> SeatRemaining = new ArrayList<Integer>();

            for (int i = 0; i < ArrSchedule.size(); ++i) {
                int tmp = 200;

                for (int j = 0; j < ArrFlight.size(); ++j) {
                    if (ArrSchedule.get(i).getID() == ArrFlight.get(j).getIDSchedule()) {
                        tmp = ArrFlight.get(j).getSeatRemaining();
                        break;
                    }
                }

                SeatRemaining.add(tmp);
            }

            request.setAttribute("ArrSchedule", ArrSchedule);
            request.setAttribute("SeatRemaining", SeatRemaining);
            
            request.getRequestDispatcher("ChooseFlight.jsp").forward(request, response);
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
