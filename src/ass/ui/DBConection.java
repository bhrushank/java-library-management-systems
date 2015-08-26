/**
 * 
 */
package ass.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import ass.user.Admin;
import ass.user.Customer;
import ass.user.Receptionist;
import ass.user.User;

/**
 * @author Zhi Li
 * 
 */
public class DBConection {
	private static final String DBNAME = "jdbc:sqlite:noName.s3db";
	private Connection conn;

	public DBConection() {
		super();
	}

	/**
	 * @return the customers
	 */

	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * @param conn
	 *            the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void openConn() {
		try {
			Class.forName("org.sqlite.JDBC");
			this.conn = DriverManager.getConnection(this.DBNAME);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeConn() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object[][] listAllbooks() {
		String[][] data = new String[1][1];
		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from Book");
			int rowNum = 0;
			while (rs.next()) {
				rowNum++;

			}
			rs.close();
			ResultSet rs1 = sta.executeQuery("select * from Book");
			data = new String[rowNum][7];
			rs1 = sta.executeQuery("select * from Book");
			int rowNumC = 0;
			while (rs1.next()) {
				data[rowNumC][0] = rs1.getString(1);
				data[rowNumC][1] = rs1.getString(2);
				data[rowNumC][2] = rs1.getString(3);
				data[rowNumC][3] = rs1.getString(4);
				data[rowNumC][4] = rs1.getString(5);
				data[rowNumC][5] = rs1.getString(6);
				data[rowNumC][6] = rs1.getString(7);
				System.out.println(rs1.getString(7));
				rowNumC++;
			}

			rs1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public Object[][] searchBook(String subString) {
		String[][] data = new String[1][1];
		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta
					.executeQuery("select * from book where title like '%"
							+ subString + "%'");
			int rowNum = 0;
			while (rs.next()) {
				rowNum++;

			}
			rs.close();
			// ResultSet rs1 = sta.executeQuery("select * from Book");
			data = new String[rowNum][7];
			ResultSet rs1 = sta
					.executeQuery("select * from book where title like '%"
							+ subString + "%'");
			int rowNumC = 0;
			while (rs1.next()) {
				data[rowNumC][0] = rs1.getString(1);
				data[rowNumC][1] = rs1.getString(2);
				data[rowNumC][2] = rs1.getString(3);
				data[rowNumC][3] = rs1.getString(4);
				data[rowNumC][4] = rs1.getString(5);
				data[rowNumC][5] = rs1.getString(6);
				data[rowNumC][6] = rs1.getString(7);
				System.out.println(rs1.getString(7));
				rowNumC++;
			}

			rs1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		// try {
		// Statement sta = this.conn.createStatement();
		// ResultSet rs = sta
		// .executeQuery("select * from book where title like '%"
		// + subString + "%'");
		// while (rs.next()) {
		// System.out.printf("%-15s%-15s%-15s%-15s"
		// + "%-15s%-15s%-15s%-15s\n", rs.getString(1),
		// rs.getString(2), rs.getString(3), rs.getString(4),
		// rs.getString(5), rs.getString(6), rs.getString(7),
		// rs.getString(8));
		// }
		// rs.close();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public void readData() {
		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from user");
			while (rs.next()) {
				System.out.printf("%-5s%-15s%-15s%-15s%-15s%-25s%-15s%"
						+ "-15s%-15s%-15s%-15s\n", rs.getString("userID"),
						rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("title"), rs.getString("phoneNumber"),
						rs.getString("email"), rs.getString("address"),
						rs.getString("DOB"), rs.getString("userName"),
						rs.getString("password"), rs.getString("userType"));

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addBook(double price, String bookStatus, int sn,
			String publishYear, String title, String publisher,
			String description, String categories, String shopName,
			String author) {
		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from Book");
			// I need take the last bookID
			int lastID = 0;
			while (rs.next()) {
				lastID = Integer.parseInt(rs.getString("bookID"));
			}
			System.out.println(lastID);
			rs.close();
			PreparedStatement statement = this.conn
					.prepareStatement("INSERT INTO Book (bookID,"
							+ "price,bookStatus,sn, publishYear, title, publisher, description,"
							+ "categories, shopName, author)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, lastID + 1);
			statement.setDouble(2, price);
			statement.setString(3, bookStatus);
			statement.setInt(4, sn);
			statement.setString(5, publishYear);
			statement.setString(6, title);
			statement.setString(7, publisher);
			statement.setString(8, description);
			statement.setString(9, categories);
			statement.setString(10, shopName);
			statement.setString(11, author);

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addNewUser() {

	}

	public User login(String username, String pwd) {

		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from User Where "
					+ "userName ='" + username + "' and password = '" + pwd
					+ "'");
			User newUser;
			while (rs.next()) {
				if (rs.getString(8).equalsIgnoreCase("cus")) {
					newUser = new Customer(rs.getInt(1), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7),
							rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(2), rs.getString(3));
					return newUser;
				}
				if (rs.getString(8).equalsIgnoreCase("recptionist")) {
					newUser = new Receptionist(rs.getInt(1), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7),
							rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(2), rs.getString(3));
					return newUser;
				}
				if (rs.getString(8).equalsIgnoreCase("Admin")) {
					newUser = new Admin(rs.getInt(1), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7),
							rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(2), rs.getString(3));
					return newUser;
				}

			}

			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int createLogin(String uName) {
		Date date = new Date();
		int id = lastLoginID() + 1;
		PreparedStatement statement;
		try {
			statement = this.conn
					.prepareStatement("INSERT INTO loginTime (logID, userName, loginTime, logOutTime)VALUES(?,?,?,?)");
			statement.setInt(1, id + 1);
			statement.setString(2, uName);
			statement.setString(3, date.toString());
			statement.setString(4, "");
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id + 1;
	}

	public int lastLoginID() {
		int num = 0;
		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from loginTime");
			while (rs.next()) {
				num++;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public void recordLogout(int loginID) {
		try {
			Date date = new Date();
			Statement stmt = this.conn.createStatement();
			String sql = "UPDATE loginTime set " + " logoutTime = '"
					+ date.toString() + "' where logID=" + loginID + ";";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Author: Jason JI Date: 22/10/2014 purpose: create a form name AddUser and
	 * connect with Database
	 */
	public void AddUser(String userName, String password, String firstName,
			String lastName, String title, String phoneNumber, String userType,
			String email, String address, String DOB) {
		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from User");
			// I need take the last UserID
			int lastID = 0;
			while (rs.next()) {
				lastID = Integer.parseInt(rs.getString("userID"));
			}
			System.out.println(lastID);
			rs.close();
			PreparedStatement statement = this.conn
					.prepareStatement("INSERT INTO user (userID,"
							+ "userName, password , firstName, lastName , title , phoneNumber, userType ,email,"
							+ "address, DOB)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, lastID + 1);
			statement.setString(2, userName);
			statement.setString(3, password);
			statement.setString(4, firstName);
			statement.setString(5, lastName);
			statement.setString(6, title);
			statement.setString(7, phoneNumber);
			statement.setString(8, userType);
			statement.setString(9, email);
			statement.setString(10, address);
			statement.setString(11, DOB);

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object[][] listAllusers() {
		String[][] data = new String[1][1];
		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from User");
			int rowNum = 0;
			while (rs.next()) {
				rowNum++;

			}
			rs.close();
			ResultSet rs1 = sta.executeQuery("select * from User");
			data = new String[rowNum][7];
			rs1 = sta.executeQuery("select * from User");
			int rowNumC = 0;
			while (rs1.next()) {
				data[rowNumC][0] = rs1.getString(1);
				data[rowNumC][1] = rs1.getString(2);
				data[rowNumC][2] = rs1.getString(3);
				data[rowNumC][3] = rs1.getString(4);
				data[rowNumC][4] = rs1.getString(5);
				data[rowNumC][5] = rs1.getString(8);

				data[rowNumC][6] = rs1.getString(7);

				System.out.println(rs1.getString(7));
				rowNumC++;
			}

			rs1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public Object[][] searchUser(String subString) {
		String[][] data = new String[1][1];
		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta
					.executeQuery("select * from User where lastName like '%"
							+ subString + "%'");
			int rowNum = 0;
			while (rs.next()) {
				rowNum++;
			}
			rs.close();
			// ResultSet rs1 = sta.executeQuery("select * from User");
			data = new String[rowNum][6];
			ResultSet rs1 = sta
					.executeQuery("select * from User where lastName like '%"
							+ subString + "%'");
			int rowNumC = 0;
			while (rs1.next()) {
				data[rowNumC][0] = rs1.getString(1);
				data[rowNumC][1] = rs1.getString(2);
				data[rowNumC][2] = rs1.getString(3);
				data[rowNumC][3] = rs1.getString(4);
				data[rowNumC][4] = rs1.getString(5);
				data[rowNumC][5] = rs1.getString(8);

				data[rowNumC][6] = rs1.getString(7);

				System.out.println(rs1.getString(7));
				rowNumC++;
			}

			rs1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public void AddReceptionist(String userName, String password,
			String firstName, String lastName, String title,
			String phoneNumber, String userType, String email, String address,
			String DOB) {
		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from User");
			// I need take the last UserID
			int lastID = 0;
			while (rs.next()) {
				lastID = Integer.parseInt(rs.getString("userID"));
			}
			System.out.println(lastID);
			rs.close();
			PreparedStatement statement = this.conn
					.prepareStatement("INSERT INTO user (userID,"
							+ "userName, password , firstName, lastName , title , phoneNumber, userType ,email,"
							+ "address, DOB)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, lastID + 1);
			statement.setString(2, userName);
			statement.setString(3, password);
			statement.setString(4, firstName);
			statement.setString(5, lastName);
			statement.setString(6, title);
			statement.setString(7, phoneNumber);
			statement.setString(8, userType);
			statement.setString(9, email);
			statement.setString(10, address);
			statement.setString(11, DOB);

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void EditUser(String userID, String userName, String password,
			String firstName, String lastName, String title,
			String phoneNumber, String userType, String email, String address,
			String DOB) {
		try {
			int ID = Integer.parseInt(userID);
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from User");
			PreparedStatement statement = this.conn
					.prepareStatement("UPDATE User set userName='" + userName
							+ "', password='" + password + "' , firstName='"
							+ firstName + "', lastName='" + lastName
							+ "' , title='" + title + "' , phoneNumber='"
							+ phoneNumber + "'," + " userType='" + userType
							+ "' ,email='" + email + "'," + "address='"
							+ address + "', DOB='" + DOB + "'where userID= '"
							+ ID + "' ");

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteUser(String userID) {
		try {
			int ID = Integer.parseInt(userID);
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from User");
			PreparedStatement statement = this.conn
					.prepareStatement("DELETE from User where userID='" + ID
							+ "' ");

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editBook(String bookID, double price, String bookStatus,
			int sn, String publishYear, String title, String publisher,
			String description, String categories, String shopName,
			String author) {
		try {
			int ID = Integer.parseInt(bookID);
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from Book");
			PreparedStatement statement = this.conn
					.prepareStatement("UPDATE Book set price='" + price
							+ "', bookStatus='" + bookStatus + "' , sn='" + sn
							+ "', publishYear='" + publishYear + "' , title='"
							+ title + "' " + ", publisher='" + publisher + "',"
							+ " description='" + description
							+ "' ,categories='" + categories + "',"
							+ "author='" + author + "',shopName='" + shopName
							+ "'where bookID= '" + ID + "' ");

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteBook(String bookID) {
		try {
			int ID = Integer.parseInt(bookID);
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from Book");
			PreparedStatement statement = this.conn
					.prepareStatement("DELETE from Book where bookID='" + ID
							+ "' ");

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrowReturnBook(int bookID, String bookStatus) {
		try {
			// int ID = Integer.parseInt(bookID);
			Statement sta = this.conn.createStatement();
			PreparedStatement statement = this.conn
					.prepareStatement("UPDATE Book set bookStatus='"
							+ bookStatus + "'where bookID= '" + bookID + "' ");

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addRecord(int userID, int bookID) {
		try {
			Date date = new Date();
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from record");
			// I need take the last bookID
			int lastID = 0;
			while (rs.next()) {
				lastID = Integer.parseInt(rs.getString("recordID"));
			}
			System.out.println(lastID);
			rs.close();
			PreparedStatement statement = this.conn
					.prepareStatement("INSERT INTO record (recordID,"
							+ "userID, bookID,"
							+ "borrowDate, fine, returnDate)VALUES(?,?,?,?,?,?)");
			statement.setInt(1, lastID + 1);
			statement.setDouble(2, userID);
			statement.setInt(3, bookID);
			statement.setString(4, date.toString());
			statement.setString(5, "None");
			statement.setString(6, "None");
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void returnRecord(int recordID) {
		try {
			Date date = new Date();
			String d = date.toString();

			Statement sta = this.conn.createStatement();
			PreparedStatement statement = this.conn
					.prepareStatement("UPDATE record set returnDate='" + d
							+ "' where recordID= '" + recordID + "' ");
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fineRecord(String fine, int recordID) {
		try {

			Statement sta = this.conn.createStatement();
			PreparedStatement statement = this.conn
					.prepareStatement("UPDATE record set fine='" + fine
							+ "' where recordID= '" + recordID + "' ");
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void finePaid(int recordID) {
		try {
			String Paid = "Paid";
			Statement sta = this.conn.createStatement();
			PreparedStatement statement = this.conn
					.prepareStatement("UPDATE record set fine='"+Paid+"' where recordID= '" + recordID + "' ");
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Object[][] listRecord() {
		String[][] data = new String[1][1];
		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from Record");
			int rowNum = 0;
			while (rs.next()) {
				rowNum++;

			}
			rs.close();
			ResultSet rs1 = sta.executeQuery("select * from Record");
			data = new String[rowNum][6];
			rs1 = sta.executeQuery("select * from Record");
			int rowNumC = 0;
			while (rs1.next()) {
				data[rowNumC][0] = rs1.getString(1);
				data[rowNumC][1] = rs1.getString(2);
				data[rowNumC][2] = rs1.getString(3);
				data[rowNumC][3] = rs1.getString(4);
				data[rowNumC][4] = rs1.getString(6);
				data[rowNumC][5] = rs1.getString(5);

				System.out.println(rs1.getString(6));
				rowNumC++;
			}

			rs1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public Object[][] searchRecord(String subString) {
		String[][] data = new String[1][1];
		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta
					.executeQuery("select * from Record where borrowDate like '%"
							+ subString + "%'");
			int rowNum = 0;
			while (rs.next()) {
				rowNum++;
			}
			rs.close();

			data = new String[rowNum][6];
			ResultSet rs1 = sta
					.executeQuery("select * from Record where borrowDate like '%"
							+ subString + "%'");
			int rowNumC = 0;
			while (rs1.next()) {
				data[rowNumC][0] = rs1.getString(1);
				data[rowNumC][1] = rs1.getString(2);
				data[rowNumC][2] = rs1.getString(3);
				data[rowNumC][3] = rs1.getString(4);
				data[rowNumC][4] = rs1.getString(5);
				data[rowNumC][5] = rs1.getString(6);

				System.out.println(rs1.getString(6));
				rowNumC++;
			}

			rs1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public Object[][] listLogInTime() {
		String[][] data = new String[1][1];
		try {
			Statement sta = this.conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from loginTime");
			int rowNum = 0;
			while (rs.next()) {
				rowNum++;

			}
			rs.close();
			ResultSet rs1 = sta.executeQuery("select * from loginTime");
			data = new String[rowNum][4];
			rs1 = sta.executeQuery("select * from loginTime");
			int rowNumC = 0;
			while (rs1.next()) {
				data[rowNumC][0] = rs1.getString(1);
				data[rowNumC][1] = rs1.getString(2);
				data[rowNumC][2] = rs1.getString(3);
				data[rowNumC][3] = rs1.getString(4);
//				data[rowNumC][4] = rs1.getString(6);
//				data[rowNumC][5] = rs1.getString(5);

				System.out.println(rs1.getString(4));
				rowNumC++;
			}

			rs1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
