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
         <img src="Icons/whitelink.png" alt="" class="navlogo">
         <div class="nav-container">
             
            <label for="donate-interface-radio" class="navtab"><img src="Icons/donate.png" alt="">Donate</label>
            <label for="seek-interface-radio" class="navtab"><img src="Icons/seekblood.png" alt="">Seek</label>
            <label for="coupons-interface-radio" class="navtab"><img src="Icons/coupons.png" alt="">Coupons</label>
         </div>
         <div class="user"><img src="Icons/profileicon.png" class="prof-icon" alt="">
            <ul class="user-drp-dwn">
                <li class="user-opt">Profile</li>
                <li class="user-opt"><a href="passwordassistance.jsp">Change Password</a></li>
                <hr>
                <li class="user-opt"><a href="LogoutServlet">Sign Out</a></li>
            </ul></div>
         
    </nav>


    <main>
<input type="radio"  checked name="switch-interface" id="donate-interface-radio" class="switch-interface">
<div id="donate-interface" class="interface">

<ul class="request-container">
    <h3>Requests</h3>
<li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>

    </details>
</li>
<li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li>
<li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li><li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li>
<li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li>
<li class="request">
    <details>
        <summary>111001 <a href="" class="respond-btn">Respond</a></summary>
        <div>Address</div>
        <div>Units</div>
        <div>Purpose</div>
    </details>
</li>
</ul>


<div class="info-container">
<ul class="bblist">
    <h3 class="info-title">Blood Banks</h3>
    <li class="bank">
        <details>
            <summary class="bank-name">Red Cross</summary>
            <div class="bank-address">Address</div>
            <div class="bank-contact">Mobile</div>
            <details class="bstock">
                <summary>Stock</summary>
                <table>
                    <th>Blood Group</th><th>Rh</th><th>Units</th>
                    <tr><td>A</td><td>+ve</td> <td>1</td></tr>
                    <tr><td>A</td><td>-ve</td> <td>2</td></tr>
                    <tr><td>B</td><td>+ve</td> <td>3</td></tr>
                    <tr><td>B</td><td>-ve</td> <td>4</td></tr>
                    <tr><td>AB</td><td>+ve</td> <td>5</td></tr>
                    <tr><td>AB</td><td>-ve</td> <td>6</td></tr>
                    <tr><td>O</td><td>+ve</td> <td>7</td></tr>
                    <tr><td>O</td><td>-ve</td> <td>8</td></tr>
                </table>
            </details>
        </details>
    </li>
    <li class="bank">
        <details>
            <summary class="bank-name">VCare Blood Bank</summary>
            <div class="bank-address">Address</div>
            <div class="bank-contact">Mobile</div>
            <details class="bstock">
                <summary>Stock</summary>
                <table>
                    <th>Blood Group</th><th>Rh</th><th>Units</th>
                    <tr><td>A</td><td>+ve</td> <td>1</td></tr>
                    <tr><td>A</td><td>-ve</td> <td>2</td></tr>
                    <tr><td>B</td><td>+ve</td> <td>3</td></tr>
                    <tr><td>B</td><td>-ve</td> <td>4</td></tr>
                    <tr><td>AB</td><td>+ve</td> <td>5</td></tr>
                    <tr><td>AB</td><td>-ve</td> <td>6</td></tr>
                    <tr><td>O</td><td>+ve</td> <td>7</td></tr>
                    <tr><td>O</td><td>-ve</td> <td>8</td></tr>
                </table>
            </details>
        </details>
    </li>
    <li class="bank">
        <details>
            <summary class="bank-name">Red Life</summary>
            <div class="bank-address">Address</div>
            <div class="bank-contact">Mobile</div>
            <details class="bstock">
                <summary>Stock</summary>
                <table>
                    <th>Blood Group</th><th>Rh</th><th>Units</th>
                    <tr><td>A</td><td>+ve</td> <td>1</td></tr>
                    <tr><td>A</td><td>-ve</td> <td>2</td></tr>
                    <tr><td>B</td><td>+ve</td> <td>3</td></tr>
                    <tr><td>B</td><td>-ve</td> <td>4</td></tr>
                    <tr><td>AB</td><td>+ve</td> <td>5</td></tr>
                    <tr><td>AB</td><td>-ve</td> <td>6</td></tr>
                    <tr><td>O</td><td>+ve</td> <td>7</td></tr>
                    <tr><td>O</td><td>-ve</td> <td>8</td></tr>
                </table>
            </details>
        </details>
    </li>
    <li class="bank">
        <details>
            <summary class="bank-name">Red Line</summary>
            <div class="bank-address">Address</div>
            <div class="bank-contact">Mobile</div>
            <details class="bstock">
                <summary>Stock</summary>
                <table>
                    <th>Blood Group</th><th>Rh</th><th>Units</th>
                    <tr><td>A</td><td>+ve</td> <td>1</td></tr>
                    <tr><td>A</td><td>-ve</td> <td>2</td></tr>
                    <tr><td>B</td><td>+ve</td> <td>3</td></tr>
                    <tr><td>B</td><td>-ve</td> <td>4</td></tr>
                    <tr><td>AB</td><td>+ve</td> <td>5</td></tr>
                    <tr><td>AB</td><td>-ve</td> <td>6</td></tr>
                    <tr><td>O</td><td>+ve</td> <td>7</td></tr>
                    <tr><td>O</td><td>-ve</td> <td>8</td></tr>
                </table>
            </details>
        </details>
    </li>
