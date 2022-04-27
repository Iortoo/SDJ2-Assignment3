package Client.Model;

import Client.Networking.Client;
import SharedResources.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ModelInterfaceImpl implements ModelInterface
{
  private Client client;
  private PropertyChangeSupport support;
  public ModelInterfaceImpl(Client client)
  {
    this.client=client;
    this.support=new PropertyChangeSupport(this);
    client.addListener("newMessage",this::newMessage);
  }

  @Override public void send(Message message)
  {
    client.send(message);
  }

  @Override public List<Message> receive()
  {
    return client.receive();
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

  private void newMessage(PropertyChangeEvent e)
  {
    Message message = (Message) e.getNewValue();
    support.firePropertyChange("newMessage",null,message);
  }
}
