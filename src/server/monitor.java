package server;

import java.util.Iterator;
import java.util.Vector;

public class  monitor {

	public static long time = System.currentTimeMillis();
	public String name;
public  int num_gnomes;
public int table_size;
	static Object gnomes=new Object();
	static Object sky_blue = new Object();
	static Vector kiss =new Vector<>();
	static public boolean iseatting=true;
	static int num=1;
	//static start_show show = new start_show();
	
	
	public monitor(int num_gnomes,int num) {
		
		this.num_gnomes=num_gnomes;
		this.table_size=num;
	
	}
	public String getName(String s){
		return this.name;
	}
	
	public synchronized void iseatting(boolean val) {
		// TODO Auto-generated method stub
		iseatting=val;
		
	}
	// this is used to put the skyblue to sleep in the cabin till the gnomes come
	
	public  void napping() throws InterruptedException{
		
		
		
	synchronized (sky_blue) {
		
	
			
			msg("the princess is falling a sleep");
			//System.out.println(sky_blue);
			//sky_blue.wait();
			msg("gnomes woke me up.");
		
		
	}
			
		
	}
	// this method is used to notify the skyblue when the gnomes arrive
		public void awake()throws InterruptedException{
			synchronized(sky_blue){
				System.out.print("we all inside the house");
				System.out.print("lets make noise and wake her up");
				System.out.println("about to wake her up");
				sky_blue.notify();
				System.out.println("she is awake");
			}
		}
		
		
		
		
		public synchronized void count() {
			// this method keep traking of the gnomes
		
			while(true){
					synchronized(gnomes){
						
					
					if(num==num_gnomes){
						//for (int i = 1; i <= num_gnomes; i++) {
					//	msg("i have the key");
							System.out.println("notify gnomes to enter the house");
							gnomes.notifyAll();// notifying all the gnomes
							notifyskyblue();
							
						
						break;
					} else {
						try {
							num++;
							//System.out.println(num+" name is " + name  );
							gnomes.wait();
							break;
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					}	
				}

		}
		
//to notify the skyblue at the dinner time
		public  synchronized void notifyskyblue() {
			
			synchronized (sky_blue) {
				
				System.out.println("sky blue is awake");
				sky_blue.notify();
			}
			
		}
		// to hold the skyblue till the group finish eating
	public  synchronized void waitskyblue() {
			
			synchronized (sky_blue) {
				
				try {
					System.out.println("sky blue waiting");
					sky_blue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
//		this is used to block gnomes again befor watching the gnomes
		
		public synchronized void waitinggnomes() {
			synchronized(gnomes){
			// TODO Auto-generated method stub
			//System.out.println("count = "+num);
		
				if(num==1){
					System.out.println("gnome waiting");
					gnomes.notifyAll();
					
				}}
					
					
			
		}
		
//to group the gnomes according to the table size
		public synchronized void dinner() throws InterruptedException {
			// TODO Auto-generated method stub
			//System.out.println("monitor2.dinner()" + num);
			synchronized (gnomes) {
				int n=0;
				while(n <num_gnomes){
						gnomes.notify();
						n++;
						System.out.println("one gnome got a seat and rady for ginner " + n);
					
					if(n%this.table_size==0 || n==num_gnomes) {
						System.out.println("there is a group eatting");
						Thread.currentThread().sleep(1000);
						if(n==num_gnomes){
							System.out.println("this the last group eating");
							System.out.println("washing the dishes");

							System.out.println("gnomes are blocked again and waiting for the movie time");
							//waitinggnomes();
							//System.out.println("gnomes are blocked again and waiting for the movie time");
						
							break;
						}
						//waitskyblue();
						iseatting(true);
					}
				}
				
				
			}
			
		}
		
		// to start the movie when the couch is full
		public synchronized void movietime() throws InterruptedException{
			synchronized(gnomes){
	    for (int i = 1; i <= 2; i++) {// playing the movie twice
	    	System.out.println("playing movie for "+i+" time.");
	     for (int j = 0; j < 3; j++) { // having 3 gnomes watching the movie
	    	 Thread.currentThread().sleep(50);
	    	 gnomes.notify();
	      
	     }
	     // msg("show is on, some gnomes arewatching the movie");
	     Thread.currentThread().sleep(100);
	
	    }
	   gnomes.notifyAll();
	  }
			System.out.println("movie time is over, time to go to sleep!!!!");
			
	}
		// the last method to take the gnomes out the vector
		public synchronized void kisses() throws InterruptedException{ // taking the gnomes out the vecotr
			
		    while(!kiss.isEmpty()){
		    	System.out.println("one gnome is out the vector");
		    	 System.out.println("got my lunch box ");
		      System.out.println("kissing ");
		      kiss.removeElementAt(0);
		      Thread.currentThread().sleep(1000);
		    }
		   System.out.println(" all gnomes are out for work");
		  }
		
		

		
		
	public void msg(String s){
		System.out.println("[" + (System.currentTimeMillis() - time) + "]" + this.getName() +" : " + s);
	}
	private String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
