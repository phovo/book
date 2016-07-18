package neo.lib.dao.service;

import neo.lib.dao.sdo.UserDao;

public interface UserDaoService {

	/**
	 * get user by user name, in database it would be the email address
	 *
	 *@return User
	 */
	UserDao getUserByUsername(String username) throws Exception;
}
