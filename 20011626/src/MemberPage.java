import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MemberPage extends JFrame {

	private JPanel contentPane;

	JLabel MemberLabel = new JLabel("회원");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberPage frame = new MemberPage();
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

	public MemberPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Member Page");
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		MemberLabel.setFont(new Font("굴림", Font.BOLD, 20));
		
		MemberLabel.setBounds(12, 10, 209, 30);
		contentPane.add(MemberLabel);
	}

	public MemberPage(String Uname) {
			MemberLabel.setText("회원 "+Uname);
	}
}
