package virtualPet.enums;

//zp git test
public enum CmdCommand {

	calc(0,"calc","打开计算器"),
	notepad(1,"notepad","打开记事本");
	
	private int code;
	private String command;
	private String desc;
	
	private CmdCommand(int code,String command,String desc){
		this.code = code;
		this.command = command;
		this.desc = desc;
	}

	public static CmdCommand getByCode(int code){
		for(CmdCommand c : CmdCommand.values()){
			if(c.code == code){
				return c;
			}
		}
		return null;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
