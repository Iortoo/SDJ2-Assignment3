package Client.Model;

import Client.Networking.Client;
import SharedResources.Message;

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
  }
  @Override
public void addListener(String eventName, PropertyChangeListener listener) {
  support.addPropertyChangeListener(eventName,listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {

    support.removePropertyChangeListener(eventName,listener);
  }

  @Override public void send()
  {

  }

  @Override public List<Message> getMessage()
  {
    return null;
  }
}
