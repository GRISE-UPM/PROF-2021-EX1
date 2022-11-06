package es.upm.grise.profundizacion.control_1;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class LibraryTest {
	
	// Declaración de variables
	private Library lib;
	private String title_1 = "El Quijote";
	private String title_2 = "Los Pilares de la Tierra";
	private Book book_1 = new Book(title_1);
	private Book book_2 = new Book(title_2);
	
	@BeforeEach
	public void setUp() {
		// Creamos de nuevo la libreria antes de cada test
		lib = new Library();
	}
	
	// Tests for addBook()
	
	@Test
	public void addSingleBookTest() {
		
		// Anhadimos el libro
		try {
			lib.addBook(book_1);
		} catch (DuplicatedBookException e) {
			fail("No debería lanzar la excepcion DuplicatedBookException");
		}
	}
	
	@Test
	public void addMultipleBooksTest() {
		
		// Anhadimos el libro
		try {
			lib.addBook(book_1);
		} catch (DuplicatedBookException e) {
			fail("No debería lanzar la excepcion DuplicatedBookException");
		}
		
		// Anhadimos el otro libro
		try {
			lib.addBook(book_2);
		} catch (DuplicatedBookException e) {
			fail("No debería lanzar la excepción DuplicatedBookException");
		}
	}
	
	@Test
	public void addBookTwiceTest() {

		// Anhadimos el libro dos veces
		assertThrows(
			DuplicatedBookException.class, () -> {
		    	lib.addBook(book_1);
		    	lib.addBook(book_1);
		    },
		    "La llamada a addBook() debería haber lanzado una DuplicatedBookException"
		);
	}
	
	// Tests for removeBook()
	
	@Test
	public void removeBookEmptyListTest() {
		
		// Eliminamos un libro con la lista vacía
		assertThrows(
			EmptyLibraryException.class,
			() -> lib.removeBook(book_1),
			"La llamada a removeBook() debería haber lanzado una EmptyLibraryException"
		);	
	}
	
	@Test
	public void removeNonExistingBookTest() {
		
		// Eliminamos un libro no existente
		assertThrows(
			NonExistingBookException.class, () -> {
				lib.addBook(book_1);
				lib.removeBook(book_2);
			},
			"La llamada a removeBook() debería haber lanzado una NonExistingBookException"
		);
	}
	
	// Tests for getBook()

	@Test
	public void getBookEmptyListTest() {
		
		// Eliminamos un libro con la lista vacía
		assertThrows(
			EmptyLibraryException.class,
			() -> lib.getBook(title_1),
			"La llamada a getBook() debería haber lanzado una EmptyLibraryException"
		);	
	}
	
	@Test
	public void getNonExistingBookTest() {
		
		// Eliminamos un libro no existente
		assertThrows(
			NonExistingBookException.class, () -> {
				lib.addBook(book_1);
				lib.getBook(title_2);
			},
			"La llamada a getBook() debería haber lanzado una NonExistingBookException"
		);
	}
}
