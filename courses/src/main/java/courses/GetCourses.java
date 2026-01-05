package courses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class GetCourses {
	private static final String URL =
		    "jdbc:mysql://localhost:3306/student_demo?useSSL=false&serverTimezone=UTC";
		    private static final String USER = "root";
		    private static final String PASS = "ch_sathwik_15";
  
  private static void getAllCourses() throws Exception{
    String sql = "select * from courses";
    
    try(Connection cn = DriverManager.getConnection(URL,USER,PASS);
      Statement st = cn.createStatement();
      ResultSet rs = st.executeQuery(sql);){
      System.out.println("------Get All Courses------");
      while(rs.next()) {
        int id = rs.getInt("id");
        String CC = rs.getString("coursecode");
        String CN = rs.getString("coursename");
        System.out.println(id+"|"+CC+"|"+CN);
      }
    }
  }
  public static void main(String[] main) {
    try {
      getAllCourses();
    }
    catch(Exception e){
      e.getStackTrace();
    }
  }
  }