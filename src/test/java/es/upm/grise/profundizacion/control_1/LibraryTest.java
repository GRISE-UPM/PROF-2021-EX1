package es.upm.grise.profundizacion.control_1;
//Esta es una prueba del pullRequest3
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

	Library library;

	@BeforeEach
	public void beforeEach() {
		library = new Library();
	}


	@BeforeEach
	public void aterEach() {
		library = null;
	}

	//------------------------------------------------------------------------------------------------------------
	// Tests añadir libros
	//------------------------------------------------------------------------------------------------------------

	@DisplayName("Se añade un libro")
	@Test
	public void seAnhadeUnLibro() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Book book = new Book("ElItaliano");

		library.addBook(book);

		assertEquals(book, library.getBook("ElItaliano"));
	}


	@DisplayName("Se añaden tres libros")
	@Test
	public void seAnhadenTresLibro() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Book book1 = new Book("HistoriaDeEspaña");
		Book book2 = new Book("HistoriaDePortugal");
		Book book3 = new Book("HistoriaDeAlemania");

		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);

		Boolean coinciden1 = book1.equals(library.getBook("HistoriaDeEspaña"));
		Boolean coinciden2 = book2.equals(library.getBook("HistoriaDePortugal"));
		Boolean coinciden3 = book3.equals(library.getBook("HistoriaDeAlemania"));

		assertTrue(coinciden1 && coinciden2 && coinciden3);
	}



	@DisplayName("Se añaden tres libros, con un duplicado")
	@Test
	public void seAnhadenTresLibro_unoDuplicado() throws DuplicatedBookException{
		Book book1 = new Book("Libro1");
		Book book2 = new Book("Libro2");
		Book book3 = new Book("Libro1");

		library.addBook(book1);
		library.addBook(book2);

		Exception exception = assertThrows(Exception.class, () -> {
			library.addBook(book3);
		});

		assertTrue(exception instanceof DuplicatedBookException);
	}


	//------------------------------------------------------------------------------------------------------------
	// Tests eliminar libros
	//------------------------------------------------------------------------------------------------------------


	@DisplayName("Se borra un libro")
	@Test
	public void seBorraUnLibro() throws DuplicatedBookException {
		Book book1 = new Book("HistoriaDeEspaña");
		Book book2 = new Book("HistoriaDePortugal");
		Book book3 = new Book("HistoriaDeAlemania");

		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);

		library.removeBook(book1);

		Exception exception = assertThrows(Exception.class, () -> {
			library.getBook("HistoriaDeEspaña");
		});

		//Aqui ya estamos comprobando lo de búsqueda de libro con la condición de no existente
		assertTrue(exception instanceof NonExistingBookException);
	}


	@DisplayName("Se borra un libro en lista vacía")
	@Test
	public void seBorraUnLibroEnListaVacia() throws DuplicatedBookException {
		Book book1 = new Book("UnicoLibro");
		Book book2 = new Book("EsteFalla");

		library.addBook(book1);

		library.removeBook(book1);

		Exception exception = assertThrows(Exception.class, () -> {
			library.removeBook(book2);
		});

		assertTrue(exception instanceof NonExistingBookException);
	}

	@DisplayName("Se borra un libro no existente")
	@Test
	public void seBorraUnLibroNoExistente() throws DuplicatedBookException {
		Book book1 = new Book("LibroUno");
		Book book2 = new Book("LibroDos");
		Book book3 = new Book("LibroTres");

		library.addBook(book1);
		library.addBook(book2);

		library.removeBook(book2);
		library.removeBook(book1);

		Exception exception = assertThrows(Exception.class, () -> {
			library.removeBook(book3);
		});

		assertTrue(exception instanceof NonExistingBookException);
	}


	@DisplayName("Se busca en una lista vacia")
	@Test
	public void seBuscaEnUnaListaVacia() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {

		Exception exception = assertThrows(Exception.class, () -> {
			library.getBook("ElItaliano");
		});

		assertTrue(exception instanceof EmptyLibraryException);
	}
}
