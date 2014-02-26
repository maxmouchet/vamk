package client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9008326627290868271L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtPassword;

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 309, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(90, 12, 134, 28);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Client.auth(txtLogin.getText(), new String(txtPassword.getPassword()));
				setVisible(false);
				dispose();
			}
		});
		loginBtn.setBounds(147, 86, 117, 29);
		contentPane.add(loginBtn);
		
		JLabel lblNewLabel = new JLabel("Login: ");
		lblNewLabel.setBounds(16, 18, 61, 16);
		contentPane.add(lblNewLabel);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(90, 46, 134, 28);
		contentPane.add(txtPassword);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(16, 52, 78, 16);
		contentPane.add(lblPassword);
	}
}
