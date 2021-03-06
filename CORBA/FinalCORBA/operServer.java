// HelloServer.java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import operApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.*;

import java.util.Properties;

class operImpl extends operPOA {
  private ORB orb;

  public void setORB(ORB orb_val) {
    orb = orb_val;
  }

  // implement sayHello() method
 /*public String sayHello() {
    return "Hello From Server";
  }*/

  /*public String concat(String s1, String s2) {
    return s1=s1.concat(s2);
  }*/


 /*public double cel_to_farh(double celsius) {
    double fahrenheit = (9.0/5.0)*celsius + 32;
        //System.out.println("Temperature in Fahrenheit is : "+fahrenheit);
	return fahrenheit;
  }*/


   /*public double farh_to_cel(double fahrenheit) {
    double celsius = (5.0/9.0)*(fahrenheit - 32);  
	return celsius;
  }*/

 /* public float add(float num1, float num2) {
    return num1=num1 + num2;
  }*/

public String datetime() {
    LocalDateTime current = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    String formatted = current.format(formatter);
    return formatted;
}

  // implement shutdown() method
  public void shutdown() {
    orb.shutdown(false);
  }
}


public class operServer {

  public static void main(String args[]) {
    try{
      // create and initialize the ORB
      ORB orb = ORB.init(args, null);

      // get reference to rootpoa and activate the POAManager
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      // create servant and register it with the ORB
      operImpl operImpl = new operImpl();
      operImpl.setORB(orb);

      // get object reference from the servant
      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(operImpl);
      oper href = operHelper.narrow(ref);

      // get the root naming context
      org.omg.CORBA.Object objRef =
          orb.resolve_initial_references("NameService");
      // Use NamingContextExt which is part of the Interoperable
      // Naming Service (INS) specification.
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      // bind the Object Reference in Naming
      String name = "oper";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println("operServer ready and waiting ...");

      // wait for invocations from clients
      orb.run();
    }

      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }

      System.out.println("operServer Exiting ...");

  }
}




/* idlj -fall oper.idl

javac *.java operApp/*.java

orbd -ORBInitialPort 1050&

java operServer -ORBInitialPort 1050 -ORBInitialHost localhost&

java operClient -ORBInitialPort 1050 -ORBInitialHost localhost

*/
