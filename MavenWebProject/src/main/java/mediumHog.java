

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
 * Servlet implementation class mediumHog
 */
public class mediumHog extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	String vehicle = request.getParameter("vehicleName");
		String vinNum = request.getParameter("vin");
		String make = request.getParameter("make");
		String pw = System.getenv("SQLJAVA");
		String location = System.getenv("SQLLOCATION");
		String del = request.getParameter("deleteVehicle");
		String id = request.getParameter("vehicleID");

    	
    	response.setContentType("text/html");
    	response.getWriter().println("<h1>Wrong username and password</h1>");
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://" + location + ":3306/myGarage", "ducky", pw);
			Statement stm = con.createStatement();
			String insertQuery = "INSERT INTO vehicles (vehicleName, VIN, Make) VALUES ('" + vehicle + "', '" + vinNum + "', '" + make + "');";
			if (del.length() > 0) {
				insertQuery = "DELETE FROM vehicles WHERE vehicleID = " + id + ";";
			}
			stm.executeUpdate(insertQuery);
			
			response.sendRedirect("Home.jsp");
				// System.out.println(Integer.toString(2+2));
			con.close();
			
    	} catch (Exception e) {
			// response.sendRedirect("Home.jsp");
			//System.out.println("Connection not Made");
			response.getWriter().println(e);
			response.getWriter().println(id);
			//response.getWriter().println(pw);
			//System.out.println(e);
		}
    }
}
