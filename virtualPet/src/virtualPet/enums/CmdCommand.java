package virtualPet.enums;

//zp
public enum CmdCommand {

	sndrec32(0,"sndrec32","打开录音机"),
	Nslookup(1,"Nslookup","IP地址侦测器"),
	notepad(2,"notepad","打开记事本");
	
	private int code;
	private String command;
	private String desc;
	
	private CmdCommand(int code,String command,String desc){
		this.code = code;
		this.command = command;
		this.desc = desc;
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
