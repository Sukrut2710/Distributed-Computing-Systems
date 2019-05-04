import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;  	  
 
class ServerClientThread extends Thread {
  Socket serverClient;
  int clientNo;
  ServerClientThread(Socket inSocket,int counter){
    serverClient = inSocket;
    clientNo=counter;
String Reverse;
  }
  public void run(){
    try{
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
      String clientMessage="", serverMessage="";
      while(!clientMessage.equals("bye")){
        clientMessage=inStream.readUTF();
        System.out.println("From Client-" +clientNo+ ": Number is :"+clientMessage);
   
	StringBuffer sbf = new StringBuffer(clientMessage);
	System.out.println("String buffer = " + sbf);

	sbf.reverse(); 
        System.out.println("String buffer after reversing = " + sbf);
			


        serverMessage="From Server to Client-" + clientNo + " factorial of " + clientMessage + " is " +sbf;
        outStream.writeUTF(serverMessage);
        outStream.flush();
      }
      inStream.close();
      outStream.close();
      serverClient.close();
    }catch(Exception ex){
      System.out.println(ex);
    }finally{
      System.out.println("Client -" + clientNo + " exit!! ");
    }
  }
}
