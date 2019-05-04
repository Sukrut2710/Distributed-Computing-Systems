import mpi.*;

public class MPI_Square 
{
    public static void main(String[] args) throws Exception 
    {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank() ;
        int size = MPI.COMM_WORLD.Size() ; 
        
        int unitsize=3;
        int root=0;     
	int[] send_buffer = new int[]{ 4,5,6,1,2,3 };

		
	int recv_buffer[] = new int[unitsize];
		
		
	MPI.COMM_WORLD.Scatter(send_buffer,0,unitsize,MPI.INT,recv_buffer,0,unitsize,MPI.INT,root);
		
	//if(rank != root)
	//{
		for(int i=0; i<unitsize; i++)
		{
			recv_buffer[i]=recv_buffer[i]*recv_buffer[i]; 			
		}
	//}
	
	
	MPI.COMM_WORLD.Gather(recv_buffer,0,unitsize,MPI.INT,send_buffer,0,unitsize,MPI.INT,root);
		

		
	if(rank == root)
	{
		for(int i=0; i < (unitsize * size); i++)
		{
			System.out.println(send_buffer[i] + " "); 			
		}
	}		
        MPI.Finalize();
    }   
}


/*
hduser@ubuntu-X550CA:~$                     cd Desktop/DCS/MPI
hduser@ubuntu-X550CA:~/Desktop/DCS/MPI$     export MPJ_HOME=/home/hduser/Desktop/DCS/MPI/mpj-v0_44
hduser@ubuntu-X550CA:~/Desktop/DCS/MPI$     javac -cp $MPJ_HOME/lib/mpj.jar MPI_Scatter_Gather_Demo.java 
hduser@ubuntu-X550CA:~/Desktop/DCS/MPI$     $MPJ_HOME/bin/mpjrun.sh -np 3 MPI_Scatter_Gather_Demo

*/
