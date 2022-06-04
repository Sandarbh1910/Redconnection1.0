<%@page import="RCPOJO.EventsPOJO"%>
<%@page import="RCDAO.EventsDAO"%>
<%@page import="RCHelper.Helper"%>
<%@page import="RCPOJO.HealthCouponsPOJO"%>
<%@page import="RCPOJO.HealthCouponsPOJO"%>
<%@page import="RCDAO.HealthCouponsDAO"%>
<%@page import="RCDAO.BloodBankDAO"%>
<%@page import="RCPOJO.BloodBankPOJO"%>
<%@page import="RCDAO.BloodRequestDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="RCPOJO.BloodRequestPOJO"%>
<%@page import="RCPOJO.UserPOJO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    UserPOJO user=(UserPOJO)session.getAttribute("loggedUser");
    if(user==null)
    {
        session.setAttribute("message", "Login Required!");
    session.setAttribute("dispcol","1");
    response.sendRedirect("login.jsp");
    System.out.println("Login required on user page");
    return;
    }
    
   
    ArrayList<BloodRequestPOJO>breqlist=null;
    ArrayList<BloodBankPOJO>banklist=null;
String region=request.getParameter("region");


if(region==null||region.equalsIgnoreCase("country"))
{
    banklist=BloodBankDAO.loadBanksByCountry(user.getCountry());
    breqlist=BloodRequestDAO.loadBloodRequestByCountry(user.getCountry());
}

else if(region.equalsIgnoreCase("state"))
{
    banklist=BloodBankDAO.loadBanksByState(user.getState(), user.getCountry());
    breqlist=BloodRequestDAO.loadBloodRequestByState(user.getState(),user.getCountry());
}

else if(region.equalsIgnoreCase("city"))
{
    banklist=BloodBankDAO.loadBanksByCity(user.getCity(), user.getState(), user.getCountry());
    breqlist=BloodRequestDAO.loadBloodRequestByCity(user.getCity(), user.getState(),user.getCountry());
}

else if(region.equalsIgnoreCase("area"))
{
    banklist=BloodBankDAO.loadBanksByArea(user.getPincode());
    breqlist=BloodRequestDAO.loadBloodRequestByArea(user.getPincode());
}

else{
     banklist=BloodBankDAO.loadBanksByState(user.getState(), user.getCountry());
    breqlist=BloodRequestDAO.loadBloodRequestByCountry(user.getCountry());
}


//Fetching user health coupons

ArrayList<HealthCouponsPOJO> couponlist=HealthCouponsDAO.getUserCouponList(user.getEmail());



%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="CSS/user.css">
</head>
<body>
    <%@include file="message.jsp" %>
    <header><img class="logo" src="Icons/red chain img.png" alt="">Red Connection</header>
    <nav>
         <img src="Icons/red chain img.png" alt="" class="navlogo">
         <div class="nav-container">
             
            <label for="donate-interface-radio" class="navtab" title="Donate"><img src="Icons/donate.png" alt="">Donate</label>
            <label for="seek-interface-radio" class="navtab" title="Request Blood"><img src="Icons/bloodsearchgrey.png" alt="">Seek</label>
            <label for="coupons-interface-radio" class="navtab" title="Vouchers"><img src="Icons/coupon3.png" alt="">Coupons</label>
         </div>
         <div class="user"><img src="Icons/usergrey.png" class="prof-icon" alt="">
            <ul class="user-drp-dwn">
                <li class="user-opt"><a href="userprofile.jsp">Profile</a></li>
                <li class="user-opt"><a href="passwordassistance.jsp">Change Password</a></li>
                <hr>
                <li class="user-opt"><a href="LogoutServlet">Sign Out</a></li>
            </ul></div>
         
    </nav>


    <main>
