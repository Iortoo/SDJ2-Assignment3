package Client.Core;

import Client.Networking.Client;
import Client.Networking.ClientRMI;

public class ClientFactory
{
  private Client client;

  public Client getClient()
  {
    if(client==null)client= new ClientRMI();
    return client;
  }


}
