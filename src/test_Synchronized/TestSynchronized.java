package test_Synchronized;

//�߳�ͬ��
public class TestSynchronized implements Runnable{
	
	Timer timer = new Timer();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSynchronized ts = new TestSynchronized();
		Thread t1 = new Thread(ts);  //ͬһ���̶߳��󣬿��������߳�
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
	
	public synchronized void add(String name) {  //synchronized�ؼ��֣���ʾ��ִ�и÷����Ĺ����У���ǰ��������
		//synchronized (this) {
			num ++;
			try {
				Thread.sleep(1);  //�˴���˯��ֻ���ò���synchronize�Ĺؼ���ʱ���ֵ�Ч��������  
			} catch (InterruptedException e) {}
			System.out.println(name +":�ǵ�"+num + "��ʹ��Timer���߳�");
		//}
	}
}