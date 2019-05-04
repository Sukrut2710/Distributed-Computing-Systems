import mpi.*;

public class Send_Recv_Object {
    public static void main(String[] args) throws Exception {

        int peer ; 
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank() ;
        int size = MPI.COMM_WORLD.Size() ; 
        int tag = 100 ; 
        if(rank == 0) 
        {
            String [] smsg = new String[1] ; 
            smsg[0] = "Hi from proc 0" ; 
            peer = 1 ; 
// public void Send(Object buf, int offset, int count, Datatype datatype, int dest, int tag) throws MPIException
            MPI.COMM_WORLD.Send(smsg,0,smsg.length,MPI.OBJECT, peer, tag);
            System.out.println("proc <"+rank+"> sent a msg to "+ "proc <"+peer+">") ; 

        } 
        else if(rank == 1) 
        {
            String[] rmsg = new String[1] ; 
            peer = 0 ; 
// public Status Recv(Object buf, int offset, int count, Datatype datatype, int src, int tag) throws MPIException
            MPI.COMM_WORLD.Recv(rmsg, 0, rmsg.length , MPI.OBJECT, peer, tag);
            System.out.println("proc <"+rank+"> received a msg from "+ "proc <"+peer+">") ; 
            System.out.println("proc <"+rank+"> received the following "+ "message: \""+rmsg[0]+"\"") ; 
        } 
        MPI.Finalize();
    }   
}

/*
$ mpjrun.sh -np 2 ObjSend

MPJ Express (0.44) is started in the multicore configuration

proc <0> sent a msg to proc <1>
proc <1> received a msg from proc <0>
proc <1> received the following message: "Hi from proc 0"

 */

/*
hduser@ubuntu-X550CA:~$                     cd Desktop/DCS/MPI
hduser@ubuntu-X550CA:~/Desktop/DCS/MPI$     export MPJ_HOME=/home/hduser/Desktop/DCS/MPI/mpj-v0_44
hduser@ubuntu-X550CA:~/Desktop/DCS/MPI$     javac -cp $MPJ_HOME/lib/mpj.jar MPI_Scatter_Gather_Demo.java 
hduser@ubuntu-X550CA:~/Desktop/DCS/MPI$     $MPJ_HOME/bin/mpjrun.sh -np 3 MPI_Scatter_Gather_Demo

*/
