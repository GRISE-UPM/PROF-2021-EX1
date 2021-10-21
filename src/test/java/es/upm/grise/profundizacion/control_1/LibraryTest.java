package es.upm.grise.profundizacion.control_1;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Assertions.*;
public class LibraryTest {
	
	//Tests pregunta 4
	@Test
	public void libroduplicado() {
		assertThrows(DuplicatedBookException.class,
	            new Executable() {
					public void execute() throws Throwable {
						Library libr = new Library();
						Book tarzan = new Book("Tarzan");
						libr.addBook(tarzan);
						libr.addBook(tarzan);
					}
				});
	}
	@Test
	public void libroañadido() throws NonExistingBookException, EmptyLibraryException, DuplicatedBookException {
		Library libr = new Library();
		Book tarzan = new Book("Tarzan");
		libr.addBook(tarzan);
		assertEquals(tarzan,libr.getBook("Tarzan"));
	}
	//Tests pregunta 5
	@Test
	public void libroborradoNoExistente() throws DuplicatedBookException {
		
		assertThrows(IndexOutOfBoundsException.class,
	            new Executable() {
					public void execute() throws Throwable {
						Library libr = new Library();
						Book tarzan = new Book("Tarzan");
						libr.removeBook(tarzan);
					}
				});
	}
	@Test
	public void libroborradoCorrectamente() throws DuplicatedBookException, NonExistingBookException {
		
		assertThrows(NonExistingBookException.class,
	            new Executable() {
					public void execute() throws Throwable {
						Library libr = new Library();
						Book tarzan = new Book("Tarzan");
						Book tarzan2 = new Book("Tarzan2");
						libr.addBook(tarzan);
						libr.addBook(tarzan2);
						libr.removeBook(tarzan);
						libr.getBook("Tarzan");
					}
				});
	}
	
	//Tests pregunta 6
	@Test
	public void obtenerlibro() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Library libr = new Library();
		Book tarzan = new Book("Tarzan");
		libr.addBook(tarzan);
		assertEquals(tarzan,libr.getBook("Tarzan"));
	}
	@Test
	public void libreriavacia(){
		
		assertThrows(EmptyLibraryException.class,
	            new Executable() {
					public void execute() throws Throwable {
						Library libr = new Library();
						libr.getBook("Tarzan");
					}
				});
	}
	

}
