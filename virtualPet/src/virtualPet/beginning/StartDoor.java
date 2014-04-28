package virtualPet.beginning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

import virtualPet.enums.LifeType;
import virtualPet.lives.Pet;
import virtualPet.tools.FileTools;
import virtualPet.tools.MacAddress;

public class StartDoor {

	public static String DATEPATH = "virtualPet" + File.separator;
	public static String PET = getDatePath() + MacAddress.getMacAddress() + ".out";
	
	public static void main(String[] args) {
		doShutDownWork();
		Pet pet = loadPet();
		System.out.println("您的智能宠物" + pet.getPetName() + "已苏醒");
		System.out.println("Hello 主人，" + pet.getPetName() + "已经在你的电脑里待了" + pet.getSurviveHours() + "小时");
		
		pet.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void doShutDownWork() {  
        Runtime run=Runtime.getRuntime();//当前 Java 应用程序相关的运行时对象。  
        run.addShutdownHook(new Thread(){ //注册新的虚拟机来关闭钩子  
            @Override  
            public void run() {  
                System.out.println("main方法运行结束,窗口将关闭");  
            }  
        });  
    }
	
	public static Pet loadPet(){
		Pet pet = null;
		if(havePet()){
			System.out.println("正在唤醒您的电脑宠物... 请稍等...");
			pet = fileToPet(PET);
			
		}else{
			System.out.print("请输入数字来选择要创建的电脑宠物种类：");
			
			LifeType[] types = LifeType.values();
			for(LifeType lt : types){
				System.out.print(lt.getCode() + "为" + lt.getDesc() + ";");
			}
			System.out.println();
			
			int num = getNum();
			LifeType lt = LifeType.getLifeTypeByCode(num);
			pet = new Pet();
			pet.setType(lt);
			System.out.println("您的电脑宠物 ：" + lt.getDesc() + "已经创建");
			System.out.println("接下来为" + lt.getDesc() + "取个名字吧，输入后按回车键即可");
			String in = getInput();
			pet.setPetName(in);
			serializePetToLocal(pet);
		}
		return pet;
	}
	
	/**
	 * 反序列化文件成pet
	 * @param pet
	 * @return
	 */
	private static Pet fileToPet(String pet){
		Pet p = null;
        try {
            FileInputStream fis = new FileInputStream(PET);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            p = (Pet)ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return p;
	}
	/**
	 * 序列化pet对象到本地
	 * @param pet
	 */
	private static void serializePetToLocal(Pet pet){
		FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
        	fos = new FileOutputStream(PET);
        	oos = new ObjectOutputStream(fos);
			oos.writeObject(pet);
			oos.close();  
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(oos != null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
	}
	
	/**
	 * 判断运行软件的电脑是否已经领养了pet
	 * @return
	 */
	public static boolean havePet(){
		boolean have = false;
		File pet = new File(PET);
		if(pet.exists()){
			have = true;
		}
		return have;
	}
	
	public static String getDatePath(){
		FileTools.createFolder(getDataRootPath() + DATEPATH);
		return getDataRootPath() + DATEPATH;
	}
	
	/**
	 * 获取配置文件等数据的根目录
	 * @return
	 */
	public static String getDataRootPath(){
		List<File> list = FileTools.listUsingRoots();
		for(File f : list){
			if(f.isDirectory() && f.canRead() && f.canWrite()){
				String path = f.getAbsolutePath();
				if(!path.endsWith(File.separator))
					path = path + File.separator;
				return path;
			}
		}
		return null;
	}
	
	public static Integer getNum(){
		
		Integer numP = null;
		try {
			numP = Integer.parseInt(getInput());
			LifeType lt = LifeType.getLifeTypeByCode(numP);
			if(lt == null){
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("输入的数据不合法，请输入一个正整数");
			return getNum();
		}
		
		return numP;
	}
	
	public static String getInput(){
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		return in;
	}
}
