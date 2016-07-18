package neo.lib.business.service.impl;

import java.util.List;

import neo.lib.business.service.BookService;
import neo.lib.business.service.sdo.Book;
import neo.lib.business.service.sdo.BookDetail;
import neo.lib.converter.AbstractConverter;
import neo.lib.dao.sdo.BookDao;
import neo.lib.dao.sdo.BookDetailDao;
import neo.lib.dao.service.BookDaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = org.springframework.transaction.annotation.Isolation.READ_COMMITTED)
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDaoService bookDaoService;
	
	@Autowired
	@Qualifier("bookConverterV1")
	private AbstractConverter<BookDao, Book> bookConverterV1;
	
	@Autowired
	@Qualifier("bookDetailConverterV1")
	private AbstractConverter<BookDetailDao, BookDetail> bookDetailConverterV1;
	
	@Autowired
	@Qualifier("bookDetailConverterV2")
	private AbstractConverter<BookDetail, BookDetailDao> bookDetailConverterV2;
	
	
	@Override
	public List<Book> readBookList() throws Exception {
		return bookConverterV1.convert(bookDaoService.readBookList());
	}

	@Override
	public void write(BookDetail bookDetail) throws Exception {
		bookDaoService.write(bookDetailConverterV2.convert(bookDetail));
	}

	@Override
	public void delete(String id) throws Exception {
		bookDaoService.delete(id);
	}

	@Override
	public BookDetail read(String bookId) throws Exception{
		return bookDetailConverterV1.convert(bookDaoService.read(bookId));
	}
}
