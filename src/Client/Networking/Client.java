package Client.Networking;

import SharedResources.Message;
import SharedResources.Subject;

import java.util.List;

public interface Client extends Subject
{
  void send(Message message);
  List<Message> receive();
  boolean connectionPossible();
}
