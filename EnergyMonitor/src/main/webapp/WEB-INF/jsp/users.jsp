
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.orange.domain.Node"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.orange.Dao.NodeDao"%>
<html lang="en">
<head>
       
	<meta charset="UTF-8">
	<title>Sample</title>
	<link rel="stylesheet" href="/EnergyMonitor/assets/style.css" />
        <link rel="stylesheet" href ="/EnergyMonitor/assets/jquery.dataTables.css"/>
        <style>
            
            </style>
<script src="/EnergyMonitor/assets/Chart.js"></script>
<script src ="/EnergyMonitor/assets/jquery-1.11.1.min.js"></script>
<script src="/EnergyMonitor/assets/jquery.dataTables.min.js"></script>
</head>


<body onload="fillGraph()">
    
    
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
		<a href="http://localhost:8081/EnergyMonitor/DashBoard/board.htm">
		<div class="navButton">
			<div class="icon"><img src="/EnergyMonitor/assets/chart.svg"></div>
			<p> Energy consumption </p>
		</div>
		</a>
		<a href="">
		<div class="navButton">
			<div class="icon"><img src="/EnergyMonitor/assets/login.svg"></div>
			<p> Users </p>
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
	
            <div name ="table">
                <table id="example" class="display" cellspacing="0" width="100%">
                        
                        
                        <thead>
                        <tr>
                            <th>Name </th>
                            <th>Address</th>
                            <th>Api Key </th>
                            </tr>
                        </thead>
                        <tfoot>
                                <tr>
                            <th>Name </th>
                            <th>Address</th>
                            <th>Api Key </th>
                                </tr>
                         </tfoot>
                         <tbody>
                             <c:forEach items = "${users}" var="user" step="1">
                                <tr>
                         
                                    <td>${user.getName()}</td>
                                    <td>${user.getAddress()}</td>
                                    <td>${user.getApikey()}</td>
                                    
                                </tr>
                                </c:forEach>
                        </tbody>
                    </table>
                
                
                
            </div>
            
            </div>
    <script>
        function fillGraph()
{
    $(document).ready(function() {
    $('#example').dataTable();
                                    } );
   }
</script>
</body>
</html>