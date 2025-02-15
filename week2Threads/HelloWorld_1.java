package week2Threads;

public class HelloWorld_1 extends Thread{
	
	@Override
	public void run() {
		System.out.println("Hello World");
	}
	public static void main(String[] args) {
		HelloWorld_1 hw=new HelloWorld_1();
		hw.start();
	}

}
