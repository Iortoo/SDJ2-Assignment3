package Server.Networking;

import SharedResources.networking.clientSide.ClientCallBack;
import SharedResources.networking.serverSide.ChatServer;
import SharedResources.networking.serverSide.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements Server
{
  private ChatServer chatServer;
  private List<ClientCallBack> clients;

  public ServerImpl(ChatServer chatServer) throws RemoteException
  {
    this.chatServer = chatServer;
    UnicastRemoteObject.exportObject(this, 0);
    clients = new ArrayList<>();
  }

  @Override public ChatServer getChatServer() throws RemoteException
  {
    return chatServer;
  }

  @Override public void registerClient(ClientCallBack clientCallBack)
      throws RemoteException
  {
    clients.add(clientCallBack);
    sendClientToChatServer(clients);
    System.out.println("client added");
  }

  @Override public void startServer()
      throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
    System.out.println("Server started");
  }

  private void sendClientToChatServer(List<ClientCallBack> clients)
      throws RemoteException
  {
    chatServer.setClients(clients);
  }
}
