package virtualPet.study;

public class TestMitiThread {

	public static void main(String[] rags) {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        new MitiSay("A").start();
        new MitiSay("B").start();
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }
	
}
