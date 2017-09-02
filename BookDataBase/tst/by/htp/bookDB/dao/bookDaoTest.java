package by.htp.bookDB.dao;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

import by.htp.bookDB.dao.impl.BookMySqlDAO;
import by.htp.bookDB.domain.entity.Book;

public class bookDaoTest {

	private static BookDao dao;

	@BeforeClass
	public static void initDao() {
		dao = new BookMySqlDAO();

	}

	@Test
	public void testNullList() {
		List<Book> books = dao.fetchBooks();
		assertNotNull("The returned list is null", books);
	}

	@Test
	public void testEmptyList() {
		List<Book> books = dao.fetchBooks();
		assertTrue("The returned list contains zero books", books.size() > 0);
	}

	@Test
	public void testFullList() {
		List<Book> books = dao.fetchBooks();
		assertTrue(!books.isEmpty());
	}

	@Test
	public void testListContainsBook() {
		List<Book> books = dao.fetchBooks();
		assertTrue(books.containsAll(books));
	}

	@Test
	public void testListWithIDs() {
		List<Book> books = dao.getBookUsingID(1);
		assertTrue(books.size() > 0);
	}

	@Test
	public void testIDisNullList() {
		List<Book> books = dao.getBookUsingID(1);
		assertNotNull("The returned list is null", books);
	}

	@Test
	public void testIDisEmptyList() {
		List<Book> books = dao.getBookUsingID(1);
		assertTrue("The returned list contains zero books", books.size() > 0);
	}

	@Test
	public void testGettingBySymbolsNotNull() {
		List<Book> books = dao.getBookBySymbols("boo%", 100);
		assertNotNull("The returned list is null", books);
	}

	@Test
	public void testGettingBySymbolsEmptyList() {
		List<Book> books = dao.getBookBySymbols("boo%", 100);
		assertTrue("The returned list contains zero books", books.size() > 0);
	}

}
