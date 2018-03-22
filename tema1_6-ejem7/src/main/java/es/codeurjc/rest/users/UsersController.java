package es.codeurjc.rest.users;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

  private UsersService usersService;

  public UsersController(UsersService usersService) {
	  this.usersService = usersService;
  }
  
  @GetMapping("/users")
  public List<User> getUsers() {

    return usersService.getUsers();
  }
}
