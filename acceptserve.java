package my_pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class acceptserve
 */
@WebServlet("/acceptserve")
public class acceptserve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acceptserve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int form=Integer.parseInt(request.getParameter("form_id").substring(0,(request.getParameter("form_id")).length()-1));
		String proctor=request.getParameter("proct").substring(0,(request.getParameter("proct")).length()-1);
		System.out.println("form id "+form);
		System.out.println("form id "+proctor);
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saranya");
			if(proctor.equals("10003")) {
				String selectSQL = "update form set hod_app='true' where form_id=?";
				PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
				preparedStatement.setInt(1, form);
				preparedStatement.executeQuery();
				System.out.println("updated successfully");
				RequestDispatcher req = request.getRequestDispatcher("dashboardhod.jsp");
				request.setAttribute("username",proctor);
				req.include(request, response);
			}
			else {
				String selectSQL = "update form set proct_app='true' where form_id=?";
				PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
				preparedStatement.setInt(1, form);
				preparedStatement.executeQuery();
				System.out.println("updated successfully");
				RequestDispatcher req = request.getRequestDispatcher("dashboardf.jsp");
				request.setAttribute("username",proctor);
				
				req.include(request, response);
			}
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
