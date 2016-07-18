package neo.lib.bean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import neo.lib.business.service.BookService;
import neo.lib.business.service.sdo.BookDetail;
import neo.lib.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * Bean for the detail pages
 *
 */
@ManagedBean
@ViewScoped
public class BookDetailBean implements Serializable {
	
	private static final long serialVersionUID = 7823772154672471159L;

	@Autowired 
	private BookService bookService;
	
	private BookDetail bookDetail;
	
	/**
	 * read book in detail
	 *
	 */
	public void readBookDetail() throws Exception
	{
		bookDetail = new BookDetail();
		String bookId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (bookService != null
				&& !StringUtils.isEmpty(bookId)) {
			setBookDetail(bookService.read(bookId));
		}
	}
	
	/**
	 * initialize the book for edition
	 *
	 */
	public void initBookEdition() throws Exception
	{
		readBookDetail();
	}
	
	/**
	 * initialize the book for creation
	 *
	 */
	public void initBookCreation()
	{
		bookDetail = new BookDetail();
	}
	
	/**
	 * save the book 
	 *
	 */
	public void save() throws Exception
	{
		Date date = new Date();
		if (StringUtils.isEmpty(bookDetail.getId())) {
			bookDetail.setDate_create(DateUtil.parse(date));
		}
		else
		{
			bookDetail.setDate_update(DateUtil.parse(date));
		}
		bookService.write(bookDetail);
	}
		
	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}

	public BookDetail getBookDetail() {
		return bookDetail;
	}
}