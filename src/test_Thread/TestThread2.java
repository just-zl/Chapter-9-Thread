package test_Thread;

//�̵߳Ĵ��������������̳�Thread��.����ʹ�÷���һ����Ϊ�������
public class TestThread2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread tThread = new TestThread();
		tThread.start();
		
		for(int i=0;i<20;i++) {
			System.out.println("Mian Thread:-----" + i);
		}
	}

}

class TestThread extends Thread {
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("TestRunnable " + i);
		}
		
	}
}