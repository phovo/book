package neo.lib.dao.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import neo.lib.dao.sdo.BookDetailDao;

import org.springframework.jdbc.core.RowMapper;

public class BookDetailRowMapper implements RowMapper<BookDetailDao> {

	@Override
	public BookDetailDao mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		BookDetailDao bookDetailDao = new BookDetailDao();
		bookDetailDao.setId(resultSet.getString("ID"));
		bookDetailDao.setTitle(resultSet.getString("TITLE"));
		bookDetailDao.setAuthor(resultSet.getString("AUTHOR"));
		bookDetailDao.setDate_create(resultSet.getString("DATE_CREATE"));
		bookDetailDao.setDate_update(resultSet.getString("DATE_UPDATE"));
		bookDetailDao.setDescription(resultSet.getString("DESCRIPTION"));
		
		return bookDetailDao;
	}

}
