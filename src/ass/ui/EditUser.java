package ass.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditUser {

	public JFrame frame;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtFN;
	private JTextField txtLN;
	private JTextField txtTitle;
	private JTextField txtPhoneNumber;
	private JTextField txtUserType;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtDOB;
	private JTextField txtUserID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditUser window = new EditUser();
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
	public EditUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 458);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:default"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblUserid = new JLabel("userID:");
		lblUserid.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblUserid, "4, 2, center, default");
		
		txtUserID = new JTextField();
		frame.getContentPane().add(txtUserID, "6, 2, fill, default");
		txtUserID.setColumns(10);
		
		JLabel label = new JLabel("userName");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(label, "4, 4, center, default");
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		frame.getContentPane().add(txtUserName, "6, 4, fill, default");
		
		JLabel label_1 = new JLabel("password");
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(label_1, "4, 6, center, default");
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		frame.getContentPane().add(txtPassword, "6, 6, fill, default");
		
		JLabel label_2 = new JLabel("firstName");
		label_2.setVerticalAlignment(SwingConstants.BOTTOM);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(label_2, "4, 8, center, default");
		
		txtFN = new JTextField();
		txtFN.setColumns(10);
		frame.getContentPane().add(txtFN, "6, 8, fill, default");
		
		JLabel label_3 = new JLabel("lastName");
		label_3.setVerticalAlignment(SwingConstants.BOTTOM);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(label_3, "4, 10, center, default");
		
		txtLN = new JTextField();
		txtLN.setColumns(10);
		frame.getContentPane().add(txtLN, "6, 10, fill, default");
		
		JLabel label_4 = new JLabel("title");
		label_4.setVerticalAlignment(SwingConstants.BOTTOM);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(label_4, "4, 12, center, default");
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		frame.getContentPane().add(txtTitle, "6, 12, fill, default");
		
		JLabel label_5 = new JLabel("phone Number");
		label_5.setVerticalAlignment(SwingConstants.BOTTOM);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(label_5, "4, 14, right, default");
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		frame.getContentPane().add(txtPhoneNumber, "6, 14, fill, default");
		
		JLabel label_6 = new JLabel("userType");
		label_6.setVerticalAlignment(SwingConstants.BOTTOM);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(label_6, "4, 16, center, default");
		
		txtUserType = new JTextField();
		frame.getContentPane().add(txtUserType, "6, 16, fill, default");
		txtUserType.setColumns(10);
		
		JLabel label_7 = new JLabel("email");
		label_7.setVerticalAlignment(SwingConstants.BOTTOM);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(label_7, "4, 18, center, default");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		frame.getContentPane().add(txtEmail, "6, 18, fill, default");
		
		JLabel label_8 = new JLabel("address");
		label_8.setVerticalAlignment(SwingConstants.BOTTOM);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(label_8, "4, 20, center, default");
		
		txtAddress = new JTextField();
		frame.getContentPane().add(txtAddress, "6, 20, fill, default");
		txtAddress.setColumns(10);
		
		JLabel label_9 = new JLabel("DOB");
		label_9.setVerticalAlignment(SwingConstants.BOTTOM);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(label_9, "4, 22, center, default");
		
		txtDOB = new JTextField();
		frame.getContentPane().add(txtDOB, "6, 22, fill, default");
		txtDOB.setColumns(10);
		
		JButton btnEditUser = new JButton("Edit User");
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean pass = true;
				if (txtUserID.getText().isEmpty()) {
					txtUserID.setText("");
					JOptionPane.showMessageDialog(frame,
							"UserID cannot be empty!");
					pass = false;
				}
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
				if (txtPhoneNumber.getText().isEmpty()) {
					txtLN.setText("");
					JOptionPane.showMessageDialog(frame,
							"Last name can not be empty!");
					pass = false;
				}
				DBConnection db = new DBConnection();
				db.openConn();
				if(pass){
				db.EditUser(txtUserID.getText(), txtUserName.getText(), txtPassword.getText(), txtFN.getText(),
						txtLN.getText(), txtTitle.getText(), txtPhoneNumber.getText(), txtUserType.getText(),
						txtEmail.getText(), txtAddress.getText(), txtDOB.getText());
				db.closeConn();
				JOptionPane.showMessageDialog(frame,
						"User Updated.");
				txtUserID.setText("");
				txtUserName.setText("");
				txtPassword.setText("");
				txtFN.setText("");
				txtLN.setText("");
				txtTitle.setText("");
				txtPhoneNumber.setText("");
				txtUserType.setText("");
				txtEmail.setText("");
				txtAddress.setText("");
				txtDOB.setText("");
				}
			}
		});
		btnEditUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(btnEditUser, "6, 26");
	}

}
