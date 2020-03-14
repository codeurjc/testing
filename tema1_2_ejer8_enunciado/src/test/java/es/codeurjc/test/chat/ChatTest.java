package es.codeurjc.test.chat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

public class ChatTest {

	private Chat chat;

	@BeforeEach
	public void setUp() {
		this.chat = new Chat("test");
	}
	
	@Test
	public void addUserTest() {
		
		// Given
		User user1 = mock(User.class);
		User user2 = mock(User.class);
		
		chat.addUser(user1);
		when(user1.getName()).thenReturn("user1");
		chat.addUser(user2);
		when(user2.getName()).thenReturn("user2");
		
		User user3 = mock(User.class);
		when(user3.getName()).thenReturn("user3");
		
		// when
		chat.addUser(user3);
		
		// then
		verify(user1, times(1)).newUserInChat("test", "user3");
		verify(user2, times(1)).newUserInChat("test", "user3");
		
		
		
	}
	
	@Test
	public void removeUserTest() {
		
	}
	
	@Test
	public void messageTest() {
		
	}
	
}
