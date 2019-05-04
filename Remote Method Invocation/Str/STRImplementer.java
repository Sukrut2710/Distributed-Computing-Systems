import java.rmi.*;  
import java.rmi.server.*;  
public class STRImplementer extends UnicastRemoteObject implements Str_op
{  
	STRImplementer() throws RemoteException
	{  
		super();  
	}  
	public int length(String s1)
	{
		return s1.length();
	}	  
	
	public String concat(String s1, String s2)
	{
		return s1=s1.concat(s2);
	}

	public String reverse(String s1, String s2)
	{
		int length = s1.length();
      		for (int i = length - 1 ; i >= 0 ; i--)
         		s2 = s2 + s1.charAt(i);
         return ("Reverse of the string: " + s2);		


	//return s1.reverse();
	}
	
	
}  

/* javac *.java
   rmic AddImplementer
   rmiregistry

   java AddServer

   java AddClient

*/
