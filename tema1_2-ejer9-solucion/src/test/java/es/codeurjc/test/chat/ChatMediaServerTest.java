package es.codeurjc.test.chat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class ChatMediaServerTest extends ChatTest {
	
	@Test
	public void givenChat_whenAUserIsAdded_thenMediaServerIsAskedForCapacity_and_whenItHas_thenUserIsAdded() {
		
		//Given
		MediaServer mediaServer = mock(MediaServer.class);
		when(mediaServer.allowMoreUsers()).thenReturn(true);
		
		Chat chat = new Chat("Mi chat", mediaServer);
		
		//When
		User user = createUser("Juan");
		chat.addUser(user);
		
		//Then
		verify(mediaServer).allowMoreUsers();
		verify(mediaServer).addUser(user);
	}
	
	@Test
	public void givenChat_whenAUserIsAdded_thenMediaServerIsAskedForCapacity_and_whenItHasnt_thenExceptionIsThrown() {
		
		//Given
		MediaServer mediaServer = mock(MediaServer.class);
		when(mediaServer.allowMoreUsers()).thenReturn(false);
		
		Chat chat = new Chat("Mi chat", mediaServer);
		
		//When
		User user = createUser("Juan");
		
		assertThatThrownBy(() -> {
			
			chat.addUser(user);
		
		}).isInstanceOf(NotEnoughResourcesException.class);		
		
		//Then
		verify(mediaServer).allowMoreUsers();
		verify(mediaServer, never()).addUser(any());
	}

}
