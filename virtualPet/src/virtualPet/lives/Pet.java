package virtualPet.lives;

import virtualPet.baseObject.VirtualLife;
import virtualPet.enums.LifeType;

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
}
