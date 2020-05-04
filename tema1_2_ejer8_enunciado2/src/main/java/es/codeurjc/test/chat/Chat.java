package es.codeurjc.test.chat;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Chat {

	private String name;
	private Map<String, User> users = new HashMap<>();

	private ChatManager chatManager;

	public Chat(ChatManager chatManager, String name) {
		this.chatManager = chatManager;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addUser(User user) {
		users.put(user.getName(), user);
		for(User u : users.values()){
			if (u != user) {
				u.newUserInChat(this, user);
			}
		}
	}

	public void removeUser(User user) {
		users.remove(user.getName());
		for(User u : users.values()){
			u.userExitedFromChat(this, user);
		}
	}

	public Collection<User> getUsers() {
		return Collections.unmodifiableCollection(users.values());
	}

	public User getUser(String name) {
		return users.get(name);
	}

	public void sendMessage(User user, String message) {
		for(User u : users.values()){
			u.newMessage(this, user, message);
		}
	}

	public void close() {
		this.chatManager.closeChat(this);
	}
}
