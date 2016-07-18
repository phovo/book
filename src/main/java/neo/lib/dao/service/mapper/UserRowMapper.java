package neo.lib.dao.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import neo.lib.dao.sdo.UserDao;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<UserDao> {

	@Override
	public UserDao mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		UserDao userDao = new UserDao();
		userDao.setFirstname(resultSet.getString("FIRSTNAME"));
		userDao.setLastname(resultSet.getString("LASTNAME"));
		userDao.setPassword(resultSet.getString("PASSWORD"));
		userDao.setId(resultSet.getString("ID"));
		userDao.setEmail(resultSet.getString("EMAIL"));
		
		return userDao;
	}
}
