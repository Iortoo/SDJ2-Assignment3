package Server.Model;

import SharedResources.Message;
import SharedResources.Subject;

import java.io.Serializable;
import java.util.List;

public interface ChatManager extends Subject, Serializable
{
  List<Message> getMessages();

  void transmitMessage(Message message);
}