</ul>
<ul class="event-list">
    <h3 class="info-title">Events</h3>
    <li class="event">
        <details>
            <summary class="event-name">Red Line</summary>
            <div class="event-address">Address</div>
            <div class="event-contact">Mobile</div>
            <div class="date"><span class="from-date">2/10/2022</span>&nbsp;-&nbsp;<span class="to-date">5/10/2022</span></div>
            </details>
        </details>
    </li>
    <li class="event">
        <details>
            <summary class="event-name">Red Line</summary>
            <div class="event-address">Address</div>
            <div class="event-contact">Mobile</div>
            <div class="date"><span class="from-date">2/10/2022</span>&nbsp;-&nbsp;<span class="to-date">5/10/2022</span></div>
            </details>
        </details>
    </li>
    <li class="event">
        <details>
            <summary class="event-name">Red Line</summary>
            <div class="event-address">Address</div>
            <div class="event-contact">Mobile</div>
            <div class="date"><span class="from-date">2/10/2022</span>&nbsp;-&nbsp;<span class="to-date">5/10/2022</span></div>
            </details>
        </details>
    </li>
    <li class="event">
        <details>
            <summary class="event-name">Red Line</summary>
            <div class="event-address">Address</div>
            <div class="event-contact">Mobile</div>
            <div class="date"><span class="from-date">2/10/2022</span>&nbsp;-&nbsp;<span class="to-date">5/10/2022</span></div>
            </details>
        </details>
    </li>
    <li class="event">
        <details>
            <summary class="event-name">Red Line</summary>
            <div class="event-address">Address</div>
            <div class="event-contact">Mobile</div>
            <div class="date"><span class="from-date">2/10/2022</span>&nbsp;-&nbsp;<span class="to-date">5/10/2022</span></div>
            </details>
        </details>
    </li>
    <li class="event">
        <details>
            <summary class="event-name">Red Line</summary>
            <div class="event-address">Address</div>
            <div class="event-contact">Mobile</div>
            <div class="date"><span class="from-date">2/10/2022</span>&nbsp;-&nbsp;<span class="to-date">5/10/2022</span></div>
            </details>
        </details>
    </li>
</ul>

</div>


</div>

<input type="radio" name="switch-interface" id="seek-interface-radio" class="switch-interface">
<div id="seek-interface" class="interface" >
    <form action="" class="seek-form">
        <input type="text" placeholder="Hospital Name" class="input-data">
        <div class="hospital-address">
        <input type="text" placeholder="Hospital City" class="input-data add">
        <input type="text" placeholder="Hospital State" class="input-data add">
        <input type="text" placeholder="Hospital Country" class="input-data add">
        <input type="number" placeholder="Hospital Pincode" class="input-data add">
        </div>
        
        <div id="blood-group">
           <div>
            Group
            <select  name="bloodgrp" id="group" required>
            <option value="">A</option>
            <option value="">B</option>
            <option value="">AB</option>
            <option value="">O</option>
            </select>
           </div>
            <div>Rh
                <select  name="Rh" id="rh" required>
                    <option value="">+ve</option>
                    <option value="">-ve</option>
                    </select></div>
    </div>
    <input type="number" placeholder="Units" class="input-data">
    <div class="date"><span>On</span><input type="date"  class="input-data on"></div>
    <textarea name="" class="input-data" placeholder="Purpose" id="" cols="30" rows="10"></textarea>
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
            <div class="reward-buy-btn"><a href="" >3 Credits</a></div>
        </div>
        <div class="reward-card">
            <img src="http://source.unsplash.com/190x150/?doctors" alt="" class="reward-img">
            <h4>Free Blood Test</h4>
            <div class="reward-buy-btn"><a href="" >5 Credits</a></div>
        </div>
        
    </div>
</div>
<div class="my-rewards">
    <h2 class="reward-title">My Vouchers</h2>
    <div class="myreward-container">
        
        <div class="myreward-card">
            <img src="http://source.unsplash.com/190x150/?doctors" alt="" class="reward-img">
            <h4>Free Doctor Consultation</h4>
            <details>
                <summary>Voucher Code</summary>
                <div class="voucher-code">1111</div>
            </details>
        </div>
       
    </div>
    
</div>
</div>

<footer> <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div></footer>
    </main>
</body>
</html>
