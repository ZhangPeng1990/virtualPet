package virtualPet.lives;

import virtualPet.baseObject.VirtualLife;
import virtualPet.enums.CmdCommand;
import virtualPet.enums.LifeType;
import virtualPet.events.OpenApplication;

public class Pet extends VirtualLife{

	private static final long serialVersionUID = -2009492671690752987L;
	
	private String name;
	private LifeType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LifeType getType() {
		return type;
	}

	public void setType(LifeType type) {
		this.type = type;
	}
	
	/**
	 * 询问主人，如第一次询问则输出一些提示信息
	 * @param time
	 */
	public void ask(int time){
		if(time == 0){
			System.out.println(this.name + "竭诚为您服务请选择您要进行的操作：");
			for(CmdCommand c : CmdCommand.values()){
				System.out.println("输入：" + c.getCode() + " ————>" + c.getDesc());
			}
		}
		
		String input = getInput();
		if(input != null){
			doThings(input);
		}
	}
	
	/**
	 * 根据主人的输入做出反应
	 * @param input
	 */
	public void doThings(String input){
		Integer code = null;
		CmdCommand cmd = null;
		try {
			code = Integer.parseInt(input);
			cmd = CmdCommand.getByCode(code);
			if(cmd == null){
				throw new NumberFormatException();
			}
		} catch (Exception e) {
			System.out.println("输入不合法");
			ask(1);
		}
		
		OpenApplication.execCommand(cmd.getCommand());
		ask(1);
	}
	
}
