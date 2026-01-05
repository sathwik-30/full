package ab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {

    private static final String URL =
    "jdbc:mysql://localhost:3306/student_demo?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "ch_sathwik_15";

    public static void main(String[] args) {

        System.out.println("JAVA PROGRAM STARTED - UPDATE");

        String sql = "UPDATE students SET email = ? WHERE id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "sathwik_updated@kluniversity.in");

            ps.setInt(2, 1);

            int row = ps.executeUpdate();
            System.out.println("Updated Rows = " + row);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
