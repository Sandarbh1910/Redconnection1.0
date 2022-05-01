<%@page import="RCPOJO.BloodBankStockPOJO"%>
<%@page import="RCPOJO.BloodBankPOJO"%>
<%@page import="RCDAO.BloodBankDAO"%>
<%@page import="RCPOJO.InstitutePOJO"%>
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
    
    BloodBankStockPOJO bstock=BloodBankDAO.loadStock(institute.getId());
    int ap=bstock.getAp();
    int an=bstock.getAn();
    int bp=bstock.getBp();
    int bn=bstock.getBn();
    int abp=bstock.getAbp();
    int abn=bstock.getAbn();
    int op=bstock.getOp();
    int on=bstock.getOn();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="CSS/bloodbank.css">
</head>
<body>
    <header><img class="logo" src="Icons/red chain img.png" alt="">Red Connection</header>
    <nav>
         <img src="Icons/red chain img.png" alt="" class="navlogo">
         <div class="nav-container">
             
            <label for="home-interface-radio" class="navtab" title="Home"><img src="Icons/home.png" alt="">Home</label>
            <label for="storage-interface-radio" class="navtab" title="Update Storage"><img src="Icons/bloodstock.png" alt="">Storage</label>
            <label for="event-interface-radio" class="navtab" title="Plan Event"><img src="Icons/scheduleevent.png" alt="">Plan Event</label>
         </div>
         <div class="user"><img src="Icons/usergrey.png" class="prof-icon" alt="">
            <ul class="user-drp-dwn">
                <li class="user-opt">Profile</li>
                <li class="user-opt"><a href="passwordassistance.jsp">Change Password</a></li>
                <hr>
                <li class="user-opt"><a href="LogoutServlet">Sign Out</a></li>
            </ul></div>
         
    </nav>


    
    <main>
        <%@include file="message.jsp" %>
        <input type="radio"  checked name="switch-interface" id="home-interface-radio" class="switch-interface">
        <div id="home-interface" class="interface">
        
            <div class="rep">
                <div id="donutchart" style="width:370px; height:90%;min-width: 300px; "></div>
            </div>
           
                <div class="mytable">
        <div class="mytr">
            <div class="myth">Group </div>
            <div class="myth">Rh</div>
            <div class="myth">Units</div>
        </div>
        
            <div class="mytr">
                <div class="mytd">A</div>
                <div class="mytd">+ve</div>
                <div class="mytd"><%=ap%></div>
            </div>
            <div class="mytr">
                <div class="mytd">A</div>
                <div class="mytd">-ve</div>
                <div class="mytd"><%=an%></div>
            </div> 
             <div class="mytr">
                <div class="mytd">B</div>
                <div class="mytd">+ve</div>
                <div class="mytd"><%=bp%></div>
            </div>  
            <div class="mytr">
                <div class="mytd">B</div>
                <div class="mytd">-ve</div>
                <div class="mytd"><%=bn%></div>
            </div>  
            <div class="mytr">
                <div class="mytd">AB</div>
                <div class="mytd">+ve</div>
                <div class="mytd"><%=abp%></div>
            </div>  
            <div class="mytr">
                <div class="mytd">AB</div>
                <div class="mytd">-ve</div>
                <div class="mytd"><%=abn%></div>
            </div>  
            <div class="mytr">
                <div class="mytd">O</div>
                <div class="mytd">+ve</div>
                <div class="mytd"><%=op%></div>
            </div> 
             <div class="mytr">
                <div class="mytd">O</div>
                <div class="mytd">-ve</div>
                <div class="mytd"><%=on%></div>
            </div>
       
    </div>
          
        
        
        </div>
        
        <input type="radio"  name="switch-interface" id="storage-interface-radio" class="switch-interface">
        <div id="storage-interface" class="interface" >
             
            <form action="UpdateBloodBankStockServlet" class="update-stock-form" method="POST">
                <h2>Update Storage</h2>
   
    <div class="data-row"> <span class="bgtype">A +ve</span><input type="number" name="ap" id="ap" placeholder="A +ve" value="<%=ap%>" class="input-stock">
        <div class="cng-btn"><span id="incbtn" onclick="inc('ap')">+</span><span id="incby">1</span><span id="decbtn" onclick="dec('ap')">-</span></div>
    </div>
    <div class="data-row">  <span class="bgtype">A -ve</span><input type="number" name="an" id="an" placeholder="A -ve" value="<%=an%>" class="input-stock">
        <div class="cng-btn"><span id="incbtn" onclick="inc('an')">+</span><span id="incby">1</span><span id="decbtn" onclick="dec('an')">-</span></div>
    </div>
    <div class="data-row"> <span class="bgtype">B +ve</span><input type="number" name="bp" id="bp" placeholder="B +ve" value="<%=bp%>" class="input-stock">
        <div class="cng-btn"><span id="incbtn" onclick="inc('bp')">+</span><span id="incby">1</span><span id="decbtn" onclick="dec('bp')">-</span></div>
    </div>
    <div class="data-row"> <span class="bgtype">B -ve</span> <input type="number" name="bn" id="bn" placeholder="B -ve" value="<%=bn%>" class="input-stock">
        <div class="cng-btn"><span id="incbtn" onclick="inc('bn')">+</span><span id="incby">1</span><span id="decbtn" onclick="dec('bn')">-</span></div>
    </div>
    <div class="data-row"> <span class="bgtype">AB +ve</span><input type="number" name="abp" id="abp" placeholder="AB +ve" value="<%=abp%>" class="input-stock">
        <div class="cng-btn"><span id="incbtn" onclick="inc('abp')">+</span><span id="incby">1</span><span id="decbtn" onclick="dec('abp')">-</span></div>
    </div>
    <div class="data-row">  <span class="bgtype">AB -ve</span><input type="number" name="abn" id="abn" placeholder="AB -ve" value="<%=abn%>" class="input-stock">
        <div class="cng-btn"><span id="incbtn" onclick="inc('abn')">+</span><span id="incby">1</span><span id="decbtn" onclick="dec('abn')">-</span></div>
    </div>
    <div class="data-row"> <span class="bgtype">O +ve</span><input type="number" name="op" id="op" placeholder="O +ve" value="<%=op%>" class="input-stock">
        <div class="cng-btn"><span id="incbtn" onclick="inc('op')">+</span><span id="incby">1</span><span id="decbtn" onclick="dec('op')">-</span></div>
    </div>
    <div class="data-row"> <span class="bgtype">O -ve</span><input type="number" name="on" id="on" placeholder="O -ve" value="<%=on%>" class="input-stock">
        <div class="cng-btn"><span id="incbtn" onclick="inc('on')">+</span><span id="incby">1</span><span id="decbtn" onclick="dec('on')">-</span></div>
    </div>
                
               
                
                
                
             
        <div class="confirm-update"><input type="checkbox" id="updatestockcheck" onchange="enableupdatestockbtn()"><b>Select to confirm.</b></div>
       
            <input type="submit" id="update-stock-btn" value="Update Stock" disabled >
            </form>
        
        </div>
        
        <input type="radio" name="switch-interface" id="event-interface-radio" class="switch-interface">
        <div id="event-interface" class="interface" >
       Event
        
       
        </div>
        
        <!-- Till here 12-04-22 -->
        
        
        <footer> <div class="copyright">Copyright &copy;2022 Red Connections | Sandarbh Taran .All rights reserved.</div></footer>
            </main>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Blood Group', 'Units'],
          ['A+ve',     <%=ap%>],
          ['A-ve',      <%=an%>],
          ['B+ve',  <%=bp%>],
          ['B-ve', <%=bn%>],
          ['AB+ve',    <%=abp%>],
          ['AB-ve',    <%=abn%>],
          ['O+ve',    <%=op%>],
          ['O-ve',    <%=on%>]
        ]);

        var options = {
          title: 'Bank Storage Description (in units)',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
    </script>
    
    <script>
function enableupdatestockbtn()
{
    let check=document.getElementById('updatestockcheck');
            let btn=document.getElementById('update-stock-btn');
            
            btn.disabled=!check.checked;
            console.log('btn is'+btn.disabled);
            
            if(btn.disabled)
            {
                console.log('to light blue');
                btn.style.backgroundColor='#5a9cfe';
            }
            else {
                btn.style.backgroundColor='#0d6efd';
                 console.log('to dark blue');
            }
}
</script>
    
     <script>
        function inc(id) {
          console.log('btnpressed');
            let data = parseInt(document.getElementById(id).value);
            console.log(data);
            document.getElementById(id).value = ++data;
        }
        function dec(id) {
          console.log('btnpressed');
            let data = parseInt(document.getElementById(id).value);
            console.log(data);
            document.getElementById(id).value = --data;
        }
        
        </script>
    
</body>
</html>
