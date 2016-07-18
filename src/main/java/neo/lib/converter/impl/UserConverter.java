package neo.lib.converter.impl;

import neo.lib.business.service.sdo.User;
import neo.lib.converter.AbstractConverter;
import neo.lib.dao.sdo.UserDao;

import org.springframework.stereotype.Component;

/**
 * User Converter
 *
 */
@Component
public class UserConverter
    extends AbstractConverter<UserDao, User>
{
	@Override
	public User convert(UserDao from) throws Exception {
		User to = null;
		if (from != null ) {
			to = new User();
			to.setId(from.getId());
			to.setEmail(from.getEmail());
			to.setFirstName(from.getFirstname());
			to.setLastName(from.getLastname());
			to.setPassword(from.getPassword());
			to.setRole(from.getRole());
		}
		
		return to;
	}
}

