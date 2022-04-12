<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="CSS/passwordassistance.css">
</head>
<body>
    <%@include file="message.jsp" %>
    <header> <a href="index.jsp"><img src="Icons/red chain img.png" class="logo" alt="">Red Connection</a></header>

    <main>
        <form  id="details-form" action="PasswordAssistanceServlet" method="POST">
            <h2>Password Assistance</h2>
             <div class="data">
                <input type="email" name="email" placeholder="Email" required class="input-data">
                <fieldset  class="input-data">
                    <legend>Usertype</legend>
                   <div> <input type="radio" value="user"  id="user" name="usertype" required>
                    <label for="user">User</label></div>
                    <div><input type="radio" value="institute" id="institute" required name="usertype">
                        <label for="institute">Institute</label></div>
                </fieldset>
                <em>An otp will be sent to your registered email address</em>
            </div>
           <input type="submit" id="send-otp-btn" value="Send Otp">
        </form>
        
    </main>
    <footer>
        <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div>
    </footer>

    
   
</body>
</html>