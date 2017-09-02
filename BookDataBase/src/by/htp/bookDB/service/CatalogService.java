package by.htp.bookDB.service;

import java.util.Date;

import by.htp.bookDB.domain.vo.Catalog;

public interface CatalogService {
	
	public Catalog getCatalog();
	public Catalog getCatalog(Date date);

}
