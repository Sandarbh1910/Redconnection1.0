/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import RCDAO.BloodBankDAO;
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
public class UpdateBloodBankStockServlet extends HttpServlet {

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
        HttpSession httpsess=request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        try  {
            InstitutePOJO institute=(InstitutePOJO)httpsess.getAttribute("loggedInstitute");
           int ap=Integer.parseInt(request.getParameter("ap"));
           int an=Integer.parseInt(request.getParameter("an"));
           int bp=Integer.parseInt(request.getParameter("bp"));
           int bn=Integer.parseInt(request.getParameter("bn"));
           int abp=Integer.parseInt(request.getParameter("abp"));
           int abn=Integer.parseInt(request.getParameter("abn"));
           int op=Integer.parseInt(request.getParameter("op"));
           int on=Integer.parseInt(request.getParameter("on"));
           
           boolean res=BloodBankDAO.updateStock(ap, an, bp, bn, abp, abn, op, on,institute.getId());
           if(res)
           {httpsess.setAttribute("message", "Stocks updated successfully");
        httpsess.setAttribute("dispcol","2");
        response.sendRedirect("bloodbank.jsp");}
           
           else{
               httpsess.setAttribute("message", "Could not update stock at the moment");
        httpsess.setAttribute("dispcol","0");
        response.sendRedirect("bloodbank.jsp");
           }
           
           
        }catch(NumberFormatException ex){ex.printStackTrace();
        httpsess.setAttribute("message", "Stocks are in units (number)");
        httpsess.setAttribute("dispcol","1");
        response.sendRedirect("bloodbank.jsp");}
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
