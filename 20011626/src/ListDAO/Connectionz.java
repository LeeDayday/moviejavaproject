package ListDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionz {
	   static Connection con;
	// 클래스 booklist를 선언한다. java.sql의 Connection 객체 con을 선언한다.  	
	   public static Connection getConnection() {
	     String Driver="";
	     String 
	     url="jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul"; 
	     String userid="madang";
	     String pwd="madang";
	// 접속변수를 초기화한다. url은 자바 드라이버 이름, 호스트명(localhost), 포트번호를 입력한다
	// userid는 관리자(madang), pwd는 사용자의 비밀번호(madang)를 입력한다.    
	     try { /* 드라이버를 찾는 과정 */
	       Class.forName("com.mysql.cj.jdbc.Driver");   
	       System.out.println("드라이버 로드 성공");
	     } catch(ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	// Class.forName()으로 드라이버를 로딩한다. 드라이버 이름을 Class.forName에 입력한다.      
	     try { /* 데이터베이스를 연결하는 과정 */
	       System.out.println("데이터베이스 연결 준비...");	
	       con=DriverManager.getConnection(url, userid, pwd);
	       System.out.println("데이터베이스 연결 성공");
	     } catch(SQLException e) {
	         e.printStackTrace();
	       }
	     return con;
	   }
}
