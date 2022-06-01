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

public class AdminPage extends JFrame {

	private JPanel contentPane;
	JLabel AdminLabel = new JLabel("관리자");
	private JTextField queryField;
	private JTable table;
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

	/**
	 * Create the frame.
	 */
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin Page");
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		AdminLabel.setFont(new Font("굴림", Font.BOLD, 20));
		
		AdminLabel.setBounds(22, 24, 209, 30);
		contentPane.add(AdminLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"INSERT", "UPDATE", "DELETE"}));
		comboBox.setBounds(22, 89, 121, 23);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Member", "Movie", "Reservation", "Schedule", "Seat", "Theater", "Ticket"}));
		comboBox_1.setBounds(182, 89, 129, 23);
		contentPane.add(comboBox_1);
		
		queryField = new JTextField();
		queryField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				queryField.setText("insert 할 value를 띄어쓰기를 구분하여 작성 / 조건식 작성");
			}
		});
		
		queryField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				queryField.setText("");

			}
		});

		queryField.setFont(new Font("굴림", Font.ITALIC, 12));
		queryField.setText("insert 할 value를 띄어쓰기를 구분하여 입력 / 조건식 입력");
		queryField.setBounds(22, 139, 371, 35);
		contentPane.add(queryField);
		queryField.setColumns(10);
		
		JLabel messageLabel = new JLabel("");
		messageLabel.setBounds(473, 82, 401, 30);
		contentPane.add(messageLabel);
		JButton btn1 = new JButton("입력/수정/삭제");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn1.setBounds(408, 139, 121, 35);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("초기화");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JComboBox searchBox = new JComboBox();
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
		btn3.setBounds(184, 192, 110, 35);
		contentPane.add(btn3);
		

		
	
		

		

	}
}
