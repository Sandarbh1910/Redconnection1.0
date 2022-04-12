
package com.mycompany.redconnection;

import RCDAO.InstituteDAO;
import RCDAO.UserDAO;
import RCHelper.Validations;
import RCMail.Mailer;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sanda
 */
public class CreatePasswordServlet extends HttpServlet {

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
           String email=request.getParameter("email");
           String password=request.getParameter("password");
           String retypedpassword=request.getParameter("retypedpassword");
           String usertype=(String)httpsess.getAttribute("cpusertype");
            System.out.println("On create pass serv email "+email+" password "+password+" retype "+retypedpassword+" usertype "+usertype);
           if(email==null||password==null||usertype==null||retypedpassword==null)
           {
               httpsess.setAttribute("message","Fields cannot be empty!");
               httpsess.setAttribute("dispcol","1");
               httpsess.removeAttribute("cpemail");
               response.sendRedirect("passwordassistance.jsp");
               return;
           }
           
           if(!retypedpassword.equals(password))
           {
                httpsess.setAttribute("cpemail", email);
                httpsess.setAttribute("message","Passwords do not match!");
               httpsess.setAttribute("dispcol","1");
               response.sendRedirect("createpassword.jsp");
               return;
           }
           
           if(!Validations.passwordValidation(password))
           {
                httpsess.setAttribute("cpemail", email);
                httpsess.setAttribute("message","Weak Password! Password should contain atleast one uppercase,lowercase,digit,special character .");
               httpsess.setAttribute("dispcol","1");
               response.sendRedirect("createpassword.jsp");
               return;
           }
           
           String res;
           switch(usertype)
           {
               case "user":
                    res=UserDAO.createNewPassword(email, password);
                   break;
               case "institute":
                    res=InstituteDAO.createNewPassword(email, password);
                   break;
               default:
                    httpsess.removeAttribute("cpemail");
               response.sendRedirect("passwordassistance.jsp");
               return;
           }
           
           
         switch(res)
         {
             case "Password Change Successfuly":
                  httpsess.removeAttribute("cpemail");
                  httpsess.setAttribute("message",res);
               httpsess.setAttribute("dispcol","2");
               LocalDateTime dt=LocalDateTime.now();
               DateTimeFormatter dtformat=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
               Mailer.sendMail("Password Changed","Your request of changing password has been successfully processed on "+dt.format(dtformat), email) ;
               response.sendRedirect("login.jsp");
                 break;
                  
             default:
                 httpsess.removeAttribute("cpemail");
                 httpsess.setAttribute("message",res);
               httpsess.setAttribute("dispcol","0");
                 response.sendRedirect("login.jsp");
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
