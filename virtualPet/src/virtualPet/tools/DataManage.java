package virtualPet.tools;

import java.util.Scanner;

/**
 * 输入，输出数据管理
 * @author tyr
 *
 */
public class DataManage {

	public static String getInput(){
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		return in;
	}
}
