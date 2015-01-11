package UAS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mckoi.database.User;
import java.awt.Color;

public class Login extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private Connection konek = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 266);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Georgia", Font.PLAIN, 15));
		lblUsername.setBounds(34, 94, 76, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Georgia", Font.PLAIN, 15));
		lblPassword.setBounds(34, 127, 76, 14);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Georgia", Font.PLAIN, 12));
		txtUsername.setBounds(156, 95, 126, 19);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Georgia", Font.PLAIN, 12));
		passwordField.setBounds(155, 125, 127, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			 User usr = null;
			private long eventMask;
			private String level;
			private int kondisilogin=3;
			private String userlogin;

			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					String query="select * from login where username=? and password=?";
					PreparedStatement pst=konek.prepareStatement(query);
					pst.setString(1,txtUsername.getText());
					pst.setString(2,passwordField.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while (rs.next())
					{
						level = rs.getString(3);
						count=count+1;
					}
					if(count==1)
					{
							if(level.equals("admin"))
							{
								kondisilogin=0;	
								JOptionPane.showMessageDialog(null, "Selamat Datang Admin");
								new MenuUtama().setVisible(true);
								frame.dispose();

							}
							else if (level.equals("user"))
							{
								kondisilogin=1;
								JOptionPane.showMessageDialog(null, "Selamat Datang User");
								new Penjualan().setVisible(true);
								frame.dispose();
							}

							userlogin=txtUsername.getText();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username atau password yang anda masukkan salah!");
					}
					
				
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				final String user = txtUsername.getText();
			}
		});
		btnLogin.setFont(new Font("Georgia", Font.PLAIN, 15));
		btnLogin.setBounds(34, 168, 89, 23);
		contentPane.add(btnLogin);
				
		JLabel lblMenuLogin = new JLabel("LOGIN");
		lblMenuLogin.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 27));
		lblMenuLogin.setBounds(122, 11, 76, 44);
		contentPane.add(lblMenuLogin);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 15));
		btnNewButton.setBounds(193, 168, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblMasukSebagaiAdmin = new JLabel("Masuk Sebagai Admin Atau User");
		lblMasukSebagaiAdmin.setBounds(64, 55, 248, 14);
		contentPane.add(lblMasukSebagaiAdmin);
	}
}

