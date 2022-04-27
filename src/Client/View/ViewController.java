package Client.View;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;

public interface ViewController
{
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory);
}
