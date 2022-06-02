/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redconnection;

import RCDAO.BloodBankDAO;
import RCDAO.InstituteDAO;
import RCDAO.UserDAO;
import RCHelper.Helper;
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
public class InstituteProfileUpdateServlet extends HttpServlet {

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

        //
        response.setContentType("text/html;charset=UTF-8");
        HttpSession httpsess = request.getSession();
        try {
            /* TODO output your page here. You may use following sample code. */
            String name = request.getParameter("iname");
            String email = request.getParameter("iemail");
            String mob = request.getParameter("imob");
            String city = request.getParameter("icity");
            String state = request.getParameter("istate");
            String country = request.getParameter("icountry");
            String pincode = request.getParameter("ipincode");
            String address = request.getParameter("iaddress");
            InstitutePOJO currentinstitute = (InstitutePOJO) httpsess.getAttribute("loggedInstitute");

            if (currentinstitute == null) {
                Helper.setMessage(httpsess, "Login required!", "1");
                response.sendRedirect("login.jsp");
                return;
            }
            String instype = currentinstitute.getInstype();
            String currentemail = currentinstitute.getEmail();
            if (name == null || email == null || mob == null || city == null || state == null || country == null || pincode == null || pincode == null || address == null) {

                Helper.setMessage(httpsess, "Error!", "0");
                response.sendRedirect("signup.jsp");
                return;
            }

            if (!Validations.mobNoValidation(mob)) {
                Helper.setMessage(httpsess, "Invalid mobile number!", "1");
                response.sendRedirect("signup.jsp");
                return;
            }

            if (!Validations.emailValidation(email)) {

                Helper.setMessage(httpsess, "Invalid email address!", "1");
                response.sendRedirect("signup.jsp");
                return;
            }

            if (!name.isEmpty() || !email.isEmpty() || !mob.isEmpty() || !address.isEmpty() || !pincode.isEmpty() || !city.isEmpty() || !country.isEmpty() || !state.isEmpty()) {

                InstitutePOJO institute = new InstitutePOJO(name, email, mob, city, state, country, pincode, address);
                String res = InstituteDAO.updateInstituteDetails(institute, currentemail);

                if (res.equalsIgnoreCase("Details updated successfully!")) {
                    Helper.setMessage(httpsess, res, "2");
                    currentinstitute=InstituteDAO.instituteLogin(email, currentinstitute.getPassword());
                  System.out.println("cuser "+currentinstitute);
              httpsess.setAttribute("loggedInstitute", currentinstitute);

                } else if (res.equalsIgnoreCase("Sorry could not update details")) {
                    Helper.setMessage(httpsess, res, "0");

                } else if (res.equalsIgnoreCase("Email/Mobile already exists!")) {
                    Helper.setMessage(httpsess, res, "1");

                }
                if (instype.equalsIgnoreCase("bloodbank")) {
                    response.sendRedirect("bloodbank.jsp");
                } else {
                    response.sendRedirect("hospital.jsp");
                }
                return;
            }
        } catch (NullPointerException ex) {
            Helper.setMessage(httpsess, "Error!", "0");

            response.sendRedirect("login.jsp");
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
