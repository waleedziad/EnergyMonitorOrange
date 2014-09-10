
<%@page import="com.orange.domain.Node"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.orange.Dao.NodeDao"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Sample</title>
	<link rel="stylesheet" href="style.css" />
<script src="../Chart.js"></script>
</head>


<body>
    <%
    
    %>
<div class="container">
	<div class="header">
		<img id="logo" alt="logo" src="">
		<span><img src="user.svg">admin</span>
	</div>		
	<div class="navBar">
		<a href="">
		<div class="navButton">
			<div class="icon"><img src="home.svg"></div>
			<p> Home </p>
		</div>
		</a>
		<a href="">
		<div class="navButton">
			<div class="icon"><img src="chart.svg"></div>
			<p> Energy consumption </p>
		</div>
		</a>
		<a href="">
		<div class="navButton">
			<div class="icon"><img src="login.svg"></div>
			<p> Login </p>
		</div>
		</a>
	</div>
	<div class="content">
		<div class="chartBoard">
			Chart
		</div>
		<div class="chartBoard">
			Table
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
					fillColor : "rgba(220,220,220,0.5)",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					data : ["$(voltage)"]
				},
				{
					fillColor : "rgba(151,187,205,0.5)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					data : ["$(power)"]
				}
			]
			
		}

	new Chart(document.getElementById("canvas").getContext("2d")).Line(lineChartData);
}
</script>
</body>
</html>