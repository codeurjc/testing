package es.codeurjc.rest.users;

import java.util.Arrays;
import java.util.List;

public class UsersService {

	private List<User> users;

	public UsersService(String defaultUser) {
		users = Arrays.asList(new User(defaultUser));
	}
	
	public List<User> getUsers() {
		return users;
	}
}
