package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	private int port=5001;
	private subThread sub;
	

	//private sky_blue sky;
	//private gnomes gnome;
	//private subThread sub;
	
	public server () throws ClassNotFoundException
	{
		try {
			ServerSocket server = new ServerSocket( port);
			System.out.println
           ("Server established.  Start client as follows:");		
			
			while (true)
			{System.out.println(" im server waiting");
				Socket Connection=server.accept();
				
				
			//ObjectInputStream value =new ObjectInputStream(Connection.getInputStream());
			sub=new subThread(Connection);// helper thread
			sub.start();
		//String s=(String) value.readObject();
		
			System.out.println(" one thread done");
				
			}//while
			
		}//try
		catch (IOException e)
		{
			System.out.println("Unable to listen to port.");
			e.printStackTrace();
		}
		
		
		
	}

	
	public static void main (String [] args) throws ClassNotFoundException
	{
		new server();
	}//main
	
	
}//class
