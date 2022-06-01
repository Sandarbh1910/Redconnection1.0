/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import RCDAO.BloodDonationResponseDAO;
import RCDAO.UserDAO;
import RCHelper.Helper;
import RCMail.Mailer;
import RCPOJO.InstitutePOJO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class VerifyDonorAtInstituteServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession httpsess=request.getSession();
        try (PrintWriter out = response.getWriter()) {
           String donorotp=request.getParameter("verificationotp");
           String donoremail=request.getParameter("donoremail");
           if(donorotp==null||donoremail==null||donorotp.isEmpty()||donoremail.isEmpty())
           {
               Helper.setMessage(httpsess, "Fields cannot be empty!", "1");
               response.sendRedirect("hospital.jsp");
               return;
           }
           
           
           int donationid=BloodDonationResponseDAO.getDonationId(donoremail,donorotp);
          if(donationid==-1)
          {
              Helper.setMessage(httpsess, "Sorry could not verify at the moment ", "1");
               response.sendRedirect("hospital.jsp");
               return;
          }
            
            httpsess.setAttribute("donorfname",UserDAO.getDonorName(donoremail));
               httpsess.setAttribute("donoremail",donoremail);
               InstitutePOJO i=(InstitutePOJO)httpsess.getAttribute("loggedInstitute");
//               httpsess.setAttribute("institute",i.getName()+" "+i.getCity());
               httpsess.setAttribute("donationid",donationid);
               
               System.out.println("Donationid at verifydonor servlet "+donationid);
               
           if(donationid>-1)
           { 
               String status=BloodDonationResponseDAO.donationResponseStatus(donoremail, donorotp);
               System.out.println("status at verifydonor serv "+status);
            if(status.equalsIgnoreCase("pending"))
            {
                BloodDonationResponseDAO.updateDonationStatus(donoremail, donorotp);
                boolean updatecrstatus=UserDAO.updateHealthCredits(donoremail,5);
                 if(updatecrstatus==false)
               {
                   Helper.setMessage(httpsess, "Sorry Could not verify at the moment!", "1");
                   BloodDonationResponseDAO.deVerifyDonor(donoremail, donorotp);
               response.sendRedirect("hospital.jsp");
               return;
               }
//                 httpsess.setAttribute("donorfname",UserDAO.getDonorName(donoremail));
//               httpsess.setAttribute("donoremail",donoremail);
//                i=(InstitutePOJO)httpsess.getAttribute("loggedInstitute");
//               httpsess.setAttribute("institute",i.getName()+" "+i.getCity());
//               httpsess.setAttribute("donationid",donationid);
               Helper.setMessage(httpsess, "Donor Verified!","2");
               Mailer.sendMail("Verified", "Conrgatulations!\nYou saved a life.\n\nHealth credits will be deposited in your RedConnection account within 48 hours.", donoremail);
               response.sendRedirect("issuecertificate.jsp");
               return;
                 
                 
                 
            }
            
            else if(status.equalsIgnoreCase("verified"))
            {
//                httpsess.setAttribute("donorfname",UserDAO.getDonorName(donoremail));
//               httpsess.setAttribute("donoremail",donoremail);
//                i=(InstitutePOJO)httpsess.getAttribute("loggedInstitute");
//               httpsess.setAttribute("institute",i.getName()+" "+i.getCity());
//               httpsess.setAttribute("donationid",donationid);
//               System.out.println("Already verified at institute");
               Helper.setMessage(httpsess, "Already Verified!!", "1");
               Mailer.sendMail("Verified", "Conrgatulations!\nYou saved a life.\n\nHealth credits will be deposited in your RedConnection account within 48 hours.", donoremail);
               response.sendRedirect("issuecertificate.jsp");
               return;
            }
            
            else{
                Helper.setMessage(httpsess, "Sorry could not verify at the moment ", "1");
               response.sendRedirect("hospital.jsp");
               return;
            }          
               
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
