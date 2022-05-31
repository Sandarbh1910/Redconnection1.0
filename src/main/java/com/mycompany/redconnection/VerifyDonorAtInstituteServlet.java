/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import RCDAO.BloodDonationResponseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class VerifyDonorAtInstituteServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession httpsess=request.getSession();
        try (PrintWriter out = response.getWriter()) {
           String donorotp=request.getParameter("verificationotp");
           String donoremail=request.getParameter("donoremail");
           if(donorotp==null||donoremail==null||donorotp.isEmpty()||donoremail.isEmpty())
           {
                httpsess.setAttribute("message","Fields cannot be empty!");
               httpsess.setAttribute("dispcol","1");
               response.sendRedirect("hospital.jsp");
               return;
           }
           
           
           String res=BloodDonationResponseDAO.verifyDonorAtInstitute(donoremail,donorotp);
           
           if(res.equalsIgnoreCase("Donor Verified"))
           {
                httpsess.setAttribute("message",res);
               httpsess.setAttribute("dispcol","2");
               response.sendRedirect("hospital.jsp");
               return;
           }
           else {
                httpsess.setAttribute("message",res);
               httpsess.setAttribute("dispcol","1");
               response.sendRedirect("hospital.jsp");
               return;
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
