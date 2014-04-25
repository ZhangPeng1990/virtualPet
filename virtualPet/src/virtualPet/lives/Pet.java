package virtualPet.lives;

import virtualPet.baseObject.VirtualLife;
import virtualPet.enums.CmdCommand;
import virtualPet.enums.LifeType;
import virtualPet.events.OpenApplication;
import virtualPet.organ.Brain;

public class Pet extends VirtualLife{

	private static final long serialVersionUID = -2009492671690752987L;
	
	private String petName;
	private LifeType type;
	private Brain brain;

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public LifeType getType() {
		return type;
	}

	public void setType(LifeType type) {
		this.type = type;
	}
	
	public void run() {
		talk(0);
	}
	
	/**
	 * 询问主人，如第一次询问则输出一些提示信息
	 * @param time
	 */
	public void talk(int time){
		if(time == 0){
			System.out.println(this.petName + "竭诚为您服务请选择您要进行的操作：");
			for(CmdCommand c : CmdCommand.values()){
				System.out.println("输入：" + c.getCode() + " ————>" + c.getDesc());
			}
		}
		
		listen();
	}
	
	/**
	 * 监听主人输入
	 */
	public void listen(){
		String input = getInput();
		if(input != null){
			doThings(input);
		}
		talk(1);
	}
	
	/**
	 * 根据主人的输入做出反应
	 * @param input
	 */
	public void doThings(String input){
		this.analyze(input);
	}
	
	/**
	 * 对接收到的信息进行分析，并作出反应
	 * @param input
	 */
	@SuppressWarnings("deprecation")
	public void analyze(String input){
		if(input.trim().equals("再见") || input.trim().equals("bye")){
			System.out.println("好吧，我也去睡觉了，Bye !");
			this.stop();
		}
		
		Integer code = null;
		CmdCommand cmd = null;
		try {
			code = Integer.parseInt(input);
			cmd = CmdCommand.getByCode(code);
			if(cmd == null){
				throw new NumberFormatException();
			}
		} catch (Exception e) {
			System.out.println("主银主银！你写的东西不认识啊！！重写一次吧！");
			listen();
		}
		OpenApplication.execCommand(cmd.getCommand());
	}

	public Brain getBrain() {
		return brain;
	}

	public void setBrain(Brain brain) {
		this.brain = brain;
	}
}
