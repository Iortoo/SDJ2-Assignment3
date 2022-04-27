package Client;

import Client.Core.ClientFactory;
import Client.Core.ModelFactory;
import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ChatApp extends Application
{
  @Override
  public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(stage,viewModelFactory);
    viewHandler.openUsernameView();
  }
}
