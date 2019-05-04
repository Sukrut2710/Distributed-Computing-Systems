import java.rmi.*;  
import java.rmi.registry.*;  
public class STRServer
{  
	public static void main(String args[])
	{  
		try
		{  
			Str_op stub = new STRImplementer();  
			Naming.rebind("//localhost/str-server",stub);  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
	}  
}  
