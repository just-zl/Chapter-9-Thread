package test_Thread;

//�ϲ��̡߳�jion(),����ǰ�߳�����̡߳��ϲ��������ȴ����߳̽������ٻָ���ǰ�̵߳�����
public class TestJoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread2 mt2 = new MyThread2("zl");
		mt2.start();
		
		try {
			mt2.join();  //��MyThread��ķ�֧�̣߳��ϲ���main������൱�ڷ����ĵ��ã���ɵĽ���ǣ���ִ��MyThread���forѭ������ִ��main���forѭ��
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
			System.out.println("Hi,I'm "+getName());  //����Thread��getName()����
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	} 
}