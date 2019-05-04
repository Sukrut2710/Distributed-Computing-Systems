import java.rmi.*;  
import java.rmi.server.*;  
public class AddImplementer extends UnicastRemoteObject implements Addition
{  
	AddImplementer() throws RemoteException
	{  
		super();  
	}  
	public int add(int x)
	{
		return x+x;
	}	  
	
	public int square(int x)
	{
		return x*x;
	}

	public int factorial(int x)
	{
		int i;
		int temp=x-1;
		for(i=temp;i>0;i--)
		{
			x=x*temp;
		}
	return x;
	}
	
	public int oddeven(int x)
	{
		if(x%2==0)
		return 0;
		else
		return 1;
	}
}  


/* javac *.java
   rmic AddImplementer
   rmiregistry

   java AddServer

   java AddClient

*/
