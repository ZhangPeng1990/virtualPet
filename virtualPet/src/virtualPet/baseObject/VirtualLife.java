package virtualPet.baseObject;

import java.io.Serializable;
import java.util.Date;

import virtualPet.tools.MacAddress;

public class VirtualLife implements Serializable {

	private static final long serialVersionUID = 620223380493003533L;
	
	private String id;
	private Date createTime;
	private String birthPlace;//创建时的机器的Mac地址
	private int surviveHours;//存活时间，小时数
	
	public VirtualLife(){
		this.birthPlace = MacAddress.getMacAddress();
		this.createTime = new Date();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public int getSurviveHours() {
		return surviveHours;
	}
	public void setSurviveHours(int surviveHours) {
		this.surviveHours = surviveHours;
	}
}
