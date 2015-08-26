package ass.user;

import javax.swing.JTable;

import ass.ui.DBConnection;

public abstract class User {
	private int uID;
	private String firstName;
	private String lastName;
	private String title;
	private String phone;
	private String email;
	private String address;
	private String dOB;
	private String username;
	private String password;
	
	
	
	public User() {
		super();
	}



	public User(int uID, String firstName, String lastName, String title,
			String phone, String email, String address, String dOB,
			String username, String password) {
		super();
		this.uID = uID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.dOB = dOB;
		this.username = username;
		this.password = password;
	}
	
	public int getuID() {
		return uID;
	}


	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getdOB() {
		return dOB;
	}



	public void setdOB(String dOB) {
		this.dOB = dOB;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public void viewAllBooks(){
		DBConnection db = new DBConnection();
		db.openConn();
		db.listAllbooks();
		db.closeConn();
	}
	
	public JTable listAllBook(){
	
		String[] columnNames = {"BookID",
                "Price",
                "Status",
                "SN",
                "Published Year", "Title", "Publisher"
                };
		DBConnection db = new DBConnection();
		db.openConn();
		Object[][] data = db.listAllbooks();
		db.closeConn();
		return new JTable(data, columnNames);
	}

	public JTable searchBook(String subString) {
		// TODO Auto-generated method stub
		String[] columnNames = {"BookID",
                "Price",
                "Status",
                "SN",
                "Published Year", "Title", "Publisher"
                };
		DBConnection db = new DBConnection();
		db.openConn();
		Object[][] data = db.searchBook(subString);;
		db.closeConn();
		return new JTable(data, columnNames);
	}
	public abstract void borrowBook();
	public abstract void returnBook();
	
	public abstract void logoff();
	
	public int loginLog(String uName){
		DBConnection db = new DBConnection();
		db.openConn();
		int loginId = db.createLogin(uName);
		db.closeConn();
		return loginId;
	}
	
	public void logoutLog(int loginID){
		DBConnection db = new DBConnection();
		db.openConn();
		db.recordLogout(loginID);
		db.closeConn();
	}



	public JTable listAllusers() {
		String[] columnNames = {"userID","userName",
                "password",
                "firstName",
                "lastName",
                "userType", "phoneNumber"
                };
		DBConnection db = new DBConnection();
		db.openConn();
		Object[][] data = db.listAllusers();
		db.closeConn();
		return new JTable(data, columnNames);
	}
	
	public JTable searchUser(String subString) {
		// TODO Auto-generated method stub
		String[] columnNames = {"userName",
                "password",
                "firstName",
                "lastName",
                "userType", "phoneNumber"
                };
		DBConnection db = new DBConnection();
		db.openConn();
		Object[][] data = db.searchUser(subString);
		db.closeConn();
		return new JTable(data, columnNames);
	
	}



	public JTable listRecord() {
		String[] columnNames = {"recordID","userID",
                "bookID",
                "borrowDate",
                "returnDate",
                "fine" 
                };
		DBConnection db = new DBConnection();
		db.openConn();
		Object[][] data = db.listRecord();
		db.closeConn();
		return new JTable(data, columnNames);
	}
	
	public JTable searchRecord(String subString) {
		String[] columnNames = {"recordID","userID",
                "bookID",
                "borrowDate",
                "returnDate",
                "fine" 
                };
		DBConnection db = new DBConnection();
		db.openConn();
		Object[][] data = db.searchRecord(subString);
		db.closeConn();
		return new JTable(data, columnNames);
	
	}



	public JTable listLogInTime() {
		String[] columnNames = {"logID","userName",
                "loginTime",
                "logoutTime",
                 
                };
		DBConnection db = new DBConnection();
		db.openConn();
		Object[][] data = db.listLogInTime();
		db.closeConn();
		return new JTable(data, columnNames);
	}




}
