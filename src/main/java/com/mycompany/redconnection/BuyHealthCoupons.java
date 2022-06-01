/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import RCDAO.HealthCouponsDAO;
import RCDAO.UserDAO;
import RCHelper.Helper;
import RCPOJO.UserPOJO;
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
public class BuyHealthCoupons extends HttpServlet {

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
            String coupontype=request.getParameter("coupontype");
             UserPOJO u=(UserPOJO)httpsess.getAttribute("loggedUser");
            boolean res=false;
             String email=u.getEmail();
            if(coupontype.isEmpty()||coupontype==null||email.isEmpty()||email==null)
            {
                Helper.setMessage(httpsess,"Error!Invalid request", "0");
                response.sendRedirect("user.jsp");
                return;
            }
           int ctype=Integer.parseInt(coupontype);
           
            switch(ctype)
            {
                
                case 1:
                    res=UserDAO.updateHealthCredits(email, -10);
                    
                    break;
                case 2:
                    res=UserDAO.updateHealthCredits(email, -20);
                    
                    break;
                default:
                    Helper.setMessage(httpsess,"Error!Invalid request", "0");
                response.sendRedirect("user.jsp");
                return;
                        
                
            }
            
            if(res)
            {
                Helper.setMessage(httpsess,"Coupon credited to you account", "2");
                if(ctype==1)
                {HealthCouponsDAO.generateCoupon(email, "Free Doctor Consultation");}   
                else if(ctype==2)
                        {HealthCouponsDAO.generateCoupon(email, "Free Blood Test");}
                response.sendRedirect("user.jsp");
                return;
            }
            
            else{
            Helper.setMessage(httpsess,"Insufficient Credits to complete the transaction", "1");
                response.sendRedirect("user.jsp");
                return;}
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
