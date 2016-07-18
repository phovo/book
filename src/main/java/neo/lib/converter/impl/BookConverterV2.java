package neo.lib.converter.impl;

import org.springframework.stereotype.Component;

import neo.lib.business.service.sdo.Book;
import neo.lib.converter.AbstractConverter;
import neo.lib.dao.sdo.BookDao;

/**
 * Book Converter
 *
 */
@Component("bookConverterV2")
public class BookConverterV2 extends AbstractConverter<Book, BookDao> {

	@Override
	public BookDao convert(Book from) throws Exception {
		BookDao to = null;
		if (from != null ) {
			to = new BookDao();
			to.setId(from.getId());
			to.setTitle(from.getTitle());
			to.setAuthor(from.getAuthor());
			to.setDescription(from.getDescription());
		}
		
		return to;
	}
}
