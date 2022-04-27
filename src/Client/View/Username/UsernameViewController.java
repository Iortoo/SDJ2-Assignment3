package Client.View.Username;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.View.ViewController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import java.io.IOException;

public class UsernameViewController implements ViewController
{
  @FXML TextField textField;
  @FXML Button save;
  private ViewHandler viewHandler;
  private UsernameViewModel usernameViewModel;
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.usernameViewModel=viewModelFactory.getUsernameViewModel();
  }

  public void onSaveButton(ActionEvent e) throws IOException
  {
    viewHandler.openChatView(textField.getText());
  }
}
