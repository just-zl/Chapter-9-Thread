package test_Thread;

//控制线程的停止
public class ThreadPractice1 {

	public static void main(String[] args) {

		Runner r1 = new Runner();
		Thread t = new Thread(r1);
		t.start();
		
		for(int i=0;i<100;i++) {
			if(i%10==0 && i>0) {
				System.out.println("Main Thread:" + i);
			}
		}
		r1.shutDown();
	}

}

class Runner implements Runnable {
	
	boolean flag = true;
	@Override
	public void run() {

		int i = 0;
		while(flag) {
			System.out.println(" " + i++);
		}
	}
	
	public void shutDown() {
		flag = false;
	}
}
