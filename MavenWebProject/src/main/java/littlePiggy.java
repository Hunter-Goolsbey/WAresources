
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class littlePiggy
 */

@WebServlet("/littlePiggy")
public class littlePiggy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String pw = System.getenv("SQLJAVA");
		String location = System.getenv("SQLLOCATION");
		String std = "hello world";
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://" + location + ":3306/helloworld", "ducky", pw);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"select * from UserCredentials where Username='" + username + "'and Password='" + password + "';");
			if (rs.next()) {
				std = rs.getString(3);
				request.setAttribute("pw", pw);
				request.setAttribute("data", std);
				RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
				//response.sendRedirect( "Home.jsp?name=" + rs.getString(3));
				// System.out.println(Integer.toString(2+2));
			} else {
				//response.sendRedirect("https://google.com");
				response.getWriter().println("<h1>Wrong username and password</h1>");
			}
			con.close();
		} catch (Exception e) {
			// response.sendRedirect("Home.jsp");
			//System.out.println("Connection not Made");
			response.getWriter().println(e);
			//response.getWriter().println(pw);
			//System.out.println(e);
		}
		
	}
}
