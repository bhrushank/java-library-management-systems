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

public class AddBookForm {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JTextField textField_2;
	private JLabel lblSn;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblAuthor;
	private JLabel lblShopFrom;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnAddBook;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookForm window = new AddBookForm();
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
	public AddBookForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 415, 403);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(85dlu;default):grow"),
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblTitle = new JLabel("Title");
		frame.getContentPane().add(lblTitle, "8, 6, left, default");
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "10, 6, fill, default");
		textField.setColumns(10);
		
		final JLabel labelErrorTitle = new JLabel("");
		frame.getContentPane().add(labelErrorTitle, "12, 6");
		
		JLabel lblDescription = new JLabel("Description");
		frame.getContentPane().add(lblDescription, "8, 8, left, default");
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "10, 8, fill, default");
		textField_1.setColumns(10);
		
		final JLabel labelErrorDescription = new JLabel("");
		frame.getContentPane().add(labelErrorDescription, "12, 8");
		
		lblNewLabel = new JLabel("Price");
		frame.getContentPane().add(lblNewLabel, "8, 10, left, default");
		
		textField_2 = new JTextField();
		frame.getContentPane().add(textField_2, "10, 10, fill, default");
		textField_2.setColumns(10);
		
		JLabel labelErrorPrice = new JLabel("");
		frame.getContentPane().add(labelErrorPrice, "12, 10");
		
		lblSn = new JLabel("SN");
		frame.getContentPane().add(lblSn, "8, 12, left, default");
		
		textField_3 = new JTextField();
		frame.getContentPane().add(textField_3, "10, 12, fill, default");
		textField_3.setColumns(10);
		
		JLabel labelErrorSN = new JLabel("");
		frame.getContentPane().add(labelErrorSN, "12, 12");
		
		lblNewLabel_1 = new JLabel("Published year");
		frame.getContentPane().add(lblNewLabel_1, "8, 14, right, default");
		
		textField_4 = new JTextField();
		frame.getContentPane().add(textField_4, "10, 14, fill, default");
		textField_4.setColumns(10);
		
		JLabel labelErrorPublishedYear = new JLabel("");
		frame.getContentPane().add(labelErrorPublishedYear, "12, 14");
		
		lblNewLabel_2 = new JLabel("Publisher");
		frame.getContentPane().add(lblNewLabel_2, "8, 16, left, default");
		
		textField_5 = new JTextField();
		frame.getContentPane().add(textField_5, "10, 16, fill, default");
		textField_5.setColumns(10);
		
		JLabel labelErrorPublisher = new JLabel("");
		frame.getContentPane().add(labelErrorPublisher, "12, 16");
		
		lblNewLabel_3 = new JLabel("Categorie");
		frame.getContentPane().add(lblNewLabel_3, "8, 18, left, default");
		
		comboBox = new JComboBox();
		frame.getContentPane().add(comboBox, "10, 18, fill, default");
		comboBox.addItem("-select one -");
		comboBox.addItem("Science fiction");
		comboBox.addItem("Satire");
		comboBox.addItem("Drama");
		
		final JLabel labelErrorCat = new JLabel("");
		frame.getContentPane().add(labelErrorCat, "12, 18");
		
		lblAuthor = new JLabel("Author");
		frame.getContentPane().add(lblAuthor, "8, 20, left, default");
		
		textField_6 = new JTextField();
		frame.getContentPane().add(textField_6, "10, 20, fill, default");
		textField_6.setColumns(10);
		
		JLabel labelErrorAuthor = new JLabel("");
		frame.getContentPane().add(labelErrorAuthor, "12, 20");
		
		lblShopFrom = new JLabel("Shop from");
		frame.getContentPane().add(lblShopFrom, "8, 22, left, default");
		
		textField_7 = new JTextField();
		frame.getContentPane().add(textField_7, "10, 22, fill, default");
		textField_7.setColumns(10);
		
		btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean pass = true;
				if (textField.getText().equals("")){
					textField.setText("");
					labelErrorTitle.setText("Title cannot be empty");
					pass = false;
				}
				if (textField_1.getText().isEmpty()){
					textField_1.setText("");
					pass = false;
				}
				if (!validPrice(textField_2.getText())){
					textField_2.setText("");
					pass = false;
				}
//				String select = comboBox.getSelectedItem().toString();
				if (comboBox.getSelectedIndex() == 0){
					labelErrorCat.setText("Please select one from box");
					pass = false;
//					select = "Default";
				}
				if (pass){
				DBConnection db = new DBConnection();
			    db.openConn();
			    db.addBook(Double.parseDouble(textField_2.getText()),
			    		"Available", Integer.parseInt(textField_3.getText()), 
			    		textField_4.getText(), textField.getText(), 
			    		textField_5.getText(), textField_1.getText(),
			    		comboBox.getSelectedItem().toString(), 
			    		textField_7.getText(), textField_6.getText());
			    db.closeConn();
			    JOptionPane.showMessageDialog(frame,
			    	    "A book has been added.");
			    textField.setText("");
			    textField_2.setText("");
			    textField_3.setText("");
			    textField_4.setText("");
			    textField_5.setText("");
			    textField_6.setText("");
			    textField_7.setText("");
			    labelErrorTitle.setText("");
			    labelErrorDescription.setText("");
				}

			}

			private boolean validPrice(String text) {
				// TODO Auto-generated method stub
				try{
					return Double.parseDouble(text) > 0;
				}catch(NumberFormatException e){
					return false;
				}
			}
		});
		
		label_6 = new JLabel("");
		frame.getContentPane().add(label_6, "12, 22");
		frame.getContentPane().add(btnAddBook, "10, 24");
	}

}
