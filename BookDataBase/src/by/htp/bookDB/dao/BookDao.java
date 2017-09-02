package by.htp.bookDB.dao;

import java.util.Date;
import java.util.List;

import by.htp.bookDB.domain.entity.Book;

public interface BookDao {
	
	List<Book> fetchBooks();
	List<Book> fetchBooksDate(Date date);
	
	public List<Book> getBookUsingID(int id);
	
	public void deleteBook(int id);
	
	public List<Book> getBookBySymbols(String partOfTheTitle, int pages);

}
