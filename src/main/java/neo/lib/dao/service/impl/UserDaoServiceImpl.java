package neo.lib.dao.service.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import neo.lib.dao.sdo.UserDao;
import neo.lib.dao.service.UserDaoService;
import neo.lib.dao.service.mapper.UserRowMapper;

@Repository
public class UserDaoServiceImpl implements UserDaoService {
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	private String sql = "SELECT u.id id, u.email name, u.firstname firstname, u.lastname lastname, u.password pass " +
				 "FROM book_core.user u " +
				 "WHERE u.email = ?";
	@Override
	public UserDao getUserByUsername(String username) {
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		UserDao userDao = null;
		try 
		{
			userDao = jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserRowMapper());
		} catch (DataAccessException e) {
			userDao = new UserDao("anonymous", "anonymous");
		} 
		
		userDao.setRole("USER");
		
		return userDao;
	}

}
