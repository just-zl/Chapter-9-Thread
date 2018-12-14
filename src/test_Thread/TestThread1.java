package test_Thread;

//线程的创建，方法一：实现Runnable接口。推荐使用方法一，因为更灵活
public class TestThread1 {

	public static void main(String[] args) {
		
		TestRunnable tr = new TestRunnable();
		//tr.run(); //这是方法的调用
		Thread myThread = new Thread(tr);  //传值过程存在多态
		myThread.start();
		
		for(int i=0;i<20;i++) {
			System.out.println("Mian Thread:-----" + i);
		}
	}

}

class TestRunnable implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("TestRunnable " + i);
		}
		
	}
	
}
