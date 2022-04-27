package SharedResources.networking.serverSide;

import SharedResources.Message;
import SharedResources.networking.clientSide.ClientCallBack;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatServer extends Remote, Serializable
{
  List<Message> getMessages() throws RemoteException;
  void transmitMessage(Message message) throws RemoteException;
  void setClients(List<ClientCallBack> clients) throws RemoteException;
}
