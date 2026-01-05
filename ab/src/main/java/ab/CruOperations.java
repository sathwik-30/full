package ab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CruOperations {

    private static final String URL =
    "jdbc:mysql://localhost:3306/student_demo?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "ch_sathwik_15";

    public static void main(String[] args) {
    	 System.out.println("JAVA PROGRAM STARTED");
        String sql = "INSERT INTO students(name,email) VALUES (?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "sathwik");
            ps.setString(2, "sathwik@kluniversity.in");

            int row = ps.executeUpdate();
            System.out.println("Inserted Rows=" + row);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
