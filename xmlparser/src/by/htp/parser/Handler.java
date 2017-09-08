package by.htp.parser;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

	private StringBuilder element;
	private Book book;
	private Author author;
	private List<Book> bookList = new ArrayList<Book>();

	public List<Book> getBookList() {
		return bookList;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parsing...");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		element = new StringBuilder();

		if (qName.equals("book")) {
			book = new Book();
			book.setId(Integer.parseInt(attributes.getValue("id")));

		}

		if (qName.equals("author")) {
			Author author = new Author();
			author.setName(attributes.getValue("name"));
			author.setDateOfBirth(attributes.getValue("date-of-birth"));
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		TagName tagName = TagName.valueOf(qName.toUpperCase().replace("-", "_"));

		switch (tagName) {
		case TITLE:
			book.setTitle(element.toString());
			break;

		case PAGES:
			book.setPages(Integer.parseInt(element.toString()));
			break;

		case AUTHORS:
			book.setAuthor(author);
			break;

		case BOOK:
			bookList.add(book);
			book = null;
			break;

		}

	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End parsing");

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		element.append(ch, start, length);

	}

}
