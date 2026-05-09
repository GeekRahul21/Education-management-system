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

@WebServlet("/ViewStudent")
public class ViewStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<link rel='stylesheet' href='ViewStudentCss.css'>");
		pw.println("</head>");
		pw.println("<body>");
		
		
		pw.println("<h2>Student List</h2>");
	    pw.println("<a href='AddStudent123.html'>Add student</a><br></br>");

	    pw.println("<table border='1'>");
	    pw.println("<tr>");
	    pw.println("<th>Student ID</th>");
	    pw.println("<th>Name</th>");
	    pw.println("<th>Course</th>");
	    pw.println("<th>Email</th>");
	    pw.println("<th>Action</th>");
	    pw.println("</tr>");
	    
	    try {
	    	Connection con=DB_Connection.getConn();
	    	
	    	PreparedStatement ps=con.prepareStatement("Select * From Student");
	    	ResultSet rs=ps.executeQuery();
	    	
	    	while(rs.next()) {
	    		

	    		int id=rs.getInt("id");
		          pw.println("<tr>");
		        //  pw.println("<td>"+id+("id")+"</td>");
		          pw.println("<td>" + rs.getString("id_no")+"</td>");
		          pw.println("<td>" + rs.getString("name") + "</td>");
		          pw.println("<td>" + rs.getString("course") + "</td>");
		          pw.println("<td>" + rs.getString("email") + "</td>");

		          // Action buttons

		         pw.println("<td>");
		          pw.println("<a href='DeleteStudent?id=" + id + "'>Delete</a>");
		          pw.println("<a href='EditStudent?id=" + id + "'>Edit</a>");
		          pw.println("</td>");

		          pw.println("</tr>");
	    	}
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	}

}
