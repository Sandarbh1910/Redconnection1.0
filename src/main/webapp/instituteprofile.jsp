<%@page import="RCPOJO.InstitutePOJO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up</title>
        <link rel="stylesheet" href="CSS/instituteprofile.css">
    </head>
    <body>
        
        <header> <a href="index.jsp"><img src="Icons/red chain img.png" class="logo" alt="">Red Connection</a></header>
        <main>


            <form class="institute" action="InstituteProfileUpdateServlet">

                <h2>Account Details</h2>
                <div class="institute-form"> 
                    <input type="text" class="input-data" placeholder="Institute Name" value="<%=institute.getName()%>" name="iname" required> 
                    <input type="email" class="input-data" placeholder="Email"  value="<%=institute.getEmail()%>" name="iemail" required>
                    <input type="tel" class="input-data" placeholder="Contact No" value="<%=institute.getMob()%>" name="imob" required>
                    <textarea name="iaddress" id="" cols="30" rows="3" class="input-data"  placeholder="Address" required><%=institute.getAddress()%></textarea>
                    <div id="iaddress">
                        <input type="text" class="input-data" placeholder="City" value="<%=institute.getCity()%>" name="icity" required>
                        <input type="text" class="input-data" placeholder="State" value="<%=institute.getState()%>"  name="istate" required>
                        <input type="text" class="input-data" placeholder="Country" value="<%=institute.getCountry()%>" name="icountry" required>
                        <input type="text" class="input-data" placeholder="Pincode" value="<%=institute.getPincode()%>" name="ipincode" required>
                        

                    </div>
                    
                    <div class="confirm-update"><input type="checkbox" id="updatedetailscheck" onchange="enableupdatedetailsbtn()"><b>Select to confirm.</b></div>
                    <input type="submit" class="update-details-btn" id="update-details-btn" value="Continue">
                    
                </div>
            </form>

           
        </main>
        <footer> <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div></footer>
   
   
        <script>
            function enableupdatedetailsbtn()
            {
                let check=document.getElementById('updatedetailscheck');
                        let btn=document.getElementById('update-details-btn');
                        
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
