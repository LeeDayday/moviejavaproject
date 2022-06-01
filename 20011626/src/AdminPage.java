import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminPage extends JFrame {
	private JPanel contentPane;
	JLabel AdminLabel = new JLabel("������");
	private JTable table;
	private JTextField setField;
	private JTextField whereField;
	JTextField messageLabel = new JTextField("");
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void conDB() {
		try {
			con = Connectionz.getConnection();
		} catch(Exception ex) {
			messageLabel.setText(("Error"+ex));
		}
	}
	/**
	 * Create the frame.
	 */
	
	public AdminPage() {
		// ������ ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin Page");
		// ���� ����
		conDB();
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		AdminLabel.setFont(new Font("����", Font.BOLD, 20));
		
		AdminLabel.setBounds(22, 24, 209, 30);
		contentPane.add(AdminLabel);
		
		// UPDATE / DELETE
		JPanel setPanel = new JPanel();
		setPanel.setBounds(22, 130, 129, 57);
		contentPane.add(setPanel);
		setPanel.setLayout(null);
		
		JLabel setLabel = new JLabel("SET");
		setLabel.setFont(new Font("����", Font.BOLD, 14));
		setLabel.setBounds(0, 0, 50, 15);
		setPanel.add(setLabel);
		
		setField = new JTextField();
		setField.setBounds(0, 25, 129, 32);
		setPanel.add(setField);
		setField.setColumns(10);
		
		// ������ ����� ����
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"UPDATE", "DELETE"}));
		comboBox.setBounds(22, 89, 121, 23);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ù��° combobox ���� ��������
				String option = comboBox.getSelectedItem().toString();
				// UPDATE �� ���� SET�� �Է¹޴´�
				if (option.equals("UPDATE")) {
					setLabel.setEnabled(true);
					setField.setEnabled(true);
				}
				else if (option.equals("DELETE")){
					setLabel.setEnabled(false);
					setField.setText("");
					setField.setEnabled(false);
				}
			}
		});

			
		// ������ ������ ����� ������ ���̺� ����
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �ι�° combobox ���� ��������
				String table1 = comboBox_1.getSelectedItem().toString();
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Member", "Movie", "Reservation", "Schedule", "Seat", "Theater", "Ticket"}));
		comboBox_1.setBounds(182, 89, 129, 23);
		contentPane.add(comboBox_1);
		
		JPanel wherePanel = new JPanel();
		wherePanel.setLayout(null);
		wherePanel.setBounds(182, 130, 129, 57);
		contentPane.add(wherePanel);
		
		JLabel whereLabel = new JLabel("WHERE");
		whereLabel.setFont(new Font("����", Font.BOLD, 14));
		whereLabel.setBounds(0, 0, 76, 15);
		wherePanel.add(whereLabel);
		
		whereField = new JTextField();
		whereField.setColumns(10);
		whereField.setBounds(0, 25, 129, 32);
		wherePanel.add(whereField);
		
		messageLabel.setBounds(473, 82, 401, 30);
		contentPane.add(messageLabel);
		JButton btn1 = new JButton("����/����");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ComboBox ���� ��������
				String option = comboBox.getSelectedItem().toString();
				String table1 = comboBox_1.getSelectedItem().toString();
				// ���ǽ� ���ڿ� ��������
				String set = setField.getText();
				String where = whereField.getText();
				
				// UPDATE ����
				if(option.equals("UPDATE")) {
					try {
						messageLabel.setText("");
						String query = "update "+table1+" set "+set+" where "+where;
						//System.out.println(query);
						pst = con.prepareStatement(query);
						int ret = pst.executeUpdate();						
					}
					catch (Exception ex) {
						messageLabel.setText(("Error"+ex));
					}
				}
				// DELETE ����
				else {
					try {
						messageLabel.setText("");
						String query = "delete "+table1+" where "+where;
						//System.out.println(query);
						pst = con.prepareStatement(query);
						int ret = pst.executeUpdate();						
					}
					catch (Exception ex) {
						messageLabel.setText(("Error"+ex));
					}
				}
			}
		});
		btn1.setBounds(408, 139, 121, 35);
		contentPane.add(btn1);
		
		
		// �ʱ�ȭ
		JButton btn2 = new JButton("�ʱ�ȭ");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					messageLabel.setText("");
					String query;
					int cnt;
					// table ����
					
	                query="DROP TABLE IF EXISTS `Ticket`;"; 
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();	
					
					query="DROP TABLE IF EXISTS `Reservation`;";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();	

	                query="DROP TABLE IF EXISTS `Schedule`;";
					pst = con.prepareStatement(query);						
					cnt = pst.executeUpdate();	
					
					query="DROP TABLE IF EXISTS `Member`;";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();	
									
	                query="DROP TABLE IF EXISTS `Seat`;";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					query="DROP TABLE IF EXISTS `Theater`;";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();	
					
	                query="DROP TABLE IF EXISTS `Movie`;";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();	
					
					System.out.println("table ��� ����");

					// table ����
					query = "CREATE TABLE IF NOT EXISTS `Movie`(\r\n"
							+ "	`Movie_id`	INTEGER PRIMARY KEY,\r\n"
							+ "	`Movie_title`	VARCHAR(30),\r\n"
							+ "	`Movie_time`	INTEGER,\r\n"
							+ "	`Movie_grade`	VARCHAR(10),\r\n"
							+ "	`Movie_dir`	VARCHAR(20),\r\n"
							+ "	`Movie_actor`	VARCHAR(20),\r\n"
							+ "	`Movie_genre`	VARCHAR(20),\r\n"
							+ "	`Movie_info`	VARCHAR(200),\r\n"
							+ "	`Movie_open`	Date\r\n);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();	
					
					query = "CREATE TABLE IF NOT EXISTS `Theater` (\r\n"
							+ "	`Theater_id` 	INTEGER PRIMARY KEY,\r\n"
							+ "	`Theater_seats`	INTEGER,\r\n"
							+ "	`Theater_use`	BOOLEAN	\r\n);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					query = "CREATE TABLE IF NOT EXISTS `Schedule` (\r\n"
							+ "	`Schedule_id` 	INTEGER PRIMARY KEY,\r\n"
							+ "	`Movie_id`	INTEGER,\r\n"
							+ "	`Theater_id`	INTEGER,\r\n"
							+ "	`Schedule_date`	VARCHAR(10),\r\n"
							+ "	`Schedule_day`	VARCHAR(20),\r\n"
							+ "	`Schedule_nth`	VARCHAR(20),\r\n"
							+ "	`Schedule_time`	VARCHAR(10),\r\n"
							+ "	FOREIGN KEY (`Movie_id`) REFERENCES Movie(`Movie_id`),\r\n"
							+ "	FOREIGN KEY(`Theater_id`) REFERENCES Theater(`Theater_id`)\r\n);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					query = "CREATE TABLE IF NOT EXISTS `Seat` (\r\n"
							+ "	`Seat_id` 	INTEGER PRIMARY KEY,\r\n"
							+ "	`Theater_id`	INTEGER,\r\n"
							+ "	`Seat_use`	BOOLEAN,\r\n"
							+ "	FOREIGN KEY (`Theater_id`) REFERENCES Theater(`Theater_id`)\r\n);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					query = "CREATE TABLE IF NOT EXISTS `Member` (\r\n"
							+ "	`Member_id` 	INTEGER PRIMARY KEY,\r\n"
							+ "	`Member_name`	VARCHAR(10),\r\n"
							+ "	`Member_phone`	VARCHAR(15),\r\n"
							+ "	`Member_mail`	VARCHAR(25)\r\n);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					query = "CREATE TABLE IF NOT EXISTS `Reservation` (\r\n"
							+ "	`Res_id` 	INTEGER PRIMARY KEY,\r\n"
							+ "	`Res_payment`	VARCHAR(10),\r\n"
							+ "	`Res_cost`	INTEGER,\r\n"
							+ " `Res_paid`	BOOLEAN,\r\n"
							+ "	`Member_id`	INTEGER,\r\n"
							+ "	`Res_date`	DATE,\r\n"
							+ "	FOREIGN KEY (`Member_id`) REFERENCES Member(`Member_id`)\r\n);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					query = "CREATE TABLE IF NOT EXISTS `Ticket` (\r\n"
							+ "	`Ticket_id`	INTEGER PRIMARY KEY,\r\n"
							+ "	`Schedule_id`	INTEGER,\r\n"
							+ "	`Theater_id`	BOOLEAN,\r\n"
							+ "	`Seat_id`	INTEGER,\r\n"
							+ "	`Res_id`	INTEGER,\r\n"
							+ "	`Ticket_print`	BOOLEAN,\r\n"
							+ "	`Ticket_price`	INTEGER,\r\n"
							+ "	`Ticket_saleprice`	INTEGER,\r\n"
							+ "	FOREIGN KEY (`Schedule_id`) REFERENCES Schedule(`Schedule_id`),\r\n"
							+ "	FOREIGN KEY (`Seat_id`) REFERENCES Seat(`Seat_id`),\r\n"
							+ "	FOREIGN KEY (`Res_id`) REFERENCES Reservation(`Res_id`)\r\n);";
							
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					System.out.println("table ��� ����");

					// data �Է�
					query = "INSERT INTO `Movie` VALUES"
							+ "(1, '�����Ǽ�Ʈ2', 119, '15�� ������', '���Ŵ �ڴ�', '�������� ����', '��Ÿ��', '������ ����� ���������� ��� ���� ��ȣ�� �������Ǽ�Ʈ���� ��ó�� ������ �����ζ󡯿� ���ʸ� ���ڡ��� ��ȥ ������� �ΰ� ������ ���ױ׸��� �պ񡯿� �븳�ϰ� �ȴ�. �̿� ������ �ΰ��� ���� ������ ������ ������ ���� ���� ��ũ������ ���� ���ڳΡ����� �����ϸ鼭 �� ����� ���� �� ���� �Ŵ��� ���￡ �ָ����� �Ǵµ���..', STR_TO_DATE('2021-01-01','%Y-%m-%d')),"
							+ "(2, '��Ŀ', 123, 'û�ҳ� ���� �Ұ�', '��� �ʸ���', 'ȣ���� �Ǵн�', '������', '������ ���� �Ƽ� �÷��� �ڹ̵���� �޲ٴ� ����. ������ ��ΰ� ���İ��� �ڹ̵� ���� ���󿡼� �� �������δ� �װ� �� �ڸ��� ������ ���ݰ� �Ǵµ��� ������ �� �� ���� ��¥ ����Ŀ���� ������!', STR_TO_DATE('2021-02-01','%Y-%m-%d')),"
							+ "(3, '����Ʈ��', 116, '12�� ������', '���', '���汸', '�ڹ̵�', '����Ʈ�� �λ��� ���� ������ �޲ٴ� �Ǵ� �����⡯(������) ���� ������ �� 7���� ������ �ֽĿ� ����������, ���ۿ��� �Ӿ� �ֽ��� ���������� �ǰ� ����. ����� �����ϱ� ���� ��Ե� 7���� ���ؾ� �ϴ� ���� �տ� ��ĥ�� ���� ��ǥ �������(���汸)�� ��Ÿ����.', STR_TO_DATE('2021-03-01','%Y-%m-%d')),"
							+ "(4, '�����: �������', 181, '15�� ������', '�ȼҴ� ���', '�ι�Ʈ �ٿ�� �ִϾ�', 'SF', '���Ǵ�Ƽ �� ���� ���ݸ� ��Ƴ��� ���� ������ ����� �� ����� ���� ���� �׵��� ���� ��� ���� �ɾ���! ������ ����� ����� �ٲ� ������ ������ ��������!', STR_TO_DATE('2021-04-01','%Y-%m-%d')),"
							+ "(5, '����Ǯ', 106, 'û�ҳ� ���� �Ұ�', '���з�', '���̾� ���̳���', '�׼�', '�߸��� �̷��� �ٷ� ��� ���� ���ſ� �̷��� ������ ��������ε��� Ȱ���� �׸� SF ��ȭ', STR_TO_DATE('2021-05-01','%Y-%m-%d')),"
							+ "(6, 'Ÿ¥: �� ���̵� ��', 139, 'û�ҳ� ���� �Ұ�', '�ֵ���', '������', '����', '�������� Ÿ¥ ��¦�͡��� �Ƶ����� ��û��� �����⡯(������)�� ���ο��� ��̰� ������ ��Ŀ�ǿ����� ���� ��� �Ƿ��ڴ�. ��Ŀ�ǿ��� �쿬�� �˰� �� ����������(����ȭ)�� ���� �ŷ¿� ������ ������ �׳��� ���� ��Ű�� ���̻󹫡�(������)���� �Ӿ� ��Ŀ�� ������ ����� ����.', STR_TO_DATE('2021-06-01','%Y-%m-%d')),"
							+ "(7, '���� ��, ���� ��, �̻��� ��', 139, '15�� ������', '������', '�۰�ȣ', '�׼�', '�� �� �� ��Ƴ��´�! 1930���, �پ��� ������ �ھ�Ű�� ��Į�� �����ϴ� ����õ�� ������ ����� ���� �������� ���� �ٸ� ������� �ݵ��⸦ ��ư��� ������ ǳ���, �� ���� ���ڰ� ���ó�� �´ڶ߸���.', STR_TO_DATE('2021-07-01','%Y-%m-%d')),"
							+ "(8, '�ܿ�ձ�', 103, '��ü ������', '������ ��', '�̵� ����', '�ִϸ��̼�', '���迡 ���� �Ʒ��� �ձ��� ���ؾ߸� �ϴ� ����� �ȳ��� ������ ������ ������ ã�� ũ��������, �ö��� �׸��� ������ �Բ� ����õ���� ���� ������ ������ �ȴ�. �ڽ��� ���� �η����ߴ� ����� ���� �� ������ ���ĳ����⿡ �ڽ��� ���� ����ϴٰ� �Ͼ�߸� �ϴµ���', STR_TO_DATE('2021-08-01','%Y-%m-%d')),"
							+ "(9, '�ظ� ���Ϳ� �ӹ��� ��', 162, '��ü ������', 'ũ���� �ݷ�����', '�ٴϿ� ����Ŭ����', '����', '����� ������ ȣ�׿�Ʈ�� ���ƿԴ�!', STR_TO_DATE('2021-09-01','%Y-%m-%d')),"
							+ "(10, '�����', 131, '15�� ������', '����ȣ', '�۰�ȣ', '���', '��������� �� �� ���������� ���̴� ���� ����(�۰�ȣ) ����. �峲 ���(�ֿ��)���� ����� ģ���� ������� �� ��� ���� �ڸ��� ��ó�� ��ư ���������� ����̴�. �� ������ ����� ��� �ӿ� �ڻ���(�̼���) ������ ���ϴ� ���. �̷��� ���۵� �� ������ ���� �ڷ�, ������ �� ���� ����� ��ٸ��� �־����ϡ�', STR_TO_DATE('2021-10-01','%Y-%m-%d')),"
							+ "(11, '�ظ� ���Ϳ� �һ��� ����', 137, '��ü ������', '���̺� ������', '�ٴϿ� ����Ŭ����', '����', 'ȣ�׿�Ʈ �ִ��� ����. ��ҿ� �¼� ������ �´�!', STR_TO_DATE('2021-11-01','%Y-%m-%d')),"
							+ "(12, '�ظ� ���Ϳ� ������ ���� - 2��', 131, '��ü ������', '���̺� ������', '�ٴϿ� ����Ŭ����', '����', '��� ���� ���� ������ ����! ��Ÿ���� �Ƹ��ٿ� ���簡 ���� ��ħǥ�� ��´�!', STR_TO_DATE('2021-12-01','%Y-%m-%d'));";

					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					System.out.println("movie inserted");
					query = "INSERT INTO `Theater` VALUES"
							+ "(1, 10, True)," 
							+ "(2, 20, True)," 
							+ "(3, 30, True)," 
							+ "(4, 40, True),"
							+ "(5, 50, True)," 
							+ "(6, 60, True)," 
							+ "(7, 70, True)," 
							+ "(8, 80, True)," 
							+ "(9, 90, True)," 
							+ "(10, 100, True);";
					
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					System.out.println("Theater inserted");

					query = "INSERT INTO `Schedule` VALUES"
							+ "(1, 1, 1, STR_TO_DATE('2021-01-01','%Y-%m-%d'), 'Fri', 1, '16:30'),"
							+ "(2, 1, 3, STR_TO_DATE('2021-01-05','%Y-%m-%d'), 'Tue', 2, '06:30'),"
							+ "(3, 2, 2, STR_TO_DATE('2021-02-01','%Y-%m-%d'), 'Mon', 1, '12:30'),"
							+ "(4, 2, 4, STR_TO_DATE('2021-02-01','%Y-%m-%d'), 'Mon', 2, '18:30'),"
							+ "(5, 3, 3, STR_TO_DATE('2021-03-01','%Y-%m-%d'), 'Mon', 1, '16:30'),"
							+ "(6, 3, 5, STR_TO_DATE('2021-03-01','%Y-%m-%d'), 'Mon', 2, '18:30'),"
							+ "(7, 4, 4, STR_TO_DATE('2021-04-01','%Y-%m-%d'), 'Fri', 1, '16:30'),"
							+ "(8, 4, 6, STR_TO_DATE('2021-04-15','%Y-%m-%d'), 'Fri', 2, '12:30'),"
							+ "(9, 5, 5, STR_TO_DATE('2021-05-01','%Y-%m-%d'), 'Sat', 1, '16:30'),"
							+ "(10, 5, 8, STR_TO_DATE('2021-05-15','%Y-%m-%d'), 'Sat', 2, '14:30'),"
							+ "(11, 6, 6, STR_TO_DATE('2021-06-01','%Y-%m-%d'), 'Tue', 1, '15:30'),"
							+ "(12, 6, 1, STR_TO_DATE('2021-06-02','%Y-%m-%d'), 'Wed', 2, '16:30'),"
							+ "(13, 7, 7, STR_TO_DATE('2021-07-01','%Y-%m-%d'), 'Thu', 1, '15:00'),"
							+ "(14, 7, 9, STR_TO_DATE('2021-07-03','%Y-%m-%d'), 'Sun', 2, '16:30'),"
							+ "(15, 8, 8, STR_TO_DATE('2021-08-01','%Y-%m-%d'), 'Sun', 1, '12:00'),"
							+ "(16, 8, 10, STR_TO_DATE('2021-08-05','%Y-%m-%d'), 'Thu', 2, '16:30'),"
							+ "(17, 9, 9, STR_TO_DATE('2021-09-01','%Y-%m-%d'), 'Wed', 1, '16:30'),"
							+ "(18, 9, 8, STR_TO_DATE('2021-09-08','%Y-%m-%d'), 'Wed', 2, '11:30'),"
							+ "(19, 10, 10, STR_TO_DATE('2021-10-01','%Y-%m-%d'), 'Fri', 1, '16:30'),"
							+ "(20, 10, 10, STR_TO_DATE('2021-10-01','%Y-%m-%d'), 'Fri', 2, '22:30'),"
							+ "(21, 11, 1, STR_TO_DATE('2021-11-01','%Y-%m-%d'), 'Mon', 1, '09:30'),"
							+ "(22, 11, 5, STR_TO_DATE('2021-11-22','%Y-%m-%d'), 'Mon', 2, '10:00'),"
							+ "(23, 12, 4, STR_TO_DATE('2021-12-01','%Y-%m-%d'), 'Wed', 1, '16:30'),"
							+ "(24, 12, 6, STR_TO_DATE('2021-12-22','%Y-%m-%d'), 'Wed', 2, '20:30');";														
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					System.out.println("Schedule inserted");

					query = "INSERT INTO `Member` VALUES"
							+ "(1, '�̰���', '010-000-0001', 'qwdqdq@naver.com'),"
							+ "(2, '�̳���', '010-000-0002', 'sqdq@naver.com'),"
							+ "(3, '�̴���', '010-000-0003', 'qeqr@daum.net'),"
							+ "(4, '�̶���', '010-000-0004', 'dqdq@gmail.com'),"
							+ "(5, '�̸���', '010-000-0005', 'gwhhw@naver.com'),"
							+ "(6, '�̹���', '010-000-0006', 'vweve@gmail.com'),"
							+ "(7, '�̻���', '010-000-0007', 'hw334@daum.net'),"
							+ "(8, '�̾���', '010-000-0008', 'gewew8@gmail.com'),"
							+ "(9, '������', '010-000-0009', '2gddwf@naver.com'),"
							+ "(10, '������', '010-000-00010', 'qge0123@naver.com');";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					System.out.println("Member inserted");

					query = "INSERT INTO `Seat` VALUES"
							+ "(1, 1, True),"
							+ "(2, 1, False),"
							+ "(3, 1, False),"
							+ "(4, 2, True),"
							+ "(5, 2, False),"
							+ "(6, 2, False),"
							+ "(7, 3, True),"
							+ "(8, 3, False),"
							+ "(9, 3, False),"
							+ "(10, 4, True),"
							+ "(11, 4, False),"
							+ "(12, 4, False),"
							+ "(13, 5, True),"
							+ "(14, 5, False),"
							+ "(15, 5, False),"
							+ "(16, 6, True),"
							+ "(17, 6, False),"
							+ "(18, 6, False),"
							+ "(19, 7, True),"
							+ "(20, 7, False),"
							+ "(21, 7, False),"
							+ "(22, 8, True),"
							+ "(23, 8, False),"
							+ "(24, 8, False),"
							+ "(25, 9, True),"
							+ "(26, 9, False),"
							+ "(27, 9, False),"
							+ "(28, 10, True),"
							+ "(29, 10, False),"
							+ "(30, 10, False);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					System.out.println("Seat inserted");

					query = "INSERT INTO `Reservation` VALUES"
							+ "(1, 'Card', 7000, TRUE, 1, STR_TO_DATE('2021-01-01','%Y-%m-%d')),"
							+ "(2, 'Card', 9000, TRUE, 2, STR_TO_DATE('2021-02-01','%Y-%m-%d')),"
							+ "(3, 'Cash', 7000, TRUE, 3, STR_TO_DATE('2021-03-01','%Y-%m-%d')),"
							+ "(4, 'Card', 7000, TRUE, 4, STR_TO_DATE('2021-04-01','%Y-%m-%d')),"
							+ "(5, 'Card', 9000, TRUE, 5, STR_TO_DATE('2021-05-01','%Y-%m-%d')),"
							+ "(6, 'Card', 9000, TRUE, 6, STR_TO_DATE('2021-06-01','%Y-%m-%d')),"
							+ "(7, 'Cash', 9000, TRUE, 7, STR_TO_DATE('2021-07-01','%Y-%m-%d')),"
							+ "(8, 'Card', 7000, TRUE, 8, STR_TO_DATE('2021-08-01','%Y-%m-%d')),"
							+ "(9, 'Cash', 7000, TRUE, 9, STR_TO_DATE('2021-09-01','%Y-%m-%d')),"
							+ "(10, 'Card', 7000, TRUE, 10, STR_TO_DATE('2021-10-01','%Y-%m-%d'));";				
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					System.out.println("reservation inserted");

					query = "INSERT INTO `Ticket` VALUES"
							+ "(1, 1, 1, 1, 1, TRUE,  8000, 7000),"
							+ "(2, 3, 2, 4, 2, TRUE,  10000, 9000),"
							+ "(3, 1, 3, 7, 3, TRUE,  8000, 7000),"
							+ "(4, 1, 4, 10, 4, TRUE,  8000, 7000),"
							+ "(5, 1, 5, 13, 5, TRUE,  10000, 9000),"
							+ "(6, 1, 6, 16, 6, TRUE,  10000, 9000),"
							+ "(7, 1, 7, 19, 7, TRUE,  10000, 9000),"
							+ "(8, 1, 8, 22, 8, TRUE,  8000, 7000),"
							+ "(9, 1, 9, 25, 9, TRUE,  8000, 7000),"
							+ "(10, 1, 10, 27, 10, TRUE,  8000, 7000);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();					
					System.out.println("Ticket inserted");

					messageLabel.setText("�ʱ�ȭ�� ���������� �Ϸ��߽��ϴ�.");
				}
				catch (Exception ex) {
					messageLabel.setText(("Error"+ex));	
					System.out.println(ex);
				}
			}
		});
		
		JComboBox searchBox = new JComboBox();
		searchBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table2 = searchBox.getSelectedItem().toString();
			}
		});
		searchBox.setModel(new DefaultComboBoxModel(new String[] {"Member", "Movie", "Reservation", "Schedule", "Seat", "Theater", "Ticket"}));
		searchBox.setBounds(22, 197, 129, 23);
		contentPane.add(searchBox);
		btn2.setBounds(742, 139, 110, 35);
		contentPane.add(btn2);
		
		table = new JTable();
		table.setBounds(22, 250, 844, 324);
		contentPane.add(table);
		
		JButton btn3 = new JButton("���̺� �˻�");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn3.setBounds(184, 205, 110, 35);
		contentPane.add(btn3);
			

	}
}
