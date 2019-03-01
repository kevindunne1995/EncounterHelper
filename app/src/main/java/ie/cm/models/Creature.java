package ie.cm.models;

import java.io.Serializable;
import java.util.UUID;

public class Creature implements Serializable
{
	public String creatureId;
	public String creatureName;
	public String classtype;
	public double challangerating;
	public double armorClass;
	public boolean marked;


	public Creature() {}

	public Creature(String name, String classtype, double challangerating, double armorClass, boolean marked)
	{
		this.creatureId = UUID.randomUUID().toString();
		this.creatureName = name;
		this.classtype = classtype;
		this.challangerating = challangerating;
		this.armorClass = armorClass;
		this.marked = marked;
	}

	@Override
	public String toString() {
		return creatureId + " " + creatureName + ", " + classtype + ", " + challangerating
				+ ", " + armorClass + ", fav =" + marked;
	}
}
