package Client.View.Chat;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.View.ViewController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import javax.swing.text.View;

public class ChatViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ChatViewModel chatViewModel;
  @FXML Label username;
  @FXML TextArea messageArea;
  @FXML TextArea receivedArea;
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
  }

  public void initPlus(ViewHandler viewHandler,ViewModelFactory viewModelFactory, String username)
  {
    this.viewHandler = viewHandler;
    this.username.setText(username);
    this.chatViewModel=viewModelFactory.getChatViewModel();
  }

  public void onSendButton()
  {
    chatViewModel.sendMessage(messageArea.getText(),username.getText());
    messageArea.setText("");
  }

  public void update(String message, String from, String dateTimeSent)
  {
    receivedArea.setText(receivedArea.getText()+from+" ("+dateTimeSent+"):\n"+message+"\n\n");
    // WE'LL CALL THIS FUNCTION WHENEVER THE CLIENT RECEIVES A NEW MESSAGE
  }
}