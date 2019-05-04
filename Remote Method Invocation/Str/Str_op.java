import java.rmi.*;  
public interface Str_op extends Remote
{  
	public int  length(String s1) throws RemoteException;
	public String concat(String s1, String s2) throws RemoteException;
	public String reverse(String s1, String s2) throws RemoteException;
	//public int oddeven(int x) throws RemoteException;

}  
