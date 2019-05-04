	import mpi.*;
	class Send_Recv_Number_Array
	{
		static public void main(String[] args) 
		{
			MPI.Init(args) ;
			int myrank = MPI.COMM_WORLD.Rank();			
			int tag = 99;
			int dest;
			if(myrank == 1) 
			{
				String stringtosend[]= new String[2];
				stringtosend[0] = "MM";
				stringtosend[1] = "COE";				
				dest = 0;
				System.out.println("====================================================================");
				System.out.println("This is process-" + myrank+ " sending strings ( " +stringtosend[0]+","+stringtosend[1]+ " ) to process-" + dest);				
				MPI.COMM_WORLD.Send(stringtosend, 0, 2, MPI.CHAR, dest, tag) ;
				System.out.println("====================================================================");
			}
			else 
			{			
				String[] stringtoreceive = new String[2] ;
				System.out.println("Tag shared is = " + tag);
				dest = 1;				
				MPI.COMM_WORLD.Recv(stringtoreceive, 0, 2, MPI.CHAR, dest, tag) ;
				System.out.println("====================================================================");
				System.out.println("I am process- " + myrank) ;
				stringtoreceive[0]=stringtoreceive[0].concat(stringtoreceive[1]);
				System.out.println("Numbers received ...from process- " + dest+ " are = " +stringtoreceive[0] + ", " + stringtoreceive[1]) ;
				System.out.println("====================================================================");
			}
			MPI.Finalize() ;
		}
	}


/*
comp9@comp9:~/Desktop/mpj-user-sss$ javac -cp /home/comp9/Desktop/mpj-v0_44/lib/mpj.jar Send_Recv_Number_Array.java 
comp9@comp9:~/Desktop/mpj-user-sss$ mpjrun.sh -np 2 Send_Recv_Number_Array

MPJ Express (0.44) is started in the multicore configuration
Tag shared is = 99
====================================================================
This is process-1 sending array ( 7,17 ) to process-0
====================================================================
====================================================================
I am process- 0
Numbers received ...from process- 1 are = 7, 17
====================================================================

*/
