/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import RCDAO.BloodBankDAO;
import RCDAO.InstituteDAO;
import RCHelper.Validations;
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
        try{
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
           String instype=request.getParameter("instype");
           
           if(name==null||email==null||mob==null||password==null||city==null||state==null||country==null||pincode==null||pincode==null||address==null||instype==null)
           {
               httpsess.setAttribute("message","Error!");
              httpsess.setAttribute("dispcol","0");
              response.sendRedirect("signup.jsp");
               return;
           }
           
           if(!Validations.validInstituteType(instype))
           {
               httpsess.setAttribute("message","Invalid institute type!");
              httpsess.setAttribute("dispcol","1");
              response.sendRedirect("signup.jsp");
               return;
           }
           
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
           
           if(!name.isEmpty()||!email.isEmpty()||!mob.isEmpty()||!password.isEmpty()||!address.isEmpty()||!pincode.isEmpty()||!city.isEmpty()||!country.isEmpty()||!state.isEmpty()||!instype.isEmpty())
           {
               if(Validations.passwordValidation(password))
               {
               InstitutePOJO institute=new InstitutePOJO(name,email,mob,password,city,state,country,pincode,address,instype);
               String res=InstituteDAO.signupInstitute(institute);
              
               if(res.equalsIgnoreCase("Registration successful"))
              {
                  if(instype.equalsIgnoreCase("hospital"))
                  {
                       httpsess.setAttribute("message",res);
              httpsess.setAttribute("dispcol","2");
              response.sendRedirect("signup.jsp");return;
                  }
                  
                  else if(instype.equalsIgnoreCase("bloodbank")&&BloodBankDAO.createStock(InstituteDAO.getInstituteId(email)))
              {
                    httpsess.setAttribute("message",res);
              httpsess.setAttribute("dispcol","2");
              response.sendRedirect("signup.jsp");return;
              }
              
              else{
                  InstituteDAO.removeInstitute(email);
                   httpsess.setAttribute("message","Could not register! .Try again later");
              httpsess.setAttribute("dispcol","1");
              response.sendRedirect("signup.jsp");return;
              }
                  
                }
              
              else if(res.equalsIgnoreCase("Could not register! .Try again later"))
              { httpsess.setAttribute("message",res);
              httpsess.setAttribute("dispcol","0");
              response.sendRedirect("signup.jsp");return;}
              
              else if(res.equalsIgnoreCase("Email/Mobile already exists!"))
              {
                   httpsess.setAttribute("message",res);
              httpsess.setAttribute("dispcol","1");
              response.sendRedirect("signup.jsp");
              return;
              }
              
               
           }
           
           else{
               httpsess.setAttribute("message","Please fill all the fields!");
              httpsess.setAttribute("dispcol","0");
              response.sendRedirect("signup.jsp");
              return;
               
           }
           
          
        }
    }catch(NullPointerException ex){
        httpsess.setAttribute("message","Please fill all the fields!");
              httpsess.setAttribute("dispcol","0");
              response.sendRedirect("signup.jsp");
              return;
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
