package test_Synchronized;

/*public class TestP_C {

	public static void main(String[] args) {
		
		Pail p = new Pail();
		Producer1 producer = new Producer1(p);
		Consumer1 consumer = new Consumer1(p);
		
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}

//食物类
class Food1 {
	public int id;
	public Food1(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "食物" + id;
	}
}

//盛器类  桶
class Pail {
	Food1 foodArray[] = new Food1[6];
	int index = 0;
	
	public Pail() {
		
	}
	//生产者往桶里添加食物
	public synchronized void push(Food1 food) {
		while(index == foodArray.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		
		foodArray[index] = food;
		index ++;
	}
	//消费者从桶里拿走食物
	public synchronized Food1 pop() {
		while(index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		index --;
		return foodArray[index];
	}
}

//生产者类
class Producer1 implements Runnable {
	
	Pail p = new Pail();
	public Producer1(Pail p) {
		this.p = p;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			Food1 food = new Food1(i);
			p.push(food);
			
			System.out.println("生产了"+food);
		}
		
		try {
			Thread.sleep((int)Math.random());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

//消费者类
class Consumer1 implements Runnable {
	
	Pail p = new Pail();
	public Consumer1 (Pail p) {
		this.p = p;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			Food1 food = p.pop();
			System.out.println("======消费了"+food);
		}
		try {
			Thread.sleep((int)Math.random());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
*/

public class TestP_C {
	public static void main(String[] args) {
		SyncStack ss = new SyncStack();
		Producer1 p = new Producer1(ss);
		Consumer1 c = new Consumer1(ss);
		new Thread(p).start();
		new Thread(c).start();
	}
}

class WoTou {
	int id; 
	WoTou(int id) {
		this.id = id;
	}
	public String toString() {
		return "WoTou : " + id;
	}
}

class SyncStack {
	int index = 0;
	WoTou[] arrWT = new WoTou[6];
	
	public synchronized void push(WoTou wt) {
		while(index == arrWT.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();		
		arrWT[index] = wt;
		index ++;
	}
	
	public synchronized WoTou pop() {
		while(index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		index--;
		return arrWT[index];
	}
}

class Producer1 implements Runnable {
	SyncStack ss = null;
	Producer1(SyncStack ss) {
		this.ss = ss;
	}
	
	public void run() {
		for(int i=0; i<20; i++) {
			WoTou wt = new WoTou(i);
			ss.push(wt);
System.out.println("生产了：" + wt+";还剩：" +ss.index);
			try {
				Thread.sleep((int)(Math.random() * 200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}

class Consumer1 implements Runnable {
	SyncStack ss = null;
	Consumer1(SyncStack ss) {
		this.ss = ss;
	}
	
	public void run() {
		for(int i=0; i<20; i++) {
			WoTou wt = ss.pop();
System.out.println("=====消费了: " + wt);
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}
