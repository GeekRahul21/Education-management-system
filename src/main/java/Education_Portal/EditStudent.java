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

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {

	// this edit servelet is to create a html form where old form values are stored
	// and through update servlet we update the values

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		int ID = Integer.parseInt(request.getParameter("id"));

		try {
			Connection con = DB_Connection.getConn();

			PreparedStatement ps = con.prepareStatement("Select * from Student where id=?");

			// set the value in update form

			ps.setInt(1, ID);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pw.println("<form action='UpdateStudent' method='post'>");

				pw.println("<input type='hidden' name='id' value='" + ID + "'>");

				pw.println("Student ID:<input type='text' name='id_no' value='" + rs.getString("id_no") + "'><br>");
				pw.println("Name:<input type='text' name='name' value='" + rs.getString("name") + "'><br>");
				pw.println("Email:<input type='text' name='course' value='" + rs.getString("course") + "'><br>");
				pw.println("Course:<input type='text' name='email' value='" + rs.getString("email") + "'><br>");

				pw.println("<button>Update</button>");
				pw.println("</form>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// response.sendRedirect("ViewStudent");
	}

}
