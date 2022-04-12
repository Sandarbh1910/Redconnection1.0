/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import RCDAO.UserDAO;
import RCHelper.Validations;
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
public class UserSignupServlet extends HttpServlet {

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
          String fname=request.getParameter("ufname");
          String lname=request.getParameter("ulname");
          String mob=request.getParameter("umob");
          String email=request.getParameter("uemail");
          String dob=request.getParameter("udob");
          String bgrp=request.getParameter("ubloodgrp");
          String rh=request.getParameter("urh");
          String password=request.getParameter("upassword");
          String city=request.getParameter("ucity");
          String state=request.getParameter("ustate");
          String country=request.getParameter("ucountry");
          String pincode=request.getParameter("upincode");
          
          if(!Validations.mobNoValidation(mob))
          {
              httpsess.setAttribute("message","Invalid mobile number!");
              httpsess.setAttribute("dispcol","1");
              response.sendRedirect("signup.jsp");
               return;
          }
          
          if(!Validations.passwordValidation(password))
          {
              httpsess.setAttribute("message","Weak Password! Password should contain atleast one uppercase,lowercase,digit,special character .");
              httpsess.setAttribute("dispcol","1");
              response.sendRedirect("signup.jsp");
              return;
          }
          
          
          if(!Validations.emailValidation(email))
          {
               httpsess.setAttribute("message","Invalid email address!");
              httpsess.setAttribute("dispcol","1");
              response.sendRedirect("signup.jsp");
               return;
          }
              
          
          if(!fname.isEmpty()||!lname.isEmpty()||!mob.isEmpty()||!email.isEmpty()||!bgrp.isEmpty()||!rh.isEmpty()||!password.isEmpty()||!country.isEmpty())
          {
              //Not null
              UserPOJO user=new UserPOJO(fname,lname,mob,email,dob,bgrp+" "+rh,password,city,state,country,pincode);
              String res=UserDAO.signupUser(user);
              if(res.equalsIgnoreCase("Registration successful"))
              { httpsess.setAttribute("message",res);
              httpsess.setAttribute("dispcol","2");}
              
              else if(res.equalsIgnoreCase("Could not register! .Try again later"))
              { httpsess.setAttribute("message",res);
              httpsess.setAttribute("dispcol","0");}
              
              else if(res.equalsIgnoreCase("Email/Mobile already exists!"))
              {
                   httpsess.setAttribute("message",res);
              httpsess.setAttribute("dispcol","1");
              }
          }
          
          else{
              //Empty
              httpsess.setAttribute("message","Please fill all the fields!");
              httpsess.setAttribute("dispcol","0");
          }
          
        }catch(NullPointerException ex){
        httpsess.setAttribute("message","Please fill all the fields!");
              httpsess.setAttribute("dispcol","0");
        }
        
        finally{response.sendRedirect("signup.jsp");}
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
