<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String cpemail=(String)session.getAttribute("cpemail");
    System.out.println("on cp page cpemail "+cpemail);
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
    <link rel="stylesheet" href="CSS/createpassword.css">
</head>
<body>
    <%@include file="message.jsp" %>
    <header> <a href="index.jsp"><img src="Icons/red chain img.png" class="logo" alt="">Red Connection</a></header>
    <main>
        <form action="CreatePasswordServlet" method="POST" class="cp-form">
            <h2>Create Password</h2>
           <div class="data"> 
               <input type="hidden" class="input-data" value="<%=cpemail%>" name="email">
               <input type="password" class="input-data" id="newpassword" required placeholder="New Password" name="password">
            <input type="text" class="input-data" id="retypedpassword" required placeholder="Retype" autocomplete="off" name="retypedpassword"></div>
            <input type="submit" value="Change Password" id="cp-btn">
        </form>
    </main>
    <footer>
        <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div>
    </footer>
</body>
</html>
