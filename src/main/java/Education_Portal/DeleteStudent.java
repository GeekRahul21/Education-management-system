package Education_Portal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Database_Connection.DB_Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ID=Integer.parseInt(request.getParameter("id"));
		
		try {
			
			Connection con=DB_Connection.getConn();
			
			PreparedStatement ps=con.prepareStatement("Delete from Student where id=?");
			
			ps.setInt(1, ID);
			
			ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("ViewStudent");
	}

}
