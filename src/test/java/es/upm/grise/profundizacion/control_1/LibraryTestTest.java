package es.upm.grise.profundizacion.control_1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Assertions.*;



    
public class LibraryTestTest {


	@Test
	public void test_add_book() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Book b1 = new Book("Libro1");
		Library l1 = new Library();
		l1.addBook(b1);
		Assertions.assertEquals(b1.getTitle(), l1.getBook(b1.getTitle()).getTitle());
		
	}
	@Test
	public void test_same_book() throws DuplicatedBookException {
		Book b1 = new Book("Libro1");
		Book b2 = new Book("Libro1");
		Library l1 = new Library();
		l1.addBook(b1);
		Assertions.assertThrows(DuplicatedBookException.class, () -> l1.addBook(b2));
		
	}
	@Test
	public void test_delete_book() throws DuplicatedBookException, NonExistingBookException{
		Book b1 = new Book("Libro1");
		Book b2 = new Book("Libro2");
		Library l1 = new Library();
		l1.addBook(b1);
		l1.addBook(b2);
		l1.removeBook(b1);
		Assertions.assertThrows(NonExistingBookException.class, () -> l1.getBook(b1.getTitle()));
	}
	@Test
	public void test_get_book() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException{
		Book b1 = new Book("Libro1");
		Library l1 = new Library();
		l1.addBook(b1);
		Assertions.assertEquals(b1.getTitle(),l1.getBook(b1.getTitle()).getTitle());
	}

}
