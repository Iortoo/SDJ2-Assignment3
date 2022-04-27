package SharedResources.networking.clientSide;

import java.rmi.RemoteException;

public interface ClientCallBack
{
  String getUsername() throws RemoteException;
}
