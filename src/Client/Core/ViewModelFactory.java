package Client.Core;

import Client.View.Chat.ChatViewModel;
import Client.View.Username.UsernameViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private UsernameViewModel usernameViewModel;
  private ChatViewModel chatViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    usernameViewModel= new UsernameViewModel(modelFactory.getModelInterface());
    chatViewModel = new ChatViewModel(modelFactory.getModelInterface());
  }

  public UsernameViewModel getUsernameViewModel()
  {
    return usernameViewModel;
  }

  public ChatViewModel getChatViewModel()
  {
    return chatViewModel;
  }
}
