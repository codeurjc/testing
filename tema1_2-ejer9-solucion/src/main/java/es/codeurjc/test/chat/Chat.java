package es.codeurjc.test.chat;

import java.util.ArrayList;
import java.util.List;

public class Chat {

	private String name;
	private List<User> users = new ArrayList<>();
	private MediaServer mediaServer;

	public Chat(String name) {
		this.name = name;
	}

	public Chat(String name, MediaServer mediaServer) {
		this.name = name;
		this.mediaServer = mediaServer;
	}

	public void addUser(User user) {
		
		if(mediaServer != null) {
			if(!mediaServer.allowMoreUsers()) {
				throw new NotEnoughResourcesException();
			} else {
				mediaServer.addUser(user);
			}
		}

		for (User u : users) {
			u.newUserInChat(name, user.getName());
		}

		users.add(user);
	}

	public void removeUser(User user) {

		users.remove(user);

		for (User u : users) {
			u.userExitedFromChat(name, user.getName());
		}
	}

	public void sendMessage(User user, String message) {

		for (User u : users) {
			if(u != user) {
				u.onMessage(name, user.getName(), message);
			}
		}
	}

}
