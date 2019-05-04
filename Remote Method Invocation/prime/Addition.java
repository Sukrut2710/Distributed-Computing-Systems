import java.rmi.*;  
public interface Addition extends Remote
{  
	public int add(int x,int y)throws RemoteException;  
	public boolean prime(int num) throws RemoteException;
}  
