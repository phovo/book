package neo.lib.dao.service;

import java.util.List;

import neo.lib.dao.sdo.BookDao;
import neo.lib.dao.sdo.BookDetailDao;

public interface BookDaoService {
	
	/**
	 * read the book list
	 *
	 *@return book list
	 */
	List<BookDao> readBookList();

	/**
	 * write the book
	 *
	 * @param book: book
	 */
	void write(BookDetailDao bookDetailDao);

	/**
     * delete book
     *
     * @param id: book Id
     */
	void delete(String bookId);

	/**
     * read book
     *
     * @param id: book Id
     * @return Book Detail
     */
	BookDetailDao read(String bookId);
	
}
