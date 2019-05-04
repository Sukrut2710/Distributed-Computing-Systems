import java.rmi.*;  
public class AddClient
{  
	public static void main(String args[])
	{  
		try
		{  
			Addition stub=(Addition)Naming.lookup("//localhost/sum-server");  
			System.out.println(stub.add(5));  
			System.out.println(stub.square(5));
			System.out.println(stub.factorial(5));
			System.out.println(stub.oddeven(5));
		}
		catch(Exception e)
		{
		}  
	}  
}  
