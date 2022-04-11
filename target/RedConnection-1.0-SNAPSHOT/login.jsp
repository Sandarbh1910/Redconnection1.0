<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="CSS/login.css">
</head>
<body>
    <header> <a href="index.html"><img src="Icons/red chain img.png" class="logo" alt="">Red Connection</a></header>
    <main>
        <input type="radio" class="uradio" id="uradio" name="switch-inteface" checked>
        <form class="user-login"  action="LoginServlet" method="POST">
            <h2>Login</h2>
            <div class="user-login-form">
                
                <input type="email" class="input-data" placeholder="Email" name="ulogin-id" required>
                
                <input type="password" class="input-data" placeholder="Password" name="ulogin-password" required>
              
                <input type="submit" class="ulogin-btn" value="Continue">

                <label  class="lbl" for="iradio">
                    <img src="Icons/hospital.png" alt="">
                    Institute</label>

                <details class="help-option">
                    <summary>Need help?</summary>
                    <div><a href="">Forgot Password</a></div>
                    <div><a href="index.jsp#contact-us-page">Contact Us</a></div>
                </details>
               
            </div>
            </form>

            <input type="radio"  name="switch-inteface" class="iradio" id="iradio">
            <form class="institute-login" action="InstituteLoginServlet" method="POST">
                
                <h2>Login</h2>
            <div class="institute-login-form"> 
                
                <input type="email" class="input-data" placeholder="Email" name="ilogin-id" required>
                
                <input type="password" class="input-data" placeholder="Password" name="ilogin-password" required>
                
                <input type="submit" class="ilogin-btn" value="Continue">
                <label class="lbl" for="uradio"><img src="Icons/user.png" alt="">
                    User</label>
                    <details class="help-option">
                        <summary>Need help?</summary>
                        <div><a href="">Forgot Password</a></div>
                        <div><a href="index.jsp#contact-us-page">Contact Us</a></div>
                    </details>
            </div>
        </form>


            <a class="signup-tab" href="signup.jsp">Sign Up</a>
    </main>
    <footer>
        <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div>
    </footer>
</body>
</html>
