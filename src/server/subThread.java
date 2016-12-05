package server;
import java.io.*;
import java.net.Socket;
import java.util.Vector;


public class subThread extends Thread {
private static Object lock = new Object();

	private Socket socket;
	private BufferedReader br;
	//private PrintWriter pw;
	//private gnomes gnomes;
	 monitor mon = new monitor(11,3);
	private ObjectOutputStream output ;
	
	public subThread(Socket s){
		this.socket=s;
		
	}
	int x,y;
	public void run ()
	{
	
	try{
//	    ObjectOutputStream ouput=new ObjectOutputStream(socket.getOutputStream());
//	    output.writeObject("");
		ObjectInputStream value =new ObjectInputStream(socket.getInputStream());
		String s=(String) value.readObject();
		System.out.println(s);
	
		String k=(String) value.readObject();
        x=Integer.parseInt(k);
		
		y=Integer.parseInt(s);
		System.out.println(x);
	
		
		

		
		if(y== 8){
			while(x<2){
		
			switch (x)
			{
				case 0:      mon.napping();
							
							break;
				case 1:
							mon.dinner();
							break;
				
			}
			x++;
			}
			
		}
		else if (y==9){
			sleep(1000);
			while(x<6){
		//	System.out.println("case !!!"+x);
			switch (x)
			{
				
				case 0:
							mon.iseatting(false);
							System.out.println(" changing boolean to false");
							break;
				case 1:
							mon.notifyskyblue();
							break;			
				case 2:
							mon.movietime();
							break;					
				case 3:
							mon.kiss.addElement(this);
							break;
				case 4:		mon.kisses();
							break;
			}
			x++;
		
			}
		}
	
	}//while
			
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
}
