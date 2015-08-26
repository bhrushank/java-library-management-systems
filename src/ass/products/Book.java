package ass.products;

public class Book {
	private int bookID;
	private String sn;
	private String title;
	private String author;
	private String publisher;
	private int pages;
	private boolean status;
	private double price;

	public Book() {
		super();
	}

	public Book(int bookID, String sn, String title, String author,
			String publisher, int pages, boolean status, double price) {
		super();
		this.bookID = bookID;
		this.sn = sn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.pages = pages;
		this.status = status;
		this.price = price;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

/**
 * Method addAbook is to add a book to system by admin
 * @param bookID
 * @param sn
 * @param title
 * @param author
 * @param publisher
 * @param pages
 * @param price
 */
	public void addAbook(int bookID, String sn, 
			String title, String author,
			String publisher, int pages, double price) {
		this.bookID = bookID;
		this.sn = sn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.pages = pages;
		this.status = true;
		this.price = price;
	}
	
	/**
	 * showBookInfo() shows the book information 
	 * to user
	 */
	public void showBookInfo(){
		System.out.println(this.title);
		System.out.printf("%-30s-20s-30s-20s\n", "Title"
				, this.title, "SN", this.sn);
		System.out.printf("%-30s-20s-30s-20s\n", "Author"
				, this.author, "Publisher", 
				this.publisher);
		String sta = "Available";
		if (!this.status){
			sta = "Not Available";
		}
		System.out.printf("%-30s-20d-30s-20s\n", "Pages"
				, this.pages, "Status", sta);
	}

}
