package es.codeurjc.test.chat;

import es.codeurjc.test.chat.Chat;
import es.codeurjc.test.chat.MediaServer;
import es.codeurjc.test.chat.NotEnoughResourcesException;
import es.codeurjc.test.chat.User;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

	@Test
	public void addUserWithoutResources() {

		User user1 = mock(User.class);
		MediaServer mediaServer = mock(MediaServer.class);
		Chat chat = new Chat("Test", mediaServer);

		when(mediaServer.allowMoreUsers()).thenReturn(false);

		assertThatThrownBy(() -> chat.addUser(user1)).isInstanceOf(NotEnoughResourcesException.class);
	}

	@Test
	public void addUserWithResources() {

		User user1 = mock(User.class);
		MediaServer mediaServer = mock(MediaServer.class);
		Chat chat = new Chat("Test", mediaServer);

		when(mediaServer.allowMoreUsers()).thenReturn(true);

		chat.addUser(user1);
	}

	@Test
	public void addFirstUserWithResourcesAnd2ndWithout() {

		User user1 = mock(User.class);
		User user2 = mock(User.class);

		MediaServer mediaServer = mock(MediaServer.class);
		Chat chat = new Chat("Test", mediaServer);

		when(mediaServer.allowMoreUsers()).thenReturn(true);

		chat.addUser(user1);

		when(mediaServer.allowMoreUsers()).thenReturn(false);

		assertThatThrownBy(() -> chat.addUser(user2)).isInstanceOf(NotEnoughResourcesException.class);
	}

}
