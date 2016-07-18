package neo.lib.dao.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import neo.lib.dao.sdo.BookDao;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<BookDao> {

	@Override
	public BookDao mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		BookDao bookDao = new BookDao();
		bookDao.setId(resultSet.getString("ID"));
		bookDao.setTitle(resultSet.getString("TITLE"));
		bookDao.setAuthor(resultSet.getString("AUTHOR"));
		bookDao.setDescription(resultSet.getString("DESCRIPTION"));
		
		return bookDao;
	}
}
