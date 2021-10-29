package es.upm.grise.profundizacion.control_1;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LibraryTest {


	static Library lib;

	@BeforeEach
	void setup() {
		lib = new Library();
	}


	@Test
	public void testAddBook() {

		try {
			lib.addBook(new Book ("prueba"));
		} catch (DuplicatedBookException e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testAddBookTwice() {

		try {
			Book prueba = new Book ("prueba");
			lib.addBook(prueba);
			lib.addBook(prueba);
		} catch (DuplicatedBookException e) {
			assertTrue(true);
		}
	}


	@Test
	public void testDeleteBook() {

		Book prueba = new Book ("prueba");
		try {

			lib.addBook(prueba);
		} catch (DuplicatedBookException e) {
			// TODO Auto-generated catch block
			fail();
		}

		lib.removeBook(prueba);

		try {
			lib.getBook("prueba");
		} catch (NonExistingBookException | EmptyLibraryException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}
	
	@Test
	public void testGetNoBook() {

		try {
			lib.getBook("prueba");
		} catch (NonExistingBookException | EmptyLibraryException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testGetBook() {
		try {
			Book prueba = new Book ("prueba");
			lib.addBook(prueba);
			lib.getBook("prueba");
		} catch (NonExistingBookException | EmptyLibraryException e2) {
			fail();

		} catch (DuplicatedBookException e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
}

