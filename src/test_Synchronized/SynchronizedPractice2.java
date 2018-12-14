package test_Synchronized;

public class SynchronizedPractice2 implements Runnable{
	
	int b = 100;
	
	public static void main(String[] args) {

		SynchronizedPractice2 sp = new SynchronizedPractice2();
		Thread t = new Thread(sp);
		t.start();
		
		sp.m4();
		System.out.println("Main里的b为"+sp.b);
	}

	@Override
	public void run() {

		try {
			m3();
		}catch (Exception e) {

			e.printStackTrace();
		}
	}

	public synchronized void m3() {
		b = 1000;  //将b的值设为1000
		
		try {
			Thread.sleep(5000);  //休眠5秒
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("m3里的b为:"+b);
	}
	
	public synchronized void m4() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		b = 5000;
		System.out.println(b);  //为什么就输出一下，会改变main()里的b的值会不一样？？？？？？？？
		//System.out.println("m4里的b为"+b);
	}
}

//先执行m3()，将b改成2000，后m4()拿到锁，将b改成了1000，故结果均为1000