import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ListDAO.Connectionz;
import ListDAO.MemberListDAO;
import ListDAO.MovieListDAO;
import ListDAO.ReservationListDAO;
import ListDAO.ScheduleListDAO;
import ListDAO.SeatListDAO;
import ListDAO.TheaterListDAO;
import ListDAO.TicketListDAO;
import ListVO.MemberListVO;
import ListVO.MovieListVO;
import ListVO.ReservationListVO;
import ListVO.ScheduleListVO;
import ListVO.SeatListVO;
import ListVO.TheaterListVO;
import ListVO.TicketListVO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
import java.util.ArrayList;

public class AdminPage extends JFrame {
	private JPanel contentPane;
	JLabel AdminLabel = new JLabel("������");
	private JTextField setField;
	private JTextField whereField;
	JTextField messageLabel = new JTextField("");
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int insertFlag = 0;

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
		
		
		// Insert
		
		JPanel propPanel = new JPanel(); // �Ӽ� �Է� â. JTextField�� ������ �޴´�
		propPanel.setBounds(22, 264, 830, 230);
		contentPane.add(propPanel);
		propPanel.setLayout(null);
		
		JPanel prop1 = new JPanel();
		prop1.setLayout(null);
		prop1.setBounds(0, 20, 129, 57);
		propPanel.add(prop1);
		
		JLabel propL1 = new JLabel("");
		propL1.setFont(new Font("����", Font.BOLD, 14));
		propL1.setBounds(0, 0, 129, 15);
		prop1.add(propL1);
		
		JTextField propF1 = new JTextField();
		propF1.setColumns(10);
		propF1.setBounds(0, 25, 129, 32);
		prop1.add(propF1);
		
		JPanel prop2 = new JPanel();
		prop2.setLayout(null);
		prop2.setBounds(159, 20, 129, 57);
		propPanel.add(prop2);
		
		JLabel propL2 = new JLabel("");
		propL2.setFont(new Font("����", Font.BOLD, 14));
		propL2.setBounds(0, 0, 129, 15);
		prop2.add(propL2);
		
		JTextField propF2 = new JTextField();
		propF2.setColumns(10);
		propF2.setBounds(0, 25, 129, 32);
		prop2.add(propF2);
		
		JPanel prop3 = new JPanel();
		prop3.setLayout(null);
		prop3.setBounds(321, 20, 129, 57);
		propPanel.add(prop3);
		
		JLabel propL3 = new JLabel("");
		propL3.setFont(new Font("����", Font.BOLD, 14));
		propL3.setBounds(0, 0, 129, 15);
		prop3.add(propL3);
		
		JTextField propF3 = new JTextField();
		propF3.setColumns(10);
		propF3.setBounds(0, 25, 129, 32);
		prop3.add(propF3);
		
		JPanel prop4 = new JPanel();
		prop4.setLayout(null);
		prop4.setBounds(484, 20, 129, 57);
		propPanel.add(prop4);
		
		JLabel propL4 = new JLabel("");
		propL4.setFont(new Font("����", Font.BOLD, 14));
		propL4.setBounds(0, 0, 129, 15);
		prop4.add(propL4);
		
		JTextField propF4 = new JTextField();
		propF4.setColumns(10);
		propF4.setBounds(0, 25, 129, 32);
		prop4.add(propF4);
		
		JPanel prop5 = new JPanel();
		prop5.setLayout(null);
		prop5.setBounds(643, 20, 129, 57);
		propPanel.add(prop5);
		
		JLabel propL5 = new JLabel("");
		propL5.setFont(new Font("����", Font.BOLD, 14));
		propL5.setBounds(0, 0, 129, 15);
		prop5.add(propL5);
		
		JTextField propF5 = new JTextField();
		propF5.setColumns(10);
		propF5.setBounds(0, 25, 129, 32);
		prop5.add(propF5);
		
		JPanel prop6 = new JPanel();
		prop6.setLayout(null);
		prop6.setBounds(0, 142, 129, 57);
		propPanel.add(prop6);
		
