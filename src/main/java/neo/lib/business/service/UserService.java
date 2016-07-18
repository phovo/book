package neo.lib.business.service;

import neo.lib.business.service.sdo.User;

public interface UserService {
	
	/**
	 * get user by user name, in database it would be the email address
	 *
	 *@return User
	 */
	User getUserByUsername(String username) throws Exception; 
}
