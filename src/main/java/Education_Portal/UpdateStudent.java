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

@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int ID=Integer.parseInt(request.getParameter("id"));
		
		String name=request.getParameter("name");
		String course=request.getParameter("course");
		String email=request.getParameter("email");
		String id_no=request.getParameter("id_no");
		
		try {
			Connection con=DB_Connection.getConn();
			
			PreparedStatement ps=con.prepareStatement("Update Student set name=?,course=?,email=?,id_no=? where id=?");
			
			ps.setString(1, name);
			ps.setString(2, course);
			ps.setString(3, email);
			ps.setString(4, id_no);
			ps.setInt(5, ID);
			
			ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("ViewStudent");

	}

}
