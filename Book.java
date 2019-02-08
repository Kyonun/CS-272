/* Name: Gabriella Garcia
 * Lab #1: Class definition and usage (OOP)
 * 01/28/2019
 */


	public class Book{	
		private String title;
		private int authors;
		private String[] bookAuth = new String[3];
		private String ISBN;
		

	// No-argument Constructor
	public Book(){
	title = null;
	ISBN = null;
	authors = 0;
    bookAuth = new String[3];
	}
	
	
	// Default Constructor
	public Book(String _title) {
		title = _title;
		ISBN = null;
		authors = 0;
		bookAuth = new String[3];
	}
	
	// Copy Constructor
	public Book(Object obj) {
		if(obj != null) {
		if(obj instanceof Book) {
			Book ref = (Book) obj;
			title = ref.getTitle();
			ISBN = ref.getISBN();
			authors = ref.getAuthorNumber();
			
			for(int x = 0; x < ref.getAuthorNumber(); x++) {
				bookAuth[x] = ref.bookAuth[x];
			
		}
	 }
	}
	}
	
	
	// Accessors
	public String getTitle() {
		return title;
	}
	
	public int getAuthorNumber() {
		return authors;
	}
	
	public String getISBN(){
		return ISBN;
	}
	
	// Mutators
	public void setTitle(String _title) {
		
		title = _title;
	}
	
	public void setISBN(String _isbn) {
		ISBN = _isbn;
	}
	
	// Method to add authors to the list of authors
	public boolean addAuthor(String _author) {
		if(authors < 3) {
			 bookAuth[authors] = _author;
			 authors++;
			 return true;
		} else 			
			return false;
		
	}
	

	
	
	// Equals Method
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			Book book = (Book) obj;
			return (book.ISBN == ISBN);		
			} else {
				return false;
			}
	}
	
	
	// Comparison of authors from two books
	public static String[] getAllAuthor(Book b1, Book b2) {
		String[] tempArray = new String[6];
		
		
		for(int x = 0; x < b1.getAuthorNumber(); x++) {
			for(int y = 0; y < b2.getAuthorNumber(); y++) {
				if(b1.bookAuth[x].equals(b2.bookAuth[x])) {
					tempArray[x] = b1.bookAuth[x];
				} else {
					tempArray[x] = b1.bookAuth[x];
					tempArray[tempArray.length-y-1] = b2.bookAuth[y];
				}
			}
		}
		return tempArray;
	}
	// toString Method
	public String toString() {
		
		return "Title: " + title + "\n " + "ISBN: " +  ISBN + "\n " + "Number of Authors: " + authors + "\n " + "Author(s): " + this.bookAuth[0] + " " + this.bookAuth[1] + " " + this.bookAuth[2];
		
	}
	
	
	//Main Function
	public static void main(String[] args) {
		
		
		// Let's test Book 1 and Book 2
		Book book1 = new Book();
		Book book2 = new Book();
		
		book1.setISBN("9708241366738");
		book2.setISBN("9782012019096");
		
		book1.setTitle("If you'd just let me finish...");
		book2.setTitle("Let it snow");
		
		book1.addAuthor("Jeremy Clarkson");

		
		book2.addAuthor("John Green");
		book2.addAuthor("Maureen Johnson");
		book2.addAuthor("Lauren Myracle");
		
		
		// Test toString()
		System.out.println(book1.toString());
		System.out.println(book2.toString());
		
		// Test getAllAuthors
		for(int x = 0; x < 6; x++) {
			
			System.out.println(getAllAuthor(book1,book2)[x]);
		
		}
		
		Book book3 = new Book(book2);
		
		// Copy Contructor Test
		System.out.println(book3.toString());
		
		// Equals method test		
		System.out.println(book1.equals(book2));
		System.out.println(book2.equals(book3));
			
	
		// Test allAuthor method with same variables
		for(int x = 0; x < 6; x++) {
			
			System.out.println(getAllAuthor(book2,book3)[x]);
		
		}
		
		

	} // End of main
} // End of program

	



