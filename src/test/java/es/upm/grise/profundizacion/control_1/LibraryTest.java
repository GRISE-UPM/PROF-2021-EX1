package es.upm.grise.profundizacion.control_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {

	private Library library;

	@BeforeEach
	public void init() {
		this.library = new Library();
	}

	@Test()
	void getEmptyLibraryException() {
		assertThrows(EmptyLibraryException.class, () -> {
			this.library.getBook("Same book");
		});
	}

	@Test()
	void addBookToLibrary() throws DuplicatedBookException {
		Book book = new Book("Same book");
		this.library.addBook(book);
	}

	@Test()
	void addDuplicatedBookToLibrary() throws DuplicatedBookException {
		Book book = new Book("Same book");
		this.library.addBook(book);

		assertThrows(DuplicatedBookException.class, () -> {
			this.library.addBook(book);
		});
	}

	@Test()
	void removeBookFromEmptyLibrary() {
		Book book = new Book("Same book");

		assertThrows(IndexOutOfBoundsException.class, () -> {
			this.library.removeBook(book);
		});
	}

	@Test()
	void removeBookFromLibrary() throws DuplicatedBookException {
		Book book = new Book("Same book");
		this.library.addBook(book);
		this.library.removeBook(book);
	}

	@Test()
	void removeNonExistingBookFromLibrary() throws DuplicatedBookException {
		Book book = new Book("Same book");
		this.library.addBook(book);
		Book non_existing_book = new Book("Non Existing book");
		assertThrows(IndexOutOfBoundsException.class, () -> {
			this.library.removeBook(non_existing_book);
		});
	}

	@Test()
	void getBookFromEmptyLibrary() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		assertThrows(EmptyLibraryException.class, () -> {
			this.library.getBook("Same book");
		});
	}

	@Test()
	void getBookFromLibrary() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Book book = new Book("Same book");
		this.library.addBook(book);
		this.library.getBook("Same book");
	}
}