		JLabel propL6 = new JLabel("");
		propL6.setFont(new Font("����", Font.BOLD, 14));
		propL6.setBounds(0, 0, 129, 15);
		prop6.add(propL6);
		
		JTextField propF6 = new JTextField();
		propF6.setColumns(10);
		propF6.setBounds(0, 25, 129, 32);
		prop6.add(propF6);
		
		JPanel prop7 = new JPanel();
		prop7.setLayout(null);
		prop7.setBounds(159, 142, 129, 57);
		propPanel.add(prop7);
		
		JLabel propL7 = new JLabel("");
		propL7.setFont(new Font("����", Font.BOLD, 14));
		propL7.setBounds(0, 0, 129, 15);
		prop7.add(propL7);
		
		JTextField propF7 = new JTextField();
		propF7.setColumns(10);
		propF7.setBounds(0, 25, 129, 32);
		prop7.add(propF7);
		
		JPanel prop8 = new JPanel();
		prop8.setLayout(null);
		prop8.setBounds(321, 142, 129, 57);
		propPanel.add(prop8);
		
		JLabel propL8 = new JLabel("");
		propL8.setFont(new Font("����", Font.BOLD, 14));
		propL8.setBounds(0, 0, 129, 15);
		prop8.add(propL8);
		
		JTextField propF8 = new JTextField();
		propF8.setColumns(10);
		propF8.setBounds(0, 25, 129, 32);
		prop8.add(propF8);
		
		JPanel prop9 = new JPanel();
		prop9.setLayout(null);
		prop9.setBounds(484, 142, 129, 57);
		propPanel.add(prop9);
		
		JLabel propL9 = new JLabel("");
		propL9.setFont(new Font("����", Font.BOLD, 14));
		propL9.setBounds(0, 0, 129, 15);
		prop9.add(propL9);
		
		JTextField propF9 = new JTextField();
		propF9.setColumns(10);
		propF9.setBounds(0, 25, 129, 32);
		prop9.add(propF9);
		
		propPanel.setVisible(false);
		// property �Է� â�� ���� Insert �� ���� ���̰� ����
		
		// UPDATE / DELETE
		JPanel setPanel = new JPanel(); // set �Է� ����
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
		
