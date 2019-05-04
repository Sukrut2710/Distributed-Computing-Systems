import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;  	  
 
class ServerClientThread extends Thread {
  Socket serverClient;
  int clientNo;
  String output;

  ServerClientThread(Socket inSocket,int counter){
    serverClient = inSocket;
    clientNo=counter;


String Reverse;
  }
  public void run(){
    try{
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
      String clientMessage1="",clientMessage2="", serverMessage="";
      while(!clientMessage1.equals("bye")){
        clientMessage1=inStream.readUTF();
	        clientMessage2=inStream.readUTF();
	
		output=clientMessage1.concat(clientMessage2);
		
        serverMessage="From Server to Client Output in " +output;
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
