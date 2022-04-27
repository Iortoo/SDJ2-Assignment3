package Client.Core;

import Client.Model.ModelInterface;
import Client.Model.ModelInterfaceImpl;
import SharedResources.networking.clientSide.ClientCallBack;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private ModelInterface modelInterface;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }

  public ModelInterface getModelInterface()
  {
    if(modelInterface==null)modelInterface=new ModelInterfaceImpl(clientFactory.getClient());
    return  modelInterface;
  }


}
