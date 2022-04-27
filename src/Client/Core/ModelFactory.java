package Client.Core;

import Client.Model.ModelInterface;
import Client.Model.ModelInterfaceImpl;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private ModelInterface modelInterface;

  public ModelInterface getModelInterface()
  {
    if(modelInterface==null)modelInterface=new ModelInterfaceImpl();
    return  modelInterface;
  }
}
