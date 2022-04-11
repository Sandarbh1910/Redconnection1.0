/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import RCDAO.InstituteDAO;
import RCPOJO.InstitutePOJO;
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
public class InstituteSignupServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
           String name=request.getParameter("iname");
           String email=request.getParameter("iemail");
           String mob=request.getParameter("imob");
           String password=request.getParameter("ipassword");
           String city=request.getParameter("icity");
           String state=request.getParameter("istate");
           String country=request.getParameter("icountry");
           String pincode=request.getParameter("ipincode");
           String address=request.getParameter("iaddress");
           if(!name.isEmpty()||!email.isEmpty()||!mob.isEmpty()||!password.isEmpty()||!address.isEmpty()||!pincode.isEmpty()||!city.isEmpty()||!country.isEmpty()||!state.isEmpty())
           {
               InstitutePOJO institute=new InstitutePOJO(name,email,mob,password,city,state,country,pincode,address);
               boolean res=InstituteDAO.signupInstitute(institute);
                if(res)
              { httpsess.setAttribute("message","Registration successful");
              httpsess.setAttribute("dispcol","2");}
              
              else{ httpsess.setAttribute("message","Could not register!");
              httpsess.setAttribute("dispcol","0");}
               
           }
           
           else{
               httpsess.setAttribute("message","Please fill all the fields!");
              httpsess.setAttribute("dispcol","0");
               
           }
           
           response.sendRedirect("signup.jsp");
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
