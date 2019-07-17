<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <script type="text/javascript">
  function validate(){
	  var today = new Date();
	  var given=new Date(document.leaveapplication.start_date.value);
	  
	   if(document.leaveapplication.std_id.value == ""){
		   alert("Please provide your rollno!");
		   document.leaveapplication.std_id.focus();
		   return false;
	   }
	   if(document.leaveapplication.start_date.value == ""||given<today){
		   alert("Please provide a valid date!");
		   document.leaveapplication.start_date.focus();
		   return false;
	   }
	   if(document.leaveapplication.days.value == ""||document.leaveapplication.days.value>5){
		   alert("leaves cannot be provide more than 3 days!");
		   document.leaveapplication.days.focus();
		   return false;
	   }
	   return true;
  }
  </script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <style type="text/css">
      div.application{
       font-family: sans-serif;
       border: thin;
       padding: 10%;
     }
     input[type=text],input[type=number],input[type=date]{
       width: 150%;
       height: 40px;
       padding: 5px;
       margin-bottom: 25px;
       margin-top: 5px;
       border: 2px solid #ccc;
       color: #4f4f4f;
       font-size: 16px;
       border-radius: 5px;
     }
     label{
       color: #464646;
       text-shadow: 0 1px 0 #fff;
       font-size: 14px;
       font-weight: bold;
  </style>
  
</head>
<body>
  <nav class="navbar navbar-dark bg-dark">
   <a class="navbar-brand" href="dashboards.jsp">Dashboard</a>
   <a class="navbar-brand" href="Login.jsp" style="align-content: right;">logout</a>
</nav>
<br><br><br><br>
  <div class="application" align="left">
   <form action="datastoreserve" method="post" name="leaveapplication" onsubmit="return validate();">
    <fieldset style="border:thin; ">
     <legend><b>LEAVE APPLICATION</b></legend><br><br>
      <table cellspacing="20" cellpadding="10">
         <tr>
           <td>Roll.No: <input type="text" name="std_id"/></td>
         </tr>
         <tr>
           <td>No.Of Days: <input type="number" name="days"/></td>
         </tr>
         <tr>
           <td>Start Date: <input type="date" name="start_date"/></td>
         </tr>
         <tr>
           <td>Reason: <input type="text" name="reason"/></td>
         </tr>
         <tr>
           <td><input type="submit" class="btn btn-dark" /></td>
         </tr>
         
      </table> 
       </fieldset>
      
   </form>
  </div>

</body>
</html>