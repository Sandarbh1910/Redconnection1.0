

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    <style>
        *{
            box-sizing: border-box;
            padding:0;
            margin:0;
        }
.message{
    width:100vw;
    min-height: 50px;
    position:absolute;
    top:0px;
    left:0px;
    z-index: 100;
    
    
}

        .alert{
            background-color:#fff3cd;
            color:#b68853;
            padding:5px;
            font-size: large;
            padding-left:10px;
    padding-right:10px;
            

        }

        .danger{
            background-color:#f0b7b7;
            color:#a95251;
            padding:5px;
            font-size: large;
            padding-left:10px;
    padding-right:10px;
           
        }

        .success{
            background-color:#d1e7dd;
            color:#166357;
            padding:5px;
            font-size: large;
            padding-left:10px;
    padding-right:10px;
            
        }
        
        .notice{
            background-color:#caddf9;
            color:#2d64aa;
            padding:5px;
            font-size: large;
            padding-left:10px;
    padding-right:10px;
        }
    </style>
</head>
<body>
    <%
        
        String msg=(String)session.getAttribute("message");
        if(msg!=null)
        {
        String dispcol=(String)session.getAttribute("dispcol");
        if(dispcol.equalsIgnoreCase("0"))
        {
            //Danger
            
            %>
    <div class="message">
        
        <div class="danger"><%=msg%></div>
        
    </div>
    <%
        }
        else if(dispcol.equalsIgnoreCase("1"))
        {
            //Alert
            %>
    <div class="message">
        <div class="alert"><%=msg%></div>
       
    </div>
    <%
        }
        else if(dispcol.equalsIgnoreCase("2"))
        {
            //Success
            %>
    <div class="message">
        
        <div class="success"><%=msg%></div>
    </div>
    <%
        }

else{
//Notice
%>
     <div class="message">
        
        <div class="notice"><%=msg%></div>
        
    </div>
    <%
}}


session.removeAttribute("message");
    %>
   
    
    
    
    
</body>
</html>
