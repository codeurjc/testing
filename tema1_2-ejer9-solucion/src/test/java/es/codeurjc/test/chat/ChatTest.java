package es.codeurjc.test.chat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChatTest {

	protected User createUser(String name) {
		User user = mock(User.class);
		when(user.getName()).thenReturn(name);
		return user;
	}
	
}
