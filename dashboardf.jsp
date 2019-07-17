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
         /* Cookie cookie = null;
         Cookie[] cookies = null;
         String username="";
         
         // Get an array of Cookies associated with the this domain
         cookies = request.getCookies();
         
         if( cookies != null ) {
            username=cookies[0].getValue();
               for(int i=0;i<cookies.length;i++){ 
            	System.out.println("dashboardf  "+cookies[i].getValue());
           }
             
        } else {
            out.println("<h2>No cookies founds</h2>");
         } */
         
         Object obj=request.getAttribute("username");
         String u = (String) obj;
         String username = u.toString();

    try{
    	Class.forName("oracle.jdbc.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saranya");
		//System.out.println("connection established succesfully");
		String selectSQL = "select * from form where std_id in (select std_id from student where proct_id=?) and proct_app='false' and hod_app='false'";
		PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
		preparedStatement.setString(1, username);
		ResultSet rs = preparedStatement.executeQuery();
    	while(rs.next()){
    		System.out.println(rs.getInt("form_id"));
  %>
      		<div class="card">
 				 <h5 class="card-header"><%=rs.getString("std_id") %></h5>
  					<div class="card-body">
   				 		<p class="card-text"><%=rs.getString("reason") %></p>
   				 	    <p class="card-text"><%=rs.getInt("days") %></p> 
   				 	    Leave From: <p class="card-text"><%=rs.getString("start_date") %></p> 
   				 	   <form action="acceptserve" method="get"><input type="hidden" name="form_id" value=<%=rs.getInt("form_id")%>/><input type="hidden" name="proct" value=<%=username %>/><input  type="submit" value="accept" class="btn btn-primary"/></form>
   				 	   <br> <form action="declineserve" method="get"><input type="hidden" name="form_id" value=<%=rs.getInt("form_id")%>/><input type="hidden" name="proct" value=<%=username %>/><input  type="submit" value="decline" class="btn btn-primary"/></form> 
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