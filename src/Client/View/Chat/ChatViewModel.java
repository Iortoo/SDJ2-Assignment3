package Client.View.Chat;

import Client.Core.ModelFactory;
//import TransferObjects.Message;
import Client.Model.ModelInterface;
import SharedResources.Message;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.GregorianCalendar;
import java.util.List;

public class ChatViewModel
{
  private ModelInterface modelInterface;
  private ObservableList<Message> messages;

  public ChatViewModel(ModelInterface modelInterface)
  {
    this.modelInterface=modelInterface;
    modelInterface.addListener("newMessage", this::newMessage);
    showMessages();
  }

  private void newMessage(PropertyChangeEvent e)
  {
    Platform.runLater(()->{
      messages.add((Message) e.getNewValue());
        }
    );
  }

  public void loadMessages()
  {
    List<Message> list = modelInterface.receive();
    messages = FXCollections.observableArrayList(list);
  }

  public ObservableList<Message> showMessages(){return messages;}

  public void sendMessage(String text, String user)
  {
    String dateTimeSent = GregorianCalendar.DATE+"/"+(GregorianCalendar.MONTH+1)+"/"+GregorianCalendar.YEAR+
        " "+GregorianCalendar.HOUR+":"+GregorianCalendar.MINUTE;
    Message message = new Message(text,dateTimeSent,user);
    modelInterface.send(message);
  }
}