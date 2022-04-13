<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up</title>
        <link rel="stylesheet" href="CSS/signup.css">
    </head>
    <body>
        <%@include file="message.jsp" %>
        <header> <a href="index.jsp"><img src="Icons/red chain img.png" class="logo" alt="">Red Connection</a></header>
        <main>



            <input type="radio" class="uradio" id="uradio" name="switch-inteface" checked>
            <form class="user"  action="UserSignupServlet">
                <h2>Sign Up</h2>
                <div class="user-form">
                    <input type="text" class="input-data" placeholder="Firstname" name="ufname" required>
                    <input type="text" class="input-data" placeholder="Lastname" name="ulname" required> 
                    <input type="date" class="input-data" placeholder="DOB" name="udob" required>
                    <input type="email" class="input-data" placeholder="Email" name="uemail" required> 
                    <input type="tel" class="input-data" placeholder="Mobile" name="umob" required>
                    <div id="blood-group">

                        Blood Group

                        <select  class="input-data" name="ubloodgrp" id="group" required>
                            <option value="A">A</option>
                            <option value="B">B</option>
                            <option value="AB">AB</option>
                            <option value="O">O</option>
                        </select>
                        Rh
                        <select class="input-data" name="urh" required id="rh" required>
                            <option value="+ve">+ve</option>
                            <option value="-ve">-ve</option>
                        </select>
                    </div>

                    <input type="password" class="input-data" placeholder="Password" name="upassword" required>

                    <div id="uaddress">
                        <input type="text" class="input-data" placeholder="City" name="ucity" required>
                        <input type="text" class="input-data" placeholder="State" name="ustate" required>
                        <input type="text" class="input-data" placeholder="Country" name="ucountry" required>
                        <input type="text" class="input-data" placeholder="Pincode" name="upincode" required>
                    </div>

                    <p> By continuing, you agree to our Conditions of Use and Privacy Notice.</p>

                    <input type="submit" class="usubmit-btn" value="Continue">
                    <label  class="lbl" for="iradio">
                        <img src="Icons/hospital.png" alt="">
                        Institute
                    </label>
                </div>



            </form>






            <input type="radio"  name="switch-inteface" class="iradio" id="iradio">
            <form class="institute" action="InstituteSignupServlet">

                <h2>Sign Up</h2>
                <div class="institute-form"> 
                    <input type="text" class="input-data" placeholder="Institute Name" name="iname" required> 
                    <input type="email" class="input-data" placeholder="Email"  name="iemail" required>
                    <input type="tel" class="input-data" placeholder="Contact No" name="imob" required>
                    <input type="password" class="input-data" placeholder="Password" name="ipassword" required>
                    <textarea name="iaddress" id="" cols="30" rows="3" class="input-data" placeholder="Address" required></textarea>
                    <div id="uaddress">
                        <input type="text" class="input-data" placeholder="City" name="icity" required>
                        <input type="text" class="input-data" placeholder="State" name="istate" required>
                        <input type="text" class="input-data" placeholder="Country" name="icountry" required>
                        <input type="text" class="input-data" placeholder="Pincode" name="ipincode" required>
                        

                    </div>
                    <select name="instype" id="instype" class="input-data" required>
                            <option style="background-color:#e1e1e2;" >Institute Type</option>
                            <option value="hospital">Hospital</option>
                            <option value="bloodbank">Blood Bank</option>
                            <option value="ngo">NGO</option>
                        </select>
                    <p>By continuing, you agree to our Conditions of Use and Privacy Notice.</p>
                    <input type="submit" class="isubmit-btn" value="Continue">
                    <label class="lbl" for="uradio"><img src="Icons/user.png" alt="">
                        User</label>
                </div>
            </form>

            <a class="login-tab" href="login.jsp">Login</a>
        </main>
        <footer> <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div></footer>
    </body>
</html>
