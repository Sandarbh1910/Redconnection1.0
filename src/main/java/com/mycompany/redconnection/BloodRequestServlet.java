/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import RCDAO.BloodRequestDAO;
import RCPOJO.BloodRequestPOJO;
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
public class BloodRequestServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            UserPOJO u=(UserPOJO)httpsess.getAttribute("loggedUser");
            String email = u.getEmail();
            String mob = u.getMob();
            String institute = request.getParameter("institute");
            String icity = request.getParameter("icity");
            String istate = request.getParameter("istate");
            String icountry = request.getParameter("icountry");
            String ipincode = request.getParameter("ipincode");
            String grp = request.getParameter("grp");
            String rh = request.getParameter("rh");
            String units = request.getParameter("units");
            String date = request.getParameter("date");
            String purpose = request.getParameter("purpose");
            System.out.println(", email=" + email + ", mob=" + mob + ", institute=" + institute + ", icity=" + icity + ", istate=" + istate + ", icountry=" + icountry + ", ipincode=" + ipincode + ", bgrp=" + grp + ", units=" + units + ", date=" + date + ", purpose=" + purpose );
            if (email == null || mob == null || institute == null || icity == null || istate == null || icountry == null || ipincode == null || grp == null || rh == null || units == null || date == null || purpose == null ) {

                httpsess.setAttribute("message", "Fields cannot be left blank!");
                httpsess.setAttribute("dispcol", "1");
                response.sendRedirect("user.jsp");
                return;
            }

            String bloodgrp = grp + " " + rh;
            BloodRequestPOJO breq = new BloodRequestPOJO(email, mob, institute, icity, istate, icountry, ipincode, bloodgrp, units, date, purpose);
            
            boolean res=BloodRequestDAO.submitRequest(breq);
            if(res)
            {
                httpsess.setAttribute("message", "Request Submitted!");
                httpsess.setAttribute("dispcol", "5");
                response.sendRedirect("user.jsp");
                return;
            }
            else{httpsess.setAttribute("message", "Could not submit request!!");
                httpsess.setAttribute("dispcol", "1");
                response.sendRedirect("user.jsp");
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
