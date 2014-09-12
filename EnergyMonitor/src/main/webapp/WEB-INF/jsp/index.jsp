
<%@page import="com.orange.domain.Node"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.orange.Dao.NodeDao"%>
<html lang="en">
<head>
        <meta http-equiv="refresh" content="5" />
	<meta charset="UTF-8">
	<title>Sample</title>
	<link rel="stylesheet" href="/EnergyMonitor/assets/style.css" />
        <style>
            canvas {
                
                
            }
            </style>
<script src="/EnergyMonitor/assets/Chart.js"></script>
</head>


<body onload="fillGraph()">
    <%
    String current = (String)request.getAttribute("current");
    String voltage = (String)request.getAttribute("voltage");
    %>
    
    
<div class="container">
	<div class="header">
            
            <img id="logo" alt="logo" src="/EnergyMonitor/assets/logo.jpeg" widhth ="50" height="50">
		<span><img src="/EnergyMonitor/assets/user.svg">admin</span>
	</div>		
	<div class="navBar">
		<a href="">
		<div class="navButton">
			<div class="icon">
                            <img src="/EnergyMonitor/assets/home.svg">
                        </div>
			<p> Home </p>
		</div>
		</a>
		<a href="">
		<div class="navButton">
			<div class="icon"><img src="/EnergyMonitor/assets/chart.svg"></div>
			<p> Energy consumption </p>
		</div>
		</a>
		<a href="">
		<div class="navButton">
			<div class="icon"><img src="/EnergyMonitor/assets/login.svg"></div>
			<p> Login </p>
		</div>
		</a>
	</div>
	<div class="content">
		<div class="chartBoard">
                    <canvas id="canvas" height="200" width="650" ></canvas>
		</div>
		<div class="chartBoard">
                    <%
                   
                    
                    
                    
                    
                    %>
		</div>
		
	</div>

</div>
    <script>
        function fillGraph()
{
	var lineChartData = {
			labels : ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"],
			datasets : [
				{
					fillColor : "rgba(255,121,0,0.5)",
					strokeColor : "rgba(225,20,0,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					data : [<%=current%>]
				},
				{
					fillColor : "rgba(255,121,0,0.5)",
					strokeColor : "rgba(255,20,0,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					data : [<%=voltage%>]
				}
			]
			
		}
                
	new Chart(document.getElementById("canvas").getContext("2d")).Line(lineChartData);
        }
</script>
</body>
</html>