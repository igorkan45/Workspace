package by.htp.bookDB.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import by.htp.bookDB.domain.vo.Catalog;
import by.htp.bookDB.service.impl.DefaultCatalogImpl;

public class CatalogServiceTest {
	
	private static CatalogService service;
	
	@BeforeClass
	public static void initCatalogServiceTest(){
		service = new DefaultCatalogImpl();
		
	}

	@Test
	public void testCatalogNotNull() {
		Catalog catalog = service.getCatalog();
		assertNotNull("The catalog was not created", catalog);
	}
	
	@Test
	public void testCatalogEmptyFields(){
		Catalog catalog = service.getCatalog();
		assertNotNull("The catalog titile wasn't filled",catalog.getTitle());
		assertNotNull("The date of creation was not set",catalog.getDateCreation());
		assertNotNull("Books list wasn't attached to the catalog", catalog.getBooks());
	}
	
	@Test
	public void testCatalogEmptyBooks(){
		Catalog catalog = service.getCatalog();
		assertNotNull("Books list wasn't attached to the catalog", catalog.getBooks());
		assertTrue("Books list is empty", catalog.getBooks().size()>0);
	}
}
