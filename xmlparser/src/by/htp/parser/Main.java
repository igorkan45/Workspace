package by.htp.parser;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Main {

	public static void main(String[] args) {

		try {

			XMLReader reader = XMLReaderFactory.createXMLReader();
			Handler handler = new Handler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource("resources/library.xml"));

			//reader.setFeature("http://xml.org/sax/features/validation", true);
			//reader.setFeature("http://xml.org/sax/features/namespaces", true);
			//reader.setFeature("http://xml.org/sax/features/string-interning", true);
			//reader.setFeature("http://apache.org/xml/features/validation/schema", false);

			List<Book> library = handler.getBookList();

			for (Book book : library) {
				System.out.println(book.getId());
				System.out.println(book.getTitle());
				System.out.println(book.getPages());
				System.out.println(book.getAuthor());
			}

		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}

	}

}
