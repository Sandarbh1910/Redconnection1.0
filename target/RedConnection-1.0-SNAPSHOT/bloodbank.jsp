
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
                <li class="user-opt">Change Password</li>
                <hr>
                <li class="user-opt"><a href="">Sign Out</a></li>
            </ul></div>
         
    </nav>


    
    <main>
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
                <div class="mytd">Units</div>
            </div>
            <div class="mytr">
                <div class="mytd">A</div>
                <div class="mytd">-ve</div>
                <div class="mytd">Units</div>
            </div> 
             <div class="mytr">
                <div class="mytd">B</div>
                <div class="mytd">+ve</div>
                <div class="mytd">Units</div>
            </div>  
            <div class="mytr">
                <div class="mytd">B</div>
                <div class="mytd">-ve</div>
                <div class="mytd">Units</div>
            </div>  
            <div class="mytr">
                <div class="mytd">AB</div>
                <div class="mytd">+ve</div>
                <div class="mytd">Units</div>
            </div>  
            <div class="mytr">
                <div class="mytd">AB</div>
                <div class="mytd">-ve</div>
                <div class="mytd">Units</div>
            </div>  
            <div class="mytr">
                <div class="mytd">O</div>
                <div class="mytd">+ve</div>
                <div class="mytd">Units</div>
            </div> 
             <div class="mytr">
                <div class="mytd">O</div>
                <div class="mytd">-ve</div>
                <div class="mytd">Units</div>
            </div>
       
    </div>
          
        
        
        </div>
        
        <input type="radio"  name="switch-interface" id="storage-interface-radio" class="switch-interface">
        <div id="storage-interface" class="interface" >
            <form action="" class="seek-form">
                <input type="text" placeholder="Hospital Name" class="input-data">
                <div class="hospital-address">
                <input type="text" placeholder="Hospital City" class="input-data add">
                <input type="text" placeholder="Hospital State" class="input-data add">
                <input type="text" placeholder="Hospital Country" class="input-data add">
                <input type="number" placeholder="Hospital Pincode" class="input-data add">
                </div>
                
                <div id="blood-group">
                   <div>
                    Group
                    <select  name="bloodgrp" id="group" required>
                    <option value="">A</option>
                    <option value="">B</option>
                    <option value="">AB</option>
                    <option value="">O</option>
                    </select>
                   </div>
                    <div>Rh
                        <select  name="Rh" id="rh" required>
                            <option value="">+ve</option>
                            <option value="">-ve</option>
                            </select></div>
            </div>
            <input type="number" placeholder="Units" class="input-data">
            <div class="date"><span>On</span><input type="date"  class="input-data on"></div>
            <textarea name="" class="input-data" placeholder="Purpose" id="" cols="30" rows="10"></textarea>
            <input type="submit" id="seek-btn" value="Request" class="input-data">
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
          ['A+ve',     11],
          ['A-ve',      2],
          ['B+ve',  2],
          ['B-ve', 2],
          ['AB+ve',    7],
          ['AB-ve',    7],
          ['O+ve',    7],
          ['O-ve',    7]
        ]);

        var options = {
          title: 'Bank Storage Description (in units)',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
    </script>
</body>
</html>
