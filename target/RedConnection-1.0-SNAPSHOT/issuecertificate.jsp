<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="RCPOJO.InstitutePOJO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    
 String donorfullname=(String)session.getAttribute("donorfname");
 String donoremail=(String)session.getAttribute("donoremail");
 String donationinst=institute.getName()+" "+institute.getCity();
 SimpleDateFormat ft=new SimpleDateFormat("dd/MM/yyyy");
 String donationdate=ft.format(new Date());
 String donationid=String.valueOf((int)session.getAttribute("donationid"));
session.removeAttribute("donorfname");
session.removeAttribute("donoremail");
session.removeAttribute("donationid");

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/issuecertificate.css">
    <title>Document</title>
</head>
<body>
  
      <header> <a href="hospital.jsp"><img src="Icons/red chain img.png" class="logo" alt="">Red Connection</a></header>
  
      <main>
        <form class="details-form" name="google-sheet" method="POST">
          <img src="Icons/verified.png" alt="">
          <h2>Donor Details</h2>
                      <div class="data">
            <input type="text" placeholder="Fullname" name="Fullname" readonly value="<%=donorfullname%>" class="donor-data">
            <input type="text" placeholder="Donation Id" name="Donation Id" readonly value="<%=donationid%>" class="donor-data">
            <input type="email" placeholder="Email" name="Email" readonly value="<%=donoremail%>" class="donor-data">
            <input type="text" placeholder="Institute" name="Institute" value="<%=donationinst%>" readonly class="donor-data"> 
            <input type="text" placeholder="Date" name="Date" readonly value="<%=donationdate%>" class="donor-data">
            <em>Please continue to issue a certificate.</em>
          </div>
            <input type="submit" id="continue-btn" value="Continue">
        </form>
          
      </main>
      <footer>
          <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div>
      </footer>
  
      
     
  


<script>
    const scriptURL = 'https://script.google.com/macros/s/AKfycbxWabAjdoIGuLLGwQjTlZ9rn5V1fTS0dlQhS-PgdocG45v4eEX7gLWMN0JRtBMsEv7R/exec'
    const form = document.forms['google-sheet']
  
    form.addEventListener('submit', e => {
      e.preventDefault()
      fetch(scriptURL, { method: 'POST', body: new FormData(form)})
        .then(response => location='hospital.jsp')
        .catch(error => console.error('Error!', error.message))
    })
  </script>
  
  
  
</body>
</html>