import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
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
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlepanel = new JPanel();
		titlepanel.setBounds(12, 10, 559, 73);
		contentPane.add(titlepanel);
		
		JLabel loginLabel = new JLabel("Login Page");
		loginLabel.setFont(new Font("굴림", Font.BOLD, 24));
		titlepanel.add(loginLabel);
		
		JPanel formpanel = new JPanel();
		formpanel.setBounds(12, 93, 559, 260);
		contentPane.add(formpanel);
		formpanel.setLayout(null);
		
		JLabel idlabel = new JLabel("ID");
		idlabel.setBounds(203, 20, 20, 24);
		idlabel.setFont(new Font("굴림", Font.BOLD, 20));
		formpanel.add(idlabel);
		
		JLabel passwordlabel = new JLabel("Password");
		passwordlabel.setFont(new Font("굴림", Font.BOLD, 20));
		passwordlabel.setBounds(203, 81, 110, 24);
		formpanel.add(passwordlabel);
		
		JLabel selectlabel = new JLabel("Select");
		selectlabel.setFont(new Font("굴림", Font.BOLD, 20));
		selectlabel.setBounds(203, 140, 110, 24);
		formpanel.add(selectlabel);
		
		textField = new JTextField();
		textField.setBounds(203, 50, 184, 21);
		formpanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(203, 115, 184, 21);
		formpanel.add(passwordField);
		
		JLabel ErrorMessage = new JLabel("");
		ErrorMessage.setBounds(329, 214, 200, 24);
		formpanel.add(ErrorMessage);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "관리자", "회원"}));
		comboBox.setBounds(203, 174, 184, 23);
		formpanel.add(comboBox);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Login Button Code
				String uname = textField.getText();
				String pword = String.valueOf(passwordField.getPassword());
				String option = comboBox.getSelectedItem().toString();
				
				if (uname.equals("")|| pword.equals("")||option.equals("Select")) {
					ErrorMessage.setText("Error 모두 입력해주세요");
				}
				else if (option.equals("관리자")){
					try {
						con = Connectionz.getConnection();
						pst = con.prepareStatement("select * from customer where custid=? and phone=?");
						// select * from admin_table where username=? and password=?"
						pst.setString(1,  uname);
						pst.setString(2, pword);
						rs = pst.executeQuery();
						
						if(rs.next()) {
							// 작동 확인하기 위해 기존 table (customer table 활용) 실제 table 작성 후 바꾸기
							String s1 = rs.getString("custid");
							String s2 = rs.getString("phone");
							System.out.println("custid: "+s1+ "phone: "+s2);
							//table 내 id,pw가 입력한 id,pw와 동일하면 login 성공
							if(s1.equals(uname) && s2.equals(pword)) {
								System.out.println("login success! custid: "+s1+ "phone: "+s2);
								System.out.println("uname:" + uname);
								AdminPage ad = new AdminPage();
								ad.setVisible(true);
								setVisible(false);
							}
						}
						else {
							ErrorMessage.setText("존재하지 않는 ID/PW 입니다.");
						}
						
					}
					catch(Exception ex) {
						ErrorMessage.setText("Error"+ex);
					}
				}
				else if (option.equals("회원")){
					try {
						con = Connectionz.getConnection();
						pst = con.prepareStatement("select * from customer where custid=? and phone=?");
						// select * from member_table where username=? and password=?"
						pst.setString(1,  uname);
						pst.setString(2, pword);
						rs = pst.executeQuery();
						
						if(rs.next()) {
							// 작동 확인하기 위해 기존 table (customer table 활용) 실제 table 작성 후 바꾸기
							String s1 = rs.getString("custid");
							String s2 = rs.getString("phone");
							
							//table 내 id,pw가 입력한 id,pw와 동일하면 login 성공
							if(s1.equals(uname) && s2.equals(pword)) {
								MemberPage ad = new MemberPage();
								ad.setVisible(true);
								setVisible(false);
							}
						}
						else {
							ErrorMessage.setText("존재하지 않는 ID/PW 입니다.");
						}
					}
					catch(Exception ex) {
						ErrorMessage.setText("Error"+ex);
					}
				}

			}
		});
		loginBtn.setBounds(203, 215, 97, 23);
		formpanel.add(loginBtn);
	}
}