<input type="radio"  checked name="switch-interface" id="donate-interface-radio" class="switch-interface">
<div id="donate-interface" class="interface">
    <div class="request-container">
        <fieldset class="region-filter">
        <legend>Region</legend>
        <a href="user.jsp?region=country" class="country region">Country</a>
        <a href="user.jsp?region=state" class="state region">State</a>
        <a href="user.jsp?region=city" class="city region">City</a>
         <a href="user.jsp?region=area" class="area region">Area</a>
    </fieldset>
    <h3>Requests</h3>
<ul class="request-list">
    <%
        if(breqlist!=null){
        for(BloodRequestPOJO breq:breqlist)
        {
            %>
    <li class="request">
    <details>
        <summary>Request id : <%=breq.getReqno()%> <i><%=breq.getIcity()+", "+breq.getIstate()+", "+breq.getIcountry()+"- "+breq.getIpincode()%></i><a href="BloodDonationResponseServlet?reqno=<%=breq.getReqno()%>&bgrp=<%=user.getBloodgrp()%>&demail=<%=user.getEmail()%>&institute=<%=breq.getInstitute()+" "+breq.getIcity()+", "+breq.getIstate()+", "+breq.getIcountry()+"- "+breq.getIpincode()%>" class="respond-btn">Respond</a></summary>
        <div>Institute Address&nbsp;:&nbsp;<%=breq.getInstitute()+" "+breq.getIcity()+", "+breq.getIstate()+", "+breq.getIcountry()+"- "+breq.getIpincode()%> </div>
        <div>Units&nbsp;:&nbsp;<%=breq.getUnits()%></div>
        <div>Purpose&nbsp;:&nbsp;<%=breq.getPurpose()%></div>

    </details>
</li>
    <%
        }}
    %>


</ul>
</div>

<div class="info-container">
<ul class="bblist">
    <h3 class="info-title">Blood Banks</h3>
    <%
        
        if(banklist!=null){
        for(BloodBankPOJO b:banklist)
        {
            %>
    
    
     <li class="bank">
        <details>
            <summary class="bank-name"><%=b.getName()%></summary>
            <div class="bank-address"><b>Address&nbsp;:&nbsp;</b><i><%=b.getAddress()+", "+b.getCity()+", "+b.getState()+", "+b.getCountry()+"- "+b.getPincode()%></i></div>
            <div class="bank-contact"><b>Email&nbsp;:&nbsp;</b><i><%=b.getEmail()%> </i></div>
            <div class="bank-contact"><b>Contact&nbsp;:&nbsp;</b><i><%=b.getMob()%></i></div>
            <details class="bstock">
                <summary>Stock</summary>
                <table>
                    <th>Blood Group</th><th>Rh</th><th>Units</th>
                    <tr><td>A</td><td>+ve</td> <td><%=b.getAp()%></td></tr>
                    <tr><td>A</td><td>-ve</td> <td><%=b.getAn()%></td></tr>
                    <tr><td>B</td><td>+ve</td> <td><%=b.getBp()%></td></tr>
                    <tr><td>B</td><td>-ve</td> <td><%=b.getBn()%></td></tr>
                    <tr><td>AB</td><td>+ve</td> <td><%=b.getAbp()%></td></tr>
                    <tr><td>AB</td><td>-ve</td> <td><%=b.getAbn()%></td></tr>
                    <tr><td>O</td><td>+ve</td> <td><%=b.getOp()%></td></tr>
                    <tr><td>O</td><td>-ve</td> <td><%=b.getOn()%></td></tr>
                </table>
            </details>
        </details>
    </li>
    
    <%
        }}
    %>
    
