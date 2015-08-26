/**
 * 
 */
package ass.user;

import java.awt.EventQueue;

import ass.ui.CustomerWindow;
import ass.ui.ReceptionistWindow;

/**
 * @author Zhi Li
 *
 */
public class Receptionist extends User {

	/**
	 * 
	 */
	public Receptionist() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uID
	 * @param firstName
	 * @param lastName
	 * @param title
	 * @param phone
	 * @param email
	 * @param address
	 * @param dOB
	 * @param username
	 * @param password
	 */
	public Receptionist(int uID, String firstName, String lastName,
			String title, String phone, String email, String address,
			String dOB, String username, String password) {
		super(uID, firstName, lastName, title, phone, email, address, dOB,
				username, password);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ass.user.User#borrowBook()
	 */
	@Override
	public void borrowBook() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ass.user.User#returnBook()
	 */
	@Override
	public void returnBook() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ass.user.User#searchBook()
	 */

	public void viewCustomers() {

	}

	public void checkCustomerRecord(int CusID) {

	}

	public void addACustomer() {

	}

	public void updateCustomerInfo() {

	}

	public void updateBookStatus() {

	}

	public void deleteCustomer(int CusID) {

	}

	public void takeFine(int CusID) {

	}

	public void printReciept() {

	}

	@Override
	public void logoff() {
		// TODO Auto-generated method stub

	}

	public void showReceptionistWindow(final int loginID) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionistWindow window = new ReceptionistWindow(loginID);
					window.frmReceptionistPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
