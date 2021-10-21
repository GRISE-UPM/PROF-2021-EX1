package es.upm.grise.profundizacion.control_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

	Library library;

	@BeforeEach
	public void init(){
		library = new Library();
	}

	@Test
	public void testAdd1Book() {
		try{
			Book a = new Book("Titulo1");
			library.addBook(a);
			assertEquals(library.getBook("Titulo1"), a);
		}catch (DuplicatedBookException exception){
			fail("El titulo esta duplicado");
		} catch (NonExistingBookException e) {
			fail("El titulo no existe");
		} catch (EmptyLibraryException e) {
			fail("La libreria esta vacia");
		}
	}

	@Test
	public void testAdd2Book() {
		try{
			Book a = new Book("Titulo1");
			Book b = new Book("Titulo2");
			library.addBook(a);
			library.addBook(b);
			assertEquals(library.getBook("Titulo1"), a);
			assertEquals(library.getBook("Titulo2"), b);
		}catch (DuplicatedBookException exception){
			fail("El titulo esta duplicado");
		} catch (NonExistingBookException e) {
			fail("El titulo no existe");
		} catch (EmptyLibraryException e) {
			fail("La libreria esta vacia");
		}
	}

	@Test
	public void testBookRepited() {
		Book a = new Book("Titulo1");
		assertThrows(DuplicatedBookException.class, () -> {
			library.addBook(a);
			library.addBook(a);
		});
	}

	@Test
	public void testBookRemoved() {
		Book a = new Book("Titulo1");
		try {
			library.addBook(a);
			library.removeBook(a);
			assertDoesNotThrow(() -> {library.addBook(a);});
		} catch (DuplicatedBookException exception) {
			fail("El titulo esta duplicado");
		}
	}

	@Test
	public void testAddBookAndGet() {
		Book a = new Book("Titulo1");
		try {
			library.addBook(a);
			assertEquals(library.getBook("Titulo1"),a);
		}catch (DuplicatedBookException exception){
			fail("El titulo esta duplicado");
		} catch (NonExistingBookException e) {
			fail("El titulo no existe");
		} catch (EmptyLibraryException e) {
			fail("La libreria esta vacia");
		}
	}

}
