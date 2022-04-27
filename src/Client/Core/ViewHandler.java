package Client.Core;

import Client.View.Chat.ChatViewController;
import Client.View.Username.UsernameViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(Stage stage, ViewModelFactory viewModelFactory)
  {
    this.stage = stage;
    this.viewModelFactory=viewModelFactory;
  }

  public void openChatView(String username) throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("../View/Chat/ChatViewModel.fxml"));
    root = loader.load();
    ChatViewController view = loader.getController();
    view.initPlus(this,viewModelFactory,username);
    scene = new Scene(root);
    stage.setTitle("Chat");
    stage.setScene(scene);
    stage.show();
  }

  public void openUsernameView() throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource("../View/Username/UsernameViewModel.fxml"));
    root = loader.load();
    UsernameViewController view = loader.getController();
    view.init(this,viewModelFactory);
    scene = new Scene(root);
    stage.setTitle("Chat");
    stage.setScene(scene);
    stage.show();
  }
}
