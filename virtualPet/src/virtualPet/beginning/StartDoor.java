package virtualPet.beginning;

import java.util.Scanner;

import virtualPet.lives.People;

public class StartDoor {

	public static void main(String[] args) {
		System.out.println("请输入数字选择操作：1创建电脑宠物，2加载电脑宠物");
		int num = getNum();
		if(num == 1){
			People p = new People();
			System.out.println(p.getCreateTime());
		}else if(num == 2){
			
		}
	}
	
	public static Integer getNum(){
		
		Scanner sc = new Scanner(System.in);
		
		String num = sc.nextLine();
		Integer numP = null;
		try {
			numP = Integer.parseInt(num);
			if(numP < 1 || numP > 2){
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("输入的数据不合法，请输入一个1到2之间的正整数");
			return getNum();
		}
		return numP;
	}
}
