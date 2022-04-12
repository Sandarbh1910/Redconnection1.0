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
public class InstituteLoginServlet extends HttpServlet {

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
             String id=request.getParameter("ilogin-id");
            String password=request.getParameter("ilogin-password");
            
            System.out.println(id+" "+password);
            if(!id.isEmpty()||!password.isEmpty())
            {
                //Not Null
           
               
                    InstitutePOJO institute=InstituteDAO.instituteLogin(id, password);
                    System.out.println("institute"+institute);
                     if(institute!=null)
                   { 
                       System.out.println("Security check complete");
                       httpsess.setAttribute("loggedInstitute",institute);
                       response.sendRedirect("institute.jsp");
                       return;
                    
                   }
                     
                     
                   else{
                         httpsess.setAttribute("message","Invalid Id/Password!");
                          httpsess.setAttribute("dispcol","0");
                           response.sendRedirect("login.jsp");
                           return;
                        }
                }
                    
               
         
            
            else{
                //Null
              httpsess.setAttribute("message","Please fill all the fields!");
              httpsess.setAttribute("dispcol","0");
               response.sendRedirect("login.jsp");
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
