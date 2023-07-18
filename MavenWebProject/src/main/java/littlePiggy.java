

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HelloWorld","root","root");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from UserCredentials where Username='" + username + "'and Password='" + password +"';");
			if(rs.next()) {
				response.sendRedirect("Home.html");
				//System.out.println(Integer.toString(2+2));
			} else {
				response.getWriter().println("wrong username and password");
			}
			con.close();
		}catch (Exception e){
			System.out.println("Connection not Made");
			System.out.println(e);
		}
    }
}
