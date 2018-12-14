package test_Synchronized;

public class SynchronizedPractice2 implements Runnable{
	
	int b = 100;
	
	public static void main(String[] args) {

		SynchronizedPractice2 sp = new SynchronizedPractice2();
		Thread t = new Thread(sp);
		t.start();
		
		sp.m4();
		System.out.println("Main���bΪ"+sp.b);
	}

	@Override
	public void run() {

		try {
			m3();
		}catch (Exception e) {

			e.printStackTrace();
		}
	}

	public synchronized void m3() {
		b = 1000;  //��b��ֵ��Ϊ1000
		
		try {
			Thread.sleep(5000);  //����5��
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("m3���bΪ:"+b);
	}
	
	public synchronized void m4() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		b = 5000;
		System.out.println(b);  //Ϊʲô�����һ�£���ı�main()���b��ֵ�᲻һ������������������
		//System.out.println("m4���bΪ"+b);
	}
}

//��ִ��m3()����b�ĳ�2000����m4()�õ�������b�ĳ���1000���ʽ����Ϊ1000