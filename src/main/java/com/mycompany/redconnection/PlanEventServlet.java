/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import RCDAO.EventsDAO;
import RCHelper.Helper;
import RCHelper.Validations;
import RCPOJO.EventsPOJO;
import RCPOJO.InstitutePOJO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sanda
 */
public class PlanEventServlet extends HttpServlet {

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
        HttpSession httpsess = request.getSession();
        try {
            System.out.println("Reached plan event serv");
            InstitutePOJO i = (InstitutePOJO) httpsess.getAttribute("loggedInstitute");
            String event = request.getParameter("event");
            String organiser = request.getParameter("organiser");
            String venue = request.getParameter("venue");
            String from = request.getParameter("from");
            String till = request.getParameter("till");
            String stime = request.getParameter("stime");
            String etime = request.getParameter("etime");
            String contact = request.getParameter("contact");
            String instype = i.getInstype();
            String email = i.getEmail();
            System.out.println(event+" "+organiser+" "+venue+" "+from+" "+till+" "+contact+" "+stime+" "+etime+" "+email+" "+instype);
            if (event == null || organiser == null || venue == null || from == null || till == null || stime == null || etime == null || contact == null || instype == null || email == null) {
                Helper.setMessage(httpsess, "Login required!", "1");
                response.sendRedirect("login.jsp");
                return;
            }
            
            if (event.isEmpty() || organiser.isEmpty() || venue.isEmpty() || from.isEmpty() || till.isEmpty() || etime.isEmpty() || stime.isEmpty() || contact.isEmpty()) {
                Helper.setMessage(httpsess, "Please fill all the fields!", "1");
                response.sendRedirect("");
                return;
            } 
            else {
                if (!Validations.mobNoValidation(contact)) {
                    Helper.setMessage(httpsess, "Invalid contact number!", "1");
                    if (instype.equalsIgnoreCase("hospital")) {
                        response.sendRedirect("hospital.jsp");
                    } else {
                        response.sendRedirect("bloodbank.jsp");
                    }
                    return;
                }
                EventsPOJO e=new EventsPOJO(event,organiser,venue,contact,from,till,stime,etime,email);
                boolean res=EventsDAO.planEvent(e);
                
                if(res)
                {
                    Helper.setMessage(httpsess, "Event planned successfully!", "2");
                }
                else
                    Helper.setMessage(httpsess,"Could not plan the event!", "1");
                if (instype.equalsIgnoreCase("hospital")) {
                        response.sendRedirect("hospital.jsp");
                    } else {
                        response.sendRedirect("bloodbank.jsp");
                    }
                    return;
                 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
           
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
