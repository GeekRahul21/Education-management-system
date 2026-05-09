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

@WebServlet("/AddStudentServlet")
public class AddStudent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String sn=request.getParameter("name");
		String co=request.getParameter("course");
		String em=request.getParameter("email");
		
		try {
			Connection con=DB_Connection.getConn();
			
			PreparedStatement ps=con.prepareStatement("insert into Student(id_no,name,course,email) values (?,?,?,?)");
			
			ps.setString(1, id);
			ps.setString(2, sn);
			ps.setString(3, co);
			ps.setString(4, em);
			
			ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("Welcome123.html");
		
		
		
	}

}
