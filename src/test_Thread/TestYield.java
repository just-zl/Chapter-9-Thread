package test_Thread;

//yield 让出cpu，让自己进入就绪队列等待调度
public class TestYield {

	public static void main(String[] args) {
		
		MyThread3 m1 = new MyThread3("zl");
		MyThread3 m2 = new MyThread3("zy");
		m1.start();
		m2.start();
	}

}

class MyThread3 extends Thread {
	
	public MyThread3(String s) {
		super(s);
	}
	
	public void run() {
		for(int i=1;i<=30;i++) {
			System.out.println(getName()+":"+i);
			if(i%10 == 0) {
				yield();
			}
		}
	}
}
