/**
 * Author: Jason JI
 * Date: 22/10/2014
 * purpose: create a form name AddUser and connect with Database
 */



package ass.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;

public class AddUser {
	/**
	 * @param uIDNumber
	 * @param firstNameInput
	 * @param lastNameInput
	 * @param titleInput
	 * @param phoneInput
	 * @param emailInput
	 * @param addressInput
	 * @param dOBInput
	 * @param usernameInput
	 * @param passwordInput
	 */
	public JFrame frame;
	
	private JTextField textField;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtUserType;
	private JTextField txtPhone;
	private JTextField txtTitle;
	private JTextField txtLN;
	private JTextField txtFN;
	private JTextField txtPassword;
	private JTextField txtUserName;
	private JTextField txtDOB;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser window = new AddUser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 *
	 *
	 * @param uIDNumber
	 * @param firstNameInput
	 * @param lastNameInput
	 * @param titleInput
	 * @param phoneInput
	 * @param emailInput
	 * @param addressInput
	 * @param dOBInput
	 * @param usernameInput
	 * @param passwordInput
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 462);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// 
		JButton btnNewButton= new JButton("Add Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean pass = true;
				if (txtUserName.getText().isEmpty()) {
					txtUserName.setText("");
					JOptionPane.showMessageDialog(frame,
							"User Name cannot be empty!");
					pass = false;
				}
				if (txtPassword.getText().isEmpty()) {
					txtPassword.setText("");
					JOptionPane.showMessageDialog(frame,
							"Password cannot be empty!");
					pass = false;
				}
				if (txtFN.getText().isEmpty()) {
					txtFN.setText("");
					JOptionPane.showMessageDialog(frame,
							"First name can not be empty!");
					pass = false;
				}
				if (txtLN.getText().isEmpty()) {
					txtLN.setText("");
					JOptionPane.showMessageDialog(frame,
							"Last name can not be empty!");
					pass = false;
				}
				if (txtPhone.getText().isEmpty()) {
					txtLN.setText("");
					JOptionPane.showMessageDialog(frame,
							"Last name can not be empty!");
					pass = false;
				}
				DBConnection db = new DBConnection();
				db.openConn();
				if (pass) {
					db.AddUser(txtUserName.getText(), txtPassword.getText(),
							txtFN.getText(), txtLN.getText(),
							txtTitle.getText(), txtPhone.getText(),
							txtUserType.getText(), txtEmail.getText(),
							txtAddress.getText(), txtDOB.getText());
					db.closeConn();
					JOptionPane.showMessageDialog(frame,
							"A new customer has been added.");
					txtUserName.setText("");
					txtPassword.setText("");
					txtFN.setText("");
					txtLN.setText("");
					txtTitle.setText("");
					txtPhone.setText("");
					txtEmail.setText("");
					txtAddress.setText("");
					txtDOB.setText("");
				}
			}
		});
		frame.getContentPane().add(btnNewButton, "6, 22");
		
		btnNewButton.setBounds(119, 368, 305, 32);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblUsername = new JLabel("userName");
		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(46, 33, 77, 20);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(46, 77, 77, 20);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblFirstname = new JLabel("firstName");
		lblFirstname.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstname.setBounds(46, 108, 77, 20);
		frame.getContentPane().add(lblFirstname);
		
		JLabel lblLastname = new JLabel("lastName");
		lblLastname.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastname.setBounds(46, 139, 77, 20);
		frame.getContentPane().add(lblLastname);
		
		JLabel lblTitle = new JLabel("title");
		lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitle.setBounds(60, 170, 63, 20);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblPhonenumber = new JLabel("phone Number");
		lblPhonenumber.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPhonenumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhonenumber.setBounds(25, 201, 105, 20);
		frame.getContentPane().add(lblPhonenumber);
		
		JLabel lblUsertype = new JLabel("userType");
		lblUsertype.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsertype.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsertype.setBounds(46, 232, 77, 20);
		frame.getContentPane().add(lblUsertype);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(46, 263, 77, 20);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblAddress = new JLabel("address");
		lblAddress.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(46, 294, 77, 20);
		frame.getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(119, 294, 305, 26);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(119, 263, 305, 26);
		frame.getContentPane().add(txtEmail);
		
		txtUserType = new JTextField();
		txtUserType.setEditable(false);
		txtUserType.setText("cus");
		txtUserType.setColumns(10);
		txtUserType.setBounds(119, 227, 305, 26);
		frame.getContentPane().add(txtUserType);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(119, 196, 305, 26);
		frame.getContentPane().add(txtPhone);
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(119, 164, 305, 26);
		frame.getContentPane().add(txtTitle);
		
		txtLN = new JTextField();
		txtLN.setColumns(10);
		txtLN.setBounds(119, 134, 305, 26);
		frame.getContentPane().add(txtLN);
		
		txtFN = new JTextField();
		txtFN.setColumns(10);
		txtFN.setBounds(119, 103, 305, 26);
		frame.getContentPane().add(txtFN);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(119, 70, 305, 26);
		frame.getContentPane().add(txtPassword);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(119, 33, 305, 26);
		frame.getContentPane().add(txtUserName);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDob.setBounds(56, 330, 67, 20);
		frame.getContentPane().add(lblDob);
		
		txtDOB = new JTextField();
		txtDOB.setColumns(10);
		txtDOB.setBounds(119, 332, 305, 26);
		frame.getContentPane().add(txtDOB);
			
	}
}
