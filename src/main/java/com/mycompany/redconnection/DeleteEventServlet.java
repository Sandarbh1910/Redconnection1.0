/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import RCDAO.EventsDAO;
import RCHelper.Helper;
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
public class DeleteEventServlet extends HttpServlet {

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
        HttpSession httpsess=request.getSession(); InstitutePOJO i=(InstitutePOJO)httpsess.getAttribute("loggedInstitute");
        if(i==null)
            response.sendRedirect("login.jsp");
        try  {
            String eventid=request.getParameter("eventid");
            if(eventid.isEmpty()||eventid==null)
            {
                Helper.setMessage(httpsess, "Invalid request!", "1");
                
                return;
            }
           
            String email=i.getEmail();
            boolean res=EventsDAO.deleteEvent(eventid, email);
            if(res)
            {
                Helper.setMessage(httpsess, "Event discarded successfully!", "1");
            }
            else{
                Helper.setMessage(httpsess, "Could not discard event!", "1");
            }
            
            
            
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(i.getInstype().equalsIgnoreCase("hospital"))
                response.sendRedirect("hospital.jsp");
            else{
                response.sendRedirect("bloodbank.jsp");
            }
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
