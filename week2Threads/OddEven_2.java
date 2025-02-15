package week2Threads;

class EvenThread extends Thread {
	public void run() {
		String even="";
		for(int i=2;i<=20;i+=2) {
				even+=i+" ";
		}
		System.out.println(even);
		
	}
}

class OddThread extends Thread {
	public void run() {
		String odd="";
		for(int i=1;i<=20;i+=2) {
			odd+=i+" ";
		}
		System.out.println(odd);
	}
}

public class OddEven_2 extends Thread{
	public static void main(String[] args) {
		EvenThread et=new EvenThread();
		OddThread ot=new OddThread();
		 et.start();
		 ot.start();
	}
}
