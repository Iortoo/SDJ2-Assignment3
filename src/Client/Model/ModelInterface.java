package Client.Model;

import SharedResources.Message;
import SharedResources.Subject;

import java.util.List;

public interface ModelInterface extends Subject
{
  void send();
  List<Message> getMessage();

}
