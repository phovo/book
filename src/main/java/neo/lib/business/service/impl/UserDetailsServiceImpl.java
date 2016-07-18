package neo.lib.business.service.impl;

import java.util.Arrays;

import neo.lib.business.service.UserService;
import neo.lib.business.service.sdo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = org.springframework.transaction.annotation.Isolation.READ_COMMITTED)
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		
		try {
			User user = userService.getUserByUsername(name);
			GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
			userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getFirstName() + " " + user.getLastName(), user.getPassword(), Arrays.asList(authority));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userDetails;
	}
}
