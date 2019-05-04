import java.rmi.*;  
public class STRClient
{  
	public static void main(String args[])
	{  
		try
		{  
			Str_op stub=(Str_op)Naming.lookup("//localhost/str-server");  
			System.out.println(stub.length("MMCOE"));  
			System.out.println(stub.concat("MM","COE"));
			System.out.println(stub.reverse("MMCOE",""));
			//System.out.println(stub.oddeven(5));
		}
		catch(Exception e)
		{
		}  
	}  
}  
