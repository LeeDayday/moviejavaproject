import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		
		setTitle("Main Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel dateLabel = new JLabel("Welcome! ������ 2021-10-01�Դϴ�.");
		dateLabel.setBounds(172, 29, 261, 46);
		contentPane.add(dateLabel);
		// ������ ����
		JButton adminBtn = new JButton("������ ����");
		adminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage ad = new AdminPage();
				ad.setVisible(true);
				setVisible(false);
			}
		});
		adminBtn.setBounds(128, 137, 101, 62);
		contentPane.add(adminBtn);
		
		// ȸ�� ����
		JButton memberBtn = new JButton("ȸ�� ����");
		memberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberPage ad = new MemberPage();
				ad.setVisible(true);
				setVisible(false);
			}
		});
		memberBtn.setBounds(357, 137, 101, 62);
		contentPane.add(memberBtn);
	}
}
