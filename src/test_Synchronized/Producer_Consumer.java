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

//************食物类*********************
class Food {
	int id;
	Food(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "食物" + id;
	}
}

//********盛器类，类似于栈*********************
class Bowl {
	
	Food foodArray[] = new Food[6];
	int index = 0;  //index指向最后一个食物上面
	
	//加食物
	public synchronized void push(Food f) {
		//当盛器满的时候
		while(index == foodArray.length) {
			try {
				this.wait();  //如果满了，就让该线程等待，并交出锁  。必须有synchronized关键字，才能用。
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();  //唤醒目前wait在某一个对象上的其他线程 .wait()和notify()都是Object类的方法
		foodArray[index] = f;
		index ++;
	}
	
	//减食物
	public synchronized Food pop() {
		while(index == 0) {  //如果盛器为空，则进程等待
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

//****************生产者类***************
class  Producer implements Runnable{
	
	Bowl bowl = null;  //需要一个容器放食物
	Producer(Bowl bowl){
		this.bowl = bowl;
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			Food food = new Food(i);
			bowl.push(food);
			System.out.println("生产了"+food);
			
			try {
				Thread.sleep((int)Math.random()*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

//************消费者类********************
class Consumer implements Runnable{
	Bowl bowl = null;  //需要一个容器放食物
	Consumer(Bowl bowl){
		this.bowl = bowl;
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			Food food = bowl.pop();
			System.out.println("消费了"+food);
			
			try {
				Thread.sleep((int)Math.random()*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}