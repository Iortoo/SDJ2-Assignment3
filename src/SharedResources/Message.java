package SharedResources;

import java.io.Serializable;

public class Message implements Serializable
{
  private String text, dateTimeSent;
  private String from;

  public Message(String text, String dateTimeSent, String from)
  {
    this.text=text;
    this.dateTimeSent=dateTimeSent;
    this.from=from;
  }

  public String getText()
  {
    return text;
  }

  public String getDateTimeSent()
  {
    return dateTimeSent;
  }

  public String getFrom()
  {
    return from;
  }
}
