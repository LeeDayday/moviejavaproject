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
	JLabel AdminLabel = new JLabel("관리자");
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
		// 관리자 페이지
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin Page");
		// 데베 연동
		conDB();
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		AdminLabel.setFont(new Font("굴림", Font.BOLD, 20));
		
		AdminLabel.setBounds(22, 24, 209, 30);
		contentPane.add(AdminLabel);
		
		
		// Insert
		
		JPanel propPanel = new JPanel(); // 속성 입력 창. JTextField로 일일이 받는다
		propPanel.setBounds(22, 264, 830, 230);
		contentPane.add(propPanel);
		propPanel.setLayout(null);
		
		JPanel prop1 = new JPanel();
		prop1.setLayout(null);
		prop1.setBounds(0, 20, 129, 57);
		propPanel.add(prop1);
		
		JLabel propL1 = new JLabel("");
		propL1.setFont(new Font("굴림", Font.BOLD, 14));
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
		propL2.setFont(new Font("굴림", Font.BOLD, 14));
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
		propL3.setFont(new Font("굴림", Font.BOLD, 14));
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
		propL4.setFont(new Font("굴림", Font.BOLD, 14));
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
		propL5.setFont(new Font("굴림", Font.BOLD, 14));
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
		propL6.setFont(new Font("굴림", Font.BOLD, 14));
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
		propL7.setFont(new Font("굴림", Font.BOLD, 14));
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
		propL8.setFont(new Font("굴림", Font.BOLD, 14));
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
		propL9.setFont(new Font("굴림", Font.BOLD, 14));
		propL9.setBounds(0, 0, 129, 15);
		prop9.add(propL9);
		
		JTextField propF9 = new JTextField();
		propF9.setColumns(10);
		propF9.setBounds(0, 25, 129, 32);
		prop9.add(propF9);
		
		propPanel.setVisible(false);
		// property 입력 창은 오직 Insert 일 때만 보이게 설정
		
		// UPDATE / DELETE
		JPanel setPanel = new JPanel(); // set 입력 공간
		setPanel.setBounds(22, 130, 129, 57);
		contentPane.add(setPanel);
		setPanel.setLayout(null);
		
		JLabel setLabel = new JLabel("SET");
		setLabel.setFont(new Font("굴림", Font.BOLD, 14));
		setLabel.setBounds(0, 0, 50, 15);
		setPanel.add(setLabel);
		
		setField = new JTextField();
		setField.setBounds(0, 25, 129, 32);
		setPanel.add(setField);
		setField.setColumns(10);
		
		JPanel wherePanel = new JPanel(); // where 입력 공간
		wherePanel.setLayout(null);
		wherePanel.setBounds(182, 130, 129, 57);
		contentPane.add(wherePanel);
		
		JLabel whereLabel = new JLabel("WHERE");
		whereLabel.setFont(new Font("굴림", Font.BOLD, 14));
		whereLabel.setBounds(0, 0, 76, 15);
		wherePanel.add(whereLabel);
		
		whereField = new JTextField();
		whereField.setColumns(10);
		whereField.setBounds(0, 25, 129, 32);
		wherePanel.add(whereField);		
		

		
		JTextArea tableArea = new JTextArea(); // 검색한 결과가 출력되는 공간
		JScrollPane sp = new JScrollPane(tableArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		sp.setBounds(22, 260, 828, 314);
		add(sp);
		//tableArea.setBounds(22, 260, 828, 314);

		
		
		
		// 실행할 기능을 선택
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" - 기능 선택 - ","INSERT","UPDATE", "DELETE"}));
		comboBox.setBounds(22, 89, 121, 23);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 첫번째 combobox 정보 가져오기
				String option = comboBox.getSelectedItem().toString();
				sp.setVisible(false);

				// UPDATE 일 때만 SET을 입력받는다
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

		
		// 위에서 선택한 명령을 실행할 테이블 선택
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// combobox 정보 가져오기
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
					// Member table 속성 값 입력 창 띄우기
					if(table1.equals("Member"))
					{
						// 회원 아이디 \t 고객명 \t 전화번호 \t 전자메일 \
						propL1.setText("회원 아이디");
						propL2.setText("고객명");
						propL3.setText("전화번호");
						propL4.setText("전자 메일");
						prop5.setVisible(false);
						prop6.setVisible(false);
						prop7.setVisible(false);
						prop8.setVisible(false);
						prop9.setVisible(false);
					}
					// Movie table 속성 값 입력 창 띄우기
					else if (table1.equals("Movie"))
					{ 
						// 영화번호 \t 영화명 \t 상영시간 \t 상영등급 \t 감독명 \t 배우명 \t 장르 \t 영화소개 \t 개봉일 정보
						propL1.setText("영화번호");
						propL2.setText("영화명");
						propL3.setText("상영시간");
						propL4.setText("상영등급");
						propL5.setText("감독");
						propL6.setText("배우");
						propL7.setText("장르");
						propL8.setText("영화소개");
						propL9.setText("개봉일");
					}
					// Reservation table 속성 값 입력 창 띄우기
					else if (table1.equals("Reservation")) 
					{
						// 예매번호 \t 결제방법 \t 결제금액 \t 결제상태 \t 회원id \t 결제일자
						propL1.setText("예매 번호");
						propL2.setText("결제 방법");
						propL3.setText("결제 금액");
						propL4.setText("결제 상태");
						propL5.setText("회원 id");
						propL6.setText("결제 일자");
						prop7.setVisible(false);
						prop8.setVisible(false);
						prop9.setVisible(false);
					}
					// Schedule table 속성 값 입력 창 띄우기
					else if (table1.equals("Schedule"))
					{
						//상영일정번호 \t 영화번호 \t 상영관번호 \t 상영시작일 \t 상영요일 \t 상영회차 \t 상영시작시간
						propL1.setText("상영 일정 번호");
						propL2.setText("영화 번호");
						propL3.setText("상영관 번호");
						propL4.setText("상영 시작일");
						propL5.setText("상영 요일");
						propL6.setText("상영 회차");
						propL7.setText("상영시작 시간");
						prop8.setVisible(false);
						prop9.setVisible(false);
					}
					// Seat table 속성 값 입력 창 띄우기
					else if (table1.equals("Seat"))
					{
						//좌석번호 \t 상영관번호 \t 좌석사용여부
						propL1.setText("좌석 번호");
						propL2.setText("상영관 번호");
						propL3.setText("좌석사용 여부");
						prop4.setVisible(false);
						prop5.setVisible(false);
						prop6.setVisible(false);
						prop7.setVisible(false);
						prop8.setVisible(false);
						prop9.setVisible(false);
					}
					// Theater table 속성 값 입력 창 띄우기
					else if (table1.equals("Theater"))
					{
						//상영관번호 \t 좌석수 \t 상영관사용여부
						propL1.setText("상영관 번호");
						propL2.setText("좌석 수");
						propL3.setText("상영관 사용 여부");
						prop4.setVisible(false);
						prop5.setVisible(false);
						prop6.setVisible(false);
						prop7.setVisible(false);
						prop8.setVisible(false);
						prop9.setVisible(false);
					}
					// Ticket table 속성 값 입력 창 띄우기
					else if (table1.equals("Ticket"))
					{
						//티켓번호 \t 상영일정번호 \t 상영관번호 \t 좌석번호 \t 예매번호 \t 발권여부 \t 표준가격 \t 판매가격
						propL1.setText("티켓 번호");
						propL2.setText("상영 일정 번호");
						propL3.setText("상영관 번호");
						propL4.setText("좌석 번호");
						propL5.setText("예매 번호");
						propL6.setText("발권 여부");
						propL7.setText("표준 가격");
						propL8.setText("판매 가격");
						prop9.setVisible(false);
					}
				}

			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {" - 테이블 선택 - ", "Member", "Movie", "Reservation", "Schedule", "Seat", "Theater", "Ticket"}));
		comboBox_1.setBounds(182, 89, 129, 23);
		contentPane.add(comboBox_1);
				
		messageLabel.setBounds(473, 82, 401, 30);
		contentPane.add(messageLabel);
		
		// 입력 취소 버튼
		JButton btn0 = new JButton("입력 취소");
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
		
		
		// 실행 버튼
		JButton btn1 = new JButton("실행");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ComboBox 정보 가져오기
				sp.setVisible(false);

				String option = comboBox.getSelectedItem().toString();
				String table1 = comboBox_1.getSelectedItem().toString();
				//System.out.println(option);
				// INSERT 실행
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
						// 속성이 3개인 table
						if(table1.equals("Seat") || table1.equals("Theater")) {
							String query = "insert into " +table1+ " values("+prop1+ "," +prop2+ "," + prop3+");";
							//System.out.println(query);
							pst = con.prepareStatement(query);
							int ret = pst.executeUpdate();
							messageLabel.setText("Insert 성공!");
						}
						// 속성이 4개인 table
						else if (table1.equals("Member")) {
							String query = "insert into " +table1+ " values("+prop1+ ", '" +prop2+ "','" + prop3+ "','" +prop4+ "');";
							//System.out.println(query);
							pst = con.prepareStatement(query);
							int ret = pst.executeUpdate();
							messageLabel.setText("Insert 성공!");
						}
						// 속성이 6개인 table
						else if (table1.equals("Reservation")) {
							String query = "insert into " +table1+ " values("+prop1+ ",'" +prop2+ "'," + prop3+ "," +prop4+ "," +prop5+ ", STR_TO_DATE('" +prop6+"', '%Y-%m-%d'));";
							//System.out.println(query);
							pst = con.prepareStatement(query);
							int ret = pst.executeUpdate();
							messageLabel.setText("Insert 성공!");
						}
						// 속성이 7개인 table
						else if (table1.equals("Schedule")) {
							String query = "insert into " +table1+ " values("+prop1+ "," +prop2+ "," + prop3+ ", STR_TO_DATE('" +prop4+ "','%Y-%m-%d'),'" +prop5+ "'," +prop6+ ",'" +prop7+ "');";
							//System.out.println(query);
							//STR_TO_DATE('2021-01-01','%Y-%m-%d')
							pst = con.prepareStatement(query);
							int ret = pst.executeUpdate();
							messageLabel.setText("Insert 성공!");
						}
						// 속성이 8개인 table
						else if (table1.equals("Ticket")) {
							String query = "insert into " +table1+ " values("+prop1+ "," +prop2+ "," + prop3+ "," +prop4+ "," +prop5+ "," +prop6+ "," +prop7+ "," +prop8+ ");";
							//System.out.println(query);
							pst = con.prepareStatement(query);
							int ret = pst.executeUpdate();
							messageLabel.setText("Insert 성공!");
						}
						// 속성이 9개인 table
						else if (table1.equals("Movie")) {
							String query = "insert into " +table1+ " values("+prop1+ ",'" +prop2+ "'," + prop3+ ",'" +prop4+ "','" +prop5+ "','" +prop6+ "','" +prop7+ "','" +prop8+ "',"
									+ "STR_TO_DATE('" + prop9+ "','%Y-%m-%d'));";
							//System.out.println(query);
							//STR_TO_DATE('2021-01-01','%Y-%m-%d')
							pst = con.prepareStatement(query);
							int ret = pst.executeUpdate();
							messageLabel.setText("Insert 성공!");
						}
						
					}
					catch (Exception ex) {
						messageLabel.setText(("Insert Error"+ex));
					}
				}
				// 조건식 문자열 가져오기
				String set = setField.getText();
				String where = whereField.getText();
				

				// UPDATE 실행
				if(option.equals("UPDATE")) {
					try {
						messageLabel.setText("");
						String query = "update "+table1+" set "+set+" where "+where;
						//System.out.println(query);
						pst = con.prepareStatement(query);
						int ret = pst.executeUpdate();	
						messageLabel.setText("Update 성공!");
					}
					catch (Exception ex) {
						messageLabel.setText(("Update Error"+ex));
					}
				}
				// DELETE 실행
				else if (option.equals("DELETE")){
					try {
						messageLabel.setText("");
						String query = "delete from "+table1+" where "+where;
						//System.out.println(query);
						pst = con.prepareStatement(query);
						int ret = pst.executeUpdate();	
						messageLabel.setText("Delete 성공!");
					}
					catch (Exception ex) {
						messageLabel.setText(("Delete Error"+ex));
					}
				}
			}
		});
		btn1.setBounds(609, 139, 121, 35);
		contentPane.add(btn1);
		
		
		// 초기화
		JButton btn2 = new JButton("초기화");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					messageLabel.setText("");
					String query;
					int cnt;
					// table 삭제
					
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
					
					//System.out.println("table 모두 삭제");

					// table 생성
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
					
					//System.out.println("table 모두 생성");

					// data 입력
					query = "INSERT INTO `Movie` VALUES"
							+ "(1, '말레피센트2', 119, '15세 관람가', '요아킴 뢰닝', '안젤리나 졸리', '판타지', '강력한 어둠의 지배자이자 무어스 숲의 수호자 ‘말레피센트’는 딸처럼 돌봐온 ‘오로라’와 ‘필립 왕자’의 결혼 약속으로 인간 세계의 ‘잉그리스 왕비’와 대립하게 된다. 이에 요정과 인간의 오랜 연합이 깨지고 숨겨진 요정 종족 다크페이의 리더 ‘코널’까지 등장하면서 두 세계는 피할 수 없는 거대한 전쟁에 휘말리게 되는데…..', STR_TO_DATE('2021-01-01','%Y-%m-%d')),"
							+ "(2, '조커', 123, '청소년 관람 불가', '토드 필립스', '호아퀸 피닉스', '스릴러', '고담시의 광대 아서 플렉은 코미디언을 꿈꾸는 남자. 하지만 모두가 미쳐가는 코미디 같은 세상에서 맨 정신으로는 그가 설 자리가 없음을 깨닫게 되는데… 이제껏 본 적 없는 진짜 ‘조커’를 만나라!', STR_TO_DATE('2021-02-01','%Y-%m-%d')),"
							+ "(3, '퍼펙트맨', 116, '12세 관람가', '용수', '설경구', '코미디', '퍼펙트한 인생을 위해 한탕을 꿈꾸는 건달 ‘영기’(조진웅) 조직 보스의 돈 7억을 빼돌려 주식에 투자하지만, 사기꾼에게 속아 주식은 휴지조각이 되고 만다. 목숨을 부지하기 위해 어떻게든 7억을 구해야 하는 영기 앞에 까칠한 로펌 대표 ‘장수’(설경구)가 나타난다.', STR_TO_DATE('2021-03-01','%Y-%m-%d')),"
							+ "(4, '어벤져스: 엔드게임', 181, '15세 관람가', '안소니 루소', '로버트 다우니 주니어', 'SF', '인피니티 워 이후 절반만 살아남은 지구 마지막 희망이 된 어벤져스 먼저 떠난 그들을 위해 모든 것을 걸었다! 위대한 어벤져스 운명을 바꿀 최후의 전쟁이 펼쳐진다!', STR_TO_DATE('2021-04-01','%Y-%m-%d')),"
							+ "(5, '데드풀', 106, '청소년 관람 불가', '팀밀러', '라이언 레이놀즈', '액션', '잘못된 미래를 바로 잡기 위해 과거와 미래를 오가는 수퍼히어로들의 활약을 그린 SF 영화', STR_TO_DATE('2021-05-01','%Y-%m-%d')),"
							+ "(6, '타짜: 원 아이드 잭', 139, '청소년 관람 불가', '최동훈', '박정민', '범죄', '전설적인 타짜 ‘짝귀’의 아들이자 고시생인 ‘일출’(박정민)은 공부에는 흥미가 없지만 포커판에서는 날고 기는 실력자다. 포커판에서 우연히 알게 된 ‘마돈나’(최유화)의 묘한 매력에 빠져든 일출은 그녀의 곁을 지키는 ‘이상무’(윤제문)에게 속아 포커의 쓴맛을 제대로 배운다.', STR_TO_DATE('2021-06-01','%Y-%m-%d')),"
							+ "(7, '좋은 놈, 나쁜 놈, 이상한 놈', 139, '15세 관람가', '김지운', '송강호', '액션', '딱 한 놈만 살아남는다! 1930년대, 다양한 인종이 뒤엉키고 총칼이 난무하는 무법천지 만주의 축소판 제국 열차에서 각자 다른 방식으로 격동기를 살아가는 조선의 풍운아, 세 명의 남자가 운명처럼 맞닥뜨린다.', STR_TO_DATE('2021-07-01','%Y-%m-%d')),"
							+ "(8, '겨울왕국', 103, '전체 관람가', '제니퍼 리', '이디나 멘젤', '애니메이션', '위험에 빠진 아렌델 왕국을 구해야만 하는 엘사와 안나는 숨겨진 과거의 진실을 찾아 크리스토프, 올라프 그리고 스벤과 함께 위험천만한 놀라운 모험을 떠나게 된다. 자신의 힘을 두려워했던 엘사는 이제 이 모험을 헤쳐나가기에 자신의 힘이 충분하다고 믿어야만 하는데…', STR_TO_DATE('2021-08-01','%Y-%m-%d')),"
							+ "(9, '해리 포터와 ㅣ밀의 방', 162, '전체 관람가', '크리스 콜럽버스', '다니엘 래드클리프', '모험', '어둠의 세력이 호그와트로 돌아왔다!', STR_TO_DATE('2021-09-01','%Y-%m-%d')),"
							+ "(10, '기생충', 131, '15세 관람가', '봉준호', '송강호', '드라마', '전원백수로 살 길 막막하지만 사이는 좋은 기택(송강호) 가족. 장남 기우(최우식)에게 명문대생 친구가 연결시켜 준 고액 과외 자리는 모처럼 싹튼 고정수입의 희망이다. 온 가족의 도움과 기대 속에 박사장(이선균) 집으로 향하는 기우. 이렇게 시작된 두 가족의 만남 뒤로, 걷잡을 수 없는 사건이 기다리고 있었으니…', STR_TO_DATE('2021-10-01','%Y-%m-%d')),"
							+ "(11, '해리 포터와 불사조 기사단', 137, '전체 관람가', '데이빗 예이츠', '다니엘 래드클리프', '모험', '호그와트 최대의 위기. 어둠에 맞설 기사단이 온다!', STR_TO_DATE('2021-11-01','%Y-%m-%d')),"
							+ "(12, '해리 포터와 죽음의 성물 - 2부', 131, '전체 관람가', '데이빗 예이츠', '다니엘 래드클리프', '모험', '모든 것을 끝낼 최후의 전투! 판타지의 아름다운 역사가 드디어 마침표를 찍는다!', STR_TO_DATE('2021-12-01','%Y-%m-%d'));";

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
							+ "(1, '이가윤', '010-000-0001', 'qwdqdq@naver.com'),"
							+ "(2, '이나윤', '010-000-0002', 'sqdq@naver.com'),"
							+ "(3, '이다윤', '010-000-0003', 'qeqr@daum.net'),"
							+ "(4, '이라윤', '010-000-0004', 'dqdq@gmail.com'),"
							+ "(5, '이마윤', '010-000-0005', 'gwhhw@naver.com'),"
							+ "(6, '이바윤', '010-000-0006', 'vweve@gmail.com'),"
							+ "(7, '이사윤', '010-000-0007', 'hw334@daum.net'),"
							+ "(8, '이아윤', '010-000-0008', 'gewew8@gmail.com'),"
							+ "(9, '이자윤', '010-000-0009', '2gddwf@naver.com'),"
							+ "(10, '이차윤', '010-000-00010', 'qge0123@naver.com');";
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

					messageLabel.setText("초기화를 성공적으로 완료했습니다.");
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
		

		// 검색 기능
		sp.setVisible(false);
		JButton btn3 = new JButton("테이블 검색");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table2 = searchBox.getSelectedItem().toString();
				propPanel.setVisible(false);
				sp.setVisible(true);
				if(table2.equals("Member")) {
					try {
						tableArea.setText("회원 아이디 \t 고객명 \t 전화번호 \t 전자메일 \n");
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
							StringBuilder colTitle = new StringBuilder("영화명");
							StringBuilder colGrade = new StringBuilder("상영등급");
							StringBuilder colDir = new StringBuilder("감독명");
							StringBuilder colAct = new StringBuilder("배우명");
							StringBuilder colGen = new StringBuilder("장르");
							
							colTitle.setLength(30);
							colGrade.setLength(10);
							colDir.setLength(20);
							colAct.setLength(20);
							colGen.setLength(20);		
							
							tableArea.setText("영화번호\t"+colTitle+"\t"+ "상영시간\t"+colGrade+"\t"+colDir+"\t"+colAct+"\t"+colGen+"\t개봉일\t영화정보\n");
							//tableArea.setText("영화번호 \t 영화명 \t 상영시간 \t 상영등급 \t 감독명 \t 배우명 \t 장르 \t 개봉일 \t 영화 정보\n");
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
							tableArea.setText("예매번호 \t 결제방법 \t 결제금액 \t 결제상태 \t 회원id \t 결제일자\n");
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
							tableArea.setText("상영일정번호 \t 영화번호 \t 상영관번호 \t 상영시작일 \t 상영요일 \t 상영회차 \t 상영시작시간\n");
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
							tableArea.setText("좌석번호 \t 상영관번호 \t 좌석사용여부\n");
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
							tableArea.setText("상영관번호 \t 좌석수 \t 상영관사용여부\n");
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
							tableArea.setText("티켓번호 \t 상영일정번호 \t 상영관번호 \t 좌석번호 \t 예매번호 \t 발권여부 \t 표준가격 \t 판매가격 \n");
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
