package test_Thread;

import java.util.Date;

public class TestSleep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread1 mt = new MyThread1();
		mt.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {}
		mt.flag = false;
	}

}

class MyThread1 extends Thread {

	boolean flag = true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag) {
			System.out.println("��ǰʱ�䣺"+new Date());
			try {
				sleep(1000);  //��λ�Ǻ���
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
		}
	}
	
}
