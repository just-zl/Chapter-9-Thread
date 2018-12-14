package test_Synchronized;

public class Producer_Consumer {

	public static void main(String[] args) {
		
		Bowl bowl = new Bowl();
		Producer p = new Producer(bowl);
		Consumer c = new Consumer(bowl);
		
		new Thread(p).start();
		new Thread(c).start();
	}

}

//************ʳ����*********************
class Food {
	int id;
	Food(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "ʳ��" + id;
	}
}

//********ʢ���࣬������ջ*********************
class Bowl {
	
	Food foodArray[] = new Food[6];
	int index = 0;  //indexָ�����һ��ʳ������
	
	//��ʳ��
	public synchronized void push(Food f) {
		//��ʢ������ʱ��
		while(index == foodArray.length) {
			try {
				this.wait();  //������ˣ����ø��̵߳ȴ�����������  ��������synchronized�ؼ��֣������á�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();  //����Ŀǰwait��ĳһ�������ϵ������߳� .wait()��notify()����Object��ķ���
		foodArray[index] = f;
		index ++;
	}
	
	//��ʳ��
	public synchronized Food pop() {
		while(index == 0) {  //���ʢ��Ϊ�գ�����̵ȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		index --;
		return foodArray[index];
	}
}

//****************��������***************
class  Producer implements Runnable{
	
	Bowl bowl = null;  //��Ҫһ��������ʳ��
	Producer(Bowl bowl){
		this.bowl = bowl;
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			Food food = new Food(i);
			bowl.push(food);
			System.out.println("������"+food);
			
			try {
				Thread.sleep((int)Math.random()*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

//************��������********************
class Consumer implements Runnable{
	Bowl bowl = null;  //��Ҫһ��������ʳ��
	Consumer(Bowl bowl){
		this.bowl = bowl;
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			Food food = bowl.pop();
			System.out.println("������"+food);
			
			try {
				Thread.sleep((int)Math.random()*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}