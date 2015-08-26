/**
 * 
 */
package ass.user;

import java.awt.EventQueue;

import ass.ui.AddBookForm;
import ass.ui.AddReceptionist;
import ass.ui.AddUser;
import ass.ui.BorrowReturnBook;
import ass.ui.DBConnection;
import ass.ui.DeleteBook;
import ass.ui.DeleteUser;
import ass.ui.EditBook;
import ass.ui.EditUser;
import ass.ui.FineWindow;
import ass.ui.MainUI;

/**
 * @author littlekey
 * 
 */
public class Admin extends User {

	/**
	 * 
	 */
	public Admin() {
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
	public Admin(int uID, String firstName, String lastName, String title,
			String phone, String email, String address, String dOB,
			String username, String password) {
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


	/*
	 * (non-Javadoc)
	 * 
	 * @see ass.user.User#login()
	 */
	

	public void deleteCustomer(int CusID) {

	}

	public void deleteReceptionist(int recptionistID) {

	}

	public void addABook() {
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
	
	public void addReceptionist(){
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
	
	public void addCustomer(){
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

	public void takeFine(int CusID){
		
	}
	
	public void updateCustomerInfo(){
		
	}
	
	public void updateReceptionistInfo(){
		
	}
	
	public void updateBookStatus(){
		
	}
	
	public void readCusInfo() {

	}
	
	public void readReceptionistInfo() {

	}
	
	public void printReciept(){
		
	}
	
	 public void showMainWindow(final int loginID){
		  EventQueue.invokeLater(new Runnable() {
		   public void run() {
		    try {
		     final MainUI window = new MainUI(loginID);
		     window.frmLibraryManagementSystem.setVisible(true);
		    } catch (Exception e) {
		     e.printStackTrace();
		    }
		   }
		  });
		 }

	@Override
	public void logoff() {
		// TODO Auto-generated method stub
		
	}

	public void updateUser() {
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

	public void deleteUser() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser window = new DeleteUser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void editBook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditBook window = new EditBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void deleteBook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBook window = new DeleteBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void addFine() {
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
}
