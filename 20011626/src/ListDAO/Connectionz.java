package ListDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionz {
	   static Connection con;
	// Ŭ���� booklist�� �����Ѵ�. java.sql�� Connection ��ü con�� �����Ѵ�.  	
	   public static Connection getConnection() {
	     String Driver="";
	     String 
	     url="jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul"; 
	     String userid="madang";
	     String pwd="madang";
	// ���Ӻ����� �ʱ�ȭ�Ѵ�. url�� �ڹ� ����̹� �̸�, ȣ��Ʈ��(localhost), ��Ʈ��ȣ�� �Է��Ѵ�
	// userid�� ������(madang), pwd�� ������� ��й�ȣ(madang)�� �Է��Ѵ�.    
	     try { /* ����̹��� ã�� ���� */
	       Class.forName("com.mysql.cj.jdbc.Driver");   
	       System.out.println("����̹� �ε� ����");
	     } catch(ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	// Class.forName()���� ����̹��� �ε��Ѵ�. ����̹� �̸��� Class.forName�� �Է��Ѵ�.      
	     try { /* �����ͺ��̽��� �����ϴ� ���� */
	       System.out.println("�����ͺ��̽� ���� �غ�...");	
	       con=DriverManager.getConnection(url, userid, pwd);
	       System.out.println("�����ͺ��̽� ���� ����");
	     } catch(SQLException e) {
	         e.printStackTrace();
	       }
	     return con;
	   }
}
