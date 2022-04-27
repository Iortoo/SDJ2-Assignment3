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

  @Override public String toString()
  {
    return "(" + dateTimeSent + ")  ψ(｀∇´)ψ" + from + "-> " + text;
  }
}
