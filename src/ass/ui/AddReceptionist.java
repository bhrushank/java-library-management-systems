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

public class AddReceptionist {

	public JFrame frame;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtFN;
	private JTextField txtLN;
	private JTextField txtTitle;
	private JTextField txtDOB;
	private JTextField txtPhoneNumber;
	private JTextField txtReceptionist;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JButton btnAddReceptionist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReceptionist window = new AddReceptionist();
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
	public AddReceptionist() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 435, 448);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("userName:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblNewLabel, "4, 6, center, default");
		
		txtUserName = new JTextField();
		frame.getContentPane().add(txtUserName, "6, 6, fill, default");
		txtUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblPassword, "4, 8, center, default");
		
		txtPassword = new JTextField();
		frame.getContentPane().add(txtPassword, "6, 8, fill, default");
		txtPassword.setColumns(10);
		
		JLabel lblFirstname = new JLabel("firstName:");
		lblFirstname.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblFirstname, "4, 10, center, default");
		
		txtFN = new JTextField();
		frame.getContentPane().add(txtFN, "6, 10, fill, default");
		txtFN.setColumns(10);
		
		JLabel lblLastname = new JLabel("lastName:");
		lblLastname.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblLastname, "4, 12, center, default");
		
		txtLN = new JTextField();
		frame.getContentPane().add(txtLN, "6, 12, fill, default");
		txtLN.setColumns(10);
		
		JLabel lblTitle = new JLabel("title:");
		lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblTitle, "4, 14, center, default");
		
		txtTitle = new JTextField();
		frame.getContentPane().add(txtTitle, "6, 14, fill, default");
		txtTitle.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("phone Number:");
		lblPhoneNumber.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblPhoneNumber, "4, 16, center, default");
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		frame.getContentPane().add(txtPhoneNumber, "6, 16, fill, default");
		
		JLabel lblUsertype = new JLabel("userType:");
		lblUsertype.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsertype.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblUsertype, "4, 18, center, default");
		
		txtReceptionist = new JTextField();
		txtReceptionist.setEditable(false);
		txtReceptionist.setText("receptionist");
		txtReceptionist.setColumns(10);
		frame.getContentPane().add(txtReceptionist, "6, 18, fill, default");
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblEmail, "4, 20, center, default");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		frame.getContentPane().add(txtEmail, "6, 20, fill, default");
		
		JLabel lblAddress = new JLabel("address:");
		lblAddress.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblAddress, "4, 22, center, default");
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		frame.getContentPane().add(txtAddress, "6, 22, fill, default");
		
		JLabel lblDob = new JLabel("DOB:");
		lblDob.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblDob, "4, 24, center, default");
		
		txtDOB = new JTextField();
		frame.getContentPane().add(txtDOB, "6, 24, fill, default");
		txtDOB.setColumns(10);
		
		btnAddReceptionist = new JButton("Add Receptionist");
		btnAddReceptionist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				if (txtPhoneNumber.getText().isEmpty()) {
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
							txtTitle.getText(), txtPhoneNumber.getText(),
							txtReceptionist.getText(), txtEmail.getText(),
							txtAddress.getText(), txtDOB.getText());
					db.closeConn();
					JOptionPane.showMessageDialog(frame,
							"A new Receptionist has been added.");
					txtUserName.setText("");
					txtPassword.setText("");
					txtFN.setText("");
					txtLN.setText("");
					txtTitle.setText("");
					txtPhoneNumber.setText("");
					txtEmail.setText("");
					txtAddress.setText("");
					txtDOB.setText("");
				}
			}
		});
		frame.getContentPane().add(btnAddReceptionist, "6, 28");
	}

}
