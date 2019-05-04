// Copyright and License

import operApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.*;


public class operClient
{
  static oper operImpl;

  public static void main(String args[])
    {
      try{
        // create and initialize the ORB
        ORB orb = ORB.init(args, null);

        // get the root naming context
        org.omg.CORBA.Object objRef =
            orb.resolve_initial_references("NameService");
        // Use NamingContextExt instead of NamingContext. This is
        // part of the Interoperable naming Service.
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        // resolve the Object Reference in Naming
        String name = "oper";
        operImpl = operHelper.narrow(ncRef.resolve_str(name));

        System.out.println("Obtained a handle on server object: " + operImpl);
	//String.valueOf(intVarable)

 	//System.out.println(operImpl.sayHello());

      //System.out.println(operImpl.concat("MM","COE"));

     //	System.out.println(operImpl.farh_to_cel(86));

    //	System.out.println(operImpl.add(5,10));

	System.out.println(operImpl.datetime());
 
      operImpl.shutdown();

        } catch (Exception e) {
          System.out.println("ERROR : " + e) ;
          e.printStackTrace(System.out);
          }
    }

}




/* idlj -fall oper.idl

javac *.java operApp/*.java

orbd -ORBInitialPort 1050&

java operServer -ORBInitialPort 1050 -ORBInitialHost localhost&

java operClient -ORBInitialPort 1050 -ORBInitialHost localhost

*/





