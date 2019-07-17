package my_pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
/*import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class datastoreserve
 */
@WebServlet("/datastoreserve")
public class datastoreserve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datastoreserve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rollno=request.getParameter("std_id");
		int days=Integer.parseInt(request.getParameter("days"));
		String start_date=request.getParameter("start_date");
		String reason=request.getParameter("reason");
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saranya");
			String sql="insert into form(std_id,days,start_date,reason,proct_app,hod_app) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, rollno);
			preparedStatement.setInt(2, days);
			preparedStatement.setString(3, start_date);
			preparedStatement.setString(4, reason);
			preparedStatement.setString(5, "false");
			preparedStatement.setString(6,"false");
			preparedStatement.executeQuery();
			//System.out.println("stored successfully");
		}
		catch(Exception e) {
			System.out.println(e);
			
			
		}
		RequestDispatcher req = request.getRequestDispatcher("dashboards.jsp");
		request.setAttribute("username",rollno);
		req.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
