package test_Synchronized;

//�߳�ͬ����ϰ��������
public class SynchronizedPractice1 implements Runnable{
	
	int b = 100;
	
	public static void main(String[] args) {
		
		SynchronizedPractice1 sp = new SynchronizedPractice1();
		Thread t = new Thread(sp);
		t.start();
		
		sp.m2();
		System.out.println("Main���bΪ:"+sp.b);
	}

	@Override
	public void run() {

		try {
			m1();
		}catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	public synchronized void m1() {
		b = 1000;  //��b��ֵ��Ϊ1000
		
		try {
			Thread.sleep(5000);  //����5��
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("m1���bΪ:"+b);
	}
	
	public void m2() {
		try {
			Thread.sleep(2500);  //����2.5��
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		b = 5000;
		//System.out.println("m2���bΪ:"+b);
	}
}

//û��m2()����ʱ���޸���b��ֵ��������ִ��t�̣߳�Ҳ����m1()����ʱ��������ˣ�������m2()��Ҳ����ʾb��ֵΪ5000