	import mpi.*;
	class Send_Recv_Hello 
	{
		static public void main(String[] args) throws Exception
		{
			MPI.Init(args) ;
			int myrank = MPI.COMM_WORLD.Rank();
			int tag = 99;
			int dest;
			if(myrank == 0) 
			{
				dest = 1;
				char[] send_message = "Hello, there".toCharArray() ;
				MPI.COMM_WORLD.Send(send_message, 0, send_message.length, MPI.CHAR, dest, tag) ;
			}
			else 
			{
				dest = 0;
				char[] recv_message = new char [100] ;
				MPI.COMM_WORLD.Recv(recv_message, 0, 100, MPI.CHAR, dest, tag) ;
				System.out.println("received:" + new String(recv_message) + ":") ;
			}
			MPI.Finalize() ;
		}
	}



/*
hduser@ubuntu-X550CA:~$                     cd Desktop/DCS/MPI
hduser@ubuntu-X550CA:~/Desktop/DCS/MPI$     export MPJ_HOME=/home/hduser/Desktop/DCS/MPI/mpj-v0_44
hduser@ubuntu-X550CA:~/Desktop/DCS/MPI$     javac -cp $MPJ_HOME/lib/mpj.jar MPI_Scatter_Gather_Demo.java 
hduser@ubuntu-X550CA:~/Desktop/DCS/MPI$     $MPJ_HOME/bin/mpjrun.sh -np 3 MPI_Scatter_Gather_Demo

*/
