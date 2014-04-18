package virtualPet.events;

import virtualPet.enums.CmdCommand;

public class OpenApplication {

	
	public static void execCommand(String command){
		try {  
            Runtime.getRuntime().exec(command);  
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }
	}
	
	public static void main(String[] args) {
		try {
			execCommand(CmdCommand.notepad.getCommand());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
