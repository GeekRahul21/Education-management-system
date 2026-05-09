package Education_Portal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database_Connection.DB_Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class Login123 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		
		String us=request.getParameter("username");
		String ps=request.getParameter("password");
		
		try {
			Connection con=DB_Connection.getConn();
			
			PreparedStatement p=con.prepareStatement("Select * from Staff  where username=? and password=?");
			
			p.setString(1, us);
			p.setString(2, ps);
			
			ResultSet rs=p.executeQuery();
			
			if(rs.next()) {
				response.sendRedirect("Welcome123.html");
			}
			else {
				pw.println("Not Valid Credential !!!!!!!!!!");
			}
		}
		catch(Exception e) {
			
		}
	}

}
