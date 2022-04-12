/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sanda
 */
public class VerificationServlet extends HttpServlet {

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
        HttpSession httpsess=request.getSession();
        try {
            String otp=(String)httpsess.getAttribute("otp");
            httpsess.removeAttribute("otp");
            String enteredotp=request.getParameter("enteredotp");
            String email=request.getParameter("cpemail");
            System.out.println("on veri serv cpemail "+email);
            if(enteredotp==null||otp==null||email==null)
            {
                 httpsess.setAttribute("message","Service not available for the momment");
               httpsess.setAttribute("dispcol","1");
               response.sendRedirect("passwordassistance.jsp");
            }
            if(otp.equalsIgnoreCase(enteredotp))
            {
                System.out.println("Otp matched email "+email);
               httpsess.setAttribute("cpemail", email);
                response.sendRedirect("createpassword.jsp");
                return;
            }
            else{
                
                httpsess.setAttribute("message","Invalid user!");
               httpsess.setAttribute("dispcol","1");
               response.sendRedirect("passwordassistance.jsp");
            }
        }catch(Exception ex){
        ex.printStackTrace();
        httpsess.setAttribute("message","Service not available for the momment");
               httpsess.setAttribute("dispcol","1");
               response.sendRedirect("passwordassistance.jsp");}
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
