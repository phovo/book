package neo.lib.business.service;

import java.util.List;

import neo.lib.business.service.sdo.Book;
import neo.lib.business.service.sdo.BookDetail;
/**
 * book service
 *
 */
public interface BookService {
	
	/**
	 * read the book list
	 *
	 *@return book list
	 */
	List<Book> readBookList() throws Exception;
	
	/**
	 * write the book
	 *
	 * @param book: book
	 */
	void write(BookDetail book) throws Exception;

	/**
     * delete book
     *
     * @param id: book Id
     */
	void delete(String id) throws Exception;

	/**
     * read book
     *
     * @param id: book Id
     * @return Book Detail
     */
	BookDetail read(String id) throws Exception;
}
