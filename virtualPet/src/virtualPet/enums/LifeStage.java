package virtualPet.enums;

/**
 * 描述生命的阶段，例如 人 有 婴儿,儿童,成人等阶段
 * @author zp
 *
 */
public enum LifeStage {
	
	BABY("婴儿"),PUP("幼崽");
	
	private LifeStage(String desc){
		this.desc = desc;
	}
	
	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
