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
    <header><img class="logo" src="Icons/red chain img.png" alt="">Red Connection</header>
    <nav>
         <img src="Icons/red chain img.png" alt="" class="navlogo">
         <div class="nav-container">
             
            <label for="verify-interface-radio" class="navtab" title="Verify Donor"><img src="Icons/donate.png" alt="">Verify Donor</label>
            <label for="storage-interface-radio" class="navtab" title="Update Storage"><img src="Icons/bloodsearchgrey.png" alt="">Update Storage</label>
            <label for="event-interface-radio" class="navtab" title="Plan Events"><img src="Icons/coupon3.png" alt="">Plan Events</label>
         </div>
         <div class="user"><img src="Icons/usergrey.png" class="prof-icon" alt="">
            <ul class="user-drp-dwn">
                <li class="user-opt">Profile</li>
                <li class="user-opt"><a href="passwordassistance.jsp">Change Password</a></li>
                <hr>
                <li class="user-opt"><a href="LogoutServlet">Sign Out</a></li>
            </ul></div>
         
    </nav>


    <main>
<input type="radio"  checked name="switch-interface" id="verify-interface-radio" class="switch-interface">
<div id="verify-interface" class="interface">
    

Verify

</div>

<input type="radio" name="switch-interface" id="storage-interface-radio" class="switch-interface">
<div id="storage-interface" class="interface" >
    <form action="BloodRequestServlet" class="seek-form" method="POST">
        <input type="email" required placeholder="Email" name="email" class="input-data">
        <input type="tel" required placeholder="Mobile" name="mob" class="input-data">
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

<input type="radio" name="switch-interface" id="event-interface-radio" class="switch-interface">
<div id="event-interface" class="interface" >


       
    Events
    

</div>

<footer> <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div></footer>
    </main>
</body>
</html>
