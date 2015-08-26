/**
 * 
 */
package ass.ui;

import java.util.ArrayList;

import ass.user.Admin;
import ass.user.Customer;
import ass.user.User;

/**
 * @author lsong
 *
 */
public class testDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection db = new DBConnection();
		db.openConn();
		User newUser = db.login("Jim001", "123");
		System.out.println(newUser.getFirstName() + " " + newUser.getLastName());		
		
		db.closeConn();
		
		
//		newUser.viewAllBooks();
//		newUser.searchBook("f");
//		((Admin)newUser).addABook(2.5, "On loan", 432, "12/12/2014", "Test", "A publisher", "description", "categories", "shopName", "author");
	}

}
