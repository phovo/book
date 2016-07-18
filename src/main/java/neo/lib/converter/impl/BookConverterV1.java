package neo.lib.converter.impl;

import org.springframework.stereotype.Component;

import neo.lib.business.service.sdo.Book;
import neo.lib.converter.AbstractConverter;
import neo.lib.dao.sdo.BookDao;

/**
 * Book Converter
 *
 */
@Component("bookConverterV1")
public class BookConverterV1 extends AbstractConverter<BookDao, Book> {

	@Override
	public Book convert(BookDao from) throws Exception {
		Book to = null;
		if (from != null ) {
			to = new Book();
			to.setId(from.getId());
			to.setTitle(from.getTitle());
			to.setAuthor(from.getAuthor());
			to.setDescription(from.getDescription());
		}
		
		return to;
	}
}
