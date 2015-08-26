package ass.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrowReturnBook {

	public JFrame frame;
	private JTextField txtBookID;
	private JTextField txtUserID;
	private JLabel lblUserid;
	private JTextField txtRecordID;
	private JLabel lblToReturnPlease;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowReturnBook window = new BorrowReturnBook();
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
	public BorrowReturnBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 362);
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the Book ID you wish to Borrow or Return:");
		frame.getContentPane().add(lblPleaseEnterThe, "4, 4, right, default");
		
		txtBookID = new JTextField();
		frame.getContentPane().add(txtBookID, "6, 4, fill, default");
		txtBookID.setColumns(10);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnection db = new DBConnection();
				db.openConn();
				db.borrowReturnBook(Integer.parseInt(txtBookID.getText()),"Available");
				db.returnRecord(Integer.parseInt(txtRecordID.getText()));
				db.closeConn();
				JOptionPane.showMessageDialog(null, "the book was returned!");
				txtBookID.setText("");
				txtUserID.setText("");
				txtRecordID.setText("");
			}
		});
		
		JButton btnBorrowBook = new JButton("Borrow Book");
		btnBorrowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnection db = new DBConnection();
				db.openConn();
				db.borrowReturnBook(Integer.parseInt(txtBookID.getText()),"Unavailable");
				db.addRecord(Integer.parseInt(txtUserID.getText()),Integer.parseInt(txtBookID.getText()));
				db.closeConn();
				JOptionPane.showMessageDialog(null, "the book was lent out!");
				
				txtBookID.setText("");
				txtUserID.setText("");
				txtRecordID.setText("");
				
			}
		});
		
		lblUserid = new JLabel("User ID:");
		frame.getContentPane().add(lblUserid, "4, 6, right, default");
		
		txtUserID = new JTextField();
		frame.getContentPane().add(txtUserID, "6, 6, fill, default");
		txtUserID.setColumns(10);
		
		lblToReturnPlease = new JLabel("To Return, please enter the record ID");
		frame.getContentPane().add(lblToReturnPlease, "4, 10, right, default");
		
		txtRecordID = new JTextField();
		frame.getContentPane().add(txtRecordID, "6, 10, fill, default");
		txtRecordID.setColumns(10);
		frame.getContentPane().add(btnBorrowBook, "6, 16");
		frame.getContentPane().add(btnReturnBook, "6, 18");
	}

}
