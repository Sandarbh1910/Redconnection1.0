
package com.mycompany.redconnection;

import RCDAO.UserDAO;
import RCHelper.Helper;
import RCHelper.Validations;
import RCPOJO.UserPOJO;
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
public class UserProfileUpdateServlet extends HttpServlet {

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
          String city=request.getParameter("ucity");
          String state=request.getParameter("ustate");
          String country=request.getParameter("ucountry");
          String pincode=request.getParameter("upincode");
          UserPOJO cuser=(UserPOJO)httpsess.getAttribute("loggedUser");
          if(cuser==null)
          {
              httpsess.setAttribute("message","Login Required!");
              httpsess.setAttribute("dispcol","1");
              response.sendRedirect("login.jsp");
               return;
          }
          if(!Validations.mobNoValidation(mob))
          {
              httpsess.setAttribute("message","Invalid mobile number!");
              httpsess.setAttribute("dispcol","1");
              response.sendRedirect("user.jsp");
               return;
          }
          
          
          
          
          if(!Validations.emailValidation(email))
          {
               httpsess.setAttribute("message","Invalid email address!");
              httpsess.setAttribute("dispcol","1");
              response.sendRedirect("user.jsp");
               return;
          }
              
          
          if(!fname.isEmpty()||!lname.isEmpty()||!mob.isEmpty()||!email.isEmpty()||!bgrp.isEmpty()||!rh.isEmpty()||!country.isEmpty())
          {
              //Not null
              UserPOJO user=new UserPOJO(fname,lname,mob,email,dob,bgrp+" "+rh,city,state,country,pincode);
              
              String res=UserDAO.updateUserProfile(user,cuser.getEmail());
              if(res.equalsIgnoreCase("Details updated successfully!"))
              { 
              Helper.setMessage(httpsess, res, "2");
                  System.out.println("email "+email);
              cuser=UserDAO.userLogin(email, cuser.getPassword());
                  System.out.println("cuser "+cuser);
              httpsess.setAttribute("loggedUser", cuser);
              }
              
              else if(res.equalsIgnoreCase("Sorry could not update details"))
              { Helper.setMessage(httpsess, res, "0");}
              
              else if(res.equalsIgnoreCase("Email/Mobile already exists!"))
              {
                   Helper.setMessage(httpsess, res, "1");
              }
          }
          
          else{
              //Empty
             Helper.setMessage(httpsess, "Please fill all the fields!", "1");
          }
          
        }catch(NullPointerException ex){
        Helper.setMessage(httpsess, "Please fill all the fields!", "1");
        }
        
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
