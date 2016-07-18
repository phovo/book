package neo.lib.business.service.impl;

import neo.lib.business.service.UserService;
import neo.lib.business.service.sdo.User;
import neo.lib.converter.AbstractConverter;
import neo.lib.dao.sdo.UserDao;
import neo.lib.dao.service.UserDaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = org.springframework.transaction.annotation.Isolation.READ_COMMITTED)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private AbstractConverter<UserDao, User> converter;
	
	@Override
	public User getUserByUsername(String username) throws Exception {
		
		return	converter.convert(userDaoService.getUserByUsername(username));		
	}
}
