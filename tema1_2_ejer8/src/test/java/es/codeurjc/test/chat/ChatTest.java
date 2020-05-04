package es.codeurjc.test.chat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;


public class ChatTest {

	@Test
	public void addUser() {

		Chat chat = new Chat("Test");
		User user1 = mock(User.class);
		User user2 = mock(User.class);

		when(user2.getName()).thenReturn("Pepe");

		chat.addUser(user1);
		chat.addUser(user2);

		verify(user1).newUserInChat("Test", "Pepe");
	}

	@Test
	public void removeUser() {

		Chat chat = new Chat("Test");
		User user1 = mock(User.class);
		User user2 = mock(User.class);

		when(user1.getName()).thenReturn("Heidi");
		when(user2.getName()).thenReturn("Pepe");

		chat.addUser(user1);
		chat.addUser(user2);

		chat.removeUser(user1);

		verify(user1).newUserInChat("Test", "Pepe");
		verify(user2).userExitedFromChat("Test", "Heidi");
	}

	@Test
	public void sendMessage() {

		Chat chat = new Chat("Test");
		User user1 = mock(User.class);
		User user2 = mock(User.class);

		when(user1.getName()).thenReturn("Heidi");
		when(user2.getName()).thenReturn("Pepe");

		chat.addUser(user1);
		chat.addUser(user2);

		chat.sendMessage(user1, "Hello");
		
		verify(user1).newUserInChat("Test", "Pepe");
		verify(user2).onMessage("Test", "Heidi", "Hello");
		verify(user1, never()).onMessage("Test", "Heidi", "Hello");
	}
}
