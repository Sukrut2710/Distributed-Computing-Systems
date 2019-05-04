import mpi.*;

public class MPI_Sort 
{
    public static void main(String[] args) throws Exception 
    {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank() ;
        int size = MPI.COMM_WORLD.Size() ; 
        
        int unitsize=4;
        int root=0;     
	int[] send_buffer = new int[]{ 1,7,4,8,2,9,3,5,6,10,12,11 };

		
	int recv_buffer[] = new int[unitsize];
		
		
	MPI.COMM_WORLD.Scatter(send_buffer,0,unitsize,MPI.INT,recv_buffer,0,unitsize,MPI.INT,root);
		
	//if(rank != root)
	//{
		for(int i=0; i<unitsize-1; i++)
		{
			for(int j=0;j<unitsize-i-1; j++)
			{
				if(recv_buffer[j]>recv_buffer[j+1])
				{
					int temp = recv_buffer[j];
					recv_buffer[j]=recv_buffer[j+1];
					recv_buffer[j+1]=temp;
				}
			} 			
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
