package Server.Model;

import SharedResources.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ChatManagerImpl implements ChatManager, Serializable
{
  private List<Message> messageList;
  private PropertyChangeSupport support;

  public ChatManagerImpl() throws RemoteException{
     messageList = new ArrayList<>();
     support = new PropertyChangeSupport(this);
  }

  @Override public List<Message> getMessages()
  {
    return messageList;
  }

  @Override public void transmitMessage(Message message)
  {
    messageList.add(message);
  }

  @Override public void addListener(String event,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(event, listener);
  }

  @Override public void removeListener(String event,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(event, listener);
  }
}
