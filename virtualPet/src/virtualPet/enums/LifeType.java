package virtualPet.enums;

/**
 * 生命体的种类，例如 人，狗，猫...
 * @author zp
 *
 */
public enum LifeType {
	
	People(1,"电脑人"),Gog(2,"电脑狗"),Cat(3,"电脑猫");
	
	private LifeType(int code, String desc){
		this.code = code;
		this.desc = desc;
	}
	
	private int code;
	private String desc;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static LifeType getLifeTypeByCode(int code){
		LifeType[] types = LifeType.values();
		for(LifeType lt : types){
			if(lt.code == code)
				return lt;
		}
		return null;
	}
}
