package es.upm.grise.profundizacion.control_1;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


public class LibraryTest {

	//Aniadimos un libro correctamente, comprobamos el titulo
	@Test
	public void aniadirLibro() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Library library = new Library();
		Book libro = new Book("El principito");

		library.addBook(libro);

		assertEquals("El principito", library.getBook("El principito").getTitle());
	}

	//Intentamos aniadir dos veces el mismo libro y nos salta la excepcion de que está duplicado
	@Test
	public void excepcionLibroDuplicado() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Library library = new Library();
		Book libro = new Book("El principito");

		library.addBook(libro);

		assertThrows(DuplicatedBookException.class , () -> library.addBook(libro));
		//assertEquals("El principito", library.getBook("Narnia"));
	}

	//Intentamos borrar libros y para comprobar que se ha eliminado utilizamos comprobamos que lanza la excepcion nonExistingBookException
	@Test
	public void borrarLibros() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException{
		Library libreria = new Library();
		Book libro1 = new Book("Los tres cerditos");
		Book libro2 = new Book("El principito");

		libreria.addBook(libro1);
		libreria.addBook(libro2);
		libreria.removeBook(libro1);

		assertThrows(NonExistingBookException.class, () -> libreria.getBook(libro1.getTitle()));
	}


	//Comprobamos la excepcion de libreria vacia
	@Test
	public void excepcionEmptyLibrary() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException{
		Library libreria = new Library();
		Book libro = new Book("Los tres cerditos");

		assertThrows(EmptyLibraryException.class, () -> libreria.getBook(libro.getTitle()));
	}

	//Comprobamos que un libro no existe
	@Test
	public void excepcionNonExistingBook() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException{
		Library libreria = new Library();
		Book libro1 = new Book("Los tres cerditos");
		Book libro2 = new Book("El principito");

		libreria.addBook(libro1);

		assertThrows(NonExistingBookException.class, () -> libreria.getBook(libro2.getTitle()));
	}

	//Comprobamos que se localizan los libros correctamente
	@Test
	public void getLibros() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException{
		Library libreria = new Library();
		Book libro = new Book("El principito");

		libreria.addBook(libro);

		assertEquals("El principito", libreria.getBook(libro.getTitle()).getTitle());
	}

}
