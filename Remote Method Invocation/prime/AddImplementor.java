import java.rmi.*;  
import java.rmi.server.*;  
public class AddImplementor extends UnicastRemoteObject implements Addition
{  
	AddImplementor()throws RemoteException
	{  
		super();  
	}  
	public int add(int x,int y)
	{
		return x+y;
	}  
	public boolean prime(int num)
	{
		int temp;
	boolean isPrime=true;
	
	for(int i=2;i<=num/2;i++)
	{
           temp=num%i;
	   if(temp==0)
	   {
	      isPrime=false;
	      break;
	   }
	}		
			
	return isPrime;
	}

}  

/* javac *.java
   rmic AddImplementer
   rmiregistry

   java AddServer

   java AddClient

*/
