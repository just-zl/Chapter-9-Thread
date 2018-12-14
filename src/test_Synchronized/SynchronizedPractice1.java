package test_Synchronized;

//线程同步练习，面试题
public class SynchronizedPractice1 implements Runnable{
	
	int b = 100;
	
	public static void main(String[] args) {
		
		SynchronizedPractice1 sp = new SynchronizedPractice1();
		Thread t = new Thread(sp);
		t.start();
		
		sp.m2();
		System.out.println("Main里的b为:"+sp.b);
	}

	@Override
	public void run() {

		try {
			m1();
		}catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	public synchronized void m1() {
		b = 1000;  //将b的值设为1000
		
		try {
			Thread.sleep(5000);  //休眠5秒
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("m1里的b为:"+b);
	}
	
	public void m2() {
		try {
			Thread.sleep(2500);  //休眠2.5秒
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		b = 5000;
		//System.out.println("m2里的b为:"+b);
	}
}

//没给m2()加锁时，修改了b的值，导致在执行t线程，也就是m1()方法时，被打断了，所以在m2()里也会显示b的值为5000