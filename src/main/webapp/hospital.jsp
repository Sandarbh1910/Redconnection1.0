<%@page import="RCPOJO.InstitutePOJO"%>
<%
    InstitutePOJO institute=(InstitutePOJO)session.getAttribute("loggedInstitute");
    if(institute==null)
    {
        session.setAttribute("message", "Login Required!");
    session.setAttribute("dispcol","1");
    response.sendRedirect("login.jsp");
    System.out.println("Login required on user page");
    return;
    }
    
 

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="CSS/hospital.css">
</head>
<body>
    <%@include file="message.jsp" %>
    <header><img class="logo" src="Icons/red chain img.png" alt="">Red Connection</header>
    <nav>
         <img src="Icons/red chain img.png" alt="" class="navlogo">
         <div class="nav-container">
             
            <label for="verify-interface-radio" class="navtab" title="Verify Donor"><img src="Icons/donate.png" alt="">Verify Donor</label>
            <label for="redeemcoupon-interface-radio" class="navtab" title="Health Coupons"><img src="Icons/coupon3.png" alt="">Health Coupons</label>
            <label for="event-interface-radio" class="navtab" title="Plan Events"><img src="Icons/planevent.png" alt="">Plan Events</label>
         </div>
         <div class="user"><img src="Icons/usergrey.png" class="prof-icon" alt="">
            <ul class="user-drp-dwn">
                <li class="user-opt"><a href="instituteprofile.jsp">Profile</a></li>
                <li class="user-opt"><a href="passwordassistance.jsp">Change Password</a></li>
                <hr>
                <li class="user-opt"><a href="LogoutServlet">Sign Out</a></li>
            </ul></div>
         
    </nav>


    <main>
<input type="radio"  checked name="switch-interface" id="verify-interface-radio" class="switch-interface">
<div id="verify-interface" class="interface">
    
  <form  method="POST" action="VerifyDonorAtInstituteServlet" id="verifydonor-form">
            <h2>Verify Donor</h2>
            <div class="data">
                <input type="email" name="donoremail" placeholder="Email" required class="verify-data">
                <input type="password" name="verificationotp" placeholder="OTP" required class="verify-data">
               
                <div><em>Verify the otp sent on donors registered email address.</em></div>
            </div>
           <input type="submit" id="verify-otp-btn" value="Verify">
        </form>
</div>

<input type="radio" name="switch-interface" id="redeemcoupon-interface-radio" class="switch-interface">
<div id="redeemcoupon-interface" class="interface" >
   
Redeem
</div>

<input type="radio" name="switch-interface" id="event-interface-radio" class="switch-interface">
<div id="event-interface" class="interface" >


       
    Events
    

</div>

<footer> <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div></footer>
    </main>
</body>
</html>
