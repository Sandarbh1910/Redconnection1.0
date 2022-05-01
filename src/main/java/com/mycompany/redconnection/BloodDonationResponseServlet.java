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

/**
 *
 * @author sanda
 */
public class BloodDonationResponseServlet extends HttpServlet {

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
            String bgrp=request.getParameter("bgrp");
            String demail=request.getParameter("demail");
            String institute=request.getParameter("institute");
            String requestno=request.getParameter("reqno");
            System.out.println("req= "+requestno);
            if(bgrp.isEmpty()||demail.isEmpty()||institute.isEmpty()||requestno.isEmpty())
            {
                httpsess.setAttribute("message","Invalid Request");
                httpsess.setAttribute("dispcol","1");
                response.sendRedirect("user.jsp");
                return;
            }
            
            String res=BloodDonationResponseDAO.respondToRequest(Integer.parseInt(requestno), demail, bgrp, institute);
            if(res.equalsIgnoreCase("Responded Successfully,Now remember to visit the institute and donate on time because you chose to be someone's saviour"))
            {
                httpsess.setAttribute("message", res);
                httpsess.setAttribute("dispcol", "2");
            }
            else if(res.equalsIgnoreCase("You already responded to this request"))
            { httpsess.setAttribute("message", res);
                httpsess.setAttribute("dispcol", "1");}
            else{httpsess.setAttribute("message", res);
                httpsess.setAttribute("dispcol", "0");}
        }catch(Exception ex){ex.printStackTrace();}
        finally{response.sendRedirect("user.jsp");}
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
