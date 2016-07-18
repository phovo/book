package neo.lib.converter.impl;

import neo.lib.business.service.sdo.BookDetail;
import neo.lib.converter.AbstractConverter;
import neo.lib.dao.sdo.BookDetailDao;

import org.springframework.stereotype.Component;

/**
 * Book Detail Converter
 *
 */
@Component("bookDetailConverterV1")
public class BookDetailConverterV1 extends AbstractConverter<BookDetailDao, BookDetail> {

	@Override
	public BookDetail convert(BookDetailDao from) throws Exception {
		BookDetail to = null;
		if (from != null ) {
			to = new BookDetail();
			to.setId(from.getId());
			to.setTitle(from.getTitle());
			to.setAuthor(from.getAuthor());
			to.setDate_create(from.getDate_create());
			to.setDate_update(from.getDate_update());
			to.setDescription(from.getDescription());
		}
		
		return to;
	}
}
