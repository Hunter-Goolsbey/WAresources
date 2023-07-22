

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bigOink
 */
@WebServlet("/bigOink")
public class bigOink extends HttpServlet {
	private static final long serialVersionUID = 1L;

        // TODO Auto-generated constructor stub
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	response.sendRedirect("Home.html");
		//doGet(request, response);
	}

}
