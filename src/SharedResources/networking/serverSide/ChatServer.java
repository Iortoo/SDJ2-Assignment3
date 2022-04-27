package SharedResources.networking.serverSide;

import SharedResources.Message;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatServer extends Remote, Serializable
{
  List<Message> getMessage() throws RemoteException;
  void transmitMessage(Message message) throws RemoteException;
}
