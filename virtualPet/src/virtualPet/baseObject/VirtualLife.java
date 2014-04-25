package virtualPet.baseObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

import virtualPet.tools.MacAddress;

public class VirtualLife implements Serializable, Runnable  {

	private static final long serialVersionUID = 620223380493003533L;
	
	private String id;
	private Date createTime;
	private String birthPlace;//创建时的机器的Mac地址
//	private int surviveHours;//存活时间，小时数
	
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
	public double getSurviveHours() {
		Date now = new Date();
		double hours = (double)(now.getTime() - this.getCreateTime().getTime())/3600000;
		BigDecimal bg = new BigDecimal(hours);
		double hour = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return hour;
	}

	@Override
	public void run() {
	}
	
	public static String getInput(){
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		return in;
	}
}
