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
	JLabel AdminLabel = new JLabel("관리자");
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
		
		// UPDATE / DELETE
		JPanel setPanel = new JPanel();
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
		
		// 실행할 기능을 선택
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"UPDATE", "DELETE"}));
		comboBox.setBounds(22, 89, 121, 23);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 첫번째 combobox 정보 가져오기
				String option = comboBox.getSelectedItem().toString();
				// UPDATE 일 때만 SET을 입력받는다
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

			
		// 위에서 선택한 명령을 실행할 테이블 선택
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 두번째 combobox 정보 가져오기
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
		whereLabel.setFont(new Font("굴림", Font.BOLD, 14));
		whereLabel.setBounds(0, 0, 76, 15);
		wherePanel.add(whereLabel);
		
		whereField = new JTextField();
		whereField.setColumns(10);
		whereField.setBounds(0, 25, 129, 32);
		wherePanel.add(whereField);
		
		messageLabel.setBounds(473, 82, 401, 30);
		contentPane.add(messageLabel);
		JButton btn1 = new JButton("수정/삭제");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ComboBox 정보 가져오기
				String option = comboBox.getSelectedItem().toString();
				String table1 = comboBox_1.getSelectedItem().toString();
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
					}
					catch (Exception ex) {
						messageLabel.setText(("Error"+ex));
					}
				}
				// DELETE 실행
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
					
					System.out.println("table 모두 삭제");

					// table 생성
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
					
					System.out.println("table 모두 생성");

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

					messageLabel.setText("초기화를 성공적으로 완료했습니다.");
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
		
		JButton btn3 = new JButton("테이블 검색");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn3.setBounds(184, 205, 110, 35);
		contentPane.add(btn3);
			

	}
}
