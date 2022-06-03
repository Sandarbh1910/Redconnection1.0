<%@page import="RCDAO.UserDAO"%>
<%@page import="RCPOJO.UserPOJO"%>
<%

    UserPOJO user = (UserPOJO) session.getAttribute("loggedUser");
    if (user == null) {
        session.setAttribute("message", "Login Required!");
        session.setAttribute("dispcol", "1");
        response.sendRedirect("login.jsp");
        System.out.println("Login required on user page");
        return;
    }

    String[] bg = user.getBloodgrp().split(" ");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up</title>
        <link rel="stylesheet" href="CSS/userprofile.css">
    </head>
    <body>

        <header> <a href="index.jsp"><img src="Icons/red chain img.png" class="logo" alt="">Red Connection</a></header>
        <main>




            <form class="user"  action="UserProfileUpdateServlet">
                <h2>Account Details</h2>
                <div class="user-form">
                    <input type="text" class="input-data" placeholder="Firstname" name="ufname" value="<%=user.getFname()%>" required>
                    <input type="text" class="input-data" placeholder="Lastname" name="ulname" value="<%=user.getLname()%>" required> 
                    <input type="date" class="input-data" placeholder="DOB" name="udob" id="dob"  required>
                    <input type="email" class="input-data" placeholder="Email" name="uemail" value="<%=user.getEmail()%>" required> 
                    <input type="tel" class="input-data" placeholder="Mobile" name="umob" value="<%=user.getMob()%>" required>
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


                    <div id="uaddress">
                        <input type="text" class="input-data" placeholder="City" name="ucity" value="<%=user.getCity()%>" required>
                        <input type="text" class="input-data" placeholder="State" name="ustate" value="<%=user.getState()%>" required>
                        <input type="text" class="input-data" placeholder="Country" name="ucountry" value="<%=user.getCountry()%>"  required>
                        <input type="text" class="input-data" placeholder="Pincode" name="upincode" value="<%=user.getPincode()%>" required>
                    </div>
                    <div class="notification">
                        <div>would like to receive blood request notification?</div>
                        <div class="notification-radio">
                            <label for="notification-enable">Enable<input type="radio" id="notification-enable" value="enable" name="notification"></label>
                            <label for="notification-disable">Disable<input type="radio" id="notification-disable" value="disable" name="notification"></label>
                        </div>
                    </div>
                    <div class="confirm-update"><input type="checkbox" id="updatedetailscheck" onchange="enableupdatedetailsbtn()"><b>Select to confirm.</b></div>
                    <input type="submit" class="update-details-btn" id="update-details-btn" value="Continue">

                </div>



            </form>









        </main>
        <footer> <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div></footer>


        <script>
            
            //Enable update btn script
            function enableupdatedetailsbtn()
            {
                let check = document.getElementById('updatedetailscheck');
                let btn = document.getElementById('update-details-btn');

                btn.disabled = !check.checked;
                console.log('btn is' + btn.disabled);

                if (btn.disabled)
                {
                    console.log('to light maroon');
                    btn.style.backgroundColor = '#f36666';
                } else {
                    btn.style.backgroundColor = '#d94645';
                    console.log('to maroon');
                }
            }
        </script>

        <script>
            
            //Blood group selection script
            let dob = document.getElementById('dob');
            dob.value = '<%=user.getDob()%>';


            let bloodgrp = document.getElementById('group');
            let RH = document.getElementById('rh');
            let bg = '<%=bg[0]%>';
            let rh = '<%=bg[1].trim()%>';

            switch (bg)
            {
                case 'A':
                    bloodgrp.selectedIndex = 0;
                    break;
                case 'B':
                    bloodgrp.selectedIndex = 1;
                    break;
                case 'AB':
                    bloodgrp.selectedIndex = 2;
                    break;
                case 'O':
                    bloodgrp.selectedIndex = 3;
                    break;
            }

            if (rh === '+ve')
                RH.selectedIndex = 0;
            else
                RH.selectedIndex = 1;



        </script>
        
        <script>
            //Notification status script
            
            let status='<%=UserDAO.getNotificationStatus(user.getEmail())%>';
            console.log(status);
           if(status=='enable')
           {document.getElementById("notification-enable").checked = true;}
           else{document.getElementById("notification-disable").checked = true;}
        </script>
        
    </body>
</html>
