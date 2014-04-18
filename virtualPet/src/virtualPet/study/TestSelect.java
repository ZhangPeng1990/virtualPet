package virtualPet.study;


public class TestSelect implements Runnable{
	
	Select s1;
	Select s2;

	public static void main(String[] args) {
		TestSelect t = new TestSelect();
		
		Thread thread1 = new Thread(t);
		Thread thread2 = new Thread(t);
		thread1.start();
		thread2.start();
		
	}

	public void run() {
		s1 = Select.A;
		s2 = Select.A;
		System.out.println(s1 == s2);
		
	}
}
