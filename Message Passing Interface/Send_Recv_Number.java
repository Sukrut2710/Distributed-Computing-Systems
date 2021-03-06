	import mpi.*;
	class Send_Recv_Number 
	{
		static public void main(String[] args) 
		{
			MPI.Init(args) ;
			int myrank = MPI.COMM_WORLD.Rank();			
			int tag = 99;
			int dest;
			if(myrank == 1) 
			{
				int numbertosend[]= new int[1];
				numbertosend[0] = 77;
				dest = 0;
				System.out.println("====================================================================");
				System.out.println("This is process-" + myrank+ " sending number ( " +numbertosend[0]+ " ) to process-" + dest);				
				MPI.COMM_WORLD.Send(numbertosend, 0, 1, MPI.INT, dest, tag) ;
				System.out.println("====================================================================");
			}
			else 
			{			
				int[] numbertoreceive = new int [1] ;
				System.out.println("Tag shared is = " + tag);
				dest = 1;				
				MPI.COMM_WORLD.Recv(numbertoreceive, 0, 1, MPI.INT, dest, tag) ;
				System.out.println("====================================================================");
				System.out.println("I am process- " + myrank) ;
				System.out.println("Number received ...from process- " + dest+ " is = " +numbertoreceive[0]) ;
				System.out.println("====================================================================");
			}
			MPI.Finalize() ;
		}
	}


/*
comp9@comp9:~/Desktop/mpj-user-sss$ javac -cp /home/comp9/Desktop/mpj-v0_44/lib/mpj.jar Send_Recv_Number.java 
comp9@comp9:~/Desktop/mpj-user-sss$ mpjrun.sh -np 2 Send_Recv_Number
MPJ Express (0.44) is started in the multicore configuration

Tag shared is = 99
====================================================================
This is process-1 sending number ( 77 ) to process-0
====================================================================
====================================================================
I am process- 0
Number received ...from process- 1 is = 77
====================================================================
*/

/*
hduser@ubuntu-X550CA:~$                     cd Desktop/DCS/MPI
hduser@ubuntu-X550CA:~/Desktop/DCS/MPI$     export MPJ_HOME=/home/hduser/Desktop/DCS/MPI/mpj-v0_44
hduser@ubuntu-X550CA:~/Desktop/DCS/MPI$     javac -cp $MPJ_HOME/lib/mpj.jar MPI_Scatter_Gather_Demo.java 
hduser@ubuntu-X550CA:~/Desktop/DCS/MPI$     $MPJ_HOME/bin/mpjrun.sh -np 3 MPI_Scatter_Gather_Demo

*/
