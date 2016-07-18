package neo.lib.dao.sdo;

import java.io.Serializable;

public class UserDao implements Serializable {

	public UserDao(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public UserDao() {
		super();
	}

	private static final long serialVersionUID = 322386292796828140L;

	private String id;
	
	private String email;
	
	private String firstname;
	
	private String lastname;
	
	private String password;
	
	private String role;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
