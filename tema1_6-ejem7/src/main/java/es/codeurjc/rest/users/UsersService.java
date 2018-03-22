package es.codeurjc.rest.users;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UsersService {

	private List<User> users = 
		Arrays.asList(new User("Pepe"));
	
	public List<User> getUsers() {
		return users;
	}
}
