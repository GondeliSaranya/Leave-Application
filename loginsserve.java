package my_pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginsserve
 */
@WebServlet("/loginsserve")
public class loginsserve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginsserve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usernames = request.getParameter("ids");
		String passwords = request.getParameter("passs");
		//System.out.println("user: "+usernames+"\n"+"pass: "+passwords);
		/*
		 * Cookie[] cookies = null; cookies = request.getCookies(); if(cookies!=null) {
		 * for(int i=0;i<cookies.length;i++){ cookies[i].setMaxAge(0);
		 * response.addCookie(cookies[i]); } }
		 */
		/*
		 * Cookie user=new Cookie("username",usernames); Cookie pass=new
		 * Cookie("password",passwords); response.addCookie( user ); response.addCookie(
		 * pass );
		 */
		
		//System.out.println("cookie created student");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saranya");
			//System.out.println("connection established succesfully");
			Statement stmt=conn.createStatement();
			//stmt.executeUpdate("insert into faculty values('anand','Anand@2107')");
			
			ResultSet ra=stmt.executeQuery("select * from student");
			while(ra.next()) {
				if(usernames.equals(ra.getString("std_id"))) {
			/*
			 * while(rs.next()) { System.out.println(rs.getInt("numb")); }
			 * System.out.println(rs.getInt("numb"));
			 * System.out.println(rs.getString("id"));
			 */
					ResultSet rs=stmt.executeQuery("select * from users");
					while(rs.next()) {
						if (usernames.equals(rs.getString("id")) && passwords.equals(rs.getString("password"))) {
							/*
							 * Cookie user=new Cookie("username",usernames); Cookie pass=new
							 * Cookie("password",passwords); response.addCookie( user ); response.addCookie(
							 * pass );
							 */
							RequestDispatcher req = request.getRequestDispatcher("dashboards.jsp");
							request.setAttribute("username",usernames);
							req.forward(request, response);
						}
						else {
							RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
							req.include(request, response);
						}
					}
				}
				else {
					RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
			    	req.include(request, response);
				}
			}
			
			conn.commit();
			
			
			
		}
		catch(Exception e) {
			System.out.println(e);
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
