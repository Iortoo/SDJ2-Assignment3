package Client.View.Chat;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Client.View.ViewController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import javax.swing.text.View;

public class ChatViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ChatViewModel chatViewModel;
  @FXML Label username;
  @FXML TextArea writeMessageTextArea;
  @FXML ListView messagesListView;
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {

  }

  public void initPlus(ViewHandler viewHandler,ViewModelFactory viewModelFactory, String username)
  {
    this.viewHandler = viewHandler;
    this.username.setText(username);
    this.chatViewModel=viewModelFactory.getChatViewModel();
    chatViewModel.loadMessages();
    messagesListView.setItems(chatViewModel.showMessages());
  }

  public void onSendButton()
  {
    chatViewModel.sendMessage(writeMessageTextArea.getText(),username.getText());
    writeMessageTextArea.setText("");
  }


}