package neo.lib.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import neo.lib.business.service.BookService;
import neo.lib.business.service.sdo.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

/**
 * Bean for the booklist/home page
 *
 */
@ManagedBean
@ViewScoped
public class BookBean implements Serializable {
	
	private static final long serialVersionUID = -1955761202973501115L;
	
	@Autowired 
	private BookService bookService;
	
	private int bookIndex;
	
	private List<Book> bookList;

	/**
	 * initialize
	 *
	 */
	public void init() throws Exception
	{
		readBookList();
	}
	
	/**
	 * delete book
	 *
	 */
	public void deleteBook() throws Exception
	{
		if (!CollectionUtils.isEmpty(bookList)) {
			bookService.delete(bookList.get(bookIndex).getId());
			bookList.remove(bookIndex);
		}
	}	
	
	/**
	 * read book list
	 *
	 */
	public void readBookList() throws Exception
	{
		if (bookService != null) {
			bookList = bookService.readBookList();
		}
	}
	
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public int getBookIndex() {
		return bookIndex;
	}

	public void setBookIndex(int bookIndex) {
		this.bookIndex = bookIndex;
	}
}