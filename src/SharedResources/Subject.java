package SharedResources;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public interface Subject
{
  void addListener(String event, PropertyChangeListener listener);
  void removeListener(String event, PropertyChangeListener listener);
}
