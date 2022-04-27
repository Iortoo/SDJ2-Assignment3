package SharedResources.networking.serverSide;

import SharedResources.networking.clientSide.ClientCallBack;
import SharedResources.networking.serverSide.ChatServer;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote
{
  ChatServer getChatServer() throws RemoteException;
  void registerClient(ClientCallBack clientCallBack) throws RemoteException;
  void startServer() throws RemoteException, AlreadyBoundException;
}
