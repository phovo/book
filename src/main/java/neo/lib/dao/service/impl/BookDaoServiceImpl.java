package neo.lib.dao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import neo.lib.dao.sdo.BookDao;
import neo.lib.dao.sdo.BookDetailDao;
import neo.lib.dao.service.BookDaoService;
import neo.lib.dao.service.mapper.BookDetailRowMapper;
import neo.lib.dao.service.mapper.BookRowMapper;
import neo.lib.util.DateUtil;
import neo.lib.util.ExceptionWrapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class BookDaoServiceImpl implements BookDaoService {
	
	private static final String ERROR_OCCURRED = "Error occurred: ";

	final static Logger logger = Logger.getLogger(BookDaoServiceImpl.class);
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	private final String select = "SELECT b.id id, b.title title, b.author author, b.description description, b.date_create date_create, b.date_update date_create " +
	 			 "FROM book_core.book b " +
				 "WHERE b.id = ?";
	private final String view_select = "SELECT b.id id, b.title title, b.author author, b.description description " +
				 "FROM book_core.book_view b";
	private final String insert = "INSERT INTO book_core.book (title,author,date_create,date_update,description) " +
	 			 "VALUES(?,?,?,?,?)";
	private final String update = "UPDATE book_core.book SET title = ?, author = ?, date_create = ?, date_update = ?, description = ? " +
				 "WHERE id = ?";
	private final String delete = "DELETE FROM book_core.book b " +
			     "WHERE b.id = ?";

	
	@Override
	public List<BookDao> readBookList() {
		logger.info("Call read book list");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		List<BookDao> bookDaoList = new ArrayList<BookDao>();
		try 
		{
			bookDaoList = jdbcTemplate.query(view_select, new BookRowMapper());
		}
		catch (DataAccessException e) 
		{
			logger.error(ERROR_OCCURRED + e.getMessage());
			ExceptionWrapper.wrapper(e);
		} 
		
		return bookDaoList;
	}

	
	@Override
	public void write(BookDetailDao bookDetailDao) {
		logger.info("write book detail");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		BookDao obj = null;
		// not exist or deleted by other user
		if (!StringUtils.isEmpty(bookDetailDao.getId())) {
			try 
			{
				obj = jdbcTemplate.queryForObject(select, new Object[]{Integer.parseInt(bookDetailDao.getId())}, new BookRowMapper());
			}
			catch (DataAccessException e) 
			{
				logger.error(ERROR_OCCURRED + e.getMessage());
				ExceptionWrapper.wrapper(e);
			} 
		}
		// update
		if (obj != null) {
			
			update(bookDetailDao); 
		}
		// insert
		else
		{
			insert(bookDetailDao); 
		}
	}

	@Override
	public void delete(String id) {
		logger.info("delete book");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		BookDao obj = null;
		// not exist or deleted by other user
		if (!StringUtils.isEmpty(id)) {
			try 
			{
				obj = jdbcTemplate.queryForObject(select, new Object[]{Integer.parseInt(id)}, new BookRowMapper());
			}
			catch (DataAccessException e) 
			{
				logger.error(ERROR_OCCURRED + e.getMessage());
				ExceptionWrapper.wrapper(e);
			} 
		}
		// delete
		if (obj != null) {
			
			remove(id); 
		}
	}

	@Override
	public BookDetailDao read(String bookId) {
		logger.info("read book detail");
		BookDetailDao obj = new BookDetailDao();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		if (!StringUtils.isEmpty(bookId)) {
			try 
			{
				obj = jdbcTemplate.queryForObject(select, new Object[]{Integer.parseInt(bookId)}, new BookDetailRowMapper());
			}
			catch (DataAccessException e) 
			{
				logger.error(ERROR_OCCURRED + e.getMessage());
				ExceptionWrapper.wrapper(e);
			} 
		}
		return obj;
	}
	
	/**
	 * insert
	 * 
	 * @param bookDetailDao
	 */
	private void insert(BookDetailDao bookDetailDao) {
		try 
		{
			jdbcTemplate.update(insert, new Object[]{bookDetailDao.getTitle(), bookDetailDao.getAuthor(),  DateUtil.parse(bookDetailDao.getDate_create()), DateUtil.parse(bookDetailDao.getDate_update()), bookDetailDao.getDescription()});
		}
		catch (DataAccessException e) 
		{
			logger.error(ERROR_OCCURRED + e.getMessage());
			ExceptionWrapper.wrapper(e);
		} 
		catch (NumberFormatException e) {
			logger.error(ERROR_OCCURRED + e.getMessage());
			ExceptionWrapper.wrapper(e);
		}
	}


	/**
	 * update
	 * 
	 * @param bookDetailDao
	 */
	private void update(BookDetailDao bookDetailDao) {
		try 
		{
			jdbcTemplate.update(update, new Object[]{bookDetailDao.getTitle(), bookDetailDao.getAuthor(),  DateUtil.parse(bookDetailDao.getDate_create()), DateUtil.parse(bookDetailDao.getDate_update()), bookDetailDao.getDescription(), Integer.parseInt(bookDetailDao.getId())});
		}
		catch (DataAccessException e) 
		{
			logger.error(ERROR_OCCURRED + e.getMessage());
			ExceptionWrapper.wrapper(e);
		} 
		catch (NumberFormatException e) {
			logger.error(ERROR_OCCURRED + e.getMessage());
			ExceptionWrapper.wrapper(e);
		}
	}
	

	/**
	 * remove
	 * 
	 * @param id
	 */
	private void remove(String id) {
		try 
		{
			jdbcTemplate.update(delete, new Object[]{Integer.parseInt(id)});
		}
		catch (DataAccessException e) 
		{
			logger.error(ERROR_OCCURRED + e.getMessage());
			ExceptionWrapper.wrapper(e);
		} 
		catch (NumberFormatException e)
		{
			logger.error(ERROR_OCCURRED + e.getMessage());
			ExceptionWrapper.wrapper(e);
		}
	}
}
