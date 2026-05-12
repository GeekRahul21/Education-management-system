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

@WebServlet("/RegisterServlet")
public class Register123 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fn = request.getParameter("fullname");
        String em = request.getParameter("email");
        String ur = request.getParameter("username");
        String ps = request.getParameter("password");

        try {

            Connection con = DB_Connection.getConn();

            PreparedStatement ps1 = con.prepareStatement(
                    "insert into Staff(fullname,email,username,password) values(?,?,?,?)");

            ps1.setString(1, fn);
            ps1.setString(2, em);
            ps1.setString(3, ur);
            ps1.setString(4, ps);

            ps1.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("Login123.html");
    }
}