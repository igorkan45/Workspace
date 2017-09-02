package by.htp.bookDB.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.bookDB.dao.BookDao;
import by.htp.bookDB.domain.entity.Book;

public class BookMySqlDAO implements BookDao {

	private static final String DB_URL = "jdbc:mysql://localhost/librarydb?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true"
			+ "&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

	private static final String DB_USER = "root";
	private static final String DB_PASS = "root";
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final String SQL_SELECT_BOOKS = "select * from book";
	private static final String SQL_SELECT_BOOK_ID = "select * from book where id = ?";
	private static final String SQL_REMOVE_BOOK_ID = "delete from book where id = ?";
	private static final String SQL_SEARCH_BY_TITLE_AND_PAGES = "select * FROM book where title LIKE ? and pages > ?";
	private static final String SQL_SELECT_BOOKS_BY_DATE = "select * from book where date <= ?";

	@Override
	public List<Book> fetchBooks() {
		List<Book> books = new ArrayList<Book>();
		Connection con = null;

		try {

			Class.forName(DB_DRIVER); // search class in external jar file
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

			Statement st = con.createStatement(); // object allows to sent query

			// query to DB with standard syntax
			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKS);

			Book book = null;

			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setPages(rs.getInt("pages"));

				books.add(book);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return books;
	}

	// -------------------------------
	// EXECUTION
	// -------------------------------

	public static void main(String[] args) {
		BookMySqlDAO dao = new BookMySqlDAO();
		dao.deleteBook(5);
		System.out.println(dao.getBookUsingID(4));
	}

	// -------------------------------

	// search by ID
	@Override
	public List<Book> getBookUsingID(int id) {

		List<Book> books = new ArrayList<Book>();
		Connection con = null;
		Book book = new Book();

		try {

			Class.forName(DB_DRIVER); // search class in external jar file
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

			PreparedStatement ps = con.prepareStatement(SQL_SELECT_BOOK_ID);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setPages(rs.getInt("pages"));

				books.add(book);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return books;

	}

	// removing book
	@Override
	public void deleteBook(int id) {
		Connection con = null;

		try {
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

			PreparedStatement ps = con.prepareStatement(SQL_REMOVE_BOOK_ID);
			ps.setInt(1, id);

			int result = ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// search by title and pages
	@Override
	public List<Book> getBookBySymbols(String partOfTheTitle, int pages) {
		List<Book> books = new ArrayList<Book>();
		Book searchBook = new Book();
		Connection con = null;

		try {
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement ps = con.prepareStatement(SQL_SEARCH_BY_TITLE_AND_PAGES);
			ps.setString(1, partOfTheTitle);
			ps.setInt(2, pages);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				searchBook = new Book();
				searchBook.setId(rs.getInt("id"));
				searchBook.setTitle(rs.getString("title"));
				searchBook.setPages(rs.getInt("pages"));

				books.add(searchBook);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return books;
		// to get valid result type dao.getBookBySymbols("dict%", 400)
	}

	@Override
	public List<Book> fetchBooksDate(Date date) {
		List<Book> books = new ArrayList<Book>();
		Connection con = null;
		Book book = null;

		try {

			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			System.out.println(sqlDate.toString());

			PreparedStatement ps = con.prepareStatement(SQL_SELECT_BOOKS_BY_DATE);
			ps.setDate(1, sqlDate);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setPages(rs.getInt("pages"));
				book.setDate(rs.getDate("date"));
				books.add(book);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return books;
	}

}
