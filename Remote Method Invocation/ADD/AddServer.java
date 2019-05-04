import java.rmi.*;  
import java.rmi.registry.*;  
public class AddServer
{  
	public static void main(String args[])
	{  
		try
		{  
			Addition stub = new AddImplementer();  
			Naming.rebind("//localhost/sum-server",stub);  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
	}  
}  
