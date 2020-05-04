package es.codeurjc.test.chat;

public interface User {

	public String getName();
	
	public String getColor();

	public void newChat(Chat chat);

	public void chatClosed(Chat chat);

	public void newUserInChat(Chat chat, User user);

	public void userExitedFromChat(Chat chat, User user);

	public void newMessage(Chat chat, User user, String message);

}
