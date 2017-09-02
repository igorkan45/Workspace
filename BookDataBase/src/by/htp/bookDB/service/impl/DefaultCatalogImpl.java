package by.htp.bookDB.service.impl;

import java.util.Date;
import java.util.List;

import by.htp.bookDB.dao.BookDao;
import by.htp.bookDB.dao.impl.BookMySqlDAO;
import by.htp.bookDB.domain.entity.Book;
import by.htp.bookDB.domain.vo.Catalog;
import by.htp.bookDB.service.CatalogService;

public class DefaultCatalogImpl implements CatalogService{
	
	private BookDao dao;
	
	{
		//change to factory
		dao = new BookMySqlDAO();
	}

	@Override
	public Catalog getCatalog() {
		
		Catalog catalog = new Catalog();
		List<Book> books = dao.fetchBooks();
		catalog.setTitle("New Catalog of Books");
		catalog.setDateCreation(new Date());
		catalog.setBooks(books);
		return catalog;
	}

	@Override
	public Catalog getCatalog(Date date) {
		
		Catalog catalog = new Catalog();
		List<Book> books = dao.fetchBooksDate(new Date());
		catalog.setTitle("New Catalog of Books");
		catalog.setDateCreation(new Date());
		catalog.setBooks(books);
		return catalog;
	}
	
	

}
