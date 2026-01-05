package courses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class InsertCourses {
	private static final String URL =
		    "jdbc:mysql://localhost:3306/student_demo?useSSL=false&serverTimezone=UTC";
		    private static final String USER = "root";
		    private static final String PASS = "ch_sathwik_15";
  public static void main(String[] args) {
    String sql = "insert into courses (coursecode , coursename) values(?,?)";
    String CC = "23SDC201E";
    String CN = "FullStack Development";
    
    try(Connection con=DriverManager.getConnection(URL,USER,PASS); 
        PreparedStatement pos = con.prepareStatement(sql))
    {
      pos.setString(1, CC);
      pos.setString(2, CN);
      int rows = pos.executeUpdate();
      System.out.println("Insert rows = "+rows);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}