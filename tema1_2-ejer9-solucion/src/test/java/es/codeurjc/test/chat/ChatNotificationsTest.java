package es.codeurjc.test.chat;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChatNotificationsTest extends ChatTest {

	private Chat chat;
	private User userA;

	@BeforeEach
	public void init() {

		chat = new Chat("Mi grupo");

		userA = mock(User.class);
		when(userA.getName()).thenReturn("Pepe");
	}

	@Test
	public void givenChatWithUserA_whenNewUserBIsAdded_thenUserAIsNotified() {

		// Given
		chat.addUser(userA);

		// When
		User userB = createUser("Juan");

		chat.addUser(userB);

		// Then
		verify(userA).newUserInChat("Mi grupo", "Juan");

	}

	@Test
	public void givenChatWithTwoUsers_whenAUserSendMessage_thenUsersAreNotified() {

		// Given
		User userB = createUser("Juan");
		User userC = createUser("Estefanía");

		chat.addUser(userA);
		chat.addUser(userB);
		chat.addUser(userC);

		// When
		chat.sendMessage(userB, "Hola caracola");

		// Then
		String userBName = userB.getName();
		verify(userA).onMessage("Mi grupo", userBName, "Hola caracola");
		verify(userC).onMessage("Mi grupo", userBName, "Hola caracola");

	}

	@Test
	public void givenChatWithTwoUsers_whenAUserSendMessage_thenSenderUserIsNotNotified() {

		// Given
		User userB = createUser("Juan");

		chat.addUser(userA);
		chat.addUser(userB);

		// When
		chat.sendMessage(userB, "Hola caracola");

		// Then
		String userBName = userB.getName();
		verify(userB, never()).onMessage("Mi grupo", userBName, "Hola caracola");
	}

}