</ul>
<ul class="event-list">
    <h3 class="info-title">Events</h3>
     <%
                        ArrayList<EventsPOJO>elist=EventsDAO.getEvents();
                        System.out.println("Events "+elist);
                        if(elist!=null)
                        {
                         for(EventsPOJO e:elist)
                         {
                    %>
    <li class="event">
        <details class="plannedevent">
                    <summary class="event"><%=e.getEvent()%> </summary>
                   <p><em>Organized by : </em><%=e.getOrganiser()%></p>
                   <p><em>Contact : </em><%=e.getContact()%></p>
                   <p><em>Venue : </em><%=e.getVenue()%></p>
                   <p class="eventduration"><em>From : </em><span><%=e.getFrom()%></span><em>To : </em><span><%=e.getTill()%></span></p>
                   <p><em>Time : </em><span><%=e.getStime()+" - "+e.getEtime()%></span></p>
                   </details>
    </li>
     <%
                       }}
                   %>
   
</ul>

</div>


</div>

<input type="radio" name="switch-interface" id="seek-interface-radio" class="switch-interface">
<div id="seek-interface" class="interface" >
    <form action="BloodRequestServlet" class="seek-form" method="POST">
        <!--<input type="email" required placeholder="Email" name="email" value="sandarbh19o@gmail.com" readonly class="input-data">-->
        <!--<input type="tel" required placeholder="Mobile" name="mob" class="input-data">-->
        <input type="text" required  placeholder="Hospital Name" name="institute" class="input-data">
        <div class="hospital-address">
        <input type="text" required  placeholder="Hospital City" name="icity" class="input-data add">
        <input type="text" required placeholder="Hospital State" name="istate" class="input-data add">
        <input type="text" required placeholder="Hospital Country" name="icountry" class="input-data add">
        <input type="number" required placeholder="Hospital Pincode" name="ipincode"class="input-data add">
        </div>
        
        <div id="blood-group">
           <div>
            Group
            <select  name="grp" id="group"  required>
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="AB">AB</option>
            <option value="O">O</option>
            </select>
           </div>
            <div>Rh
                <select  name="rh" id="rh" name="rh" required>
                    <option value="+ve">+ve</option>
                    <option value="-ve">-ve</option>
                    </select></div>
    </div>
    <input type="number" placeholder="Units" name="units" required class="input-data">
    <div class="date"><span>On</span><input name="date" type="date" required class="input-data on"></div>
    <textarea name="purpose" class="input-data" required placeholder="Purpose" id="" cols="30" rows="10"></textarea>
    <input type="submit" id="seek-btn" value="Request" class="input-data">
    </form>

</div>

<input type="radio" name="switch-interface" id="coupons-interface-radio" class="switch-interface">
<div id="coupons-interface" class="interface" >

<div class="rewards">
    <h2 class="reward-title">Rewards</h2>
    <div class="reward-container">
        <div class="reward-card">
            <img src="http://source.unsplash.com/190x150/?doctors" alt="" class="reward-img">
            <h4>Free Doctor Consultation</h4>
            <div class="reward-buy-btn"><a href="BuyHealthCoupons?coupontype=1" >10 Credits</a></div>
        </div>
        <div class="reward-card">
            <img src="http://source.unsplash.com/190x150/?lab" alt="" class="reward-img">
            <h4>Free Blood Test</h4>
            <div class="reward-buy-btn"><a href="BuyHealthCoupons?coupontype=2" >20 Credits</a></div>
        </div>
        
    </div>
</div>
<div class="my-rewards">
    <h2 class="reward-title">My Coupons</h2>
    <div class="myreward-container">
        
        <%
            System.out.println("couponlist"+ couponlist);
            if(couponlist!=null){
        for(HealthCouponsPOJO h:couponlist)
        {
        
        %>
        
        <div class="myreward-card">
            <img src="http://source.unsplash.com/190x150/?coupons" alt="" class="reward-img">
            <h4><%=h.getCtype()%></h4>
            
            <details>
                <summary>Coupon Code</summary>
                <div class="voucher-code"><%=h.getCcode()%></div>
            </details>
        </div>
       <%
        
        }}
        %>
    </div>
    
</div>
</div>

<footer> <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div></footer>
    </main>
</body>
</html>
