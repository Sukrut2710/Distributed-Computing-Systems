import java.rmi.*;  
public interface Addition extends Remote
{  
	public int add(int x) throws RemoteException;
	public int square(int x) throws RemoteException;
	public int factorial(int x) throws RemoteException;
	public int oddeven(int x) throws RemoteException;

}  
