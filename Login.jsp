<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
  <nav class="navbar navbar-dark bg-dark">
   <a class="navbar-brand" href="#">Home</a>
</nav>

<br><br><br><br><br>
<%-- <%
Cookie[] cookies = null;
cookies = request.getCookies();
if(cookies!=null) {
	 for(int i=0;i<cookies.length;i++){
   		cookies[i].setMaxAge(0);
   		response.addCookie(cookies[i]);
   	}
}
%> --%>
<div class="row">
  <div class="col-sm-6" style=" position: relative;float: left;padding: 8%;">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Faculty</h5>
        <form class="card-text" action="loginserve" method="post">
           <label>LoginID:</label><br>
           <input type="text" name="idf"/><br><br>
           <label>Password:</label><br>
           <input type="password" name="passf"/><br><br>
           <input type="submit" class="btn btn-primary" value="Login"/>
        </form>
      </div>
    </div>
  </div>
  <div class="col-sm-6" style=" position: relative;float: left;padding: 8%;">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Student</h5>
        <form class="card-text" action="loginsserve" method="post" name="studentlogin">
           <label>LoginID:</label><br>
           <input type="text" name="ids"/><br><br>
           <label>Password:</label><br>
           <input type="password" name="passs"/><br><br>
           <input type="submit" class="btn btn-primary" value="Login"/>
        </form>
      </div>
    </div>
  </div>
</div>


</body>
</html>