package Server;

import Server.Model.ChatManager;
import Server.Model.ChatManagerImpl;
import Server.Networking.ChatServerImpl;
import Server.Networking.ServerImpl;
import SharedResources.networking.serverSide.ChatServer;
import SharedResources.networking.serverSide.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    ChatServer chatServer = new ChatServerImpl(new ChatManagerImpl());
    Server server = new ServerImpl(chatServer);
    server.startServer();
  }
}
