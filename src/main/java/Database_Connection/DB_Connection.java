
package Database_Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {

    public static Connection getConn() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/Education_System";
            String username = "root";
            String password = "rayal_goluExe@2324";

            con = DriverManager.getConnection(url, username, password);

            System.out.println("Connected");

        } catch (Exception e) {

            e.printStackTrace();
        }

        return con;
    }
}