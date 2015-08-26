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
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FineWindow {

	public JFrame frame;
	private JTextField txtRecordID;
	private JTextField txtRate;
	private JTextField txtDays;
	private JTextField txtTotalFine;
	private JTextField txtExtraFine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FineWindow window = new FineWindow();
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
	public FineWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 512, 394);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(75dlu;default):grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
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
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblRecordId = new JLabel("Record ID:");
		frame.getContentPane().add(lblRecordId, "4, 4");

		txtRecordID = new JTextField();
		frame.getContentPane().add(txtRecordID, "8, 4, fill, default");
		txtRecordID.setColumns(10);

		JLabel label = new JLabel("");
		frame.getContentPane().add(label, "24, 4");

		JLabel lblFineRate = new JLabel("Fine Rate:");
		frame.getContentPane().add(lblFineRate, "4, 8");

		txtRate = new JTextField();
		txtRate.setEditable(false);
		txtRate.setText("0.60");
		frame.getContentPane().add(txtRate, "8, 8, fill, default");
		txtRate.setColumns(10);

		JLabel lblDaysOverdue = new JLabel("Days Overdue:");
		frame.getContentPane().add(lblDaysOverdue, "4, 12");

		txtDays = new JTextField();
		frame.getContentPane().add(txtDays, "8, 12, fill, default");
		txtDays.setColumns(10);

		JButton btnCalculateFine = new JButton("Calculate Fine");
		btnCalculateFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double fine = 0;
				double extraFine = 0;
				
				String totalFine = null;
				fine = Double.parseDouble(txtRate.getText())
						* Double.parseDouble(txtDays.getText());
				if (txtExtraFine.getText().isEmpty()) {
					totalFine = Double.toString(fine);
					txtTotalFine.setText(totalFine);
				} else {
					extraFine = Double.parseDouble(txtExtraFine.getText());
					totalFine = Double.toString(fine + extraFine);
					txtTotalFine.setText(totalFine);
				}
			}
		});
		frame.getContentPane().add(btnCalculateFine, "16, 12");

		JButton btnUpdateFine = new JButton("Update Fine");
		btnUpdateFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnection db = new DBConnection();
				db.openConn();
				db.fineRecord(txtTotalFine.getText(),
						Integer.parseInt(txtRecordID.getText()));
				db.closeConn();
				JOptionPane.showMessageDialog(null, "Fine was Added!");
			}
		});

		JLabel lblNewLabel = new JLabel("Extra Fine:");
		frame.getContentPane().add(lblNewLabel, "4, 16");

		txtExtraFine = new JTextField();
		txtExtraFine.setText("");
		frame.getContentPane().add(txtExtraFine, "8, 16, fill, default");
		txtExtraFine.setColumns(10);
		frame.getContentPane().add(btnUpdateFine, "16, 16");

		JButton btnFinePaid = new JButton("Fine Paid");
		btnFinePaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnection db = new DBConnection();
				db.openConn();
				db.finePaid(Integer.parseInt(txtRecordID.getText()));
				db.closeConn();
				JOptionPane.showMessageDialog(null, "Fine is paid!");
			}
		});

		JLabel lblTotalFine = new JLabel("Total Fine:");
		frame.getContentPane().add(lblTotalFine, "4, 20");

		txtTotalFine = new JTextField();
		txtTotalFine.setEditable(false);
		frame.getContentPane().add(txtTotalFine, "8, 20, fill, default");
		txtTotalFine.setColumns(10);
		frame.getContentPane().add(btnFinePaid, "16, 20");
	}

}
