package es.codeurjc.rest.users.manager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import es.codeurjc.rest.users.User;

@RestController
@RequestMapping("/manager/users")
public class UsersManagerController {

	private static final String BASE_URL = "http://localhost:9000/users/";

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@GetMapping("/")
	public ResponseEntity<User[]> users() {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<User[]> usersResponse = restTemplate.getForEntity(BASE_URL, User[].class);

		return usersResponse;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<User> usersResponse = restTemplate.getForEntity(BASE_URL + id, User.class);

		return usersResponse;
	}

	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		if (validEmail(user.getEmail())) {

			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<User> userResponse = restTemplate.postForEntity(BASE_URL, user, User.class);

			return userResponse;

		} else {

			return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User updatedUser) {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<User> usersResponse = restTemplate.getForEntity(BASE_URL + id, User.class);

		if (usersResponse.getStatusCode() == HttpStatus.NOT_FOUND) {

			return usersResponse;

		} else {

			User user = usersResponse.getBody();

			if (user.isEditable()) {

				ResponseEntity<User> updatedUserResponse = 
						restTemplate.exchange(BASE_URL + id, HttpMethod.PUT,
						new HttpEntity<User>(updatedUser), User.class);

				return updatedUserResponse;
				
			} else {
				return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
			}
		}
	}

	public static boolean validEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
}
