package Library;

public class LibrarySystem {
	public static void main(String[] args) {
        CLibrary library = new CLibrary();

        // Adding Books & Users
        library.addBook(new Book("Java Programming", "James Gosling", "654321"));
        library.addBook(new Book("Quantitative Aptitude", "R S Agarwal", "89589"));
        library.addUser(new User("Ramya", "01"));
        library.addUser(new User("Rithu", "02"));

        // Borrowing & Returning Books
        library.borrowBook("89589", "01");
        library.borrowBook("654321", "02");
        library.returnBook("89589", "01");

        // Searching for a book
        Book foundBook = library.findBook("654321");
        if (foundBook != null) System.out.println("Book Found: " + foundBook);
        else System.out.println("Book Not Found.");
    }

}
