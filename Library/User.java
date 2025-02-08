package Library;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String userID;
	private List<Book> borrowedBooks;

	public User(String name, String userID) {
		this.name = name;
		this.userID = userID;
		this.borrowedBooks = new ArrayList<>();
	}

	public String getUserID() {
		return userID;
	}
	public String getname() {
		return name;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void borrowBook(Book book) {
		borrowedBooks.add(book);
		book.borrow();
	}

	public void returnBook(Book book) {
		borrowedBooks.remove(book);
		book.returnBook();
	}

	@Override
	public String toString() {
		return "User{" + "Name='" + name + "', UserID='" + userID + "', BorrowedBooks=" + borrowedBooks + "}";
	}

}
