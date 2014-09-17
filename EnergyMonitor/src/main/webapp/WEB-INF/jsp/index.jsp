
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.orange.domain.Node"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.orange.Dao.NodeDao"%>
<html lang="en">
<head>
       <meta http-equiv="refresh" content="25" />
	<meta charset="UTF-8">
	<title>Sample</title>
	<link rel="stylesheet" href="/EnergyMonitor/assets/style.css" />
        <link rel="stylesheet" href ="/EnergyMonitor/assets/jquery.dataTables.css"/>
        <style>
            canvas {
                
                
            }
            </style>
<script src="/EnergyMonitor/assets/Chart.js"></script>
<script src ="/EnergyMonitor/assets/jquery-1.11.1.min.js"></script>
<script src="/EnergyMonitor/assets/jquery.dataTables.min.js"></script>
</head>


<body onload="fillGraph()">
    <%
    String current = (String)request.getAttribute("current");
    String voltage = (String)request.getAttribute("voltage");
    List<Node> nodes = (List<Node> ) request.getAttribute("nodes");
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
		<a href="http://localhost:8081/EnergyMonitor/Users/getUsers.htm">
		<div class="navButton">
			<div class="icon"><img src="/EnergyMonitor/assets/login.svg"></div>
                        <p>Users</p> 
		</div>
		</a>
            
            <a href="">
		<div class="navButton">
			<div class="icon"><img src="/EnergyMonitor/assets/alarms.svg"></div>
			<p> Alerts </p>
		</div>
		</a>
           
		<a href="">
		<div class="navButton">
			<div class="icon"><img src="/EnergyMonitor/assets/billing.svg"></div>
			<p> Billing </p>
		</div>
		</a>
		
	
	</div>
	<div class="content">
		<div class="chartBoard">
                    <canvas id="canvas"width ="425%" class ="canvas" ></canvas>
		</div>
            <div class ="InfoBoard">
                Current status :
                <br>
                Voltage : <%= nodes.get(nodes.size()-1).getVoltage()%>
                <br>
                Current : <%=nodes.get(nodes.size()-1).getCurrentAmp()%>
                <br>
                Power   : <%=nodes.get(nodes.size()-1).getPower()  %>
                <br>
                Apparent power : <%=nodes.get(nodes.size()-1).getApparentPower()%>
                <br>
                Power factor : <%=nodes.get(nodes.size()-1).getPowerFactor() %>
                <br>
            </div>
                <div name ="table" class="infoTable">
                    <table id="example" class="display" cellspacing="0" width="100%">
                        
                        
                        <thead>
                        <tr>
                            <th>Voltage</th>
                            <th>Current</th>
                            <th>Power</th>
                            <th>Apparent Power</th>
                            <th>Power Factor</th>
                         </tr>
                        </thead>
                        <tfoot>
                                <tr>
                                    <th>Voltage</th>
                                    <th>Current</th>
                                    <th>Power</th>
                                    <th>Apparent Power</th>
                                    <th>Power Factor</th>
                                </tr>
                         </tfoot>
                         <tbody>
                             <c:forEach items = "${nodes}" var="node" step="1">
                                <tr>
                         
                                    <td>${node.getVoltage()}</td>
                                    <td>${node.getCurrentAmp()}</td>
                                    <td>${node.getPower()}</td>
                                    <td>${node.getApparentPower()}</td>
                                    <td>${node.getPowerFactor()}</td>
                                   
                                </tr>
                                </c:forEach>
                        <tbody>
                    </table>
                
                </div>
		
	</div>

</div>
    <script>
        function fillGraph()
{
    $(document).ready(function() {
    $('#example').dataTable();
                                    } );
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