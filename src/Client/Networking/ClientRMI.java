package Client.Networking;

import SharedResources.Message;
import SharedResources.networking.clientSide.ClientCallBack;
import SharedResources.networking.serverSide.Server;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ClientRMI implements Client, ClientCallBack
{
  private Server server;
  private PropertyChangeSupport support;

  public ClientRMI()
  {
    try{
      UnicastRemoteObject.exportObject(this,0);
      Registry registry = LocateRegistry.getRegistry(1099);
      server = (Server) registry.lookup("Server");
      support = new PropertyChangeSupport(this);
      server.registerClient(this);
    }
    catch(RemoteException e){}
    catch(NotBoundException e){}
  }

  @Override public void send(Message message)
  {
    try{
      server.getChatServer().transmitMessage(message);
    }
    catch(RemoteException e){System.out.println(e.getMessage());}

  }

  @Override public List<Message> receive()
  {
    try{
      return server.getChatServer().getMessages();
    }
    catch (RemoteException e){}
    return null;
  }


  @Override public void addListener(String event,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(event,listener);
  }

  @Override public void removeListener(String event,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(event,listener);
  }

  @Override public void updateChat(Message message) throws RemoteException
  {
    support.firePropertyChange("newMessage",null, message);
  }
}
