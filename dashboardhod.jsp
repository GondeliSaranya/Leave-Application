<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
 <body>
  <nav class="navbar navbar-dark bg-dark">
   <a class="navbar-brand" href="#">Dashboard</a>
   <a class="navbar-brand" href="Login.jsp" style="align-content: right;">logout</a>
  </nav>
  <br>
  <br>
  <%
         
    try{
    	Class.forName("oracle.jdbc.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saranya");
		//System.out.println("connection established succesfully");
		Statement stmt=conn.createStatement();
		String selectSQL = "select * from form where proct_app='true' and hod_app='false'";
		PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
		ResultSet rs = preparedStatement.executeQuery();
    	while(rs.next()){
  %>
      		<div class="card">
 				 <h5 class="card-header"><%=rs.getString("std_id") %></h5>
  					<div class="card-body">
   				 		<p class="card-text"><%=rs.getString("reason") %></p>
   				 	    <p class="card-text"><%=rs.getInt("days") %></p> 
   				 	    Leave From: <p class="card-text"><%=rs.getString("start_date") %></p> 
   				 	    <form action="acceptserve" method="get"><input type="hidden" name="form_id" value=<%=rs.getInt("form_id")%>/><input type="hidden" name="proct" value="10003/"/><input  type="submit" value="accept" class="btn btn-primary"/></form>
   				 	   <br> <form action="declineserve" method="get"><input type="hidden" name="form_id" value=<%=rs.getInt("form_id")%>/><input type="hidden" name="proct" value="10003/"/><input  type="submit" value="decline" class="btn btn-primary"/></form>  
  					</div>
				</div>
				<br><br>
  <%
    	}
    }
    catch(Exception e){
    	System.out.println(e);
    }
%>
  

</body>
</html>