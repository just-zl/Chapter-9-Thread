package test_Synchronized;

//ËÀËø×´¿ö
public class TestDeadLock implements Runnable{
	
	int flag = 1;
	static Object o1 = new Object();
	static Object o2 = new Object();
	
	public static void main(String[] args) {
		TestDeadLock td1 = new TestDeadLock();
		TestDeadLock td2 = new TestDeadLock();
		td1.flag = 0;
		td2.flag = 1;
		
		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		
		t1.start();
		t2.start();
		
	}
	
	public void run() {
		System.out.println("flag="+flag);
		if(flag == 0) {
			synchronized (o1) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("1");
				}
			}
		}
		else if(flag == 1) {
			synchronized (o2) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("2");
				}
			}
		}
	}
}

