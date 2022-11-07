package es.upm.grise.profundizacion.control_1;

//import static org.junit.Assert.fail;

//import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Test;

public class LibraryTest {
	
	@BeforeAll
	static public void beforeAll() {
		System.out.println("Executed before any test has been run");
	}
	
	@AfterAll
	static public void afterAll() {
		System.out.println("Executed after all tests have been run");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Executed before each test");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("Executed after each test");
	}
	
	@Test()
	public void add_first_book() throws EmptyLibraryException, DuplicatedBookException {
		Library library = new Library();
		Book book = new Book("The Lord of the Rings");
		library.addBook(book);
		assertEquals(1, library.books.size());
	}
	
	@Disabled
	@Test
	public void test() {
		fail();
	}
}
