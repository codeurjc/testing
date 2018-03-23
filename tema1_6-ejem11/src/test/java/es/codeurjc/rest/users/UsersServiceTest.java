package es.codeurjc.rest.users;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class UsersServiceTest {
	
	@Test
	public void getUsersTest() throws Exception {
		 
	    UsersService service = new UsersService();
	    
	    List<User> users = service.getUsers();
	    
	    assertThat(users).hasSize(1);
	    assertThat(users.get(0).getName()).isEqualTo("Pepe");
		
	}
}
