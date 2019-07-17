package my_pack;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginserve
 */
@WebServlet("/loginserve")
public class loginserve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginserve() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usernamef = request.getParameter("idf");
		// String usernamef = "00000";
		System.out.println(usernamef);
		String passwordf = request.getParameter("passf");
		/*
		 * Cookie[] cookies = null; cookies = request.getCookies(); if(cookies!=null) {
		 * for(int i=0;i<cookies.length;i++){ cookies[i].setMaxAge(0);
		 * //response.addCookie(cookies[i]); } }
		 */
		/*
		 * Cookie user=new Cookie("username",usernamef); Cookie pass=new
		 * Cookie("password",passwordf); response.addCookie( user ); response.addCookie(
		 * pass );
		 */
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "saranya");
			Statement stmt = conn.createStatement();
			ResultSet ra = stmt.executeQuery("select * from proctor");
			while (ra.next()) 
			{
				//System.out.println("checking with proct table" + ra.getString("proct_id"));
				
				if (usernamef.equals(ra.getString("proct_id"))) 
				{
					System.out.println("Username "+ra.getString("proct_id")+" matchd with DB");
					ResultSet rs = stmt.executeQuery("select * from users");
					while (rs.next()) 
					{
						System.out.println("checking with users table" + rs.getString("id"));
						if (usernamef.equals(rs.getString("id")) && passwordf.equals(rs.getString("password"))) 
						{
							if (usernamef.equals("00000")) 
							{
								RequestDispatcher req = request.getRequestDispatcher("dashboardhod.jsp");
								request.setAttribute("username", usernamef);
								req.forward(request, response);
							}
							else 
							{
								/*
								 * Cookie user=new Cookie("username",usernamef); Cookie pass=new
								 * Cookie("password",passwordf); response.addCookie( user ); response.addCookie(
								 * pass );
								 */
								if (!response.isCommitted()) 
								{
									System.out.println("going to dashboardf");
									RequestDispatcher req = request.getRequestDispatcher("dashboardf.jsp");
									request.setAttribute("username", usernamef);
									req.forward(request, response);
								} 
								/*
								 * else { System.out.println("response commited"); }
								 */

							}
						} else {
							System.out.println("back to login");
							RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
							req.include(request, response);
						}
					}
				} else {
					RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
					req.include(request, response);
				}
			}

			//conn.commit();

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
