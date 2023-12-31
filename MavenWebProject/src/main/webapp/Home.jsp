<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%//Set database connection variables
String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://18.235.221.130:3306/";
String database = "myGarage";
String userid = "ducky";
String password = "roundabout";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<!DOCTYPE html>
<html lang="en" data-bs-theme="light">
	<head>
		<!--  <link rel="stylesheet" href="appBoots.css">-->
		<meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
 		
		<title>Home</title>
	</head>
	<body>
	<div id="navigation-placeholder"></div>
	<script src="getNavigationElements.js" type="text/javascript"></script>
		<h4 class="p-2">MyGarage</h4>
		<div class="container mt-2">
  			
  			<!-- <p><strong>Note:</strong> The <strong>data-bs-parent</strong> attribute makes sure that all collapsible elements under the specified parent will be closed when one of the collapsible item is shown.</p> -->
  			<!-- <div id="accordion">
    			<div class="card">
      				<div class="card-header-sm">
        				<a class="btn" data-bs-toggle="collapse" href="#collapseOne">My Client Messages from Portal</a>
        				<span class="badge bg-primary rounded-pill">1</span>
      				</div>
      				<div id="collapseOne" class="collapse" data-bs-parent="#accordion">
        				<div class="card-body">
        					--ReadMe <span class="badge bg-primary">NEW</span>
        				</div>
      				</div>
    			</div>
  			</div>
  		</div>-->
  		
  </div>
  		<div class="container-fluid p-2">
  			<div class="row">
    			<div class="col-sm-4 p-2 border">
    				<div class="row">
    			 		<div class="input-group mb-3">
      						<!-- <label for='username' class="form-label-top">Customer Search:</label> -->
      						<input type="text" class="form-control" id="mySearch" onkeyup="myFunction()" placeholder="Search Garage">
      						<!-- <ul id="myMenu">
      							<li style="display:none;"><a href="#">Porsche</a></li>
      							<li style="display:none;"><a href="#">Honda</a></li>
      							<li style="display:none;"><a href="#">Toyota</a></li>
      							<li style="display:none;"><a href="#">Hyundai</a></li>
      							<li style="display:none;"><a href="#">Ford</a></li>
      							<li style="display:none;"><a href="#">Chevrolete</a></li>
      							<li style="display:none;"><a href="#">Mazda</a></li>
      							<li style="display:none;"><a href="#">Pontiac</a></li>
     							<li style="display:none;"><a href="#">Mitsubishi</a></li>
    						</ul> -->
      						<button class="btn btn-primary" type="submit">
      							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  									<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
								</svg>
							</button>
						</div>
      				</div>
      				<div class="row p-1">
      					<div>
      						<ul class="nav nav-tabs" id="myTab" role="tablist">
  								<li class="nav-item" role="presentation">
    								<button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">Last Accounts</button>
  								</li>
  								<li class="nav-item" role="presentation">
    								<button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Campaigns</button>
  								</li>
							</ul>
						<div class="tab-content" id="myTabContent">
  							<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">LAST ACCOUNTS TABLE</div>
  							<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">CAMPAIGNS TABLE</div>
							<div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">...</div>
						</div>
      					</div>
      				</div>
    			</div>
    			<div class="col-sm-8 p-2 border">
    					<button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">
    						Add Vehicle
      						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
  								<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  								<path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
							</svg>
						</button>
   				</div>
  			</div>
		</div>
		<div id="cards" class="container">
			<div class="row card-container" id="myMenu"><!-- style="width:45vw" -->
			<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from vehicles where garageID = " + request.getAttribute("data");
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
				<div class="col-md-4 searchMe">
				<div class="card">
				<form action="mediumHog" method="post">
    				<div class="card-body">
    				<div class="row p-1">
      					<div class="col-sm">
      						<h4 class="card-title"><%=resultSet.getString("vehicleName") %></h4>
      					</div>
      					<div class="col-sm text-end">
      					<button type="submit" class="btn" name="deleteVehicle" id="deleteVehicle" value="0">
      						<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  								<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
  								<path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
							</svg>
						</button>
						
      					</div>
      					</div>
      					<input type = "hidden" name = "vehicleID" value = <%=resultSet.getString("vehicleID") %>>
      					<p class="card-text">VIN: <%=resultSet.getString("VIN") %></p>
      					<a href="#" class="btn btn-primary"><%=resultSet.getString("Make") %></a>
      					<a href="#" class="btn btn-primary">Services</a>
    				</div>
    				</form>
    				<div style="text-align: center">
    					<svg xmlns="http://www.w3.org/2000/svg" width="50%" height="50%" fill="currentColor" class="bi bi-car-front" viewBox="0 0 16 16">
  							<path d="M4 9a1 1 0 1 1-2 0 1 1 0 0 1 2 0Zm10 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0ZM6 8a1 1 0 0 0 0 2h4a1 1 0 1 0 0-2H6ZM4.862 4.276 3.906 6.19a.51.51 0 0 0 .497.731c.91-.073 2.35-.17 3.597-.17 1.247 0 2.688.097 3.597.17a.51.51 0 0 0 .497-.731l-.956-1.913A.5.5 0 0 0 10.691 4H5.309a.5.5 0 0 0-.447.276Z"/>
  							<path d="M2.52 3.515A2.5 2.5 0 0 1 4.82 2h6.362c1 0 1.904.596 2.298 1.515l.792 1.848c.075.175.21.319.38.404.5.25.855.715.965 1.262l.335 1.679c.033.161.049.325.049.49v.413c0 .814-.39 1.543-1 1.997V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.338c-1.292.048-2.745.088-4 .088s-2.708-.04-4-.088V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.892c-.61-.454-1-1.183-1-1.997v-.413a2.5 2.5 0 0 1 .049-.49l.335-1.68c.11-.546.465-1.012.964-1.261a.807.807 0 0 0 .381-.404l.792-1.848ZM4.82 3a1.5 1.5 0 0 0-1.379.91l-.792 1.847a1.8 1.8 0 0 1-.853.904.807.807 0 0 0-.43.564L1.03 8.904a1.5 1.5 0 0 0-.03.294v.413c0 .796.62 1.448 1.408 1.484 1.555.07 3.786.155 5.592.155 1.806 0 4.037-.084 5.592-.155A1.479 1.479 0 0 0 15 9.611v-.413c0-.099-.01-.197-.03-.294l-.335-1.68a.807.807 0 0 0-.43-.563 1.807 1.807 0 0 1-.853-.904l-.792-1.848A1.5 1.5 0 0 0 11.18 3H4.82Z"/>
						</svg>
					</div>
				</div>
  			</div>
  			<%}%>
  		</div>
  	</div>
	<div class="modal" id="myModal">
  		<div class="modal-dialog modal-xl">
    		<div class="modal-content">
      			<div class="container mt-3">
  					<h2>Stacked form</h2>
  					<form class="mb-3" action="mediumHog" method="post">
  						<input type = "hidden" name = "garageID" value = <%=request.getAttribute("data") %>>
  						<div class="mb-3 mt-3">
      						<label for="carName">Name:</label>
      						<input type="text" class="form-control" id="carName" placeholder="Enter Car Name" name="vehicleName">
    					</div>
    					<div class="mb-3 mt-3">
      						<label for="carVin">Vin Number:</label>
      						<input type="text" class="form-control" id="vin" placeholder="VIN" name="vin">
    					</div>
    					<div class="form-check mb-3">
      						<label class="form-check-label">
        						<input class="form-check-input" type="checkbox" name="remember"> Remember me
      						</label>
    					</div>
    					<button id="submitBtn" class="btn btn-primary" data-mdb-dismiss="modal">Submit</button>
    					<input id="vehicleMake-info" name="make"></input>
    					<div><%= request.getParameter("name")%></div>
    					<div><%= request.getAttribute("data")%></div>
  					</form>
  					<!-- <div id="vehicleCylinder-info"></div>-->
				</div>
    		</div>
  		</div>
	</div>



