<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String cpemail=(String)session.getAttribute("cpemail");
    if(cpemail==null)
    {
        response.sendRedirect("passwordassistance.jsp");
        return;
    }
    
session.removeAttribute("cpemail");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="CSS/verification.css">
</head>
<body>
    <header> <a href="index.jsp"><img src="Icons/red chain img.png" class="logo" alt="">Red Connection</a></header>

    <main>
       
        <form  id="otp-form" method="POST" action="VerificationServlet">
            <h2>Verification</h2>
            <div class="data"><input type="hidden" value="<%=cpemail%>" name="cpemail">
                <input type="text" placeholder="Otp" id="otp" required name="enteredotp">
                <em>Verify otp sent on registered email address.</em></div>
            <input type="submit" id="verify-otp-btn" value="Verify">
        </form>
    </main>
    <footer>
        <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div>
    </footer>
</body>
</html>