		JPanel wherePanel = new JPanel(); // where �Է� ����
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
		

		
		JTextArea tableArea = new JTextArea(); // �˻��� ����� ��µǴ� ����
		JScrollPane sp = new JScrollPane(tableArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		sp.setBounds(22, 260, 828, 314);
		add(sp);
		//tableArea.setBounds(22, 260, 828, 314);

		
		
		
		// ������ ����� ����
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" - ��� ���� - ","INSERT","UPDATE", "DELETE"}));
		comboBox.setBounds(22, 89, 121, 23);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ù��° combobox ���� ��������
				String option = comboBox.getSelectedItem().toString();
				sp.setVisible(false);

				// UPDATE �� ���� SET�� �Է¹޴´�
				propPanel.setVisible(false);
				if(option.equals("INSERT")) {
					setPanel.setVisible(false);
					wherePanel.setVisible(false);
					sp.setVisible(false);
					insertFlag = 1;
					
				}
				else if (option.equals("UPDATE")) {
					setPanel.setVisible(true);
					wherePanel.setVisible(true);
					setLabel.setEnabled(true);
					setField.setEnabled(true);
					insertFlag = 0;
				}
				else if (option.equals("DELETE")){
					setPanel.setVisible(true);
					wherePanel.setVisible(true);
					setLabel.setEnabled(false);
					setField.setText("");
					setField.setEnabled(false);
					insertFlag = 0;
				}
				else {
					insertFlag = 0;
				}
			}
		});

		
		// ������ ������ ����� ������ ���̺� ����
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// combobox ���� ��������
				sp.setVisible(false);

				String table1 = comboBox_1.getSelectedItem().toString();
				if(insertFlag == 1)
				{
					propPanel.setVisible(true);
					prop4.setVisible(true);
					prop5.setVisible(true);
					prop6.setVisible(true);
					prop7.setVisible(true);
					prop8.setVisible(true);
					prop9.setVisible(true);
					// Member table �Ӽ� �� �Է� â ����
					if(table1.equals("Member"))
					{
						// ȸ�� ���̵� \t ���� \t ��ȭ��ȣ \t ���ڸ��� \
						propL1.setText("ȸ�� ���̵�");
						propL2.setText("����");
						propL3.setText("��ȭ��ȣ");
						propL4.setText("���� ����");
						prop5.setVisible(false);
						prop6.setVisible(false);
						prop7.setVisible(false);
						prop8.setVisible(false);
						prop9.setVisible(false);
					}
					// Movie table �Ӽ� �� �Է� â ����
					else if (table1.equals("Movie"))
					{ 
						// ��ȭ��ȣ \t ��ȭ�� \t �󿵽ð� \t �󿵵�� \t ������ \t ���� \t �帣 \t ��ȭ�Ұ� \t ������ ����
						propL1.setText("��ȭ��ȣ");
						propL2.setText("��ȭ��");
						propL3.setText("�󿵽ð�");
						propL4.setText("�󿵵��");
						propL5.setText("����");
						propL6.setText("���");
						propL7.setText("�帣");
						propL8.setText("��ȭ�Ұ�");
						propL9.setText("������");
					}
					// Reservation table �Ӽ� �� �Է� â ����
					else if (table1.equals("Reservation")) 
					{
						// ���Ź�ȣ \t ������� \t �����ݾ� \t �������� \t ȸ��id \t ��������
						propL1.setText("���� ��ȣ");
						propL2.setText("���� ���");
						propL3.setText("���� �ݾ�");
						propL4.setText("���� ����");
						propL5.setText("ȸ�� id");
						propL6.setText("���� ����");
						prop7.setVisible(false);
						prop8.setVisible(false);
						prop9.setVisible(false);
					}
					// Schedule table �Ӽ� �� �Է� â ����
					else if (table1.equals("Schedule"))
					{
						//��������ȣ \t ��ȭ��ȣ \t �󿵰���ȣ \t �󿵽����� \t �󿵿��� \t ��ȸ�� \t �󿵽��۽ð�
						propL1.setText("�� ���� ��ȣ");
						propL2.setText("��ȭ ��ȣ");
						propL3.setText("�󿵰� ��ȣ");
						propL4.setText("�� ������");
						propL5.setText("�� ����");
						propL6.setText("�� ȸ��");
						propL7.setText("�󿵽��� �ð�");
						prop8.setVisible(false);
						prop9.setVisible(false);
					}
					// Seat table �Ӽ� �� �Է� â ����
					else if (table1.equals("Seat"))
					{
						//�¼���ȣ \t �󿵰���ȣ \t �¼���뿩��
						propL1.setText("�¼� ��ȣ");
						propL2.setText("�󿵰� ��ȣ");
						propL3.setText("�¼���� ����");
						prop4.setVisible(false);
						prop5.setVisible(false);
						prop6.setVisible(false);
						prop7.setVisible(false);
						prop8.setVisible(false);
						prop9.setVisible(false);
					}
					// Theater table �Ӽ� �� �Է� â ����
					else if (table1.equals("Theater"))
					{
						//�󿵰���ȣ \t �¼��� \t �󿵰���뿩��
						propL1.setText("�󿵰� ��ȣ");
						propL2.setText("�¼� ��");
						propL3.setText("�󿵰� ��� ����");
						prop4.setVisible(false);
						prop5.setVisible(false);
						prop6.setVisible(false);
						prop7.setVisible(false);
						prop8.setVisible(false);
						prop9.setVisible(false);
					}
					// Ticket table �Ӽ� �� �Է� â ����
					else if (table1.equals("Ticket"))
					{
						//Ƽ�Ϲ�ȣ \t ��������ȣ \t �󿵰���ȣ \t �¼���ȣ \t ���Ź�ȣ \t �߱ǿ��� \t ǥ�ذ��� \t �ǸŰ���
						propL1.setText("Ƽ�� ��ȣ");
						propL2.setText("�� ���� ��ȣ");
						propL3.setText("�󿵰� ��ȣ");
						propL4.setText("�¼� ��ȣ");
						propL5.setText("���� ��ȣ");
						propL6.setText("�߱� ����");
						propL7.setText("ǥ�� ����");
						propL8.setText("�Ǹ� ����");
						prop9.setVisible(false);
					}
				}

			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {" - ���̺� ���� - ", "Member", "Movie", "Reservation", "Schedule", "Seat", "Theater", "Ticket"}));
		comboBox_1.setBounds(182, 89, 129, 23);
		contentPane.add(comboBox_1);
				
		messageLabel.setBounds(473, 82, 401, 30);
		contentPane.add(messageLabel);
		
		// �Է� ��� ��ư
		JButton btn0 = new JButton("�Է� ���");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setField.setText("");
				whereField.setText("");
				propF1.setText("");
				propF2.setText("");
				propF3.setText("");
				propF4.setText("");
				propF5.setText("");
				propF6.setText("");
				propF7.setText("");
				propF8.setText("");
				propF9.setText("");

			}
		});
		
		btn0.setBounds(476, 139, 121, 35);
		contentPane.add(btn0);
		
		
		// ���� ��ư
		JButton btn1 = new JButton("����");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ComboBox ���� ��������
				sp.setVisible(false);

				String option = comboBox.getSelectedItem().toString();
				String table1 = comboBox_1.getSelectedItem().toString();
				//System.out.println(option);
				// INSERT ����
				if(option.equals("INSERT")) {
					try {
						//System.out.println("Start Insert");
						String prop1 = propF1.getText();
						String prop2 = propF2.getText();
						String prop3 = propF3.getText();
						String prop4 = propF4.getText();
						String prop5 = propF5.getText();
						String prop6 = propF6.getText();
						String prop7 = propF7.getText();
						String prop8 = propF8.getText();
						String prop9 = propF9.getText();
						// �Ӽ��� 3���� table
						if(table1.equals("Seat") || table1.equals("Theater")) {
							String query = "insert into " +table1+ " values("+prop1+ "," +prop2+ "," + prop3+");";
							//System.out.println(query);
							pst = con.prepareStatement(query);
							int ret = pst.executeUpdate();
							messageLabel.setText("Insert ����!");
						}
						// �Ӽ��� 4���� table
						else if (table1.equals("Member")) {
							String query = "insert into " +table1+ " values("+prop1+ ", '" +prop2+ "','" + prop3+ "','" +prop4+ "');";
							//System.out.println(query);
							pst = con.prepareStatement(query);
							int ret = pst.executeUpdate();
							messageLabel.setText("Insert ����!");
						}
						// �Ӽ��� 6���� table
						else if (table1.equals("Reservation")) {
							String query = "insert into " +table1+ " values("+prop1+ ",'" +prop2+ "'," + prop3+ "," +prop4+ "," +prop5+ ", STR_TO_DATE('" +prop6+"', '%Y-%m-%d'));";
							//System.out.println(query);
							pst = con.prepareStatement(query);
							int ret = pst.executeUpdate();
							messageLabel.setText("Insert ����!");
						}
						// �Ӽ��� 7���� table
						else if (table1.equals("Schedule")) {
							String query = "insert into " +table1+ " values("+prop1+ "," +prop2+ "," + prop3+ ", STR_TO_DATE('" +prop4+ "','%Y-%m-%d'),'" +prop5+ "'," +prop6+ ",'" +prop7+ "');";
							//System.out.println(query);
							//STR_TO_DATE('2021-01-01','%Y-%m-%d')
							pst = con.prepareStatement(query);
							int ret = pst.executeUpdate();
							messageLabel.setText("Insert ����!");
						}
						// �Ӽ��� 8���� table
						else if (table1.equals("Ticket")) {
							String query = "insert into " +table1+ " values("+prop1+ "," +prop2+ "," + prop3+ "," +prop4+ "," +prop5+ "," +prop6+ "," +prop7+ "," +prop8+ ");";
							//System.out.println(query);
							pst = con.prepareStatement(query);
							int ret = pst.executeUpdate();
							messageLabel.setText("Insert ����!");
						}
						// �Ӽ��� 9���� table
						else if (table1.equals("Movie")) {
							String query = "insert into " +table1+ " values("+prop1+ ",'" +prop2+ "'," + prop3+ ",'" +prop4+ "','" +prop5+ "','" +prop6+ "','" +prop7+ "','" +prop8+ "',"
									+ "STR_TO_DATE('" + prop9+ "','%Y-%m-%d'));";
							//System.out.println(query);
							//STR_TO_DATE('2021-01-01','%Y-%m-%d')
							pst = con.prepareStatement(query);
							int ret = pst.executeUpdate();
							messageLabel.setText("Insert ����!");
						}
						
					}
					catch (Exception ex) {
						messageLabel.setText(("Insert Error"+ex));
					}
				}
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
						messageLabel.setText("Update ����!");
					}
					catch (Exception ex) {
						messageLabel.setText(("Update Error"+ex));
					}
				}
				// DELETE ����
				else if (option.equals("DELETE")){
					try {
						messageLabel.setText("");
						String query = "delete from "+table1+" where "+where;
						//System.out.println(query);
						pst = con.prepareStatement(query);
						int ret = pst.executeUpdate();	
						messageLabel.setText("Delete ����!");
					}
					catch (Exception ex) {
						messageLabel.setText(("Delete Error"+ex));
					}
				}
			}
		});
		btn1.setBounds(609, 139, 121, 35);
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
					
					//System.out.println("table ��� ����");

					// table ����
					query = "CREATE TABLE IF NOT EXISTS `Movie`(\r\n"
							+ "	`Movie_id`	INTEGER PRIMARY KEY auto_increment,\r\n"
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
							+ "	`Theater_id` 	INTEGER PRIMARY KEY auto_increment,\r\n"
							+ "	`Theater_seats`	INTEGER,\r\n"
							+ "	`Theater_use`	BOOLEAN	\r\n);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					query = "CREATE TABLE IF NOT EXISTS `Schedule` (\r\n"
							+ "	`Schedule_id` 	INTEGER PRIMARY KEY auto_increment,\r\n"
							+ "	`Movie_id`	INTEGER,\r\n"
							+ "	`Theater_id`	INTEGER,\r\n"
							+ "	`Schedule_date`	VARCHAR(10),\r\n"
							+ "	`Schedule_day`	VARCHAR(20),\r\n"
							+ "	`Schedule_nth`	VARCHAR(20),\r\n"
							+ "	`Schedule_time`	VARCHAR(10),\r\n"
							+ "	FOREIGN KEY (`Movie_id`) REFERENCES Movie(`Movie_id`) on delete cascade on update cascade,\r\n"
							+ "	FOREIGN KEY(`Theater_id`) REFERENCES Theater(`Theater_id`) on delete cascade on update cascade\r\n);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					query = "CREATE TABLE IF NOT EXISTS `Seat` (\r\n"
							+ "	`Seat_id` 	INTEGER PRIMARY KEY auto_increment,\r\n"
							+ "	`Theater_id`	INTEGER,\r\n"
							+ "	`Seat_use`	BOOLEAN,\r\n"
							+ "	FOREIGN KEY (`Theater_id`) REFERENCES Theater(`Theater_id`) on delete cascade on update cascade\r\n);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					query = "CREATE TABLE IF NOT EXISTS `Member` (\r\n"
							+ "	`Member_id` 	INTEGER PRIMARY KEY auto_increment,\r\n"
							+ "	`Member_name`	VARCHAR(10),\r\n"
							+ "	`Member_phone`	VARCHAR(15),\r\n"
							+ "	`Member_mail`	VARCHAR(25)\r\n);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					query = "CREATE TABLE IF NOT EXISTS `Reservation` (\r\n"
							+ "	`Res_id` 	INTEGER PRIMARY KEY auto_increment,\r\n"
							+ "	`Res_payment`	VARCHAR(10),\r\n"
							+ "	`Res_cost`	INTEGER,\r\n"
							+ " `Res_paid`	BOOLEAN,\r\n"
							+ "	`Member_id`	INTEGER,\r\n"
							+ "	`Res_date`	DATE,\r\n"
							+ "	FOREIGN KEY (`Member_id`) REFERENCES Member(`Member_id`) on delete cascade on update cascade\r\n);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					query = "CREATE TABLE IF NOT EXISTS `Ticket` (\r\n"
							+ "	`Ticket_id`	INTEGER PRIMARY KEY auto_increment,\r\n"
							+ "	`Schedule_id`	INTEGER,\r\n"
							+ "	`Theater_id`	BOOLEAN,\r\n"
							+ "	`Seat_id`	INTEGER,\r\n"
							+ "	`Res_id`	INTEGER,\r\n"
							+ "	`Ticket_print`	BOOLEAN,\r\n"
							+ "	`Ticket_price`	INTEGER,\r\n"
							+ "	`Ticket_saleprice`	INTEGER,\r\n"
							+ "	FOREIGN KEY (`Schedule_id`) REFERENCES Schedule(`Schedule_id`) on delete cascade on update cascade,\r\n"
							+ "	FOREIGN KEY (`Seat_id`) REFERENCES Seat(`Seat_id`) on delete cascade on update cascade,\r\n"
							+ "	FOREIGN KEY (`Res_id`) REFERENCES Reservation(`Res_id`) on delete cascade on update cascade\r\n);";
							
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();
					
					//System.out.println("table ��� ����");

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
					//System.out.println("movie inserted");
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
					//System.out.println("Theater inserted");

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
					//System.out.println("Schedule inserted");

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
					//System.out.println("Member inserted");

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
					//System.out.println("Seat inserted");

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
					//System.out.println("reservation inserted");

					query = "INSERT INTO `Ticket` VALUES"
							+ "(1, 1, 1, 1, 1, TRUE,  8000, 7000),"
							+ "(2, 3, 2, 4, 2, TRUE,  10000, 9000),"
							+ "(3, 5, 3, 7, 3, TRUE,  8000, 7000),"
							+ "(4, 7, 4, 10, 4, TRUE,  8000, 7000),"
							+ "(5, 9, 5, 13, 5, TRUE,  10000, 9000),"
							+ "(6, 11, 6, 16, 6, TRUE,  10000, 9000),"
							+ "(7, 13, 7, 19, 7, TRUE,  10000, 9000),"
							+ "(8, 15, 8, 22, 8, TRUE,  8000, 7000),"
							+ "(9, 17, 9, 25, 9, TRUE,  8000, 7000),"
							+ "(10, 19, 10, 27, 10, TRUE,  8000, 7000);";
					pst = con.prepareStatement(query);
					cnt = pst.executeUpdate();					
					//System.out.println("Ticket inserted");

					messageLabel.setText("�ʱ�ȭ�� ���������� �Ϸ��߽��ϴ�.");
				}
				catch (Exception ex) {
					messageLabel.setText(("Error"+ex));	
					//System.out.println(ex);
				}
			}
		});
		
		JComboBox searchBox = new JComboBox();
		searchBox.setModel(new DefaultComboBoxModel(new String[] {"Member", "Movie", "Reservation", "Schedule", "Seat", "Theater", "Ticket"}));
		searchBox.setBounds(601, 208, 129, 23);
		contentPane.add(searchBox);
		btn2.setBounds(742, 139, 110, 35);
		contentPane.add(btn2);
		

		// �˻� ���
		sp.setVisible(false);
		JButton btn3 = new JButton("���̺� �˻�");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table2 = searchBox.getSelectedItem().toString();
				propPanel.setVisible(false);
				sp.setVisible(true);
				if(table2.equals("Member")) {
					try {
						tableArea.setText("ȸ�� ���̵� \t ���� \t ��ȭ��ȣ \t ���ڸ��� \n");
						MemberListDAO memberDAO = new MemberListDAO();
						ArrayList<MemberListVO> memberList = memberDAO.getMemberList();
						for (MemberListVO v: memberList) {
							int id = v.getId();
							String name = v.getName();
							String phone = v.getPhone();
							String mail = v.getMail();
							String str = id+"\t"+name+"\t"+phone+"\t"+mail+"\n";
							//System.out.println(str);
							tableArea.append(str);
						}
					}
					catch(Exception e1) {
						messageLabel.setText("Error "+ e1);
					}
				}
					
					else if (table2.equals("Movie")) {
						try {
							StringBuilder colTitle = new StringBuilder("��ȭ��");
							StringBuilder colGrade = new StringBuilder("�󿵵��");
							StringBuilder colDir = new StringBuilder("������");
							StringBuilder colAct = new StringBuilder("����");
							StringBuilder colGen = new StringBuilder("�帣");
							
							colTitle.setLength(30);
							colGrade.setLength(10);
							colDir.setLength(20);
							colAct.setLength(20);
							colGen.setLength(20);		
							
							tableArea.setText("��ȭ��ȣ\t"+colTitle+"\t"+ "�󿵽ð�\t"+colGrade+"\t"+colDir+"\t"+colAct+"\t"+colGen+"\t������\t��ȭ����\n");
							//tableArea.setText("��ȭ��ȣ \t ��ȭ�� \t �󿵽ð� \t �󿵵�� \t ������ \t ���� \t �帣 \t ������ \t ��ȭ ����\n");
							MovieListDAO movieDAO = new MovieListDAO();
							ArrayList<MovieListVO> movieList = movieDAO.getMovieList();
							for (MovieListVO v: movieList) {
								int id = v.getId();
								String title = v.getTitle();
								int time = v.getTime();
								String grade = v.getGrade();
								String dir = v.getDir();
								String actor = v.getActor();
								String genre = v.getGenre();
								String info = v.getInfo();
								String date = v.getDate();
								
								StringBuilder SBtitle = new StringBuilder(title);
								StringBuilder SBgrade = new StringBuilder(grade);
								StringBuilder SBdir = new StringBuilder(dir);
								StringBuilder SBactor = new StringBuilder(actor);
								StringBuilder SBgenre = new StringBuilder(genre);
								
								SBtitle.setLength(30);
								SBgrade.setLength(10);
								SBdir.setLength(20);
								SBactor.setLength(20);
								SBgenre.setLength(20);
								
								//System.out.println(SBgrade+ "length:"+SBgrade.length());
								String str = id+"\t"+SBtitle+"\t"+time+"\t"+SBgrade+"\t"+SBdir+"\t"+SBactor+"\t"+SBgenre+"\t"+date+"\t"+info+"\n";
								//System.out.println(str);
								tableArea.append(str);
							}
						}
						catch(Exception e1) {
							messageLabel.setText("Error "+ e1);
						}
					}
					else if (table2.equals("Reservation")) {
						try {
							tableArea.setText("���Ź�ȣ \t ������� \t �����ݾ� \t �������� \t ȸ��id \t ��������\n");
							ReservationListDAO resDAO = new ReservationListDAO();
							ArrayList<ReservationListVO> resList = resDAO.getReservationList();
							for (ReservationListVO v: resList) {
								int id = v.getId();
								String payment = v.getPayment();
								int cost = v.getCost();
								boolean paid = v.getPaid();
								int mid = v.getMemberId();
								String date = v.getDate();
										
								
								String str = id+"\t"+payment+"\t"+cost+"\t"+paid+"\t"+mid+"\t"+date+"\n";
								//System.out.println(str);
								tableArea.append(str);
							}
						}
						catch(Exception e1) {
							messageLabel.setText("Error "+ e1);
						}
					}
					else if (table2.equals("Schedule")) {
						try {
							tableArea.setText("��������ȣ \t ��ȭ��ȣ \t �󿵰���ȣ \t �󿵽����� \t �󿵿��� \t ��ȸ�� \t �󿵽��۽ð�\n");
							ScheduleListDAO scDAO = new ScheduleListDAO();
							ArrayList<ScheduleListVO> scList = scDAO.getScheduleList();
							for (ScheduleListVO v: scList) {
								int id = v.getId();
								int mid = v.getMovieId();
								int tid = v.getTheaterId();
								String date = v.getDate();
								String day = v.getDay();
								int nth = v.getNth();
								String time = v.getTime();
										
								
								String str = id+"\t"+mid+"\t"+tid+"\t"+date+"\t"+day+"\t"+nth+"\t"+time+"\n";
								//System.out.println(str);
								//
								tableArea.append(str);
							}
						}
						catch(Exception e1) {
							messageLabel.setText("Error "+ e1);
						}
					}
					else if (table2.equals("Seat")) {
						try {
							tableArea.setText("�¼���ȣ \t �󿵰���ȣ \t �¼���뿩��\n");
							SeatListDAO seatDAO = new SeatListDAO();
							ArrayList<SeatListVO> seatList = seatDAO.getSeatList();
							for (SeatListVO v: seatList) {
								int id = v.getId();
								int tid = v.getTheaterId();
								boolean use = v.getSeat();									
								
								String str = id+"\t"+tid+"\t"+use+"\n";
							//	System.out.println(str);
								tableArea.append(str);
							}
						}
						catch(Exception e1) {
							messageLabel.setText("Error "+ e1);
						}	
					}
					else if (table2.equals("Theater")) {
						try {
							tableArea.setText("�󿵰���ȣ \t �¼��� \t �󿵰���뿩��\n");
							TheaterListDAO theaterDAO = new TheaterListDAO();
							ArrayList<TheaterListVO> theaterList = theaterDAO.getTheaterList();
							for (TheaterListVO v: theaterList) {
								int id = v.getId();
								int seats = v.getSeats();
								boolean use = v.getUse();									
								
								String str = id+"\t"+seats+"\t"+use+"\n";
							//	System.out.println(str);
								tableArea.append(str);
							}
						}
						catch(Exception e1) {
							messageLabel.setText("Error "+ e1);
						}	
					}
					else if (table2.equals("Ticket")) {
						try {
							tableArea.setText("Ƽ�Ϲ�ȣ \t ��������ȣ \t �󿵰���ȣ \t �¼���ȣ \t ���Ź�ȣ \t �߱ǿ��� \t ǥ�ذ��� \t �ǸŰ��� \n");
							TicketListDAO ticketDAO = new TicketListDAO();
							ArrayList<TicketListVO> ticketList = ticketDAO.getTicketList();
							for (TicketListVO v: ticketList) {
								int id = v.getId();
								int scid = v.getScheduleId();
								int tid = v.getTheaterId();
								int seid = v.getSeatId();
								int rid = v.getResId();
								boolean print = v.getPrint();
								int price = v.getPrice();
								int saleprice = v.getSaleprice();
								
								String str = id+"\t"+scid+"\t"+tid+"\t"+seid+"\t"+rid+"\t"+print+"\t"+price+"\t"+saleprice+"\n";
						//		System.out.println(str);
								tableArea.append(str);
							}
						}
						catch(Exception e1) {
							messageLabel.setText("Error "+ e1);
						}	
					}
				}
				
			
		});
		btn3.setBounds(742, 202, 110, 35);
		contentPane.add(btn3);
		
		
		

	}
}
