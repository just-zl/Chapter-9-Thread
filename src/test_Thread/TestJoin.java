package test_Thread;

//合并线程。jion(),将当前线程与该线程“合并”，即等待该线程结束，再恢复当前线程的运行
public class TestJoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread2 mt2 = new MyThread2("zl");
		mt2.start();
		
		try {
			mt2.join();  //将MyThread里的分支线程，合并到main进程里，相当于方法的调用，造成的结果是，先执行MyThread里的for循环，后执行main里的for循环
		} catch (InterruptedException e) {}
		
		for(int i=0;i<9;i++) {
			System.out.println("I'm Main Thread");
		}
	}

}

class MyThread2 extends Thread {
	
	public MyThread2(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
	
	public void run() {
		for(int i=0;i<9;i++) {
			System.out.println("Hi,I'm "+getName());  //调用Thread的getName()方法
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	} 
}