<%
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

  		
		<script>
function myFunction() {
  var input, filter, ul, li, a, i;
  input = document.getElementById("mySearch");
  filter = input.value.toUpperCase();
  ul = document.getElementById("myMenu");
  li = ul.getElementsByTagName("h4");
  for (i = 0; i < li.length; i++) {
    //a = li[i].getElementsByTagName("a")[0];
    if (filter.length > 0){
      if (li[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
    	  ul.getElementsByClassName("searchMe")[i].style.display = "";
      	}
      else {
    	  ul.getElementsByClassName("searchMe")[i].style.display = "none";
    	  	}
    }
    else {
    	ul.getElementsByClassName("searchMe")[i].style.display = "";
  	}
  }
}
</script>
<script>
document.addEventListener("click", function (event) {
	  // Check if the click event originated from the "vinInput" element
	  if (event.target.id !== "vin") {
	    var inpt = document.getElementById("vin").value;
	    var settings = {
	      "url": "https://vpic.nhtsa.dot.gov/api/vehicles/DecodeVin/" + inpt + "?format=json",
	      "method": "GET",
	      "timeout": 0,
	      "headers": {},
	    };

	    $.ajax(settings).done(function (response) {
	      console.log(response);
	      var resultsArray = response.Results;

	      // Loop through the array to find the object with 'Variable' equal to 'Make'
	      var makeValue = ""; // Initialize makeValue
	      for (var i = 0; i < resultsArray.length; i++) {
	        if (resultsArray[i].Variable === "Make") {
	          makeValue = resultsArray[i].Value; // Assign value to makeValue
	          //console.log(makeValue); // Output: "BMW"
	          break; // Exit the loop since we found the 'Make' property
	        }
	      }

	      // Similarly, find the value for "Engine Number of Cylinders"
	      var cylinderValue = ""; // Initialize cylinderValue
	      for (var i = 0; i < resultsArray.length; i++) {
	        if (resultsArray[i].Variable === "Engine Number of Cylinders") {
	          cylinderValue = resultsArray[i].Value; // Assign value to cylinderValue
	          break;
	        }
	      }

	      document.getElementById("vehicleMake-info").value = makeValue;
	      $("#vehicleCylinder-info").text(cylinderValue);
	    });
	  }
	});
</script>
<script>
function change()
{
    var elem = document.getElementById("deleteVehicle");
    if (elem.value=="0") elem.value = "1";
    else elem.value = "0";
    location.reload();
}
</script>

	</body>
</html>