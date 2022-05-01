/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import RCDAO.InstituteDAO;
import RCDAO.UserDAO;
import RCHelper.Helper;
import RCMail.Mailer;
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
public class PasswordAssistanceServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
           String email=request.getParameter("email");
           String usertype=request.getParameter("usertype");
            System.out.println("email "+email+" usertype "+usertype);
           if(email==null)
           {
               httpsess.setAttribute("message","Field cannot be empty!");
               httpsess.setAttribute("dispcol","1");
               response.sendRedirect("passwordassistance.jsp");
           }
           
           if(usertype==null)
           {
                httpsess.setAttribute("message","Invalid user!");
               httpsess.setAttribute("dispcol","1");
               response.sendRedirect("passwordassistance.jsp");
               return;
           }
           httpsess.setAttribute("cpusertype", usertype);
            System.out.println("Passed empty email and user validation");
           boolean trueuser;
           int otp;
           if(usertype.equalsIgnoreCase("user"))
           {
               
               trueuser=UserDAO.getUserEmail(email);
               
               System.out.println(" user trueuser var "+trueuser);
               if(trueuser)
               {
                   httpsess.setAttribute("verificationfor","password");
                   otp=Mailer.sendOTP("Password Change", email);
                   httpsess.setAttribute("otp",String.valueOf(otp));
                    httpsess.setAttribute("cpemail",email);
                   response.sendRedirect("verification.jsp");
                   return;
               }
           }
           else if(usertype.equalsIgnoreCase("institute"))
           {
               trueuser=InstituteDAO.getInstituteEmail(email);
               System.out.println("inst trueuser var "+trueuser);
                if(trueuser)
               {
                   otp=Mailer.sendOTP("Password Change", email);
                   httpsess.setAttribute("cpemail",email);
                   httpsess.setAttribute("otp",String.valueOf(otp));
                   response.sendRedirect("verification.jsp");
                   return;
               }
           }
           httpsess.setAttribute("message","No such user found!");
                   httpsess.setAttribute("dispcol","1");
           response.sendRedirect("passwordassistance.jsp");
           
           
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
