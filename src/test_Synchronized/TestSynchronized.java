package test_Synchronized;

//线程同步
public class TestSynchronized implements Runnable{
	
	Timer timer = new Timer();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSynchronized ts = new TestSynchronized();
		Thread t1 = new Thread(ts);  //同一个线程对象，可以起多个线程
		Thread t2 = new Thread(ts);
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		timer.add(Thread.currentThread().getName());
	}

}

class Timer {
	public static int num = 0;
	
	public synchronized void add(String name) {  //synchronized关键字，表示在执行该方法的过程中，当前对象被锁定
		//synchronized (this) {
			num ++;
			try {
				Thread.sleep(1);  //此处的睡眠只是让不加synchronize的关键字时出现的效果更明显  
			} catch (InterruptedException e) {}
			System.out.println(name +":是第"+num + "个使用Timer的线程");
		//}
	}
}