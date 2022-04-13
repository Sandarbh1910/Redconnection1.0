<%@page import="RCPOJO.InstitutePOJO"%>
<%
    InstitutePOJO institute = (InstitutePOJO) session.getAttribute("loggedInstitute");
    if (institute == null) {
        session.setAttribute("message", "Login Required!");
        session.setAttribute("dispcol", "1");
        response.sendRedirect("login.jsp");
        System.out.println("Login required on verify donor page");
        return;
    }
%><!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="verifydonor.css">
    </head>
    <body>
        <header> <a href="index.jsp"><img src="Icons/red chain img.png" class="logo" alt="">Red Connection</a></header>

        <main>
            <form  id="details-form" action="VerifyDonorServlet" method="POST">
                <h2>Verify Donor</h2>
                <div class="data">
                    <input type="email" name="email" placeholder="Email" required class="input-data">
                    <input type="text" name="donorotp" placeholder="OTP" required class="input-data">

                    <em>Verify the otp sent on donors registered email address.</em>
                </div>
                <input type="submit" id="send-otp-btn" value="Send Otp">
            </form>

        </main>
        <footer>
            <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div>
        </footer>



    </body>
</html>