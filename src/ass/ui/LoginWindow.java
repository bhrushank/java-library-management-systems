package ass.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ass.user.Admin;
import ass.user.Customer;
import ass.user.Receptionist;
import ass.user.User;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class LoginWindow {

	private JFrame frmLibraryManagementSystem;
	private JTextField username;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JLabel lblNewLabel_1;
	private JLabel lblWelcomeToOur;
	private JLabel lblNewLabel;
	private int loginID;
	private JLabel lblPleaseEnterUsername;
	private JLabel lblNewLabel_2;
//	private ImageIcon image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frmLibraryManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLibraryManagementSystem = new JFrame();
		frmLibraryManagementSystem.setTitle("Library Management System");
		frmLibraryManagementSystem.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));
		frmLibraryManagementSystem.setBounds(100, 100, 513, 357);
		frmLibraryManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibraryManagementSystem.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(5dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(4dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(61dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(112dlu;default)"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(35dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblWelcomeToOur = new JLabel("Welcome to Our Library");
		lblWelcomeToOur.setForeground(Color.RED);
		lblWelcomeToOur.setFont(new Font("Calibri", Font.PLAIN, 23));
		frmLibraryManagementSystem.getContentPane().add(lblWelcomeToOur, "8, 4, center, default");
		
		ImageIcon icon = new ImageIcon(getClass().getResource("bookimage.png"));
		
		lblNewLabel_2 = new JLabel(icon);
		
		frmLibraryManagementSystem.getContentPane().add(lblNewLabel_2, "6, 4");
		
		lblPleaseEnterUsername = new JLabel("Please enter username and password:");
		frmLibraryManagementSystem.getContentPane().add(lblPleaseEnterUsername, "8, 8");
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmLibraryManagementSystem.getContentPane().add(lblUsername, "6, 10, center, default");
		
		username = new JTextField();
		frmLibraryManagementSystem.getContentPane().add(username, "8, 10, fill, default");
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmLibraryManagementSystem.getContentPane().add(lblPassword, "6, 14, center, default");
		
		passwordField = new JPasswordField();
		frmLibraryManagementSystem.getContentPane().add(passwordField, "8, 14, fill, default");
		
		lblNewLabel = new JLabel("Login Status:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmLibraryManagementSystem.getContentPane().add(lblNewLabel, "6, 18, center, default");
		
		lblNewLabel_1 = new JLabel("");
		frmLibraryManagementSystem.getContentPane().add(lblNewLabel_1, "8, 18, center, default");
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBConnection db = new DBConnection();
				db.openConn();
				User newUser = db.login(username.getText(), passwordField.getText());
				db.closeConn();
				try{
					if (newUser instanceof Admin){
						
						loginID = newUser.loginLog(newUser.getUsername());
						((Admin)newUser).showMainWindow(loginID);
						
						//lblNewLabel_1.setText(((Admin)newUser).getFirstName());
					}
					else if(newUser instanceof Customer){
						
						loginID = newUser.loginLog(newUser.getUsername());
						((Customer)newUser).showCustomerWindow(loginID);
						
						//lblNewLabel_1.setText(((Customer)newUser).getFirstName());
						
					}else{
						loginID = newUser.loginLog(newUser.getUsername());
						((Receptionist)newUser).showReceptionistWindow(loginID);
						
						//lblNewLabel_1.setText(((Receptionist)newUser).getFirstName());
						
					}
					frmLibraryManagementSystem.dispose();
				}catch(NullPointerException e){
					lblNewLabel_1.setText("Login failed");
				}
				
			}
		});
		frmLibraryManagementSystem.getContentPane().add(btnLogin, "8, 22, center, default");
	}

}
