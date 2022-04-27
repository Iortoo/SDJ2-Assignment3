package SharedResources;

import java.beans.PropertyChangeSupport;

public interface Subject
{
  void addListener(String event, PropertyChangeSupport listener);
  void removeListener(String event, PropertyChangeSupport listener);
}
