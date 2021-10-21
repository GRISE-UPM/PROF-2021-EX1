package es.upm.grise.profundizacion.control_1;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
    
public class LibraryTestTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Test
	public void test_add_book() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Book b1 = new Book("Libro1");
		Library l1 = new Library();
		l1.addBook(b1);
		Assert.assertEquals(b1.getTitle(), l1.getBook(b1.getTitle()).getTitle());
		
	}
	@Test
	public void test_same_book() throws DuplicatedBookException {
		Book b1 = new Book("Libro1");
		Book b2 = new Book("Libro1");
		Library l1 = new Library();
		l1.addBook(b1);
		assertThrows(DuplicatedBookException.class, () -> l1.addBook(b2));
		
	}
	@Test
	public void test_delete_book() throws DuplicatedBookException, NonExistingBookException{
		Book b1 = new Book("Libro1");
		Book b2 = new Book("Libro2");
		Library l1 = new Library();
		l1.addBook(b1);
		l1.addBook(b2);
		l1.removeBook(b1);
		assertThrows(NonExistingBookException.class, () -> l1.getBook(b1.getTitle()));
	}
	@Test
	public void test_get_book() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException{
		Book b1 = new Book("Libro1");
		Library l1 = new Library();
		l1.addBook(b1);
		Assert.assertEquals(b1.getTitle(),l1.getBook(b1.getTitle()).getTitle());
	}

}
