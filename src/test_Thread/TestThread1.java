package test_Thread;

//�̵߳Ĵ���������һ��ʵ��Runnable�ӿڡ��Ƽ�ʹ�÷���һ����Ϊ�����
public class TestThread1 {

	public static void main(String[] args) {
		
		TestRunnable tr = new TestRunnable();
		//tr.run(); //���Ƿ����ĵ���
		Thread myThread = new Thread(tr);  //��ֵ���̴��ڶ�̬
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
