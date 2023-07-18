

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class littlePiggy
 */
@WebServlet("/littlePiggy")
public class littlePiggy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public littlePiggy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    //
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HelloWorld","root","Cook1");
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
