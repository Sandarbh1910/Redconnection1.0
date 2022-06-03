<%@page import="RCPOJO.EventsPOJO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="RCDAO.EventsDAO"%>
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
    
 ArrayList<EventsPOJO>elist=EventsDAO.getInstituteEvents(institute.getEmail());

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
      <img src="Icons/verify2.png">
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
   

<form class="redeemform"  action="RedeemHealthCouponServlet">
    <img src="Icons/redeemcoupon.png">
                <h2>Redeem Health Coupon</h2>
               <div class="redeem">
                   <input type="text" class="redeem-input-data" name="email" placeholder="Email">
                   <input type="text" class="redeem-input-data" name="ccode" placeholder="Couponcode">
               
                    <div class="confirm-redeem">
                        <input type="checkbox" id="redeemcouponcheck" onchange="enablebtn()"><b>Select to confirm.</b>
                    </div>
                    
                    
                </div>

<input type="submit" class="redeem-coupon-btn" id="redeem-coupon-btn" value="Continue" disabled>

            </form>
</div>

<input type="radio" name="switch-interface" id="event-interface-radio" class="switch-interface">
<div id="event-interface" class="interface" >
    
    <div class="event">
        <div class="plannedevents">
                <div class="plannedevents-container">
                    <h2>Planned Events</h2>
                    
                    <%
                      if(elist!=null) {  for(EventsPOJO e:elist)
                         {
                    %>
               <details class="plannedevent">
                    <summary class="event"><%=e.getEvent()%> <a href="DeleteEventServlet?eventid=<%=e.getEventid()%>" class="deleteevent">Delete</a></summary>
                   <p><em>Organized by : </em><%=e.getOrganiser()%></p>
                   <p><em>Contact : </em><%=e.getContact()%></p>
                   <p><em>Venue : </em><%=e.getVenue()%></p>
                   <p class="eventduration"><em>From : </em><span><%=e.getFrom()%></span><em>To : </em><span><%=e.getTill()%></span></p>
                   <p><em>Time : </em><span><%=e.getStime()+" - "+e.getEtime()%></span></p>
                   </details>
                   <%
                       }}
                   %>
                   
                </div>
            </div> 
    </div>
    
    
     <form class="planevent"  action="PlanEventServlet">
                <h2>Plan Event</h2>
               <div class="eventform">
                   <input type="text" class="planevent-data" name="event" placeholder="Event">
                   <input type="text" class="planevent-data" name="organiser" placeholder="Organizer">
                   <textarea  placeholder="Venue" id="" cols="30" rows="4" name="venue" class="planevent-data"></textarea>
                   <input type="mob" class="planevent-data"  name="contact" placeholder="Contact">
                   <div class="pdate">
                       <span >From</span>
                       <span >To</span>
                       <input type="date" name="from" class="pdated" >
                       <input type="date"  name="till" class="pdated">
                    </div>
                       <div class="ptime">
                        <p>Time</p>
                        <input type="time" class="ptimed" name="stime">
                        <input type="time" class="ptimed" name="etime">
                       </div>
                       
               
                    <div class="confirm-event">
                        <input type="checkbox" id="planeventcheck" onchange="enableplaneventbtn()"><b>Select to confirm.</b>
                    </div>
                    <input type="submit" class="plan-event-btn" id="plan-event-btn" value="Continue" disabled>
                    
                </div>



            </form>

            


    

</div>

<footer> <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div></footer>
    </main>
    
    
        <script>
            function enablebtn()
            {
                let check=document.getElementById('redeemcouponcheck');
                        let btn=document.getElementById('redeem-coupon-btn');
                        
                        btn.disabled=!check.checked;
                        console.log('btn is'+btn.disabled);
                        
                        if(btn.disabled)
                        {
                            console.log('to light maroon');
                            btn.style.backgroundColor='#f36666';
                        }
                        else {
                            btn.style.backgroundColor='#d94645';
                             console.log('to maroon');
                        }
            }
            
            
            
              function enableplaneventbtn()
            {
                let check=document.getElementById('planeventcheck');
                        let btn=document.getElementById('plan-event-btn');
                        
                        btn.disabled=!check.checked;
                        console.log('btn is'+btn.disabled);
                        
                        if(btn.disabled)
                        {
                            console.log('to light maroon');
                            btn.style.backgroundColor='#f36666';
                        }
                        else {
                            btn.style.backgroundColor='#d94645';
                             console.log('to maroon');
                        }
            }
            
            
            </script>
</body>
</html>
