package es.codeurjc.test.chat;

public interface User {

	void onMessage(String chat, String user, String message);

	void newUserInChat(String chat, String user);

	void userExitedFromChat(String chat, String user);

	String getName();
}
