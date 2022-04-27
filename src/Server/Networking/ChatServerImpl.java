package Server.Networking;

import Server.Model.ChatManager;
import SharedResources.Message;
import SharedResources.networking.clientSide.ClientCallBack;
import SharedResources.networking.serverSide.ChatServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChatServerImpl implements ChatServer
{
  private List<ClientCallBack> clients;
  private ChatManager chatManager;

  public ChatServerImpl(ChatManager chatManager) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0)
    ;
  }

  @Override public List<Message> getMessages() throws RemoteException
  {
    return chatManager.getMessages();
  }

  @Override public void transmitMessage(Message message) throws RemoteException
  {
    chatManager.transmitMessage(message);
    for (ClientCallBack client : clients)
    {
      client.updateChat(message);
    }
  }

  @Override public void setClients(List<ClientCallBack> clients)
      throws RemoteException
  {
    this.clients = clients;
  }
}
