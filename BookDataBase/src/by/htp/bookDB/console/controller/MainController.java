package by.htp.bookDB.console.controller;

import java.util.Date;

import by.htp.bookDB.console.view.ConsoleOutput;

import by.htp.bookDB.console.view.impl.SimpleConsoleOutput;
import by.htp.bookDB.domain.vo.Catalog;
import by.htp.bookDB.service.CatalogService;
import by.htp.bookDB.service.impl.DefaultCatalogImpl;

public class MainController {

	public static void main(String[] args) {
		
		ConsoleOutput output = new SimpleConsoleOutput();
		CatalogService service = new DefaultCatalogImpl(); 
		//Catalog catalog = service.getCatalog();
		//output.printCatalog(catalog);
		
		
		Catalog catalogDate = service.getCatalog(new Date());
		output.printCatalog(catalogDate);

	}

}
