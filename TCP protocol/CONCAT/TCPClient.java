 // CLIENT CLASS
 
import java.net.*;
import java.io.*;
import java.util.*; 

public class TCPClient {
  public static void main(String[] args) throws Exception {
  try{
    Socket socket=new Socket("127.0.0.1",8888);
    DataInputStream inStream=new DataInputStream(socket.getInputStream());
    DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String clientMessage1="",clientMessage2="",serverMessage="";
    while(!clientMessage1.equals("bye")){
      System.out.println("Enter string :");
      clientMessage1=br.readLine();
      outStream.writeUTF(clientMessage1);
      	clientMessage2=br.readLine();
      outStream.writeUTF(clientMessage2);
	      
      serverMessage=inStream.readUTF();
      System.out.println(serverMessage);
    }
    outStream.close();
    inStream.close();
    socket.close();
  }catch(Exception e){
    System.out.println(e);
  }
  }
}
