package test_Thread;

public class TestPriority {

	public static void main(String[] args) {
	
		Thread t1 = new Thread(new MyRunnable1());
		Thread t2 = new Thread(new MyRunnable2());
		
		t1.setPriority(Thread.NORM_PRIORITY+3);  //Thread.NORM_PRIORITY的值为5.整个优先级的级别为从1到10
		t1.start();
		t2.start();
	}

}

class MyRunnable1 implements Runnable {
	
	public void run() {
		for(int i=1;i<=100;i++) {
			System.out.println("M1: "+i);
		}
	}
}

class MyRunnable2 implements Runnable {
	
	public void run() {
		for(int i=1;i<=100;i++) {
			System.out.println("------M2: "+i);
		}
	}
}